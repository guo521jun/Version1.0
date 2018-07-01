package com.xupt.gj.service;

import java.util.List;

import com.xupt.gj.bean.Users;

public interface UserService {

	int insert(Users users);
	
	int delete(Integer id);
	
	Users get(Integer id);
	
	Users get(String name);
	
	List<Users> list();
}
