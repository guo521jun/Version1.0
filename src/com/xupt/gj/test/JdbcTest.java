package com.xupt.gj.test;

import java.sql.Connection;
import java.util.List;

import com.xupt.gj.bean.Products;
import com.xupt.gj.bean.Users;
import com.xupt.gj.dao.ProductDAO;
import com.xupt.gj.dao.UserDAO;
import com.xupt.gj.util.DataSourceUtil;

public class JdbcTest {

	public static void main(String[] args) {
		Connection conn = DataSourceUtil.getConnection();
		System.out.println(conn);
		
		UserDAO dao = new UserDAO();
		Users users = new Users();
//		users.setName("科比");
//		users.setPassword("818181");
//		users.setAge(36);
//		dao.save(users);
		
//		users.setName("詹姆斯");
//		users.setPassword("666666");
//		users.setAge(32);
//		dao.save(users);
		
//		Users users2 = dao.get(2);
//		System.out.println(users2);
		
		List<Users> list = dao.list();
		for (Users users2 : list) {
			System.out.println(users2);
		}
		
		
		ProductDAO dao2 = new ProductDAO();
		Products products = new Products();
//		products.setName("华为荣耀i5");
//		products.setPrice(3669.9);
//		products.setStock(100);
//		products.setDescription("你值得拥有!");
//		dao2.save(products);
		
//		products.setName("魅族");
//		products.setPrice(2666.8);
//		products.setStock(200);
//		products.setDescription("flyme畅玩!");
//		dao2.save(products);
		
//		Products products2 = dao2.get(1);
//		System.out.println(products2);
		
		List<Products> list2 = dao2.list();
		for (Products products3 : list2) {
			System.out.println(products3);
		}
	}

}
