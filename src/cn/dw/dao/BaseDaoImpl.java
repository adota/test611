package cn.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dw.utils.JdbcUtlis;

public abstract class BaseDaoImpl<T> {

	protected void excuteUpdate(String sql, Object[] param) {

		Connection connection = JdbcUtlis.getConnection();
		PreparedStatement pre = null;
		try {
			pre = connection.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				pre.setObject(i + 1, param[i]);
			}
			pre.executeUpdate();
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

	protected abstract T getRow(ResultSet rs) throws SQLException;

	protected List<T> query(String sql, Object keyword) {
		Connection connection = JdbcUtlis.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		List<T> modelList = new ArrayList<T>();
		try {
			pre = connection.prepareStatement(sql);
			pre.setObject(1, keyword);
			rs = pre.executeQuery();
			while (rs.next()) {
				modelList.add(this.getRow(rs));
			}
			return modelList;

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
