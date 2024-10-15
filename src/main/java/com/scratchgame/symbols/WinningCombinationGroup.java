package com.scratchgame.symbols;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WinningCombinationGroup {
	
	 SAME_SYMBOL_3_TIMES(1, Group.SAME_SYMBOLS.getGroup(), 	3, Group.SAME_SYMBOLS.getWhen(),(" SAME_SYMBOL_3_TIMES")),
	 SAME_SYMBOL_4_TIMES(1.5, Group.SAME_SYMBOLS.getGroup(), 4, Group.SAME_SYMBOLS.getWhen(),("SAME_SYMBOL_4_TIMES")),
	 SAME_SYMBOL_5_TIMES(2, Group.SAME_SYMBOLS.getGroup(), 5, Group.SAME_SYMBOLS.getWhen(),("SAME_SYMBOL_5_TIMES")),
	 SAME_SYMBOL_6_TIMES(3, Group.SAME_SYMBOLS.getGroup(), 6, Group.SAME_SYMBOLS.getWhen(),("SAME_SYMBOL_6_TIMES")),
	 SAME_SYMBOL_7_TIMES(5, Group.SAME_SYMBOLS.getGroup(), 7, Group.SAME_SYMBOLS.getWhen(),("SAME_SYMBOL_7_TIMES")),
	 SAME_SYMBOL_8_TIMES(10, Group.SAME_SYMBOLS.getGroup(), 8, Group.SAME_SYMBOLS.getWhen(),("SAME_SYMBOL_8_TIMES")),
	 SAME_SYMBOL_9_TIMES(20, Group.SAME_SYMBOLS.getGroup(), 9, Group.SAME_SYMBOLS.getWhen(),("SAME_SYMBOL_9_TIMES"));
	
	

	 private double rewardMultiplier;
	 private String when;
	 private int count;
	 private String group;
	 private String name;
}
