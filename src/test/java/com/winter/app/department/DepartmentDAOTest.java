package com.winter.app.department;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;

public class DepartmentDAOTest extends MyTest {
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	
	@Test
	public void list() throws Exception{
		
		List<DepartmentDTO> ar = departmentDAO.getList();
		
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void detail() throws Exception{
		
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(1);
		
		departmentDAO.getDetail(departmentDTO);
		assertNotNull(departmentDTO);
	}
	
}
