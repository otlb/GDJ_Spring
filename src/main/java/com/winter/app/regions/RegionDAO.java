package com.winter.app.regions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.util.DBConnector;

import oracle.jdbc.driver.DBConversion;

public class RegionDAO {
	
	public List<RegionDTO> getList() throws Exception {
		
		
		//1. driver를 메모리에 로딩(객체 생성)
		Connection con = DBConnector.getConnector();
			
			//3. SQL문 생성
			String sql = "SELECT * FROM REGIONS";
			//4.SQL문을 미리전송
			PreparedStatement st = con.prepareStatement(sql);
			//5.
			
			//6.최종전송 및 결과처리
			ResultSet rs = st.executeQuery();	
			List<RegionDTO> ar = new ArrayList<RegionDTO>();
			while(rs.next()) {
				//첫번째 rs= 1,Europe
				RegionDTO dto = new RegionDTO();
				
				dto.setRegion_id(rs.getInt("REGION_ID"));
				
				dto.setRegion_name(rs.getString("REGION_NAME"));
				
				ar.add(dto);
			}
			//연결 끊어주기
			DBConnector.disConnect(rs, st, con);
			return ar;
		
			
		
	}
	//검색 
	public RegionDTO getDetail(RegionDTO regionDTO)throws Exception {
		
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID =?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1,regionDTO.getRegion_id());
		
		ResultSet rs = st.executeQuery();
		
		RegionDTO resultDTO = null; 
		
		if(rs.next()) {
			resultDTO = new RegionDTO();
			resultDTO.setRegion_id(rs.getInt("REGION_ID"));
			resultDTO.setRegion_name(rs.getString("REGION_NAME"));
		}
		DBConnector.disConnect(rs, st, con);
		return resultDTO;
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
