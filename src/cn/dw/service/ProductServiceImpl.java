package cn.dw.service;

import java.util.List;

import cn.dw.dao.ProductDaoImpl;
import cn.dw.model.Product;

public class ProductServiceImpl {

	private ProductDaoImpl productDao = new ProductDaoImpl();

	public void save(Product product) {
		productDao.save(product);
	}

	public List<Product> query(String name) {
		return productDao.queryByName(name);
	}
	
	public void update(Product product) {
		productDao.update(product);
	}

	public void delete(int id) {
		productDao.delete(id);
	}
	

	public Product queryByid(int id) {
		return productDao.queryByid(id);
	}

	

}
