package com.douglas.springcoursestudy.dto;

import javax.validation.constraints.NotNull;

import com.douglas.springcoursestudy.enums.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRoleDTO {

	@NotNull(message = "Role required")
	private Role role;
}
