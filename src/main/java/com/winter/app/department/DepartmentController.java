package com.winter.app.department;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String detail(Model model,DepartmentDTO departmentDTO )throws Exception{
				
		
		departmentDTO = departmentService.getDetail(departmentDTO);
		
		model.addAttribute("dto",departmentDTO);
		
		return "department/detail";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String add() {
		
		return "department/add";				
	}
	
	
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public String add(Model model,DepartmentDTO departmentDTO )throws Exception{
		
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
		
		int result = departmentService.add(departmentDTO);
		
		String msg = "등록실패";
		if(result>0) {
			msg="등록성공";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("path", "./list");
		
		return"commons/result";
	}
	
	
	
}
