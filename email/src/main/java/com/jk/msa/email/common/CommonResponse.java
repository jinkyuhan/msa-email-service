package com.jk.msa.email.common;

public class CommonResponse<T> {
  public String resultCode;
  public String resultMessage;
  public T data;

  public CommonResponse(ApiResult resultObject) {
    this.resultCode = resultObject.getResultCode();
    this.resultMessage = resultObject.getResultMessage();
 }

  public CommonResponse(ApiResult resultObject, T data) {
    this.resultCode = resultObject.getResultCode();
    this.resultMessage = resultObject.getResultMessage();
    this.data = data;
  }

	public CommonResponse(ApiResult resultObject, String messageOverwrite) {
		this.resultCode = resultObject.getResultCode();
		this.resultMessage = messageOverwrite;
	}

  public CommonResponse(ApiResult resultObject, String messageOverwrite, T data) {
    this.resultCode = resultObject.getResultCode();
    this.resultMessage = messageOverwrite;
    this.data = data;
  }
}
