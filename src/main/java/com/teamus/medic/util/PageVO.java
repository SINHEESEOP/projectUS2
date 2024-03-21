package com.teamus.medic.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Data;


@Data
public class PageVO {

	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int pageNum;
	private int amount;
	private int total;
	
	private int realEnd;
	private List<Integer> pageList;
	
	private Criteria cri;
	
	public PageVO(Criteria cri , int total) {
		this.cri = cri;
		this.total = total;
		this.pageNum = cri.getPageNum();
		this.amount = cri.getAmount();
		
		this.endPage = (int)(Math.ceil(this.pageNum / 10.0)  ) * 10;
		
		this.startPage = endPage - 10  + 1;
		
		this.realEnd = (int)Math.ceil(total / (double)this.amount);
		
		if(this.endPage > realEnd ) this.endPage = realEnd;
		
		this.prev = this.startPage > 1;
		
		this.next = realEnd > this.endPage;
		
		this.pageList = IntStream.rangeClosed(this.startPage, this.endPage).boxed().collect(Collectors.toList());
	}
}
