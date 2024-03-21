package com.teamus.medic.command;



import com.teamus.medic.util.Search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {

	private String USERNAME;
	private String PASSWORD;
	private String USER_NM;
	private String USER_EML_ADDR;
	private String USER_TELNO;
	private String SCSBJT_NM;
	private String SMK_YN;
	private String JBTTL_NM;
	private String USER_ROLE;
	private Search search;
	 
	
	public UserVO(Search search) {
		super();
		this.search = search;
	}
	
	
  
}
