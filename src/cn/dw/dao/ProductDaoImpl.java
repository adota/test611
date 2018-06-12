package cn.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dw.model.Product;
import cn.dw.utils.JdbcUtlis;

public class ProductDaoImpl extends BaseDaoImpl {

	public static void main(String[] args) {
		ProductDaoImpl productDao = new ProductDaoImpl();
		// Product product = new Product();
		// product.setName("yyy");
		// product.setPrice(8.88);
		// product.setRemark("父类测试");
		// productDao.save(product);
//		productDao.queryByName("xxx",1,10);
//		System.out.println(product);
		List<Product> proList = productDao.queryByName("xx");
		for(Product temp:proList) {
			System.out.println(temp.toString());
		}
	}

	public void save(Product product) {
		String sql = "insert into product (name,price,remark)  values (?,?,?)";
		super.excuteUpdate(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}

	public void update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id=?";
		super.excuteUpdate(sql,
				new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getId() });
	}

	public void delete(int id) {
		String sql = "delete from product where id=?";
		super.excuteUpdate(sql, new Object[] { id });
	}

	public Product queryByid(int id) {
		Connection connection = JdbcUtlis.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "select * from product where id=?";
		Product product = new Product();
		try {
			pre = connection.prepareStatement(sql);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			if (rs.next()) {
				product.setId(id);
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
			}
			return product;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}

	public List<Product> queryByName(String name) {
		Connection connection = JdbcUtlis.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "select * from product where name like ?";
		List<Product> proList=new ArrayList<Product>();
		try {
			pre = connection.prepareStatement(sql);
			pre.setString(1, "%" + name + "%");
			rs = pre.executeQuery();
			while(rs.next()) {
				Product product=new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
				product.setDate(rs.getDate("date"));
				proList.add(product);
			}
			 return proList;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}

}
