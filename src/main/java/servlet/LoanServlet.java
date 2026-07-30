package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.LoanDAO;

/**
 * Servlet implementation class LoanServlet
 */
@WebServlet("/LoanServlet")
public class LoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LoanProcessing.jsp");
        dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 request.setCharacterEncoding("UTF-8");

	        String bookId = (request.getParameter("BookId"));
	        String bookTitle = (request.getParameter("Title"));
	        LoanDAO dao = new LoanDAO();

	        boolean result = dao.returnBook(bookId,bookTitle);

	        if(result) {

	            request.getRequestDispatcher("/WEB-INF/jsp/LoanProcessing.jsp")
                .forward(request, response);

	        }else {

	            request.setAttribute("message", "返却に失敗しました");

	            request.getRequestDispatcher("/WEB-INF/jsp/Error.jsp")
	                   .forward(request, response);
	        }
	}

}
