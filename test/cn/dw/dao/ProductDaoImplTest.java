package cn.dw.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.dw.model.Product;

public class ProductDaoImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testSave() {
		ProductDaoImpl productDao=new ProductDaoImpl();
		Product product=new Product();
		product.setName("xxx");
		product.setPrice(3.11);
		product.setRemark("测试一下");
		productDao.save(product);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryByid() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryByName() {
		fail("Not yet implemented");
	}

}
