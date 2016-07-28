package com.footmorning.app.util;

public class ClubCriteria {
	
	private int page;
	private int perPageNum;
	
	public ClubCriteria(){
		this.page = 1;
		this.perPageNum = 5;
	}
	
	public void setPage(int page){
		if(page <= 0){
			this.page = 1;
			return;
		}
		
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum){
		
		if(perPageNum <= 0 || perPageNum > 100){
			this.perPageNum = 5;
			return;
		}
		
		this.perPageNum = perPageNum;
	}
	
	public int getPage(){
		return page;
	}
	
	// method for MyBatis SQL Mapper -
	public int getPageStart(){
		
		return (this.page -1 ) * perPageNum;
	}
	
	// method for MyBatis SQL Mapper -
	public int getPerPageNum(){
		
		return this.perPageNum;
	}

	@Override
	public String toString() {
		return "ClubCriteria [page=" + page + ", "
				+ "perPageNum=" + perPageNum + "]";
	}
	
	
}
