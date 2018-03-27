package com.example.demoProject.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demoProject.dao.BankAccountDao;
import com.example.demoProject.domain.AccountDetails;

public class TransactionServiceImpl implements TransactionService {
	@Autowired 
	private BankAccountDao accountDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer depositMoney(AccountDetails accDetails) {
		AccountDetails accountDetails = accountDao.getAccountDetails(accDetails.getAccountNo());
		Integer count = 0;
		if(accountDetails != null) {
			long amount = accountDetails.getAmount();
			amount = amount+accDetails.getAmount();
			accountDetails.setAmount(amount);
			 count = (Integer) sessionFactory.openSession().save(accountDetails);
			if(count > 0) {
				return count;
			}
			else {
				return count;
			}
		}
		return count;
	}

	@Override
	public Integer withdrowMoney(AccountDetails accDetails) {
		AccountDetails accountDetails = accountDao.getAccountDetails(accDetails.getAccountNo());
		Integer count = 0;
		if(accountDetails != null) {
			long amount = accountDetails.getAmount();
			amount = amount - accDetails.getAmount();
			accountDetails.setAmount(amount);
			 count = (Integer) sessionFactory.openSession().save(accountDetails);
			if(count > 0) {
				return count;
			}
			else {
				return count;
			}
		}
		return count;
	}

}
