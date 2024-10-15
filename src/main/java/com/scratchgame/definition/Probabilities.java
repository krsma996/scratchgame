package com.scratchgame.definition;

import java.util.List;
import java.util.Map;

import com.scratchgame.symbols.BonusSymbol;
import com.scratchgame.symbols.StandardSymbols;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Probabilities {

    private List<StandardSymbolsGrid> standardSymbolsGrid;
    private BonusSymbolProbability bonusSymbolProbability;

    public static Probabilities createProbabilities() {
        List<StandardSymbolsGrid> standardSymbolsGrid = List.of(
            new StandardSymbolsGrid(0, 0, createStandardSymbolProbability()),
            new StandardSymbolsGrid(0, 1, createStandardSymbolProbability()),
            new StandardSymbolsGrid(0, 2, createStandardSymbolProbability()),
            new StandardSymbolsGrid(1, 0, createStandardSymbolProbability()),
            new StandardSymbolsGrid(1, 1, createStandardSymbolProbability()),
            new StandardSymbolsGrid(1, 2, createStandardSymbolProbability()),
            new StandardSymbolsGrid(2, 0, createStandardSymbolProbability()),
            new StandardSymbolsGrid(2, 1, createStandardSymbolProbability()),
            new StandardSymbolsGrid(2, 2, createStandardSymbolProbability())
        );

        BonusSymbolProbability bonusSymbolProbability = new BonusSymbolProbability(Map.of(
            BonusSymbol.TEN_X, 1,
            BonusSymbol.FIVE_X, 2,
            BonusSymbol.PLUS_1000, 3,
            BonusSymbol.PLUS_500, 4,
            BonusSymbol.MISS, 5
        ));

        return new Probabilities(standardSymbolsGrid, bonusSymbolProbability);
    }
    private static Map<StandardSymbols, Integer> createStandardSymbolProbability() {
        return Map.of(
        		StandardSymbols.A, 1,
        		StandardSymbols.B, 2,
        		StandardSymbols.C, 3,
        		StandardSymbols.D, 4,
        		StandardSymbols.E, 5,
        		StandardSymbols.F, 6
        );
    }
}
