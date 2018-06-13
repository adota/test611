package cn.dw.service;

import cn.dw.dao.ProductDaoImpl;
import cn.dw.model.Product;

public class ProductServiceImpl {

	public void save(Product product) {
		ProductDaoImpl productDao=new ProductDaoImpl();
		productDao.save(product);
	}
	
	
}
