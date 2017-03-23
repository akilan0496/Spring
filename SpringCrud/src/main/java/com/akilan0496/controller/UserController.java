package com.akilan0496.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akilan0496.model.User;
import com.akilan0496.util.CustomJSONRoot;
import com.akilan0496.util.JSONRootHelper;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private JSONRootHelper jsonRootHelper;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> getUsers() {
		List<User> userlist = new ArrayList<User>();
		User user = new User();
		user.setUserId("1");
		user.setName("Akilan");
		user.setLastName("Mohan");
		user.setEmail("makilanit@gmail.com");
		
		User user1 = new User();
		user1.setUserId("2");
		user1.setName("Roman");
		user1.setLastName("Reigns");
		user1.setEmail("romanreigns@gmail.com");
		
		userlist.add(user);
		userlist.add(user1);

		return new ResponseEntity<Map<String, Object>>(jsonRootHelper.getResponse(User.class.getAnnotation(CustomJSONRoot.class).plural(), userlist), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<Map<String, Object>> getUser(@PathVariable(value = "userId") String userId) {
		User user = new User();
		user.setUserId("3");
		user.setName("Brock");
		user.setLastName("Lesner");
		user.setEmail("brock_lesner@gmail.com");
		return new ResponseEntity<Map<String, Object>>(jsonRootHelper.getResponse(User.class.getAnnotation(CustomJSONRoot.class).singular(), user), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> createUser() {
		return null;
	}
	
	@PutMapping
	public ResponseEntity<Map<String, Object>> updateUser() {
		return null;
	}
	
	@DeleteMapping
	public void deleteUser() {
		
	}

}