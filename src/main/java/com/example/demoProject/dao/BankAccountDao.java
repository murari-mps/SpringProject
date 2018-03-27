package com.example.demoProject.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demoProject.domain.AccountDetails;

@Repository
public class BankAccountDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession() {
		return sessionFactory.openSession();
	}
	public AccountDetails getAccountDetails(String accNo) {
		AccountDetails AccountDetails = null;
		Criteria criteria = getSession().createCriteria(AccountDetails.class)
                .add(Restrictions.eq("accountNo",accNo));
		Object result = criteria.uniqueResult();
		if(result !=null) {
			 AccountDetails = (AccountDetails)result;
		}
		return AccountDetails;
	}
}
