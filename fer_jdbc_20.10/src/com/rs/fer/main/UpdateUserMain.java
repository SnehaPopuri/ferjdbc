package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class UpdateUserMain {
	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		User user = new User();
		Address address = new Address();

		int ID = 1;
		user.setId(ID);
		user.setFirstName("Sneha");
		user.setMiddleName("Sneha");
		user.setLastName("Sneha");
		user.setUserName("Sneha");
		user.setEmail("Sneha");
		user.setPassword("Sneha");
		user.setMobile("Sneha");
		user.setAddress(address);

		int addressId = 1;
		address.setLine1("fghj");
		address.setLine1("fghj");
		address.setPinCode("asdxfcv012");
		address.setCity("fghj");
		address.setState("fghj");
		address.setCountry("fghj");
		address.setUserId(addressId);
		boolean isUpdateUser = ferService.updateUser(user);
		if (isUpdateUser) {
			System.out.println("success");
		} else
			System.out.println("failed");

	}
}
