package com.xupt.gj.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xupt.gj.bean.Products;
import com.xupt.gj.service.ProductService;
import com.xupt.gj.service.impl.ProductServiceImpl;

@WebServlet("/product/*")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String type = req.getParameter("flag");
		PrintWriter out = resp.getWriter();
		if (type == null)
			out.print("出错了");
		if ("add".equals(type))
			add(req, resp);
		else if ("get".equals(type)) 
			getById(req, resp);
	}

	private void getById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (!"".equals(id.trim())) {
			int ids = Integer.parseInt(id.trim());
			Products products = productService.get(ids);
			if (products != null) {
				PrintWriter out = resp.getWriter();
				StringBuilder sb = new StringBuilder();
				resp.setHeader("Content-Type", "text/html;charset=utf-8");
				sb.append("<html>").append("<head></head>")
				.append("<body>")
				.append("<table border='1' cellpadding='10' cellspacing='0' bordercolor='blue'><tr>")
				.append("<td>" + products.getId() + "</td>")
				.append("<td>" + products.getName() + "</td>")
				.append("<td>" + products.getPrice() + "</td>")
				.append("<td>" + products.getDescription() + "</td>")
				.append("</tr></table>")
				.append("</body>")
				.append("</html>");
				out.print(sb.toString());
			} else {
				PrintWriter out = resp.getWriter();
				StringBuilder sb = new StringBuilder();
				resp.setHeader("Content-Type", "text/html;charset=utf-8");
				sb.append("<html>").append("<head></head>")
				.append("<body>")
				.append("<h2><font color='red'>无此商品</font></h2>")
				.append("</body")
				.append("</html>");
				out.println(sb.toString());
			}
		} else {
			PrintWriter out = resp.getWriter();
			StringBuilder sb = new StringBuilder();
			resp.setHeader("Content-Type", "text/html;charset=utf-8");
			sb.append("<html>").append("<head></head>")
			.append("<body>")
			.append("<h2><font color='red'>请输入参数</font></h2>")
			.append("</body")
			.append("</html>");
			out.println(sb.toString());
		}
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String stock = req.getParameter("stock");
		String desc = req.getParameter("desc");
		if (name != null && price != null && stock != null && desc != null) {
			if ((!"".equals(name.trim())) && (!"".equals(price.trim())) && (!"".equals(stock.trim())) && (!"".equals(desc.trim()))) {
				Products products = new Products();
				products.setName(name);
				products.setPrice(Double.parseDouble(price));
				products.setStock(Integer.parseInt(stock));
				products.setDescription(desc);
				productService.insert(products);
				resp.sendRedirect(req.getServletContext().getContextPath() + "/finished.jsp");
			} else {
				PrintWriter out = resp.getWriter();
				StringBuilder sb = new StringBuilder();
				resp.setHeader("Content-Type", "text/html;charset=utf-8");
				sb.append("<html>").append("<head></head>")
				.append("<body><h2><font color='red'>输入参数不正确</font></h2></body>")
				.append("</html>");
				out.print(sb.toString());
			}
		} else {
			PrintWriter out = resp.getWriter();
			StringBuilder sb = new StringBuilder();
			resp.setHeader("Content-Type", "text/html;charset=utf-8");
			sb.append("<html>").append("<head></head>")
			.append("<body><h2><font color='red'>没有输入参数!</font></h2></body>")
			.append("</html>");
			out.print(sb.toString());
		}
	}

}
