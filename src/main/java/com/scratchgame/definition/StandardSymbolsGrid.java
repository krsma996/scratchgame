package com.scratchgame.definition;

import java.util.Map;

import com.scratchgame.symbols.StandardSymbols;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardSymbolsGrid {

	private int column;
    private int row;
    private Map<StandardSymbols, Integer> symbols;
}
