package cn.dw.dao;

import cn.dw.model.Product;

public class ProductDaoImpl extends BaseDaoImpl {

	public static void main(String[] args) {
		ProductDaoImpl productDao = new ProductDaoImpl();
		Product product = new Product();
		product.setName("yyy");
		product.setPrice(8.88);
		product.setRemark("父类测试");
		productDao.save(product);
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
		String sql="delete from product where id=?";
		super.excuteUpdate(sql, new Object[] {id});
	}

}
