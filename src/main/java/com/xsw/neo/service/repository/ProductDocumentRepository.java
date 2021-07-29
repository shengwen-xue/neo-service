package com.xsw.neo.service.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author xueshengwen
 * @since 2021/7/27 15:24
 */
@Component
public interface ProductDocumentRepository extends ElasticsearchRepository<ProductDocument, String> {
}
