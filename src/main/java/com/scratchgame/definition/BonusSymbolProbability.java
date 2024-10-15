package com.scratchgame.definition;

import java.util.Map;

import com.scratchgame.symbols.BonusSymbol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class BonusSymbolProbability {
	
	private Map<BonusSymbol, Integer> symbols;
}
