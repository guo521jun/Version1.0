package com.xupt.gj.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xupt.gj.bean.Products;
import com.xupt.gj.service.ProductService;
import com.xupt.gj.service.impl.ProductServiceImpl;

@WebServlet("/product/detail")
public class ProductDetailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		detail(request, response);
	}
	
	private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Products> result = productService.list();
		if (result == null)
			result = new ArrayList<>();
		req.getSession().setAttribute("result", result);
		System.out.println(result);
		req.getRequestDispatcher("/detail.jsp").forward(req, resp);
	}

}
