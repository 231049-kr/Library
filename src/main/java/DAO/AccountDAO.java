package DAO;

import java.sql.SQLException;

import model.User;

public class AccountDAO {
	
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/tutorial_memo_db";
	private final String DB_USER = "root";
	private final String DB_PASS = "password";

	
	//JDBCドライバを読み込む
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	} catch(ClassNotFoundException e) {
		
		throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	}
	try {Connection conn= DBManager.getConnection((JDBC_URL, DB_USER, DB_PASS)){
		System.out.println("接続");
		
	}catch(SQLException e){
		e.printStackTrace();
		return null;
	}
	}
}
