package cn.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.dw.utils.JdbcUtlis;

public class BaseDaoImpl {

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

}
