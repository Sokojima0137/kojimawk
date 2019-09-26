package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBManager;

/**
 * Servlet implementation class Registerservlet2
 */
@WebServlet(name = "RegisterServlet2", urlPatterns = { "/RS2" })
public class Registerservlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 直接アクセスがあった場合は index.jsp に処理を転送
		RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
				request.setCharacterEncoding("UTF-8");

				String loginId = request.getParameter("loginId");
				String password = request.getParameter("password");
				String userName = request.getParameter("userName");
				String icon = request.getParameter("icon");
				String profile = request.getParameter("profile");
				RequestDispatcher dispatcher = null;
				String button = request.getParameter("button1");


				DBManager dbm = new DBManager();


				//確認で"はい"が取れたらDBに登録
				if("btn1".equals(button)) {

				// ユーザー情報をDBに登録
				dbm.registerUser(loginId, password, userName, icon, profile);

				// RegistrationComplete.jsp に処理を転送
				dispatcher = request.getRequestDispatcher("RegistrationComplete.jsp");
				dispatcher.forward(request, response);
				}else {
					dispatcher = request.getRequestDispatcher("Register.jsp");
					dispatcher.forward(request, response);
				}
	}

}
