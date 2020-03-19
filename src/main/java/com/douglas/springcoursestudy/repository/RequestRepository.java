package com.douglas.springcoursestudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.douglas.springcoursestudy.domain.Request;
import com.douglas.springcoursestudy.enums.RequestState;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long>{

	public List<Request> findAllByOwnerId(Long id);
	
	@Query("UPDATE request SET state = ?2 WHERE id = ?1")
	public Request updateStatus(Long id, RequestState state);
}
