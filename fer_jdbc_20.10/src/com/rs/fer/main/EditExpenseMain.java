package com.rs.fer.main;

import java.util.Scanner;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class EditExpenseMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		FERService ferservice = new FERServiceImpl();

		System.out.println("Enter expensetype: ");
		String ExpenseType = s.nextLine();
		System.out.println("Enter date :  ");
		String Date = s.nextLine();
		System.out.println("Enter Price : ");
		float Price = s.nextFloat();
		System.out.println("Enter NumberOfItems : ");
		int NumberOfItems = s.nextInt();
		System.out.println("Enter Total : ");
		Float Total = s.nextFloat();
		System.out.println("Enter ByWhom : ");
		String ByWhom = s.next();
		System.out.println("Enter userid : ");
		int UserId = s.nextInt();
		System.out.println("Enter expenseid : ");
		int ExpenseId = s.nextInt();

		Expense expense = new Expense();
		expense.setExpenseType(ExpenseType);
		expense.setDate(Date);
		expense.setPrice(Price);
		expense.setNumberOfItems(NumberOfItems);
		expense.setByWhom(ByWhom);
		expense.setTotal(Total);
		expense.setUserId(UserId);
		expense.setExpenseId(ExpenseId);

		boolean isExecuted = ferservice.editExpense(expense);

		if (isExecuted) {
			System.out.println("Expense Edited Successfully");
		} else {
			System.out.println("Failed");
		}
	}
}
