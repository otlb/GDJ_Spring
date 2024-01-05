package com.winter.app.department;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;

public class DepartmentDAOTest extends MyTest {
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	
	//@Test
	public void list() throws Exception{
		
		List<DepartmentDTO> ar = departmentDAO.getList();
		
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void detail() throws Exception{
		
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(1);
		
		departmentDAO.getDetail(departmentDTO);
		assertNotNull(departmentDTO);
	}
	
	//@Test
	public void add()throws Exception{
		
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_name("test1");
		departmentDTO.setLocation_id(1700);
		departmentDTO.setManager_id(100);
		
		int result = departmentDAO.add(departmentDTO);
		
		assertEquals(1, result);
		
	}
	//@Test
	public void update()throws Exception{
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_name("test");
		departmentDTO.setDepartment_id(310);
		
		int result = departmentDAO.update(departmentDTO);
		assertEquals(1, result);
	}
	//@Test
	public void delete() throws Exception{
		
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(310);
		
		int result = departmentDAO.delete(departmentDTO);
		
		assertEquals(1, result);
		
	}
	
}
