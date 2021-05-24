package com.xsw.neo.service.common.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xueshengwen
 * @since 2021/5/24 14:30
 */
public enum StrategyEnum {

    FAST("快速", "FAST"),

    NORMAL("正常", "NORMAL"),

    SLOW("慢速", "SLOW"),

    SMOOTH("平滑", "SMOOTH");

    StrategyEnum(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String type;
}
