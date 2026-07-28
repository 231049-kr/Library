package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReserveServlet
 */
@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String bookId = request.getParameter("book_id");
		String title = request.getParameter("book_title");

		request.setAttribute("bookId", bookId);
		request.setAttribute("title", title);

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/ReserveRegist.jsp");
		dispatcher.forward(request, response);
	}
}
	
		



