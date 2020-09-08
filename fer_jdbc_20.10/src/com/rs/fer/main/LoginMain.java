package com.rs.fer.main;

import java.util.Scanner;

import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class LoginMain {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		FERService ferService = new FERServiceImpl();
		System.out.println("Enter Username: ");
		String UserName = s.nextLine();
		System.out.println("Enter Password: ");
		String Password = s.next();
		boolean isValid = ferService.login(UserName, Password);
		if (isValid) {
			System.out.println("User is valid");

		} else {
			System.out.println("User is invalid");
		}

	}

}
