package com.cnj.orm.iIbatis.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceConfig {
	
	public static String username;
	
	public static String url;
	
	public static String password;
	
	public static String driver;
	
	private static BasicDataSource  dataSource;
	
	public static BasicDataSource loadProperties(String confFileName){
		Properties p=new Properties();
		try {
			dataSource=new BasicDataSource();
			p.load(DataSourceConfig.class.getClassLoader().getResourceAsStream(confFileName));
			password=p.getProperty("password");
			dataSource.setDriverClassName(driver=p.getProperty("driver"));
			dataSource.setUrl(url=p.getProperty("url"));
			dataSource.setUsername(username=p.getProperty("username"));
			dataSource.setPassword(password=p.getProperty("password"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("初始化失败",e);
		}
		return dataSource;
	}
	public BasicDataSource getDataSource(){
		if(dataSource==null){
			throw new RuntimeException("未完成初始化,dataSource="+dataSource);
		}
		return dataSource;
	}
	public static Connection getConnection() {
		try {
			return dataSource==null?null:dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		loadProperties("oracle.properties");
	}
}
