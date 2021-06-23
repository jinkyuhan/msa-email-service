package com.jk.msa.email.account.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(value = "메일 등록 위한 사용자 인증 준비 및 메일 전송 Request body")
public class AuthPrepareDto {

	@ApiModelProperty(value = "등록할 이메일", required = true)
	private String emailAddress;

	@ApiModelProperty(value = "등록 위한 유저 ID", required = true)
	private String userId;

	@ApiModelProperty(value = "조회 시 필터링 대비한 여분 칼럼", required = false)
	private String tag;

	// @AllArgsConstructor
	// @Getter
	// @ApiModel()
	// public class allowMultiMailForUserOption {
	// @ApiModelProperty(value = "true: 유저 한명에게 여러 이메일 등록 가능, false: 유저 고유한 이메일 허용",
	// required = true)
	// private boolean enabled;
	// }
}
