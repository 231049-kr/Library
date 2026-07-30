package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.LibraryDAO;

/**
 * Servlet implementation class LibraryManagementServlet
 */
@WebServlet("/LibraryManagementServlet")
public class LibraryManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LibraryManagement.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		switch(action) {
		case "insert":
			String Iid = request.getParameter("bookId");
			String title = request.getParameter("title");
			String status = request.getParameter("status");
			
			LibraryDAO dao = new LibraryDAO();
			boolean result = dao.insert(Iid, title, status);
			
			if(result) {
				request.setAttribute("message", "蔵書を登録しました。");
			}else {
				request.setAttribute("message", "蔵書の登録に失敗しました。");
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LibraryResult.jsp");
			dispatcher.forward(request, response);
			
			
		break;
		
		}
	}

}
