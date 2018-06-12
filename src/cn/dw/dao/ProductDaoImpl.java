package cn.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.dw.model.Product;
import cn.dw.utils.JdbcUtlis;

public class ProductDaoImpl {

	public static void main(String[] args) {
		ProductDaoImpl daoImlpl = new ProductDaoImpl();
		Product product = new Product();
		product.setName("xxx");
		product.setPrice(3.14);
		product.setRemark("测试一下");
//		daoImlpl.save(product);
		product.setId(5);
//		daoImlpl.update(product);
		daoImlpl.delete(5);
	}

	public void save(Product product) {
		Connection connection = JdbcUtlis.getConnection();
		PreparedStatement pre = null;
		try {
			pre = connection.prepareStatement("insert into product (name,price,remark)  values (?,?,?)");
			pre.setString(1, product.getName());
			pre.setDouble(2, product.getPrice());
			pre.setString(3, product.getRemark());
			pre.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void update(Product product) {
		String sql="update product set name=?,price=?,remark=? where id=?";
		Connection connection = JdbcUtlis.getConnection();
		PreparedStatement pre = null;
		try {
			pre = connection.prepareStatement(sql);
			pre.setString(1, product.getName());
			pre.setDouble(2, product.getPrice());
			pre.setString(3, product.getRemark());
			pre.setInt(4, product.getId());
			pre.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void delete(int id) {
		String sql="delete from product where id=?";
		Connection connection = JdbcUtlis.getConnection();
		PreparedStatement pre = null;
		try {
			pre = connection.prepareStatement(sql);
			pre.setInt(1, id);
			pre.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}


}
