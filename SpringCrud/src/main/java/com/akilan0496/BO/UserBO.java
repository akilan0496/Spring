package com.akilan0496.BO;

import java.util.List;

import com.akilan0496.model.VO.User;

public interface UserBO {
	
	public List<User> findAll();
	public User findOne(User user);
	public User save(User user);
	public void delete(User user);

}
