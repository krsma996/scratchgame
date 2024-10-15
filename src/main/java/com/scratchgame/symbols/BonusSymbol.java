package com.scratchgame.symbols;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BonusSymbol {
	TEN_X("10x", 10, SymbolType.BONUS, "multiply_reward"),
	FIVE_X("5x", 5, SymbolType.BONUS, "multiply_reward"),
	PLUS_1000("+1000", 1000, SymbolType.BONUS, "extra_bonus"),
	PLUS_500("+500", 500, SymbolType.BONUS, "extra_bonus"),
	MISS("MISS", 0, SymbolType.BONUS, "miss");
	
	
	
	
	private final String symbolName;
	private final double rewardMultiplier;
	private final SymbolType type;
	private final String impact;
}
