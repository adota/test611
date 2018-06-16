package cn.dw.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import cn.dw.model.Product;

@Component(value="productDao")
public class ProductDaoImpl {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public void save(Product product) {
		String sql = "insert into product (name,price,remark)  values (?,?,?)";
		jdbcTemplate.update(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}

	public void update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id=?";
		jdbcTemplate.update(sql,
				new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getId() });
	}

	public void delete(int id) {
		String sql = "delete from product where id=?";
		jdbcTemplate.update(sql, new Object[] { id });
	}

	public Product queryByid(int id) {
		String sql = "select * from product where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Product>(Product.class));
	}

	public List<Product> queryByName(String name) {
		String sql = "select * from product where name like ?";
		String keyword = "%" + name + "%";
		return jdbcTemplate.query(sql, new Object[] { keyword }, new BeanPropertyRowMapper<Product>(Product.class));
	}

	// @Override
	// public Product getRow(ResultSet rs) throws SQLException {
	// Product product = new Product();
	// product.setId(rs.getInt("id"));
	// product.setName(rs.getString("name"));
	// product.setPrice(rs.getDouble("price"));
	// product.setRemark(rs.getString("remark"));
	// product.setDate(rs.getDate("date"));
	// return product;
	// }

}
