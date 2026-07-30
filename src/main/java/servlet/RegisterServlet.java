package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.RentalDAO;

public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// JSPから送られてきた id と title を取得
		String id = request.getParameter("id");
		String title = request.getParameter("title");

		// 参照先テーブル用のDAOを実行
		RentalDAO rentalDao = new RentalDAO();
		rentalDao.insertRental(id, title);

		// 完了画面または一覧へリダイレクト
		response.sendRedirect("success.jsp");
	}
}