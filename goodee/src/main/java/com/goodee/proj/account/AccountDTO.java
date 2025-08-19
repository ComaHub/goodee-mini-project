package com.goodee.proj.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountDTO {

	private Long number;
	@NotBlank
	private String id;
	private String password;
	@NotBlank
	private String name;
	@Email
	private String email;
	@NotBlank
	private String phone;
	@NotBlank
	private String postcode;
	@NotBlank
	private String address;
	private String addressDetail;
	private Boolean admin;
	private Boolean active;
}
