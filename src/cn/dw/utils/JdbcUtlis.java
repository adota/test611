package cn.dw.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtlis {

	public static void main(String[] args) {
		System.out.println(JdbcUtlis.getConnection());
		System.out.println(JdbcUtlis.getConnection());
		System.out.println(JdbcUtlis.getConnection());
	}
	
	static {
		System.out.println("---------");
		//加载驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	//编写获取Connection对象的方法
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/demo",
					"root","aA123456");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
