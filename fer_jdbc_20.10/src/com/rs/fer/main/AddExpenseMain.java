package com.rs.fer.main;

import java.util.Scanner;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class AddExpenseMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		FERService ferservice = new FERServiceImpl();
		Expense expense = new Expense();

		System.out.println("Enter expensetype: ");
		String ExpenseType = s.nextLine();
		System.out.println("Enter date :  ");
		String Date = s.nextLine();
		System.out.println("Enter price: ");
		float Price = s.nextFloat();
		System.out.println("Enter Numberofitems: ");
		int NumberOfItems = s.nextInt();
		System.out.println("Enter total: ");
		float Total = s.nextFloat();
		System.out.println("Enter bywhom: ");
		String ByWhom = s.next();
		System.out.println("Enter userid : ");
		int UserId = s.nextInt();

		expense.setExpenseType(ExpenseType);
		expense.setDate(Date);
		expense.setPrice(Price);
		expense.setNumberOfItems(NumberOfItems);
		expense.setTotal(Total);
		expense.setByWhom(ByWhom);
		expense.setUserId(UserId);
		boolean isExecuted = ferservice.addExpense(expense);

		if (isExecuted) {
			System.out.println("Expense added Successfully");
		} else {
			System.out.println("Failed");
		}
	}
}
