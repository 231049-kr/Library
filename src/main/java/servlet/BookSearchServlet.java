package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.BookDAO;
import model.Book;

@WebServlet("/BookSearchServlet")
public class BookSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // JSPから検索条件を取得
        String title = request.getParameter("title");
        String bookId = request.getParameter("bookid");

        // DAOを呼び出す
        BookDAO dao = new BookDAO();
        Book book = dao.selectBookById(bookId, title);

        // 検索結果をリクエストスコープに保存
        request.setAttribute("book", book);

        // 結果画面へ遷移
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/WEB-INF/jsp/BookSearchResult.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	RequestDispatcher dispatcher =
                request.getRequestDispatcher("/WEB-INF/jsp/BookSearchResult.jsp");
        dispatcher.forward(request, response);
    }
}