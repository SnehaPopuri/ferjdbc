package com.rs.fer.service;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;

public interface FERService {

	boolean registration(User user);

	boolean login(String UserName, String Password);

	boolean addExpense(Expense expense);

	boolean editExpense(Expense expense);

	boolean deleteExpense(int ExpenseId);

	boolean resetPassword(int ID, String currentPassword, String newPassword);

	List<Expense> getExpenses(int UserId);

	Expense getExpense(int ExpenseId);

	List<Expense> expenseReport(int UserId, String ExpenseType, String fromDate, String toDate);

	User getUser(int UserId);

	boolean updateUser(User user);
}
