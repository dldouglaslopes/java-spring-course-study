package com.douglas.springcoursestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.douglas.springcoursestudy.domain.RequestFile;
import com.douglas.springcoursestudy.model.PageModel;
import com.douglas.springcoursestudy.model.PageRequestModel;
import com.douglas.springcoursestudy.repository.RequestFileRepository;

@Service
public class RequestFileService {
	
	@Autowired
	private RequestFileRepository requestFileRepository;
	
	public PageModel<RequestFile> listAllByRequestId(Long requestId, PageRequestModel pr) {
		Pageable pageable = PageRequest.of(pr.getPage(), pr.getSize());
		Page<RequestFile> page = requestFileRepository.findAllByRequestId(requestId, pageable);
		
		PageModel<RequestFile> pm = new PageModel<>( (int) page.getTotalElements(), 
														page.getSize(), 
														page.getTotalPages(), 
														page.getContent());
		
		return pm;
	}
}
