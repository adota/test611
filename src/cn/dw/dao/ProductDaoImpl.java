package cn.dw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dw.model.Product;

public class ProductDaoImpl extends BaseDaoImpl<Product> {

	public static void main(String[] args) {
		ProductDaoImpl productDao = new ProductDaoImpl();
		List<Product> proList=productDao.queryByName("xx");
		for(Product temp:proList) {
			System.out.println(temp);
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
		String sql = "select * from product where id=?";
		return (Product) super.query(sql, id);
	}

	public List<Product> queryByName(String name) {
		String sql = "select * from product where name like ?";
		String keyword = "%" + name + "%";
		List<Product> proList = super.query(sql, keyword);
		return proList;
	}

	@Override
	public Product getRow(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setRemark(rs.getString("remark"));
		product.setDate(rs.getDate("date"));
		return product;
	}

}
