package com.teamus.medic.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipVO {
	
	private String ISTR_CODE;
	private int ISTR_NO;
	private String ISTR_NM;
	private int ISTR_QTY;
}
