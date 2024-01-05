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
	
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception{
		
		return departmentDAO.getDetail(departmentDTO);
	}
	
	public int add (DepartmentDTO departmentDTO) throws Exception{
		
		return departmentDAO.add(departmentDTO);
	}
	
	public int update(DepartmentDTO departmentDTO) throws Exception{
		return departmentDAO.update(departmentDTO);
	}
	
	public int delete(DepartmentDTO departmentDTO) throws Exception{
		return departmentDAO.delete(departmentDTO);
	}
	
}
