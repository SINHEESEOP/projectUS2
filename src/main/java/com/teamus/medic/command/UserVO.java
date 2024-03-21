package com.teamus.medic.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserVO {

	private String USER_NO;
	private String USER_NM;
	private String USER_EML_ADDR;
	private String USER_TELNO;
	private String SCSBJT_NM;
}
