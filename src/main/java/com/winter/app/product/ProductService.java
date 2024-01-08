package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> getList() throws Exception{
		
		List<ProductDTO> ar = this.productDAO.list();
		
		return ar;
	}
	
	public ProductDTO detail(ProductDTO productDTO) throws Exception{
		
			return productDAO.detail(productDTO);
			
			
	}
}
