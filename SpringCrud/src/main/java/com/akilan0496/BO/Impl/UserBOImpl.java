package com.akilan0496.BO.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akilan0496.BO.UserBO;
import com.akilan0496.DAO.UserDAO;
import com.akilan0496.model.DO.User;

@Service
public class UserBOImpl implements UserBO{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public List<com.akilan0496.model.VO.User> findAll() {
		List<com.akilan0496.model.DO.User> usersDO = (List<User>) userDAO.findAll();
		List<com.akilan0496.model.VO.User> usersVO = new ArrayList<com.akilan0496.model.VO.User>();
		
		for(com.akilan0496.model.DO.User userDO : usersDO) {
			com.akilan0496.model.VO.User userVO = new com.akilan0496.model.VO.User();
			BeanUtils.copyProperties(userDO, userVO);
			usersVO.add(userVO);
		}
		return usersVO;
	}



	@Override
	public com.akilan0496.model.VO.User findOne(
			com.akilan0496.model.VO.User user) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public com.akilan0496.model.VO.User save(com.akilan0496.model.VO.User user) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void delete(com.akilan0496.model.VO.User user) {
		// TODO Auto-generated method stub
		
	}
	
}
