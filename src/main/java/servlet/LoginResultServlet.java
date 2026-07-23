package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.AccountDAO;
import model.User;

/**
 * Servlet implementation class LoginResultServlet
 */
@WebServlet("/LoginResultServlet")
public class LoginResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		
		AccountDAO dao = new AccountDAO();
		User user = dao.findByLogin(id, pw);
		
		if (user != null) {
			
			if (id.length() == 8) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AdminMenu");//後で書き換え
				dispatcher.forward(request, response);
			}else if (id.length() == 6) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LibrarianMenu");//後で書き換え
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserMenuScreen");
				dispatcher.forward(request, response);
			}
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LoginResult");
			dispatcher.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
