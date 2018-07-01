package com.xupt.gj.service.impl;

import java.util.List;

import com.xupt.gj.bean.Users;
import com.xupt.gj.dao.UserDAO;
import com.xupt.gj.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO dao = new UserDAO();
	
	@Override
	public int insert(Users users) {
		return dao.save(users);
	}

	@Override
	public int delete(Integer id) {
		return dao.delete(id);
	}

	@Override
	public Users get(Integer id) {
		return dao.get(id);
	}

	@Override
	public List<Users> list() {
		return dao.list();
	}

	@Override
	public Users get(String name) {
		return dao.get(name);
	}

}
