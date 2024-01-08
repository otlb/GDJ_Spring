package com.winter.app.regions;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;
import com.winter.app.util.Pager;

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
	
	@Test
	public void getList() throws Exception {
		Pager pager = new Pager();
		pager.setPage(3L);
		pager.makeRow();		
		
		List<RegionDTO> ar = regionDAO.getList(pager);
		System.out.println(ar.get(0).getRegion_name());
		assertEquals(10, ar.size());		
		
	}
	
	//@Test
	public void add()throws Exception{
		RegionDTO regionDTO = new RegionDTO();
		
		for(int i=0;i<100;i++) {
		regionDTO.setRegion_name("test"+i);
		int result = regionDAO.add(regionDTO);
		if(i%10==0) {
			Thread.sleep(500);
		}
		
		}
		System.out.println("100개 입력 완료");
		//assertEquals(1, result);
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
