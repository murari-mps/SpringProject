package com.example.demoProject.service;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoProject.dao.BankAccountDao;
import com.example.demoProject.domain.AccountDetails;

@Service
public class OpenBankAccountServiceImpl implements OpenBankAccountService {
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Autowired 
	private BankAccountDao accountDao;
	
	@Override
	public AccountDetails createAccount(AccountDetails accDetails) {
		Session session = sessionFactory.openSession();
		Random rand = new Random();
		int accNo = rand.nextInt(9000000) + 1000000;
		if(accDetails != null) {
			accDetails.setAccountNo(String.valueOf(accNo));
			long count =  (long) session.save(accDetails);
			if(count>0) {
				return accDetails;
			}
			else {
				return null;
			}
		}
		return accDetails;
	}
	
	public AccountDetails getAccountDetails(String accNo) {
		AccountDetails details = accountDao.getAccountDetails(accNo);
		if(details !=null) {
			return details;
		}else {
			return null;
		}
	}

}
