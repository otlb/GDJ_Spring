package com.winter.app.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception {
		ProductDAO productDAO = new ProductDAO();
		List<ProductDTO> ar = productDAO.list();
		request.setAttribute("list",ar);
		
		return "product/list";
	}
	
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public void detail(ProductDTO productDTO) {
		
		
	}

}
