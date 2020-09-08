package com.rs.fer.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpensesMain {
	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		List<Expense> expenses = new ArrayList<Expense>();
		expenses = ferService.getExpenses(1);
		Iterator<Expense> iterator = expenses.iterator();
		while (iterator.hasNext()) {
			Expense expense = null;
			expense = iterator.next();
			System.out.println("ExpenseType : " + expense.getExpenseType() + " ," + "Date : " + expense.getDate() + ","
					+ "Price : " + expense.getPrice() + "," + "numberofitems : " + expense.getNumberOfItems() + ","
					+ "total : " + expense.getTotal() + "," + "ByWhom : " + expense.getByWhom());

		}
	}
}
