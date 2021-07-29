package com.xsw.neo.service.service;

import com.xsw.neo.service.repository.ProductDocument;

import java.util.List;

/**
 * Es搜索服务接口
 *
 * @author xueshengwen
 * @since 2021/7/27 14:58
 */
public interface ElasticsearchService extends BaseSearchService<ProductDocument> {

    void save(ProductDocument... productDocuments);

    List<ProductDocument> queryAll();
}
