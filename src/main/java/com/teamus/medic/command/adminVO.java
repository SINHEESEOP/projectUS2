package com.teamus.medic.command;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class adminVO {
	
	private Integer DSCSN_SN;
	private LocalDate DSCSN_REG_YMD;
	private String DSCSN_CN;
	private String DSCSN_TTL;
	private LocalDate DSCSN_END_YMD;
	private LocalDate DSCSN_BGNG_YMD;
	private String username;
	

}
