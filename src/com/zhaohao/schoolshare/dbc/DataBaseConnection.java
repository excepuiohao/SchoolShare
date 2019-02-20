package com.zhaohao.schoolshare.dbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//数据库驱动连接类  ，通过getConnection()返回一个数据库连接对象
public class DataBaseConnection {
	String url;
	String driver;
	String username;
	String password;
	Connection con = null;
	ResultSet rs = null;
	Statement sm = null;

	public DataBaseConnection() throws IOException, ClassNotFoundException, SQLException {
		String resource = "/drive.properties";
		InputStream is = this.getClass().getResourceAsStream(resource);
		Properties pro = new Properties();
		pro.load(is);
		driver = pro.getProperty("driver");
		url = pro.getProperty("url");
		username = pro.getProperty("username");
		password = pro.getProperty("password");
		Class.forName(driver);
		con = DriverManager.getConnection(url, username, password);
	}

	public Connection getConnection() {
		return this.con;
	}

	public void closedriver() {
		try {
			if (con != null) {
				con.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (sm != null) {
				sm.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
