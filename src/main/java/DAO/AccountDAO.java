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
    
    //ログイン
    public User findByLogin(String id, String pass) {

        User user = null;

        try {
            // JDBCドライバの読み込み
            Class.forName("com.mysql.cj.jdbc.Driver");
            // データベースへ接続
            Connection conn = DriverManager.getConnection(
                    JDBC_URL, DB_USER, DB_PASS);

            // SQL

            String sql = "SELECT * FROM users WHERE user_id = ? AND password = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            
            // ログイン成功
            if (rs.next()) {
                user = new User(
                    rs.getString("user_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getInt("role")
                );
            }

            // 後片付け
            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
           
        }

        return user;
    }
    
    //ユーザー登録
    public int insert(String name, String pass, int role) {
    	
    	try {
    		 // JDBCドライバの読み込み
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC");
            // データベースへ接続
            Connection conn = DriverManager.getConnection(
                    JDBC_URL, DB_USER, DB_PASS);

            String sql = "INSERT INTO users(username, password, role) VALUES(?, ?)";
            
            PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, name);
            pstmt.setString(2, pass);
            pstmt.setInt(3, role);
            int result = pstmt.executeUpdate();
            
            if (result == 1) {
            	ResultSet rs = pstmt.getGeneratedKeys();
            	
            	if (rs.next()) {
            		int userId = rs.getInt(1);
            		return userId;
            	}
            }
    	} catch (Exception e) {
            e.printStackTrace();
        }
    	return -1;
    }
    
    //ユーザー更新
    
}
