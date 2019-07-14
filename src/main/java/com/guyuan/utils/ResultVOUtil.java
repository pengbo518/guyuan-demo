package com.guyuan.utils;

import com.guyuan.enums.ResultEnum;
import com.guyuan.vo.ResponseEntity;

/**
 * @description: 统一返回结果集
 * @author: Mr.Liu
 * @version: v1.0
 * @create: 2019-06-24 23:29
 **/
public class ResultVOUtil {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ResponseEntity success(Object obj) {
		ResponseEntity resultVO = new ResponseEntity<>();
		resultVO.setData(obj);
		resultVO.setCode(0);
		resultVO.setMessage("成功");
		return resultVO;
	}

	@SuppressWarnings("rawtypes")
	public static ResponseEntity success() {
		ResponseEntity resultVO = new ResponseEntity<>();
		resultVO.setCode(0);
		resultVO.setMessage("成功");
		return resultVO;
	}
	
	@SuppressWarnings("rawtypes")
	public static ResponseEntity success(String message) {
		ResponseEntity resultVO = new ResponseEntity<>();
		resultVO.setCode(0);
		resultVO.setMessage(message);
		return resultVO;
	}

	@SuppressWarnings("rawtypes")
	public static ResponseEntity success(Integer code, String message) {
		ResponseEntity resultVO = new ResponseEntity<>();
		resultVO.setCode(code);
		resultVO.setMessage(message);
		return resultVO;
	}

	@SuppressWarnings("rawtypes")
	public static ResponseEntity error(Integer code, String message) {
		ResponseEntity resultVO = new ResponseEntity<>(code, message);
		return resultVO;
	}
	
	@SuppressWarnings("rawtypes")
	public static ResponseEntity error(ResultEnum resultEnum) {
		ResponseEntity resultVO = new ResponseEntity<>(resultEnum.getCode(), resultEnum.getMessage());
		return resultVO;
	}

}
