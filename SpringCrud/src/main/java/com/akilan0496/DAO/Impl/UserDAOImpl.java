package com.akilan0496.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.akilan0496.DAO.UserDAO;
import com.akilan0496.model.DO.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public List<User> findAll() {
		List<User> userlist = new ArrayList<User>();
		User user = new User();
		user.setUserId(1L);
		user.setName("Akilan");
		user.setLastName("Mohan");
		user.setEmail("makilanit@gmail.com");
		
		User user1 = new User();
		user1.setUserId(2L);
		user1.setName("Roman");
		user1.setLastName("Reigns");
		user1.setEmail("romanreigns@gmail.com");
		
		userlist.add(user);
		userlist.add(user1);
		return userlist;
	}

	@Override
	public User findOne(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

}
