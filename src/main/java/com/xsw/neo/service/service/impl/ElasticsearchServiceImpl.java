package com.xsw.neo.service.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.xsw.neo.service.repository.ProductDocument;
import com.xsw.neo.service.repository.ProductDocumentRepository;
import com.xsw.neo.service.service.ElasticsearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author xueshengwen
 * @since 2021/7/27 15:01
 */
@Slf4j
@Service
public class ElasticsearchServiceImpl extends BaseSearchServiceImpl<ProductDocument> implements ElasticsearchService {

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;
    @Resource
    private ProductDocumentRepository productDocumentRepository;

    @Override
    public void save(ProductDocument... productDocuments) {
        elasticsearchTemplate.putMapping(ProductDocument.class);
        if (productDocuments.length > 0) {
            Arrays.asList(productDocuments)
                    .parallelStream()
                    .map(productDocumentRepository::save)
                    .forEach(productDocument -> log.info("[保存索引]:{}", JSONObject.toJSONString(productDocument)));
        }
    }

    @Override
    public List<ProductDocument> queryAll() {
        List<ProductDocument> productDocuments = Lists.newArrayList();
        productDocumentRepository.findAll().forEach(productDocuments::add);
        return productDocuments;
    }
}
