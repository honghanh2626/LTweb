package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.UserServiceImpl;
import vn.iotstar.utils.constant;

import java.io.IOException;


/**
 * Servlet implementation class dangNhap
 */
@WebServlet("/dangNhap1")
public class dangNhap1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dangNhap1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			response.sendRedirect(request.getContextPath() + "/LonginSuccess.jsp");
			return;
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isRememberMe = false;
		String remember = request.getParameter("remember");

		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = "";
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		System.out.println("yes");
		UserServiceImpl service = new UserServiceImpl();
		UserModel user = service.login(username, password);
		if (user != null) {
			System.out.println(user.getUserName() + "" + user.getPassWord());
			HttpSession session = request.getSession(true);
			session.setAttribute("account", user);
			if (isRememberMe) {
				saveRemeberMe(response, username);
			}
			response.sendRedirect(request.getContextPath() + "/LonginSuccess.jsp");
		} else {
			System.out.println("no");
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	private void saveRemeberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
	}

}
