package cn.dw.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dw.model.Product;
import cn.dw.service.ProductServiceImpl;

public class ProductDaoImplTest {

	private static  ProductServiceImpl productService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
		productService = context.getBean("productService",ProductServiceImpl.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test  
	public void testSave() {
		Product product=new Product();
		product.setName("zzzzz");
		product.setPrice(3.11);
		product.setRemark("测试一下");
		System.out.println(productService);
		productService.save(product);
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
