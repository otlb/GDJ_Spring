package com.winter.app.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	public List<DepartmentDTO> getList() throws Exception{
		
		List<DepartmentDTO> ar = this.departmentDAO.getList();
		
		return ar;
	}
	
//	public void getDitali() {
//		
//		DepartmentDTO departmentDTO = new DepartmentDTO();
//		
//		departmentDTO.getDepartment_id();
//		
//	}
	
}
