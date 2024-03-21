package com.teamus.medic.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgramRegVO {
	
	private Integer EVNT_REG_NO;
	private LocalDateTime EVNT_REG_YMD;
	private Character EVNT_REG_YN;
	private Character EVNT_END_YN;
	private Integer EVNT_NO;
	private String EVNT_NM;
	private String EVNT_PLC_NM;
	private String USER_NO;
	private String USER_NM;
	private String USER_TELNO;
	private String SCSBJT_NM;
	private String USER_EML_ADDR;
}
