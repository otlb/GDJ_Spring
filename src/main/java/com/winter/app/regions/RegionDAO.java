package com.winter.app.regions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.Pager;

import oracle.jdbc.driver.DBConversion;

@Repository
public class RegionDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.winter.app.regions.RegionDAO.";
	
	
	public List<RegionDTO> getList(Pager pager) throws Exception {
									
			return sqlSession.selectList(namespace+"getList",pager);
		
			
		
	}
	//검색 
	public RegionDTO getDetail(RegionDTO regionDTO)throws Exception {
			
			// 하나의 결과만 가지고 오기때문에 selectOne 사용 
			return	sqlSession.selectOne(namespace+"getDetail",regionDTO);	
					
	}
	
	//추가(INSERT)
	public int add(RegionDTO regionDTO) throws Exception {
	
		return sqlSession.insert(namespace+"add", regionDTO);
	}
		
	//수정(UPDATE)	
	public int update(RegionDTO regionDTO) throws Exception  {
		
		return sqlSession.update(namespace+"update",regionDTO);
	}
	
	//삭제(delete)
	public int delete(RegionDTO regionDTO) throws Exception{
		return sqlSession.delete(namespace+"delete", regionDTO);	
	}
	

}
