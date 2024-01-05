package com.winter.app.regions;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;

public class RegionDAOTest extends MyTest {

	@Autowired
	private RegionDAO regionDAO;
	
	//@Test
	public void getDetailTest() throws Exception{
		
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setRegion_id(1);		
		regionDTO = regionDAO.getDetail(regionDTO);
		
		assertNotNull(regionDTO);
	}
	
	//@Test
	public void getList() throws Exception {
		
		List<RegionDTO> ar = regionDAO.getList();
		assertNotEquals(0, ar.size());		
		
	}
	
	//@Test
	public void add()throws Exception{
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setRegion_name("test");
		int result = regionDAO.add(regionDTO);
		
		assertEquals(1, result);
	}
	//@Test
	public void update() throws Exception{
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setRegion_id(500);
		regionDTO.setRegion_name("aig");
		
		int result = regionDAO.update(regionDTO);
		
	}
	//@Test
	public void delete() throws Exception{
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setRegion_id(209);		
		
		int result = regionDAO.delete(regionDTO);
		
	}

}
