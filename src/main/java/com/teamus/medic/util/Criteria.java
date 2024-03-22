package com.teamus.medic.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {

	
	private int pageNum;
	private int amount;
	
	private String searchContent;
	private String searchValue;
	
	public Criteria() {
		this.pageNum = 1;
		this.amount = 10;
	}

	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public int getPageStart() {
		return (pageNum - 1) * amount; 
	}
	
}
