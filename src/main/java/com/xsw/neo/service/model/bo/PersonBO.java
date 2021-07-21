package com.xsw.neo.service.model.bo;

import com.xsw.neo.service.common.annotation.I18nAnnotation;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xueshengwen
 * @since 2021/7/19 15:27
 */
@Data
public class PersonBO implements Serializable {

    @I18nAnnotation(langs = {"zh-cn|姓名", "en-us|NAME", "fr-fr|Nom"})
    private String name;

    @I18nAnnotation(langs = {"zh-cn|昵称", "en-us|NICKNAME", "fr-fr|surnom"})
    private String nickname;
}
