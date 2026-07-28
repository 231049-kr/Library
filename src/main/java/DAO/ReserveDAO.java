package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ReserveDAO {

    private final String JDBC_URL = "jdbc:mysql://localhost:3306/tutorial_memo_db";
    private final String DB_USER = "root";
    private final String DB_PASS = "password";

    public boolean reserveBook(String title) {

        boolean result = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    JDBC_URL, DB_USER, DB_PASS);

            String sql =
                    "INSERT INTO reservations "
                  + "(book_title, reserve_date, return_date) "
                  + "VALUES (?, CURRENT_TIMESTAMP, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 7 DAY))";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, title);

            int count = pstmt.executeUpdate();

            if (count == 1) {
                result = true;
            }

            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}