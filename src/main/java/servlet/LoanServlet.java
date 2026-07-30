package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
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


    // 貸出・返却一覧表示
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        LoanDAO dao = new LoanDAO();


        // 予約DBから一覧取得
        List<Book> books = dao.findAll();


        request.setAttribute("books", books);



        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/WEB-INF/jsp/LoanProcessing.jsp");


        dispatcher.forward(request, response);

    }



    // 返却処理
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");


        // JSPのname="bookId"と合わせる
        String bookId =
                request.getParameter("bookId");



        LoanDAO dao = new LoanDAO();



        boolean result =
                dao.returnBook(bookId);



        if(result){


            // 削除後、一覧再表示
            response.sendRedirect(
                    "LoanServlet");


        }else{


            request.setAttribute(
                    "message",
                    "返却に失敗しました");


            request.getRequestDispatcher(
                    "/WEB-INF/jsp/Error.jsp")
                    .forward(request,response);

        }

    }

}