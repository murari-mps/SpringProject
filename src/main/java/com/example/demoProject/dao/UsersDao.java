package com.example.demoProject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		getSession().close();
		if(i>0) {
			return "Success";
		}
		else {
			return "Some thing went wrong";
		}
	}
	
	public List<users> getAllUsers(int pageNumber,int pageSize){
		Criteria criteria = getSession().createCriteria(users.class);
		criteria.setFirstResult((pageNumber - 1) * pageSize);
		criteria.setMaxResults(pageSize);
		List<users> userList = criteria.list();
		getSession().close();
		return userList;
	}
	
	public boolean deleteUser(Long userId) {
		Session session = getSession();
		users user = session.load(users.class,userId);
		Transaction tx = session.beginTransaction();
		if(user !=null) {
			session.delete(user);
			tx.commit();
			return true;
		}
		else {
			return false;
		}
	}
	
	public users updateUser(long userId) {
		Session session = getSession();
		users user = session.load(users.class,userId);
		Transaction tx = session.beginTransaction();
		if(user !=null) {
			user.setUserName("AAAAAAAAAAAAAAA");
			session.saveOrUpdate(user);
			tx.commit();
			return user;
		}
		else {
			return null;
		}
	}
}
