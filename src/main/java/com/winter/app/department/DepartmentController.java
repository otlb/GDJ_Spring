package com.winter.app.department;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/department/*")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "list", method=RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception {
		
		
		List<DepartmentDTO> ar = departmentService.getList();
		
		request.setAttribute("list",ar);
		return "/department/list";
	}
	
	
	@RequestMapping(value = "detail",method = RequestMethod.GET)
	public String detail(HttpServletRequest request)throws Exception{
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		String id = request.getParameter("department_id");
		
		departmentDTO.setDepartment_id(Integer.parseInt(id));
		
		departmentDTO = departmentDAO.getDetail(departmentDTO);
		
		request.setAttribute("dto",departmentDTO);
		
		return "department/detail";
	}
	
//	@RequestMapping(value = "add",method = RequestMethod.GET)
//	public String add() {
//		
//		return "department/add";				
//	}
//	
//	
//	@RequestMapping(value = "add",method = RequestMethod.POST)
//	public String add(HttpServletRequest request)throws Exception{
//		
//		String id = request.getParameter("department_id");
//		String name = request.getParameter("department_name");
//		String manager = request.getParameter("manager_id");
//		String location = request.getParameter("location_id");
//		
//		DepartmentDTO departmentDTO = new DepartmentDTO();
//		
//		departmentDTO.setDepartment_id(Integer.parseInt(id));
//		departmentDTO.setDepartment_name(name);
//		departmentDTO.setManager_id(Integer.parseInt(manager));
//		departmentDTO.setLocation_id(Integer.parseInt(location));
//		
//		int result = departmentDAO.add(departmentDTO);
//		
//		String msg = "등록실패";
//		if(result>0) {
//			msg="등록성공";
//		}
//		
//		request.setAttribute("msg", msg);
//		request.setAttribute("path", "./list");
//		
//		return"commons/result";
//	}
	
	
	
}
