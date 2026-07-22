package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Book;

public class BookDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/tutorial_memo_db";
	private final String DB_USER = "root";
	private final String DB_PASS = "password";

	public Book selectBookById(String bookId) {
		Book book = null;
		String sql = "SELECT memo_id FROM reading_memo_db";
		try {
			// JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースへ接続
			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
}