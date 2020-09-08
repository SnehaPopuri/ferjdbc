package com.rs.fer.main;

import java.util.Scanner;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class DeleteExpenseMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		FERService ferservice = new FERServiceImpl();

		System.out.println("Enter expenseid : ");
		int ExpenseId = s.nextInt();
		Expense expense = new Expense();
		expense.setExpenseId(ExpenseId);
		boolean isExecuted = ferservice.deleteExpense(ExpenseId);

		if (isExecuted) {
			System.out.println("Expense Deleted Successfully");
		} else {
			System.out.println("Failed");
		}

	}
}
