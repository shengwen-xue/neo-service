package com.xsw.neo.service.controller;

import com.xsw.neo.service.common.result.ResultBody;
import com.xsw.neo.service.repository.ProductDocument;
import com.xsw.neo.service.service.ElasticsearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author xueshengwen
 * @since 2021/7/27 15:18
 */
@Api(tags = "ES搜索相关接口")
@RestController
@RequestMapping(value = "es")
public class ElasticsearchController {

    @Autowired
    private ElasticsearchService elasticsearchService;

    @PostMapping(value = "/save")
    @ApiOperation(value = "新增索引")
    public ResultBody save(@RequestParam(value = "indexName")
                           @ApiParam(name = "indexName", value = "索引", required = true) String indexName,
                           @RequestParam(value = "indexDescription")
                           @ApiParam(name = "indexDescription", value = "索引描述", required = true) String indexDescription) {
        ProductDocument productDocument = new ProductDocument();
        productDocument.setId(new Random().nextLong());
        productDocument.setProductName(indexName);
        productDocument.setProductDescription(indexDescription);
        productDocument.setCreateTime(new Date());
        productDocument.setUpdateTime(new Date());
        elasticsearchService.save(productDocument);
        return ResultBody.SUCCESS("新增索引成功");
    }

    @GetMapping(value = "/query")
    @ApiOperation(value = "查询索引")
    public List<ProductDocument> query(@RequestParam(value = "keyword")
                                       @ApiParam(name = "keyword", value = "关键字", required = true) String keyword) {
        List<ProductDocument> productDocuments = elasticsearchService.query(keyword, ProductDocument.class);
        return CollectionUtils.isEmpty(productDocuments) ? new ArrayList<>() : productDocuments;
    }

    @GetMapping(value = "/queryAll")
    @ApiOperation(value = "查询所有索引")
    public List<ProductDocument> queryAll() {
        List<ProductDocument> productDocuments = elasticsearchService.queryAll();
        return CollectionUtils.isEmpty(productDocuments) ? new ArrayList<>() : productDocuments;
    }

    @GetMapping(value = "/hitQuery")
    @ApiOperation(value = "高亮查询")
    public List<Map<String, Object>> hitQuery(@RequestParam(value = "keyword")
                                          @ApiParam(name = "keyword", value = "关键字", required = true) String keyword,
                                          @RequestParam(value = "indexName")
                                          @ApiParam(name = "indexName", value = "索引库", required = true) String indexName,
                                          @RequestParam(value = "fieldNames")
                                          @ApiParam(name = "fieldNames", value = "搜索的字段", required = true) String... fieldNames) {
        List<Map<String, Object>> list = elasticsearchService.queryHit(keyword, indexName, fieldNames);
        return list;
    }
}
