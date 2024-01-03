package com.winter.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.util.DBConnector;

public class ProductDAO {
	
	//등록
	public int add(ProductDTO productDTO) {
		
		
		return 0;
	}
	//목록
	public List<ProductDTO> list() throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM PRODUCT";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		List<ProductDTO> ar = new ArrayList<ProductDTO>();
		while(rs.next()) {
			ProductDTO dto = new ProductDTO();
			dto.setProductNum(rs.getLong("PRODUCTNUM"));
			dto.setProductName(rs.getString("PRODUCTNAME"));
			dto.setProductContents(rs.getString("PRODUCTCONTENTS"));
			dto.setProductRate(rs.getDouble("PRODUCTRATE"));
			dto.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
			
			ar.add(dto);
						
		}	
		
		DBConnector.disConnect(rs, st, con);	
		
		return ar;
	}
	//디테일
	public ProductDTO detail(ProductDTO productDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql ="SELECT * FROM PRODUCT WHERE PRODUCTNUM=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, productDTO.getProductNum());
		
		
		return null;
	}
	//삭제
	public int remove(ProductDTO productDTO) {
		
		
		return 0;
	}
	
	//수정
	public int revies(ProductDTO productDTO) {
		
		
		return 0;
	}
	

}

