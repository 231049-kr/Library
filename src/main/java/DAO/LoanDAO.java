package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LoanDAO {

    private final String JDBC_URL = "jdbc:mysql://localhost:3306/tutorial_memo_db";
    private final String DB_USER = "root";
    private final String DB_PASS = "password";

    public boolean returnBook(int bookId) {

        try {

            // JDBCドライバ読み込み
            Class.forName("com.mysql.cj.jdbc.Driver");

            // DB接続
            Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            // ===== このSQLはDB担当が修正 =====
            String sql =
                "UPDATE books SET quantity = quantity + 1 WHERE book_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, bookId);

            int result = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            return result > 0;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }
}