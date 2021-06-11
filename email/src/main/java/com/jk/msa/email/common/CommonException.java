package com.jk.msa.email.common;

import lombok.Getter;

public class CommonException extends RuntimeException{
	@Getter
	private ApiResult apiResult;
	
	public CommonException(ApiResult apiResult) {
		super();
		this.apiResult = apiResult;
	}
}
