package com.rs.fer.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class ExpenseReportMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		FERService ferService = new FERServiceImpl();

		System.out.println("Enter userid: ");
		int UserId = s.nextInt();
		System.out.println("Enter expensetype: ");
		String ExpenseType = s.next();
		System.out.println("Enter fromdate: ");
		String fromDate = s.next();
		System.out.println("Enter todate: ");
		String toDate = s.next();

		List<Expense> expenseReport = ferService.expenseReport(UserId, ExpenseType, fromDate, toDate);
		Iterator<Expense> iterator = expenseReport.iterator();
		while (iterator.hasNext()) {
			Expense expense = null;
			expense = iterator.next();
			System.out.println("ExpenseType : " + expense.getExpenseType() + " ," + "Date : " + expense.getDate() + ","
					+ "Price : " + expense.getPrice() + "," + "numberofitems : " + expense.getNumberOfItems() + ","
					+ "total : " + expense.getTotal() + "," + "ByWhom : " + expense.getByWhom());

		}
	}
}
