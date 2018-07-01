package com.xupt.gj.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xupt.gj.bean.Users;
import com.xupt.gj.service.UserService;
import com.xupt.gj.service.impl.UserServiceImpl;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1980761545472087316L;
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String type = req.getParameter("flag");
		PrintWriter out = resp.getWriter();
		if (type == null)
			out.print("出错了");
		if ("register".equals(type)) {
			register(req, resp);		
		} else if ("login".equals(type)) {
			login(req, resp);
		}
			
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		if (username != null && password != null && age != null) {
			if (!"".equals(username.trim()) && !"".equals(password.trim()) && !"".equals(age.trim())) {
				Users user = new Users();
				user.setName(username);
				user.setPassword(password);
				user.setAge(Integer.parseInt(age));
				userService.insert(user);
				request.getSession().setAttribute("user", username);
				request.getSession().setAttribute("target", "register");
				response.sendRedirect(request.getServletContext().getContextPath() + "/success.jsp");
			} else {
				PrintWriter out = response.getWriter();
				StringBuilder sb = new StringBuilder();
				response.setHeader("Content-Type", "text/html;charset=utf-8");
				sb.append("<html>").append("<head></head>")
				.append("<body>")
				.append("<h2><font color='red'>请检查输入是否正确</font></h2>")
				.append("</body")
				.append("</html>");
				out.println(sb.toString());
			}
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username != null && password != null) {
			if (!"".equals(username.trim()) && !"".equals(password.trim())) {
				Users user = userService.get(username);
				if (user != null) {
					if (username.equals(user.getName()) && password.equals(user.getPassword())) {
						request.getSession().setAttribute("user", username);
						request.getSession().setAttribute("target", "login");
						request.getRequestDispatcher("/product.jsp").forward(request, response);
					} else {
						PrintWriter out = response.getWriter();
						StringBuilder sb = new StringBuilder();
						response.setHeader("Content-Type", "text/html;charset=utf-8");
						sb.append("<html>").append("<head></head>")
						.append("<body>")
						.append("<h2><font color='red'>请检查用户名或密码是否正确</font></h2>")
						.append("</body")
						.append("</html>");
						out.println(sb.toString());
					}
				} else {
					PrintWriter out = response.getWriter();
					StringBuilder sb = new StringBuilder();
					response.setHeader("Content-Type", "text/html;charset=utf-8");
					sb.append("<html>").append("<head></head>")
					.append("<body>")
					.append("<h2><font color='red'>此用户不存在</font></h2>")
					.append("</body")
					.append("</html>");
					out.println(sb.toString());
				}
			} else {
				PrintWriter out = response.getWriter();
				StringBuilder sb = new StringBuilder();
				response.setHeader("Content-Type", "text/html;charset=utf-8");
				sb.append("<html>").append("<head></head>")
				.append("<body>")
				.append("<h2><font color='red'>请检查输入是否正确</font></h2>")
				.append("</body")
				.append("</html>");
				out.println(sb.toString());
			}
			
		}
	}
}
