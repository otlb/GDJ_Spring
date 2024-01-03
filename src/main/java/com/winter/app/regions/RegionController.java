package com.winter.app.regions;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/regions/*")
public class RegionController {
	
	private RegionDAO regionDAO;
	
	public RegionController( ) {
		this.regionDAO = new RegionDAO();
	}
	
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception {
				
		RegionDAO regionDAO = new RegionDAO();
		List<RegionDTO> ar = regionDAO.getList();
		
		request.setAttribute("list", ar);
		
		return "regions/list";
				
	}
	
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	//파라미터의 이름과 타입을 동일하게 선언
	public String detail(Integer region_id, Model model)throws Exception{
		                //@RequestParam() 
		RegionDAO regionDAO = new RegionDAO();
		RegionDTO regionDTO = new RegionDTO();
		//String id = request.getParameter("region_id");
		
		regionDTO.setRegion_id(region_id);
		
		regionDTO = regionDAO.getDetail(regionDTO);
		
		model.addAttribute("dto",regionDTO);
		
		return "regions/detail";
	} 
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String add() {		
		
		
		return "regions/add";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public String add(RegionDTO regionDTO, Model model ) throws Exception{
		
//		String id = request.getParameter("region_id");
//		String name = request.getParameter("region_name");
//		
//		RegionDTO regionDTO = new RegionDTO();
//		regionDTO.setRegion_id(Integer.parseInt(id));
//		regionDTO.setRegion_name(name);
		
		int result = this.regionDAO.add(regionDTO);
		String msg = "등록 실패";
		
		if(result>0) {
			msg = "등록 성공";
			
		}		
//		request.setAttribute("msg", msg);
//		request.setAttribute("path", "./list");
		model.addAttribute("msg", msg);
		model.addAttribute("path",".list");
		return "commons/result";
	}
	
	
	
	
}
