package cn.dw.service;

import java.util.List;

import cn.dw.dao.ProductDaoImpl;
import cn.dw.model.Product;

public class ProductServiceImpl {

	private ProductDaoImpl productDao;

	// private String keyword;
	// public static void main(String[] args) {
	// ProductServiceImpl impl = new ProductServiceImpl();
	// new Thread(new Runnable() {
	// @Override
	// public void run() {
	// impl.test("aaa");
	// }
	// }) {
	// }.start();
	//
	// new Thread(new Runnable() {
	// @Override
	// public void run() {
	// impl.test("bbb");
	// }
	// }) {
	// }.start();
	//
	// }

	// public void test(String name) {
	// keyword=name;
	// Product product=new Product();
	// product.setName(keyword);
	// System.out.println(product.getName());
	// }

	public void setProductDao(ProductDaoImpl productDao) {
		this.productDao = productDao;
	}

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
