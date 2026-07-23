package servlet;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.BookDAO;

/**
 * Servlet implementation class BookSerchReServlet
 */
@WebServlet("/BookSerchReServlet")
public class BookSerchReServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		
		BookDAO dao = new BookDAO();
        List<Book> books = dao.findByTitle(title);

        request.setAttribute("books", books);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/WEB-INF/jsp/BookSearchResult.jsp");
        dispatcher.forward(request, response);
	}

}
