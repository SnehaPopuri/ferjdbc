package com.rs.fer.main;

import java.util.Scanner;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class RegistrationMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter FirstName: ");
		String FirstName = s.nextLine();
		System.out.println("Enter MiddleName: ");
		String MiddleName = s.nextLine();
		System.out.println("Enter LastName: ");
		String LastName = s.nextLine();
		System.out.println("Enter UserName: ");
		String UserName = s.nextLine();
		System.out.println("Enter Email: ");
		String Email = s.nextLine();
		System.out.println("Enter Password: ");
		String Password = s.nextLine();
		System.out.println("Enter Mobile: ");
		String Mobile = s.next();
		FERService ferservice = new FERServiceImpl();
		User user = new User();
		user.setFirstName(FirstName);
		user.setMiddleName(MiddleName);
		user.setLastName(LastName);
		user.setUserName(UserName);
		user.setEmail(Email);
		user.setPassword(Password);
		user.setMobile(Mobile);
		boolean isExecuted = ferservice.registration(user);

		if (isExecuted) {
			System.out.println("Registerd Successfully");
		} else {
			System.out.println("Registration Failed");
	}
}
}