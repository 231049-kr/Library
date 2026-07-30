package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.LoanDAO;
import model.Book;


@WebServlet("/LoanServlet")
public class LoanServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    // 貸出・返却画面表示
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        LoanDAO dao = new LoanDAO();


        // 予約DBから取得
        List<Book> books =
                dao.selectReservedBooks();


        // JSPへ渡す
        request.setAttribute("books", books);



        request.getRequestDispatcher(
                "/WEB-INF/jsp/LoanProcessing.jsp")
                .forward(request, response);

    }



    // 返却処理
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");


        String bookId =
                request.getParameter("bookId");


        LoanDAO dao = new LoanDAO();


        boolean result =
                dao.returnBook(bookId);



        if(result) {


            // 削除後一覧を再表示
            response.sendRedirect("LoanServlet");


        } else {


            request.setAttribute(
                    "message",
                    "返却に失敗しました");


            request.getRequestDispatcher(
                    "/WEB-INF/jsp/Error.jsp")
                    .forward(request, response);

        }

    }

}