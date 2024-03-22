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
public class ProgramVO {

	
			private Integer EVNT_NO;//프로그램 번호
			private String EVNT_NM; //프로그램 명
			private String EVNT_CN; //프로그램 내용
			private String EVNT_BGNG_YMD; //프로그램 시작일
			private String EVNT_END_YMD; //프로그램 종료일
			private String EVNT_PLC_NM; //프로그램 장소
			private String EVNT_APLY_BGNG_YMD; //프로그램 신청시작일,
			private String EVNT_APLY_END_YMD; //프로그램 신청마감일,
			private LocalDateTime EVNT_REG; //프로그램 등록일
			
		
}
