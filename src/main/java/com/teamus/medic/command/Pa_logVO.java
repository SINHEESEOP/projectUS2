package com.teamus.medic.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pa_logVO {

	private Integer MDEXM_BNO; // 진료번호
	private LocalDateTime MDEXM_YMD; // 진료일자
	private String MDEXM_CN; // 진료내용
	private String MDEXM_CN2; // 처방내용
	private Integer MDEXM_QTY; // 수량
	private String USERNAME; // 사용자번호(학교, 교번)
	private String DSS_CODE; // 질병코드

	private UserVO userVo;
}