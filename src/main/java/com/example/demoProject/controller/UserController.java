package com.example.demoProject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoProject.dao.UsersDao;
import com.example.demoProject.domain.users;
import com.example.demoProject.util.ResponseEntity;

@RestController
@RequestMapping("api/v1")
public class UserController {
	
	@Autowired
	private UsersDao userDao;
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public Map<String,Object> saveUserDetails(@RequestBody users user) {
		String response = userDao.saveUsersDetail(user);
		if(response.equals(null)) {
			return ResponseEntity.generateResponse(HttpStatus.BAD_REQUEST, true, "Something Went Wrong", null);
		}
		else {
			return ResponseEntity.generateResponse(HttpStatus.ACCEPTED, false, "Success", response);
		}
	}
	
	@RequestMapping(value = "/userDetail",method = RequestMethod.GET)
	public Map<String,Object> getAllUsers(@RequestParam("start") int start,int end){
		List<users> userList = userDao.getAllUsers(start,end);
		if(userList.size()>0) {
			return ResponseEntity.generateResponse(HttpStatus.ACCEPTED, false, "Success", userList);
		}else {
			return ResponseEntity.generateResponse(HttpStatus.BAD_REQUEST, true, "Something Went Wrong", userList);
		}
		
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.DELETE)
	public Map<String,Object> deleteUser(@RequestParam("userId") Long userId){
		boolean isDeleted = userDao.deleteUser(userId);
		if(isDeleted) {
			return ResponseEntity.generateResponse(HttpStatus.ACCEPTED, false, "User Deleted", isDeleted);
		}else {
			return ResponseEntity.generateResponse(HttpStatus.BAD_REQUEST, true, "not Deleted", null);
		}
	}
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public Map<String,Object> updateUser(@RequestParam("userId") Long userId){
		users user = userDao.updateUser(userId);
		if(user !=null) {
			return ResponseEntity.generateResponse(HttpStatus.ACCEPTED, false, "User updated", user.getUserName());
		}else {
			return ResponseEntity.generateResponse(HttpStatus.BAD_REQUEST, true, "not updated", null);
		}
	}
	
}
