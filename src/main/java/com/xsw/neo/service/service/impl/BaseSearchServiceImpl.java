package com.xsw.neo.service.service.impl;

import com.xsw.neo.service.service.BaseSearchService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xueshengwen
 * @since 2021/7/27 17:56
 */
@Slf4j
@Service
public class BaseSearchServiceImpl<T> implements BaseSearchService<T> {

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<T> query(String keyWord, Class<T> clazz) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(new QueryStringQueryBuilder(keyWord))
                .withSort(SortBuilders.scoreSort().order(SortOrder.DESC))
                .build();
        return elasticsearchTemplate.queryForList(searchQuery, clazz);
    }

    @Override
    public List<Map<String, Object>> queryHit(String keyWord, String indexName, String... fieldNames) {
        // 构造查询条件,使用标准分词器
        QueryBuilder queryBuilder = createQueryBuilder(keyWord, fieldNames);

        // 设置高亮,使用默认的highlighter高亮器
        HighlightBuilder highlightBuilder = createHighlightBuilder(fieldNames);


        SearchResponse searchResponse = elasticsearchTemplate.getClient().prepareSearch(indexName)
                .setQuery(queryBuilder)
                .highlighter(highlightBuilder)
                // 设置一次返回的文档数量，最大值：10000
                .setSize(10000)
                .get();

        SearchHits hits = searchResponse.getHits();
        return getHitList(hits);
    }

    @Override
    public Integer deleteIndex(String indexName) {
        return null;
    }

    /**
     * 构造查询条件
     *
     * @param keyword    关键字
     * @param fieldNames 设置查询哪些字段
     * @return 查询条件构造器
     */
    private QueryBuilder createQueryBuilder(String keyword, String... fieldNames) {
        // 构造查询条件,使用标准分词器
        // QueryBuilders.matchQuery() 单字段搜索
        return QueryBuilders.multiMatchQuery(keyword, fieldNames)
                .analyzer("ik_max_word")
                .operator(Operator.OR);
    }

    /**
     * 构造高亮器
     *
     * @param fieldNames 需要设置的高亮字段
     * @return 高亮器构造器
     */
    private HighlightBuilder createHighlightBuilder(String... fieldNames) {
        // 设置高亮,使用默认的highlighter高亮器
        HighlightBuilder highlightBuilder = new HighlightBuilder()
                .preTags("<span style='color:red'>")
                .postTags("</span>");

        // 设置高亮字段
        for (String fieldName : fieldNames) {
            highlightBuilder.field(fieldName);
        }

        return highlightBuilder;
    }

    private List<Map<String, Object>> getHitList(SearchHits hits) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map;
        for (SearchHit searchHit : hits) {
            map = new HashMap<>();
            // 处理源数据
            map.put("source", searchHit.getSourceAsMap());
            // 处理高亮数据
            Map<String, Object> hitMap = new HashMap<>();
            searchHit.getHighlightFields().forEach((k, v) -> {
                String hight = "";
                for (Text text : v.getFragments()) hight += text.string();
                hitMap.put(v.getName(), hight);
            });
            map.put("highlight", hitMap);
            list.add(map);
        }
        return list;
    }
}
