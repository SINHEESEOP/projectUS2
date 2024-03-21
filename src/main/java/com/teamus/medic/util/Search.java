package com.teamus.medic.utill;

import lombok.Data;

@Data
public class Search {
	private String searchName;
	private String searchNo;

	public Search() {
		this.searchName = "이름 또는 학번 or 교번을 입력해주세요.";
	}

}
