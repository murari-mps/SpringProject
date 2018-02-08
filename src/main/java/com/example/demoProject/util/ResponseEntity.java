package com.example.demoProject.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ResponseEntity {
	public static Map<String,Object> generateResponse(HttpStatus status,Boolean error,String msg,Object object) {
		Map<String,Object> response = new HashMap<>();
		response.put("Status",status);
		response.put("error",error);
		response.put("Message",msg);
		response.put("Data",object);
		return response;
	}
}
