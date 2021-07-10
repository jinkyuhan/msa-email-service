package com.jk.msa.email.common;

public enum ApiResult {
    SUCCESS("00", "성공"),
    PARTIAL_SUCCESS("01", "일부만 성공"),
    NOT_REGISTRATION("41", "등록되지 않은 유저에 대한 요청"),
    ALREADY_EXIST_EMAIL("42", "이미 등록된 이메일 임"),
    NOT_EXIST_ACCOUNT("43", "존재하지 않는 유저, 이메일에 대한 요청"),
    INVALID_AUTHENTICATION_CODE("48", "유효하지 않은 인증 코드"),
    ALREADY_AUTHENTICATED("49", "이미 인증된 계정임"),
    MESSAGE_SENDING_FAIL("51", "이메일 전송 실패"),
    UNKNOWN_ERROR("99", "알수 없는 에러 발생, 서버 로그 확인 요망"),
    BAD_PARAMETER("40", "잘못된 입력 파라미터 입니다.");


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
