package cn.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.dw.model.Product;
import cn.dw.utils.JdbcUtlis;

public class ProductDaoImpl {
	
	public static void main(String[] args) {
		ProductDaoImpl daoImlpl=new ProductDaoImpl();
		Product product =new Product();
		product.setName("xxx");
		product.setPrice(3.14);
		product.setRemark("测试一下");
		daoImlpl.save(product);
	}

	public void save(Product product) {
		Connection connection = JdbcUtlis.getConnection();
		PreparedStatement pre = null;
		try {
			pre = connection.prepareStatement("insert into product (name,price,remark) " 
					+ "values (?,?,?)");
			pre.setString(1, product.getName());
			pre.setDouble(2, product.getPrice());
			pre.setString(3, product.getRemark());
			pre.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
