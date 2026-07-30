package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LibraryDAO {

	 private final String JDBC_URL = "jdbc:mysql://localhost:3306/tutorial_memo_db";
	 private final String DB_USER = "root";
	 private final String DB_PASS = "password";
	 
	 public boolean insert(String bookId, String title, String status) {
		 
		 try {
			// JDBCドライバの読み込み
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // データベースへ接続
	        Connection conn = DriverManager.getConnection(
	        		JDBC_URL, DB_USER, DB_PASS);
			 
			 String sql = "INSERT INTO reading_memos(memo_id, title, status) VALUES(?, ?, ?)";
			 
			 String memo_id = bookId;
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, memo_id);
			 pstmt.setString(2, title);
			 pstmt.setString(3, status);
			 
			 int result = pstmt.executeUpdate();
			 
			 return result > 0;
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 return false;
	 }
}
