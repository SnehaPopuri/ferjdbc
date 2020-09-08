package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpenseMain {
	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		int ExpenseId = 3;
		Expense expense = ferService.getExpense(ExpenseId);
		System.out.println("ExpenseType : " + expense.getExpenseType() + " ," + "Date : " + expense.getDate() + ","
				+ "Price : " + expense.getPrice() + "," + "numberofitems : " + expense.getNumberOfItems() + ","
				+ "total : " + expense.getTotal() + "," + "ByWhom : " + expense.getByWhom());
	}
}
