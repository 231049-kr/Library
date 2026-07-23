package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class AccountDAO {

    private final String JDBC_URL = "jdbc:mysql://localhost:3306/tutorial_memo_db";
    private final String DB_USER = "root";
    private final String DB_PASS = "password";

    public User findByLogin(String id, String pass) {

        User user = null;

        try {
            // JDBCドライバの読み込み
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC");
            // データベースへ接続
            Connection conn = DriverManager.getConnection(
                    JDBC_URL, DB_USER, DB_PASS);

            // SQL

            String sql = "SELECT * FROM users WHERE user_id = ? AND password = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pass);
            System.out.println("SQL");
            ResultSet rs = pstmt.executeQuery();

            // ログイン成功
            if (rs.next()) {
                user = new User(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("pass")
                    
                );
                System.out.println("ログイン");
            }

            // 後片付け
            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("エラー");
           
        }

        return user;
    }
}
