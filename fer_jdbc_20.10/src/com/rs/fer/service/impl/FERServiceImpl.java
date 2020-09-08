package com.rs.fer.service.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.util.DBUtil; 
public class FERServiceImpl implements FERService {

	@Override
	public boolean registration(User user) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean isUpdated = false;
		try {
			connection = DBUtil.getConnection();
			String input = "INSERT INTO user (firstName,middleName,lastName,userName,email,password,mobile) VALUES (?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(input);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getMiddleName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getUserName());
			statement.setString(5, user.getEmail());
			statement.setString(6, user.getPassword());
			statement.setString(7, user.getMobile());
			int numOfRecUpdated = statement.executeUpdate();

			isUpdated = numOfRecUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}

		return isUpdated;
	}

	@Override
	public boolean login(String UserName, String Password) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean isRegister = false;
		try {
			connection = DBUtil.getConnection();
			String input = "SELECT * FROM user WHERE userName=? and password=?";
			statement = connection.prepareStatement(input);
			statement.setString(1, UserName);
			statement.setString(2, Password);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int ID = resultSet.getInt(1);
				String FirstName = resultSet.getString(2);
				String MiddleName = resultSet.getString(3);
				String LastName = resultSet.getString(4);
				UserName = resultSet.getString(5);
				String Email = resultSet.getString(6);
				Password = resultSet.getString(7);
				String Mobile = resultSet.getString(8);
				System.out.println(ID + "," + FirstName + "," + MiddleName + "," + LastName + "," + UserName + ","
						+ Email + "," + Password + "," + Mobile);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}
		return false;
	}
	@Override
	public boolean addExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean expenseAdded = false;
		try {
			connection = DBUtil.getConnection();
			String input = "INSERT INTO expense (expenseType,date,price,numberOfItems,total,byWhom,userId) VALUES (?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(input);
			statement.setString(1, expense.getExpenseType());
			statement.setString(2, expense.getDate());
			statement.setFloat(3, expense.getPrice());
			statement.setInt(4, expense.getNumberOfItems());
			statement.setFloat(5, expense.getTotal());
			statement.setString(6, expense.getByWhom());
			statement.setInt(7, expense.getUserId());
			int numOfRecUpdated = statement.executeUpdate();

			expenseAdded = numOfRecUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}
		return expenseAdded;
	}

	@Override
	public boolean editExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean expenseEdited = false;
		try {
			connection = DBUtil.getConnection();
			String input = "UPDATE expense SET expenseType=?,date=? , price=?, numberOfItems=?, total=?, byWhom=? WHERE expenseId=? ";
			statement = connection.prepareStatement(input);
			statement.setString(1, expense.getExpenseType());
			statement.setString(2, expense.getDate());
			statement.setFloat(3, expense.getPrice());
			statement.setInt(4, expense.getNumberOfItems());
			statement.setFloat(5, expense.getTotal());
			statement.setString(6, expense.getByWhom());
			//statement.setInt(7, expense.getUserId());
			statement.setInt(7, expense.getExpenseId());
			int numOfRecUpdated = statement.executeUpdate();

			expenseEdited = numOfRecUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}
		return expenseEdited;

	}

	@Override
	public boolean deleteExpense(int ExpenseId) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean expenseDeleted = false;
		try {
			connection = DBUtil.getConnection();
			String input = "DELETE FROM expense WHERE expenseId=? ";
			statement = connection.prepareStatement(input);

			statement.setInt(1, ExpenseId);

			int numOfRecUpdated = statement.executeUpdate();

			expenseDeleted = numOfRecUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}
		return expenseDeleted ;

	}

	@Override
	public boolean resetPassword(int ID, String currentPassword, String newPassword) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean isUpdated = false;
		try {
			connection = DBUtil.getConnection();
			String input = "Update user SET password=? WHERE id=? and password=? ";
			statement = connection.prepareStatement(input);

			statement.setString(1,newPassword);
			statement.setInt(2, ID);
			statement.setString(3, currentPassword);

			int numOfRecUpdated = statement.executeUpdate();

			isUpdated = numOfRecUpdated > 0;
			
			System.out.println( numOfRecUpdated );
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}
		return isUpdated;
	}

	@Override
	public List<Expense> getExpenses(int UserId) {
		List<Expense> expenses = new ArrayList<Expense>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBUtil.getConnection();
			String input = "select * from expense where userId=?";
			statement = connection.prepareStatement(input);

			statement.setInt(1, UserId);

			ResultSet resultSet = statement.executeQuery();

			Expense expense = null;
			while (resultSet.next()) {

				expense = new Expense();

				expense.setExpenseId(resultSet.getInt(1));
				expense.setExpenseType(resultSet.getString(2));
				expense.setDate(resultSet.getString(3));
				expense.setPrice(resultSet.getFloat(4));
				expense.setNumberOfItems(resultSet.getInt(5));
				expense.setTotal(resultSet.getFloat(6));
				expense.setByWhom(resultSet.getString(7));
				expense.setUserId(resultSet.getInt(8));
				expenses.add(expense);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}
		return expenses;
	}

	@Override
	public Expense getExpense(int ExpenseId) {
		Expense expense=new Expense();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBUtil.getConnection();
			String input = "select * from expense where expenseId=?";
			statement = connection.prepareStatement(input);

			statement.setInt(1, ExpenseId);

			ResultSet resultSet = statement.executeQuery();

			expense = null;
			while (resultSet.next()) {

				expense = new Expense();

				expense.setExpenseId(resultSet.getInt(1));
				expense.setExpenseType(resultSet.getString(2));
				expense.setDate(resultSet.getString(3));
				expense.setPrice(resultSet.getFloat(4));
				expense.setNumberOfItems(resultSet.getInt(5));
				expense.setTotal(resultSet.getFloat(6));
				expense.setByWhom(resultSet.getString(7));
				expense.setUserId(resultSet.getInt(8));
				//System.out.println("ExpenseType : " +expense.getExpenseType()+ " ,"+ "Date : " + expense.getDate()+ ","+ "Price : " + expense.getPrice()+"," + "numberofitems : " + expense.getNumberOfItems()+ "," + "total : " + expense.getTotal()+ "," +"ByWhom : "+expense.getByWhom());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}
		return expense;
	}

	@Override
	public List<Expense> expenseReport(int UserId, String ExpenseType, String fromDate, String toDate) {
		Connection connection = null;
		List<Expense> expenseReport = new ArrayList<Expense>();
		PreparedStatement statement = null;
		try {
			connection = DBUtil.getConnection();
			String input = "select * from expense where userId=? and expenseType=? and date between ? and ? ";
			statement = connection.prepareStatement(input);
			statement.setInt(1, UserId);
			statement.setString(2, ExpenseType);
			statement.setString(3, fromDate);
			statement.setString(4, toDate);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Expense expense = new Expense();
				expense.setExpenseId(resultSet.getInt(1));
				expense.setExpenseType(resultSet.getString(2));
				expense.setDate(resultSet.getString(3));
				expense.setPrice(resultSet.getFloat(4));
				expense.setNumberOfItems(resultSet.getInt(5));
				expense.setTotal(resultSet.getFloat(6));
				expense.setByWhom(resultSet.getString(7));
				expense.setUserId(resultSet.getInt(8));
				expenseReport.add(expense);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}

		return expenseReport;
	}

	@Override
	public User getUser(int UserId) {
		User user = new User();
		Address address = new Address();
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();

			String inputQuery = "select u.*,a.* From user u right join address a on u.id=a.userid where u.id=? ";

			PreparedStatement preparedStatement = connection.prepareStatement(inputQuery);

			preparedStatement.setInt(1, UserId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				user.setId(resultSet.getInt(1));
				user.setFirstName(resultSet.getString(2));
				user.setMiddleName(resultSet.getString(3));
				user.setLastName(resultSet.getString(4));
				user.setUserName(resultSet.getString(5));
				user.setEmail(resultSet.getString(6));
				user.setPassword(resultSet.getString(7));
				user.setMobile(resultSet.getString(8));
				
				address.setId(resultSet.getInt(9));
				address.setLine1(resultSet.getString(10));
				address.setLine2(resultSet.getString(11));
				address.setPinCode(resultSet.getString(12));
				address.setCity(resultSet.getString(13));
				address.setState(resultSet.getString(14));
				address.setCountry(resultSet.getString(15));
				address.setUserId(resultSet.getInt(16));
				
				user.setAddress(address);
				System.out.println(user.getId() + "," + user.getFirstName() + "," + user.getMiddleName() + "," + user.getLastName() + "," + user.getUserName() + ","
						+ user.getEmail() + "," + user.getPassword() + "," + user.getMobile()+ "," + address.getLine1()+ "," + address.getLine2()+ "," + address.getPinCode()+ "," + address.getCity());
				
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean isUpdated = false;
		try {
			connection = DBUtil.getConnection();
			connection.setAutoCommit(false);
			
			String input = "Update user set firstName=?,middleName=?,lastName=?,userName=?,email=?,password=?,mobile=? where id=?";
			statement = connection.prepareStatement(input);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getMiddleName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getUserName());
			statement.setString(5, user.getEmail());
			statement.setString(6, user.getPassword());
			statement.setString(7, user.getMobile());
			statement.setInt(8, user.getId());
			int numOfRecUpdated = statement.executeUpdate();
			System.out.println(numOfRecUpdated);
			isUpdated = numOfRecUpdated > 0;
			
			Address address = user.getAddress();

			int addressId=user.getAddress().getId(); 
			if (addressId > 0)
			{
				String input1 = "update address set line1=?, line2=?, pincode=?, city=?, state=?, country=? where id=? ";

				PreparedStatement statement1 = connection.prepareStatement(input1);
				statement1.setString(1, address.getLine1());
				statement1.setString(2, address.getLine2());
				statement1.setString(3, address.getPinCode());
				statement1.setString(4, address.getCity());
				statement1.setString(5, address.getState());
				statement1.setString(6, address.getCountry());
				//statement1.setInt(7, address.getID());
				int numOfRecUpdated1  = statement1.executeUpdate() ;
				System.out.println(numOfRecUpdated1);
				
			} 
			else {
				 String input2 = "INSERT INTO address(line1,line2,pincode,city,state,country,userId) VALUES (?,?,?,?,?,?,?)";
				
				 PreparedStatement statement2 = connection.prepareStatement(input2);
				statement2.setString(1, address.getLine1());
				statement2.setString(2, address.getLine2());
				statement2.setString(3, address.getPinCode());
				statement2.setString(4, address.getCity());
				statement2.setString(5, address.getState());
				statement2.setString(6, address.getCountry());
				statement2.setInt(7, address.getUserId());
				int numOfRecUpdated2 = statement2.executeUpdate();
				System.out.println(numOfRecUpdated2);
			}
			if(isUpdated)
			{
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}

		return isUpdated;
	}

}
