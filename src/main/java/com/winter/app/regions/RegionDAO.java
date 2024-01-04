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

import com.winter.app.util.DBConnector;

import oracle.jdbc.driver.DBConversion;

@Repository
public class RegionDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.winter.app.regions.RegionDAO.";
	
	
	public List<RegionDTO> getList() throws Exception {
									
			return sqlSession.selectList(namespace+"getList");
		
			
		
	}
	//검색 
	public RegionDTO getDetail(RegionDTO regionDTO)throws Exception {
			
			// 하나의 결과만 가지고 오기때문에 selectOne 사용 
			return	sqlSession.selectOne(namespace+"getDetail",regionDTO);	
				
		
	}
	
	//추가(INSERT)
	public int add(RegionDTO regionDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "INSERT INTO REGIONS VALUES(?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, regionDTO.getRegion_id());
		st.setString(2, regionDTO.getRegion_name());
		
		//0,1로 정보를 받기때문에 데이터타입int, 추가하면 업데이트를 사용
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
		
	}
		
	//수정(UPDATE)	
	public int update(RegionDTO regionDTO) throws Exception  {
		
		Connection con = DBConnector.getConnector();
		String sql = "UPDATE REGIONS SET REGION_NAME=? WHERE REGION_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, regionDTO.getRegion_name());
		st.setInt(2, regionDTO.getRegion_id());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
		
	}
	

}
