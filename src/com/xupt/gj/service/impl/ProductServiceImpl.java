package com.xupt.gj.service.impl;

import java.util.List;

import com.xupt.gj.bean.Products;
import com.xupt.gj.dao.ProductDAO;
import com.xupt.gj.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductDAO dao = new ProductDAO();
	
	@Override
	public int insert(Products products) {
		return dao.save(products);
	}

	@Override
	public int delete(Integer id) {
		return dao.delete(id);
	}

	@Override
	public Products get(Integer id) {
		return dao.get(id);
	}

	@Override
	public int getStock(Integer id) {
		return dao.getStock(id);
	}

	@Override
	public List<Products> list() {
		return dao.list();
	}

}
