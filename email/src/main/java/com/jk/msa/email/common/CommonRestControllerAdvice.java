package com.jk.msa.email.common;


import org.springframework.web.bind.annotation.ExceptionHandler;


public class CommonRestControllerAdvice {

	@ExceptionHandler(CommonException.class)
	public CommonResponse<Void> handleControllerException(CommonException exception) {
		return new CommonResponse<Void>(exception.getApiResult());
	}
}
