package com.winter.app.regions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//DAO 보내기전 전처리, 후처리 
@Service
public class RegionService {
	
	@Autowired
	private RegionDAO regionDAO;
	
	
	//list
	public List<RegionDTO> getList() throws Exception{
		
		List<RegionDTO> ar = this.regionDAO.getList();
		
		return ar;
	}
	
	//detail
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception{
		
		
		return regionDAO.getDetail(regionDTO);
	}
	
	//add
	public int add(RegionDTO regionDTO) throws Exception{
		
		return regionDAO.add(regionDTO);
	}
	
	//update
	public int update(RegionDTO regionDTO) throws Exception{
		return regionDAO.update(regionDTO);
	}
	
	//delete
	public int delete(RegionDTO regionDTO) throws Exception{
		return regionDAO.delete(regionDTO);
		
	}
	
	
}
