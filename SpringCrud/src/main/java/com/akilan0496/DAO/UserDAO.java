package com.akilan0496.DAO;

import java.util.List;

import com.akilan0496.model.DO.User;

public interface UserDAO {
	
	public List<User> findAll();
	public User findOne(User user);
	public User save(User user);
	public void delete(User user);
	
}