package com.winter.app.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.DBConnector;


@Repository
public class DepartmentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String names = "com.winter.app.department.DepartmentDAO.";
	
	//전체조회
	
	public List<DepartmentDTO> getList() throws Exception {
					
			return sqlSession.selectList(names+"getList");
			
	}
	
	//원하는 부분 조회 ?데이터 활용
	
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception {
		
		return sqlSession.selectOne(names+"getDetail", departmentDTO);
		
	}
	
//	public int add(DepartmentDTO departmentDTO) throws Exception {
//		Connection con = DBConnector.getConnector();
//		String sql = "INSERT INTO DEPARTMENTS VALUES(?,?,?,?)";
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		st.setInt(1, departmentDTO.getDepartment_id());
//		st.setString(2,departmentDTO.getDepartment_name());
//		st.setInt(3,departmentDTO.getManager_id());
//		st.setInt(4, departmentDTO.getLocation_id());
//		
//		int result = st.executeUpdate();
//		
//		DBConnector.disConnect(st, con);
//		return result;
//		
//	}
//	
//	public int update(DepartmentDTO departmentDTO) throws Exception {
//		Connection con = DBConnector.getConnector();
//		String spl = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ? WHERE DEPARTMENT_ID =?";
//		PreparedStatement st = con.prepareStatement(spl);
//		
//		st.setString(1,departmentDTO.getDepartment_name());
//		st.setInt(2,departmentDTO.getDepartment_id());
//		
//		int result = st.executeUpdate();
//		DBConnector.disConnect(st, con);
//		
//		return result;
//		
//	}
	
	
	
}
