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
 * Servlet implementation class UserManagementServlet
 */
@WebServlet("/UserManagementServlet")
public class UserManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserManagement.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		switch (action) {
		case "insert":
			String Iname = request.getParameter("name");
			String Ipw = request.getParameter("password");
			int Irole = 3;
			
			AccountDAO dao = new AccountDAO();
			int user = dao.insert(Iname, Ipw, Irole);
			
			if(user != -1) {
				request.setAttribute("user", user);
				
				request.getRequestDispatcher("")//飛ばし先後で決める
				.forward(request, response);
			}
			break;
		case "update":
			String Uid = request.getParameter("userId");
			String Uname = request.getParameter("name");
			String Upw = request.getParameter("password");
			int Urole = Integer.parseInt(request.getParameter("role"));
			
			User Uuser = new User(Uid, Uname, Upw, Urole);
			break;
		case "delete":
			
			break;
		}
	}

}
