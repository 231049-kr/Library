package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/tutorial_memo_db";
	private final String DB_USER = "root";
	private final String DB_PASS = "password";

	public void insertRental(String id, String name) {
		// 2枚目のテーブル（id, name, rental_date, return_date）へ挿入するSQL
		String sql = "INSERT INTO book_data (id, book_title, rental_date, return_date) VALUES (?, ?, ?, ?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			String rentalDate = LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			LocalDate twoWeeksLater = LocalDate.now().plusWeeks(2);

			// String型に変換 (例: "2026-08-11")
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String returnDate = twoWeeksLater.format(formatter);

			ps.setString(1, id); // memo_id から引き継いだ値
			ps.setString(2, name); // title から引き継いだ値（2枚目の name カラムへ）
			ps.setString(3, rentalDate); // 貸出日
			ps.setString(4, returnDate); // 返却日

			ps.executeUpdate();
			System.out.println("はいったよ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("無理だよ");
		}
	}
}
