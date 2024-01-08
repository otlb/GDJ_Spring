package com.winter.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.DBConnector;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String namespace = "com.winter.app.product.ProductDAO.";
		
	
	//목록
	public List<ProductDTO> list() throws Exception {
							
			return sqlSession.selectList(namespace+"list");
			
	}
	
	public ProductDTO detail(ProductDTO productDTO) throws Exception{
		
				return sqlSession.selectOne(namespace+"detail", productDTO);
	}
	
	
	
//	//등록
//	public int add(ProductDTO productDTO) {
//		
//		
//		return 0;
//	}
//	//디테일
//	public ProductDTO detail(ProductDTO productDTO) throws Exception {
//		Connection con = DBConnector.getConnector();
//		String sql ="SELECT * FROM PRODUCT WHERE PRODUCTNUM=?";
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setLong(1, productDTO.getProductNum());
//		
//		
//		return null;
//	}
//	//삭제
//	public int remove(ProductDTO productDTO) {
//		
//		
//		return 0;
//	}
//	
//	//수정
//	public int revies(ProductDTO productDTO) {
//		
//		
//		return 0;
//	}
	

}

