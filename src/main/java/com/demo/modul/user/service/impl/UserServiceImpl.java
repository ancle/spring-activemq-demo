package com.demo.modul.user.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.modul.user.entity.User;
import com.demo.modul.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@CachePut(cacheNames="user", key="'user:' + #{user.id}")
	public User save(User user) {
		return user;
	}

	@CachePut(cacheNames="user", key="'user:' + #{user.id}")
	public int update(User user) {
		return 0;
	}

	@Cacheable(cacheNames="user", key="user:#user.id")
	public User getById(String id) {
		return new User();
	}

	@Cacheable(cacheNames="user", key="user:#user.id")
	public User getOne(User user) {
		return new User();
	}

	@CacheEvict(cacheNames="user", key="user:#user.id", beforeInvocation=false)
	public void delete(User user) {

	}

}
