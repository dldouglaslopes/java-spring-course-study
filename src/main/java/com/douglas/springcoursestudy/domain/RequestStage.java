package com.douglas.springcoursestudy.domain;

import java.util.Date;

import com.douglas.springcoursestudy.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestStage {
	private Long id;
	private String description;
	private Date realizationDate;
	private RequestState state;
	private Request request;
	private User user;
}
