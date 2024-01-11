package com.winter.app.regions;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.swing.Box.Filler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.FileManager;
import com.winter.app.util.Pager;

//DAO 보내기전 전처리, 후처리 
@Service
public class RegionService {
	
	@Autowired
	private RegionDAO regionDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	//내장 객체 중 application 
	private ServletContext servletContext;
	
	
	//list
	public List<RegionDTO> getList(Pager pager) throws Exception{
		pager.makeRow();
		
		Long totalCount = regionDAO.getTotal(pager);
		
		pager.makeNum(totalCount);
				
		List<RegionDTO> ar = this.regionDAO.getList(pager);
		
		return ar;
	}
	
	//detail
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception{
		
		
		return regionDAO.getDetail(regionDTO);
	}
	
	//add
	public int add(RegionDTO regionDTO,MultipartFile [] file) throws Exception{
		
		int result = regionDAO.add(regionDTO); // 추가하는게 먼저 실행되야지 region_id가 있다 아니면 없어서 오류
		
		//1. 어디에 저장할것인가??
		String path =servletContext.getRealPath("/resources/upload/regions");
		
		for(MultipartFile f:file) {
			
			if(f.isEmpty()) {
				continue;
			}
			
		String fileName = fileManager.fileSave(path, f);			
		
		
		//4. DB에 정보 저장 
		RegionFileDTO regionFileDTO = new RegionFileDTO();
		regionFileDTO.setFileName(fileName);
		regionFileDTO.setOriName(f.getOriginalFilename());
		regionFileDTO.setRegion_id(regionDTO.getRegion_id());
		regionDAO.addFile(regionFileDTO);
		}
		return result;
	}
	
	//update
	public int update(RegionDTO regionDTO) throws Exception{
		return regionDAO.update(regionDTO);
	}
	
	//delete
	public int delete(RegionDTO regionDTO) throws Exception{
		//파일명 조회 
		List<RegionFileDTO> ar = regionDAO.getListFiles(regionDTO);
		//DB에서 삭제
		int result = regionDAO.delete(regionDTO);
		//경로 생성
		String path = servletContext.getRealPath("/resources/upload/regions/");	
		
		for(RegionFileDTO f:ar) {
			
			//HDD에서 삭제 
			fileManager.fileDelete(path,f.getFileName());
		}
		return result;
		
	}
	
	
	
	
}
