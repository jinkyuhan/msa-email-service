package com.jk.msa.email.common;

public enum ApiResult {

  SUCCESS("00", "성공"),
  PARTIAL_FAIL("01", "일부만 성공"),
	FAIL("40", "알수없는 이유로 실패"),
  NOT_REGISTRATION("41", "등록되지 않은 유저에 대한 요청"),
	ALREADY_EXIST_EMAIL("42", "이미 등록된 이메일 임"),
	NOT_EXIST_ACCOUNT("43", "존재하지 않는 유저, 이메일에 대한 요청");

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
