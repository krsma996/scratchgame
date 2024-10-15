package com.scratchgame.symbols;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Group {
	
	SAME_SYMBOLS("same_symbols","same_symbols"),
	LINEAR_SYMBOLS("linear_symbols","horizontally_linear_symbols"),
	HORIZONTALY_LINEAR_SYMBOLS("linear_symbols","horizontally_linear_symbols"),
	VERTICALLY_LINEAR_SYMBOLS("linear_symbols","vertically_linear_symbols"),
	LTR_DIAGONALLY_LINEAR_SYMBOLS("linear_symbols","ltr_diagonally_linear_symbols"),
	RTR_DIAGONALLY_LINEAR_SYMBOLS("linear_symbols","rtl_diagonally_linear_symbols");
	
	
	private String when;
	private String group;
	
}
