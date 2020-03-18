package com.douglas.springcoursestudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestStage extends JpaRepository<RequestStage, Long>{

	public List<RequestStage> findAllByRequestId(Long id);
}
