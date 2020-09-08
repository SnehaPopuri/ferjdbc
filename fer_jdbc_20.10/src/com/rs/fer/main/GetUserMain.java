package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetUserMain {
	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		User user = new User();
		Address address = user.getAddress();
		int UserId = 1;
		User isExecuted = ferService.getUser(UserId);

		if (isExecuted != null) {
			System.out.println(" Successfully");
		} else {
			System.out.println("Failed");
		}

	}
}
