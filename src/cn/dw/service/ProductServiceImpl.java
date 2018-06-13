package cn.dw.service;

import java.util.List;

import cn.dw.dao.ProductDaoImpl;
import cn.dw.model.Product;

public class ProductServiceImpl {

	public void save(Product product) {
		ProductDaoImpl productDao=new ProductDaoImpl();
		productDao.save(product);
	}
	
	public List<Product> query(String name) {
		ProductDaoImpl productDao=new ProductDaoImpl();
		return productDao.queryByName(name);
	}
	
	
}
