package com.xsw.neo.service.repository;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.Mapping;

import java.util.Date;

/**
 * @author xueshengwen
 * @since 2021/7/27 15:25
 */
@Data
@Document(indexName = "orders", type = "product")
@Mapping(mappingPath = "ProductDocumentIndex.json") // 解决IK分词不能使用问题
public class ProductDocument {

    @Id
    private Long id;

    //@Field(analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String productName;

    //@Field(analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String productDescription;

    private Date createTime;

    private Date updateTime;
}
