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




@Repository
public class DepartmentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.winter.app.department.DepartmentDAO.";
	
	//전체조회
	
	public List<DepartmentDTO> getList() throws Exception {
					
			return sqlSession.selectList(namespace+"getList");
			
	}
	
	//원하는 부분 조회 ?데이터 활용
	
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception {
		
		return sqlSession.selectOne(namespace+"getDetail", departmentDTO);
		
	}
	
	public int add(DepartmentDTO departmentDTO) throws Exception {
				
		return sqlSession.insert(namespace+"add", departmentDTO);

		
	}
	
	public int update(DepartmentDTO departmentDTO) throws Exception {
		
		
		return sqlSession.update(namespace+"update", departmentDTO);
		
	}
	
	public int delete(DepartmentDTO departmentDTO) throws Exception{
		
		return sqlSession.delete(namespace+"delete", departmentDTO);
	}
	
	
}
