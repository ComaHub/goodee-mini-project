package com.goodee.proj.account;

import com.goodee.proj.account.groups.Join;
import com.goodee.proj.account.groups.Login;
import com.goodee.proj.account.groups.Update;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AccountDTO {

	private Long number;
	@NotBlank(groups = {Login.class, Join.class})
	private String id;
	private String password;
	@NotBlank(groups = {Join.class, Update.class})
	private String name;
	@Email(groups = {Join.class, Update.class})
	private String email;
	@NotBlank(groups = {Join.class, Update.class})
	private String phone;
	@NotBlank(groups = {Join.class, Update.class})
	private String postcode;
	@NotBlank(groups = {Join.class, Update.class})
	private String address;
	private String addressDetail;
	private Boolean admin;
	private Boolean active;
}
