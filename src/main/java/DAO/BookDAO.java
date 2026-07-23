package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Book;

public class BookDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/tutorial_memo_db";
	private final String DB_USER = "root";
	private final String DB_PASS = "password";

	public Book selectBookById(String bookId, String title) {
		Book book = null;
		try {
			// JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースへ接続
			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			
			 String sql = "SELECT * FROM reading_memos WHERE memo_id = ? AND title = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bookId);
			 pstmt.setString(2, title);
			 
			 ResultSet rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
}