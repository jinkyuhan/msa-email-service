package com.jk.msa.email.common;

import com.jk.msa.email.common.exception.ByServerException;
import com.jk.msa.email.common.exception.RequestFailException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class CommonRestControllerAdvice {

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(RequestFailException.class)
	public CommonResponse<Void> handleRequestFailException(RequestFailException exception) {
		// TODO: 에러 파일 로깅 제대로 하기
		System.out.println(exception.getMessage());
		return new CommonResponse<Void>(exception.getApiResult());
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ ByServerException.class, NullPointerException.class })
	public CommonResponse<Void> handleByServerException(ByServerException exception) {
		// TODO: 에러 파일 로깅 제대로 하기
		System.out.println(exception.getMessage());
		return new CommonResponse<Void>(ApiResult.UNKNOWN_ERROR);
	}

	@ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
	public CommonResponse<Void> handleRequestConstraintViolation(MethodArgumentNotValidException exception) {
		System.out.println(exception.getMessage());
		return new CommonResponse<Void>(ApiResult.BAD_PARAMETER);
	}
}
