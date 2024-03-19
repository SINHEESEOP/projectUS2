package com.teamus.medic.command;

import com.teamus.medic.utill.Search;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	
	private String USER_NO;
	private String USER_NM;
	private String USER_EML_ADDR;
	private String USER_TELNO;
	private String JBTTL_NM;
	private String SMK_YN;
	private String SCSBJT_NM;

//	USER_NO			VARCHAR(20)	PRIMARY KEY,
//	USER_NM			VARCHAR(100),
//	USER_EML_ADDR 	VARCHAR(320),
//	USER_TELNO	 	VARCHAR(11),
//	JBTTL_NM 		VARCHAR(100),
//	SMK_YN			CHAR(1),
//	SCSBJT_NM

	private Search search;

	public UserVO(Search search) {
		this.search = search;
	}
}
