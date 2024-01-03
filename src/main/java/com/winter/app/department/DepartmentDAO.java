package com.winter.app.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.util.DBConnector;


public class DepartmentDAO {
	
	//전체조회
	public List<DepartmentDTO> getList() throws Exception {
	
			Connection con = DBConnector.getConnector();
		
		
			//sql문 생성
			String sql = "SELECT * FROM DEPARTMENTS";
			//전송
			PreparedStatement st = con.prepareStatement(sql);
			
			//최종전송 결과처리
			ResultSet rs = st.executeQuery();
			List<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
			while(rs.next()) {
				DepartmentDTO dto = new DepartmentDTO();
				dto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				dto.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
				dto.setManager_id(rs.getInt("MANAGER_ID"));
				dto.setLocation_id(rs.getInt("LOCATION_ID"));
				ar.add(dto);
				
			}
			//db연결 끊어주기
			DBConnector.disConnect(rs, st, con);
			return ar;
			
	}
	
	//원하는 부분 조회 ?데이터 활용
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception {
		
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, departmentDTO.getDepartment_id());
		
		ResultSet rs = st.executeQuery();
		
		DepartmentDTO dto = null;
		
		if(rs.next()) {
			dto = new DepartmentDTO();
			dto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			dto.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			dto.setManager_id(rs.getInt("MANAGER_ID"));
			dto.setLocation_id(rs.getInt("LOCATION_ID"));			
		}
		DBConnector.disConnect(rs, st, con);
		return dto;
		
	}
	
	public int add(DepartmentDTO departmentDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "INSERT INTO DEPARTMENTS VALUES(?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, departmentDTO.getDepartment_id());
		st.setString(2,departmentDTO.getDepartment_name());
		st.setInt(3,departmentDTO.getManager_id());
		st.setInt(4, departmentDTO.getLocation_id());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
		
	}
	
	public int update(DepartmentDTO departmentDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String spl = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ? WHERE DEPARTMENT_ID =?";
		PreparedStatement st = con.prepareStatement(spl);
		
		st.setString(1,departmentDTO.getDepartment_name());
		st.setInt(2,departmentDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		
		return result;
		
	}
	
	
	
}
