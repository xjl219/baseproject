package com.xujl.base.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xujl.base.entity.User;
import com.xujl.base.repository.UserRepository;

public interface UserService extends UserRepository{

	public User getByUserName(String userName);
	public Page<User> findByUserNameLike(String userName, Pageable pageable) ;
}
