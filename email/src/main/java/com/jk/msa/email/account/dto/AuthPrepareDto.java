package com.jk.msa.email.account.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(value = "메일 등록 위한 사용자 인증 준비 및 메일 전송 Request body")
public class AuthPrepareDto {

  @ApiModelProperty(value = "등록할 이메일", required = true)
  @NotEmpty
  @NotBlank
  @NotNull
  @Email
  private String emailAddress;

  @ApiModelProperty(value = "등록 위한 유저 ID", required = true)
  @NotEmpty
  @NotBlank
  @NotNull
  private String userId;

  @ApiModelProperty(value = "조회 시 필터링 대비한 여분 칼럼", required = false)
  private String tag;

}
