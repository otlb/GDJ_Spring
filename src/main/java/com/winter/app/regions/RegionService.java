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

import com.winter.app.util.Pager;

//DAO 보내기전 전처리, 후처리 
@Service
public class RegionService {
	
	@Autowired
	private RegionDAO regionDAO;
	
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
	public int add(RegionDTO regionDTO,MultipartFile file) throws Exception{
		
		//1. 어디에 저장할것인가??
		String path =servletContext.getRealPath("/resources/upload");
		System.out.println(path);
		
		File f = new File(path, "regions");
		
		if(!f.exists()) {
			f.mkdirs();
		}
		//2. 어떤 파일명으로 저장할 것인가??
		//a. 시간을 사용하자
		Calendar ca = Calendar.getInstance();
		String fileName = ca.getTimeInMillis()+"_"+file.getOriginalFilename();
		
		//b. UUID
		fileName = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		
		//3. 파일 저장
		//a. FileCopysUtil 클래스 사용
		f=new File(f,fileName);  //파일경로 , 파일이름
		FileCopyUtils.copy(file.getBytes(), f); 
		
		//4. DB에 정보 저장 
		RegionFileDTO regionFileDTO = new RegionFileDTO();
		regionFileDTO.setFileName(fileName);
		regionFileDTO.setOriName(file.getOriginalFilename());
		regionDAO.addFile(regionFileDTO);
		
		return 0; //regionDAO.add(regionDTO);
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
