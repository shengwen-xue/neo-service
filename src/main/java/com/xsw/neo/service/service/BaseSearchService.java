package com.xsw.neo.service.service;

import java.util.List;
import java.util.Map;

/**
 * 基础搜索服务接口
 *
 * @author xueshengwen
 * @since 2021/7/27 14:51
 */
public interface BaseSearchService<T> {

    /**
     * 搜索
     *
     * @param keyWord 关键字
     * @param clazz   类
     * @return 结果集
     */
    List<T> query(String keyWord, Class<T> clazz);

    /**
     * 搜索高亮显示
     *
     * @param keyWord    关键字
     * @param indexName  索引库
     * @param fieldNames 搜索的字段
     * @return 高亮显示结果集
     */
    List<Map<String, Object>> queryHit(String keyWord, String indexName, String... fieldNames);

    /**
     * 删除索引库
     *
     * @param indexName 索引库
     * @return 删除结果
     */
    Integer deleteIndex(String indexName);
}
