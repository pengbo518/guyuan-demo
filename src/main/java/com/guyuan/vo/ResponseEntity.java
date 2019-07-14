package com.guyuan.vo;

import lombok.Data;

@Data
public class ResponseEntity<T> {
	private Integer code;
	private String message;

	private T data;

	public ResponseEntity() {

	}

	public ResponseEntity(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

}
