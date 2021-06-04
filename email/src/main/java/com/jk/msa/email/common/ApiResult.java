package com.jk.msa.email.common;

public enum ApiResult {

  SUCCESS("00", "성공"),
  PARTIAL_FAIL("01", "일부만 성공")
  NOT_REGISTRATION("04", "등록되지 않은 유저에 대한 요청");

  private final String resultCode;
  private final String resultMessage;
  

  private ApiResult(String code, String message) {
    this.resultCode = code;
    this.resultMessage = message;
  }

  public String getResultCode() {
    return resultCode;
  }

  public String getResultMessage() {
    return resultMessage;
  }
}
