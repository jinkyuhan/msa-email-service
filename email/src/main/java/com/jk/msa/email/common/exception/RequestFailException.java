package com.jk.msa.email.common.exception;

import com.jk.msa.email.common.ApiResult;

import lombok.Getter;

public class RequestFailException extends RuntimeException{
	@Getter
	private ApiResult apiResult;

	public RequestFailException(ApiResult apiResult) {
		super();
		this.apiResult = apiResult;
	}

	public RequestFailException(ApiResult apiResult, String message) {
		super(message);
		this.apiResult = apiResult;
	}
}
