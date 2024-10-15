package com.scratchgame.symbols;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 * 
 * **Standard Symbols**: identifies if user won or lost the game based on winning combinations 
 * (combination can be X times repeated symbols or symbols that follow a specific pattern)
	Bonus symbols are described the enum below:
 */
@Getter
@AllArgsConstructor
public enum StandardSymbols {

	A("A", 5,  SymbolType.STANDARD), 
	B("B", 3,  SymbolType.STANDARD), 
	C("C", 2.5,  SymbolType.STANDARD), 
	D("D", 2,   SymbolType.STANDARD),
	E("E", 1.2,   SymbolType.STANDARD), 
	F("F", 1.5, SymbolType.STANDARD);

	
	private final String symbolName;
	private final double rewardMultiplier;
	private final SymbolType type;
	
}
