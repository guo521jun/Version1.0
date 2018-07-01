package com.xupt.gj.service;

import java.util.List;

import com.xupt.gj.bean.Products;

public interface ProductService {
	
	int insert(Products products);
	
	int delete(Integer id);
	
	Products get(Integer id);
	
	int getStock(Integer id);
	
	List<Products> list();
}
