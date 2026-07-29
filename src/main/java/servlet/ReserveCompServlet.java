package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.RentalDAO;

/**
 * Servlet implementation class ReserveCompServlet
 */
@WebServlet("/ReserveCompServlet")
public class ReserveCompServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveCompServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		// JSPから送られてきた id と title を取得
		String id = request.getParameter("id");
		String title = request.getParameter("title");

		// 参照先テーブル用のDAOを実行
		RentalDAO rentalDao = new RentalDAO();
		rentalDao.insertRental(id, title);

		  RequestDispatcher dispatcher =
	                request.getRequestDispatcher("/WEB-INF/jsp/ReserveComplete.jsp");
	        dispatcher.forward(request, response);
	}

}
