package com.example.demoProject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoProject.dao.BankAccountDao;
import com.example.demoProject.domain.AccountDetails;
import com.example.demoProject.service.OpenBankAccountService;
import com.example.demoProject.util.ResponseEntity;

@RestController
public class BankAccountController {
	@Autowired
	private OpenBankAccountService accountService;
	
	@Autowired 
	private BankAccountDao accountDao;
	
	@RequestMapping(value = "api/v1/createAcc",method = RequestMethod.POST)
	public Map<String,Object> createBankAccount(@RequestBody AccountDetails accDetails){
		AccountDetails response = null;
		if(accDetails !=null) {
			 response = accountService.createAccount(accDetails);
			 return ResponseEntity.generateResponse(HttpStatus.ACCEPTED, false, "Success", response);
		}
		else {
			 return ResponseEntity.generateResponse(HttpStatus.BAD_REQUEST, true, "Something Went Wrong", response);
		}
		
	}
	
	@RequestMapping(value = "api/v1/accdetails",method = RequestMethod.GET)
	public Map<String,Object> getAccountDetails(@RequestParam String accountNo){
		AccountDetails response = null;
		response = accountDao.getAccountDetails(accountNo);
			 if(response != null) {
				 return ResponseEntity.generateResponse(HttpStatus.ACCEPTED, false, "Success", response);
			 }else {
			 return ResponseEntity.generateResponse(HttpStatus.BAD_REQUEST, true, "Something Went Wrong", response);
		}
		
	}
}
