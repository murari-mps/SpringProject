package com.example.demoProject.service;

import com.example.demoProject.domain.AccountDetails;

public interface TransactionService {
	public Integer depositMoney(AccountDetails accDetails);
	public Integer withdrowMoney(AccountDetails accDetails);
}
