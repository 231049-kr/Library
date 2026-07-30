package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class LoanDAO {

    private final String JDBC_URL =
            "jdbc:mysql://localhost:3306/tutorial_memo_db";

    private final String DB_USER = "root";
    private final String DB_PASS = "password";

    // 予約DBから予約中の本一覧取得
    public List<Book> selectReservedBooks() {

        List<Book> books = new ArrayList<>();

        try {

            // JDBCドライバ読み込み
            Class.forName("com.mysql.cj.jdbc.Driver");
            // DB接続
            Connection conn =
                    DriverManager.getConnection(
                            JDBC_URL,
                            DB_USER,
                            DB_PASS
                    );

            String sql = "SELECT book_id, title FROM reservation";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                Book book = new Book(
                        rs.getString("title"),
                        rs.getString("book_id")
                );

                books.add(book);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    // 返却処理（予約DBから削除）
    public boolean returnBook(String bookId) {
        boolean result = false;
        try {
            // JDBCドライバ読み込み
            Class.forName("com.mysql.cj.jdbc.Driver");

            // DB接続
            Connection conn =
                    DriverManager.getConnection(
                            JDBC_URL,
                            DB_USER,
                            DB_PASS
                    );
            String sql =  "DELETE FROM reservation WHERE book_id = ?";

            PreparedStatement pstmt =
                    conn.prepareStatement(sql);

            pstmt.setString(1, bookId);

            int count = pstmt.executeUpdate();

            if(count > 0) {
                result = true;
            }

            pstmt.close();
            conn.close();

        } catch(Exception e) {
            e.printStackTrace();

        }
        return result;

    }

}