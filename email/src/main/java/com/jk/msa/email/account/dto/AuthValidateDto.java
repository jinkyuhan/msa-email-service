package com.jk.msa.email.account.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@ApiModel(value = "이메일 인증 번호 검증 Request body")
public class AuthValidateDto {

  @ApiModelProperty(value = "검증 진행할 유저 ID", required = true)
  private String userId;

  @ApiModelProperty(value = "검증 진행할 유저 이메일", required = true)
  private String emailAddress;

  @ApiModelProperty(value = "사용자가 입력한 인증 번호", required = true)
  private String authCode;

}
