package com.teamus.medic.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentVO {
	
	private int RNTL_NO;
	private String ISTR_NM;
	private String USERNAME;
	private int RNTL_QTY;
	private String RNTL_YMD;
	private String ISTR_CODE;
	private String ISTR_YMD;
	
	
}
