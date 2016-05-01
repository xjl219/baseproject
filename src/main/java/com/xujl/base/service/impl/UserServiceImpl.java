package com.xujl.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import com.xujl.base.entity.User;
import com.xujl.base.repository.BaseRepository;
import com.xujl.base.repository.UserRepository;
import com.xujl.base.service.UserService;
@Service
public class UserServiceImpl  extends BaseService<User,Integer> implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User getByUserName(String userName) {
		return userRepository.getByUserName(userName);
	}

	@Override
	public Page<User> findByUserNameLike(String userName, Pageable pageable) {
		return userRepository.findByUserNameLike(userName, pageable);
	}

	@Override
	BaseRepository<User, Integer> getJpaRepository() {
		return userRepository;
	}

	
}
