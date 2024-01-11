package com.winter.app.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	
	
	public String fileSave(String path, MultipartFile file)throws Exception{
		System.out.println(path);
		
		//path : realpath 실제경로
		File f = new File(path);
				
		
		if(f.isFile()) {
			throw new Exception();
			//return
		}			
		
		if(!f.exists()) {
			f.mkdirs();
		}
		//2. 어떤 파일명으로 저장할 것인가??
		//a. 시간을 사용하자
		Calendar ca = Calendar.getInstance();
		String fileName = ca.getTimeInMillis()+"_"+file.getOriginalFilename();
		
		//b. UUID
		fileName = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		
		
		f=new File(f,fileName);  //파일경로 , 파일이름
		
		//3. 파일 저장
		//a. FileCopysUtil 클래스 사용
		//FileCopyUtils.copy(file.getBytes(), f); 
		
		//b. MultipartFile의 transferTo 메서드 사용 
		file.transferTo(f);
		
		
		return fileName;
		
	}
	
}
