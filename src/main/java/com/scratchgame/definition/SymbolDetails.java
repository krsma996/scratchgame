package com.scratchgame.definition;

import com.scratchgame.symbols.SymbolType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymbolDetails {
	
	
	private double rewardMultiplier;
	private SymbolType type;
	private String impact;
	private Integer extra;
}
