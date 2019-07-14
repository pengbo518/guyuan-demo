package com.guyuan.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
	SUCCESS(0, "成功"),
	USER_NOT_EXIST(1000, "暂无该用户"),
	DELETE_FAILED(1001, "删除用户失败");

	private Integer code;

	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
