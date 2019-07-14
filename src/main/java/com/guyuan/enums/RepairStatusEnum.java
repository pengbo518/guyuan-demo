package com.guyuan.enums;

import lombok.Getter;

/**
 * 审批流程枚举
 */
@Getter
public enum RepairStatusEnum {

    APPPLY(0, "申请中"),
    APPPLY_PASS(1, "审批通过"),
    ON_FILE(2, "已存档");

    private Integer code;

    private String message;

    RepairStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
