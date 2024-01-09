package com.winter.app.util;

import com.winter.app.regions.RegionDAO;

public class Pager {

	private Long startRow;
	private Long lastRow;
	private Long perPage = 10L;//몇개씩 조회
	private Long page;
	private Long totalPage;
	private Long startNum;
	private Long lastNum;
	
	
	//검색관련
	private String search;
	private String kind;
	
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	//startRow,lastRow 계산하는 메서드
	public void makeRow() {
		this.startRow=(this.getPage()-1)*this.getPerPage()+1;
		this.lastRow= this.getPage()*this.getPerPage();				
		
	}
	
	
	public void makeNum(Long totalCount) throws Exception {
										
				//계산
				Long totalPage = 0L;
				
				totalPage = totalCount/this.getPerPage();
				if(totalCount%this.getPerPage() !=0 ) {
					totalPage++;
				}		
				this.setTotalPage(totalPage);
				
				//블럭계산
				Long perBlock = 5L; //블럭당 번호 갯수
				Long totalBlock = 0L;
				
				totalBlock = totalPage/perBlock;
				if(totalPage%perBlock != 0) {
					totalBlock++;
				}
				
				// page 값으로 현재 블록 번호 구하기
				Long curBlock=0L; //블록번호
				
				curBlock = this.getPage()/perBlock;
				if(this.getPage()%perBlock != 0) {
					curBlock++;
				}
				
				// 현재 블록번호로 시작과 끝 번호구하기
				Long startNum =0L;
				Long lastNum =curBlock*perBlock;
				startNum = lastNum-perBlock+1;
				
				this.setLastNum(lastNum);
				this.setStartNum(startNum);
				
				//이전, 다음 블럭유무
				if(curBlock==1) {
					this.setStart(true);
				}
				if(curBlock==totalBlock) {
					this.setLastNum(totalPage);
					this.setLast(true);
				}
		
		
	}
	
	
	
	//이전 블럭이 없으면 true;
	private boolean start;
	//다음 블럭이 없으면 true;
	private boolean last;
	
	
	
	
	
	public boolean isStart() {
		return start;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	
	public Long getPerPage() {
		return perPage;
	}
	
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	
	
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page =1L;
		}
		return page;
	}
	
	
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
}
