package com.jk.msa.email.account.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@ApiModel(value = "이메일 등록 Request body")
public class EmailRegistrationDto {

	@ApiModelProperty(value = "등록할 유저 ID", required = true)
	private String userId;
	@ApiModelProperty(value = "등록할 이메일", required = true)
	private String emailAddress;
	@ApiModelProperty(value = "이메일 등록 시 메일의 멀티 유저 옵션", required = true)
	private AllowMultiUserForEmailOption allowMultiUserForEmailOption;
	@ApiModelProperty(value = "이메일 등록 시 유저의 멀티 이메일 옵션", required = true)
	private AllowMultiMailForUserOption allowMultiMailForUserOption;

	@AllArgsConstructor
	@Getter
	@ApiModel()
	public class AllowMultiUserForEmailOption {
		@ApiModelProperty(value = "true: 한 메일을 여러 유저에게 등록 가능, false: 한 메일은 한 유저에게만 등록 가능", required = true)
		private boolean enabled;
		@ApiModelProperty(value = "enabled가 false 일 시 이메일이 다른사람에게 등록되어 있어도 뺏어서 등록")
		private boolean force = false;
	}

	@AllArgsConstructor
	@Getter
	@ApiModel()
	public class AllowMultiMailForUserOption {
		@ApiModelProperty(value = "true: 유저 한명에게 여러 이메일 등록 가능, false: 유저 고유한 이메일 허용", required = true)
		private boolean enabled;
	};
}
