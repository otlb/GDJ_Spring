package com.winter.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {

	//1. ip:port
	//2. id,pw

	public static Connection getConnector() throws Exception {
		String user = "user01";
		String password = "user01";
		String url="jdbc:oracle:thin:@3.39.190.102:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//1. driver를 메모리에 로딩(객체 생성)
		
			Class.forName(driver);
			//2. DB연결
			Connection con = DriverManager.getConnection(url, user, password);
			
			return con;
				
		
	}
	
	public static void disConnect(ResultSet rs, PreparedStatement st,Connection con ) throws Exception {
		
		rs.close();
		st.close();
		con.close();
		
	}
	public static void disConnect(PreparedStatement st,Connection con ) throws Exception {
				
		st.close();
		con.close();
		
	}
	
	
	
}
