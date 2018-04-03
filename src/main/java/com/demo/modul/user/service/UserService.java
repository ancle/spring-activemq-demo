package com.demo.modul.user.service;

import com.demo.modul.user.entity.User;

public interface UserService {
	public User save(User user);
	
	public int update(User user);
	
	public User getById(String id);
	
	public User getOne(User user);
	
	public void delete(User user);
}
