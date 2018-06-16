package cn.dw.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.dw.dao.ProductDaoImpl;
import cn.dw.model.Product;

@Component(value="productService")
public class ProductServiceImpl {

	@Resource(name="productDao")
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

	public void save(Product product) {
		productDao.save(product);
//		 Integer.parseInt("xxx");
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
