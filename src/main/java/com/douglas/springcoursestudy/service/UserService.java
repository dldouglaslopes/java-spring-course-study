package com.douglas.springcoursestudy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.douglas.springcoursestudy.domain.User;
import com.douglas.springcoursestudy.exception.NotFoundException;
import com.douglas.springcoursestudy.model.PageModel;
import com.douglas.springcoursestudy.model.PageRequestModel;
import com.douglas.springcoursestudy.repository.UserRepository;
import com.douglas.springcoursestudy.service.util.HashUtil;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		String hash = HashUtil.getSecurityHash(user.getPassword());
		user.setPassword(hash);
		
		User createdUser = userRepository.save(user);
		return createdUser;
	}
	
	public User update(User user) {
		String hash = HashUtil.getSecurityHash(user.getPassword());
		user.setPassword(hash);
		
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}
	
	public User getById(Long id) {
		Optional<User> result = userRepository.findById(id);
		return result.orElseThrow(() -> new NotFoundException("There are not user with id = " + id));
	}
	
	public List<User> listAll() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public User login(String email, String password) {
		password = HashUtil.getSecurityHash(password);
		
		Optional<User> result = userRepository.login(email, password);
		return result.get();
	}
	
	public PageModel<User> listAllOnLazyMode(PageRequestModel pr) {
		Pageable pageable = PageRequest.of(pr.getPage(), pr.getSize());
		Page<User> page = userRepository.findAll(pageable);
		PageModel<User> pm = new PageModel<>((int) page.getTotalElements(), 
												page.getSize(), 
												page.getTotalPages(), 
												page.getContent());
		return pm;
	}
	
	public int updateRole(User user) {
		return userRepository.updateRole(user.getId(), user.getRole());
	}
}
