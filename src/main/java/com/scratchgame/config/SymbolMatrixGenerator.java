package com.scratchgame.config;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.scratchgame.definition.BonusSymbolProbability;
import com.scratchgame.definition.Probabilities;
import com.scratchgame.definition.StandardSymbolsGrid;
import com.scratchgame.symbols.BonusSymbol;
import com.scratchgame.symbols.StandardSymbols;

import lombok.Data;

@Data
public class SymbolMatrixGenerator {
	
	
	public static Object[][] generateSymbolMatrix(Probabilities probabilities, int rows, int columns) {
        Object[][] symbolMatrix = new Object[rows][columns];
        Random random = new Random();

        List<StandardSymbolsGrid> standardGrids = probabilities.getStandardSymbolsGrid();
        BonusSymbolProbability bonusProbability = probabilities.getBonusSymbolProbability();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // Fetch the probability for this cell (row i, column j)
                StandardSymbolsGrid gridForCell = getGridForCell(standardGrids, i, j);
                Map<StandardSymbols, Integer> standardSymbolProbabilities = gridForCell.getSymbols();
                
                // Fetch probabilities for bonus symbols
                Map<BonusSymbol, Integer> bonusSymbolProbabilities = bonusProbability.getSymbols();
                
                // Determine if we should select a standard symbol or a bonus symbol
                if (random.nextDouble() < 0.20) { // Assuming 20% chance for bonus symbols
                    symbolMatrix[i][j] = getRandomBonusSymbol(bonusSymbolProbabilities, random);
                } else {
                    symbolMatrix[i][j] = getRandomStandardSymbol(standardSymbolProbabilities, random);
                }
            }
        }

        return symbolMatrix;
    }

    // Helper method to find the grid configuration for a specific cell
    private static StandardSymbolsGrid getGridForCell(List<StandardSymbolsGrid> grids, int row, int column) {
        for (StandardSymbolsGrid grid : grids) {
            if (grid.getRow() == row && grid.getColumn() == column) {
                return grid;
            }
        }
        throw new IllegalArgumentException("No grid found for row " + row + " and column " + column);
    }

    // Get a random standard symbol based on probabilities
    private static StandardSymbols getRandomStandardSymbol(Map<StandardSymbols, Integer> symbolProbabilities, Random random) {
        int totalWeight = symbolProbabilities.values().stream().mapToInt(Integer::intValue).sum();
        int randomValue = random.nextInt(totalWeight);
        
        for (Map.Entry<StandardSymbols, Integer> entry : symbolProbabilities.entrySet()) {
            randomValue -= entry.getValue();
            if (randomValue < 0) {
                return entry.getKey();
            }
        }
        throw new IllegalStateException("Failed to select a random standard symbol");
    }

    // Get a random bonus symbol based on probabilities
    private static BonusSymbol getRandomBonusSymbol(Map<BonusSymbol, Integer> bonusProbabilities, Random random) {
    	
        int totalWeight = bonusProbabilities.values().stream().mapToInt(Integer::intValue).sum();
        int randomValue = random.nextInt(totalWeight);
        
        for (Map.Entry<BonusSymbol, Integer> entry : bonusProbabilities.entrySet()) {
            randomValue -= entry.getValue();
            if (randomValue < 0) {
                return entry.getKey();
            }
        }
        throw new IllegalStateException("Failed to select a random bonus symbol");
    }
}
