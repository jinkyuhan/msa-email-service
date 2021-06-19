package com.jk.msa.email.common;


import com.jk.msa.email.common.exception.ByServerException;
import com.jk.msa.email.common.exception.RequestFailException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CommonRestControllerAdvice {

	@ExceptionHandler(RequestFailException.class)
	public CommonResponse<Void> handleRequestFailException(RequestFailException exception) {
		// TODO: 에러 파일 로깅 제대로 하기
		System.out.println(exception.getMessage());
		return new CommonResponse<Void>(exception.getApiResult());
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ByServerException.class) 
	public CommonResponse<Void> handleByServerException(ByServerException exception) {
		// TODO: 에러 파일 로깅 제대로 하기
		System.out.println(exception.getMessage());
		return new CommonResponse<Void>(ApiResult.UNKNOWN_ERROR);
	}
}
