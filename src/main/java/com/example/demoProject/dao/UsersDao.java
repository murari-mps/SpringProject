package com.example.demoProject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demoProject.domain.users;

@Repository
public class UsersDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.openSession();
	}
	
	public String saveUsersDetail(users userDet) {
		Long i = (Long) getSession().save(userDet);
		if(i>0) {
			return "Success";
		}
		else {
			return "Some thing went wrong";
		}
	}
	
	public List<users> getAllUsers(){
		List<users> userList = getSession().createCriteria(users.class).list();
		return userList;
	}
	
	public boolean deleteUser(Long userId) {
		users user1 = getSession().get(users.class,userId);
		if(user1 !=null) {
			getSession().delete(user1);
			return true;
		}
		else {
			return false;
		}
	}
}
