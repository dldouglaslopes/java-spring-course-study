package com.douglas.springcoursestudy.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.douglas.springcoursestudy.domain.Request;
import com.douglas.springcoursestudy.domain.RequestStage;
import com.douglas.springcoursestudy.domain.User;
import com.douglas.springcoursestudy.enums.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSaveDTO {
	
	@NotBlank
	private String name;
	
	@Email
	private String email;
	
	@Size(min = 7, max = 99, message = "Password must be between 7 and 99")
	private String password;
	
	@NotNull
	private Role role;
	
	private List<Request> requests = new ArrayList<>();
	private List<RequestStage> stages = new ArrayList<>();
	
	public User toUser() {
		User user = new User( null, this.name, this.email, this.password, this.role, this.requests, this.stages);
		return user;
	}
}
