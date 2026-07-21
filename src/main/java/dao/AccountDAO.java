package dao;

import model.User;

public class AccountDAO {
	
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/tutorial_memo_db";
	private final String DB_USER = "root";
	private final String DB_PASS = "password";
	
public User findByUser(User user) {
	
	//JDBCドライバを読み込む
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	} catch(ClassNotFoundException e) {
		
		throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	}
	
}}