package com.teamus.medic.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pa_logVO {

	private Integer mdexmBno; // 진료번호
	private LocalDateTime mdexmYmd; // 진료일자
	private String mdexmCn; // 진료내용
	private String mdexmCn2; // 처방내용
	private Integer mdexmQty; // 수량
	private Integer userNo; // 사용자번호(학교, 교번)
	private String dssCode; // 질병코드

}
