package com.scratchgame.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scratchgame.definition.Probabilities;
import com.scratchgame.definition.SymbolDetails;
import com.scratchgame.definition.User;
import com.scratchgame.definition.WinningCombinations;
import com.scratchgame.symbols.BonusSymbol;
import com.scratchgame.symbols.StandardSymbols;
import com.scratchgame.symbols.WinningCombinationGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScratchGameConfig {
	
    private Map<StandardSymbols, SymbolDetails> standardSymbols;
    private Map<BonusSymbol, SymbolDetails> bonusSymbols;
    private Probabilities probabilities;
    private Object[][] symbolMatrix;//it can hold both standards and bonus symbols
    private User user;

    
 
    public static Map<BonusSymbol, SymbolDetails> fillBonusSymbols() {
		Map<BonusSymbol, SymbolDetails> bonusSymbolsMap = new HashMap<>();
        for (BonusSymbol symbol : BonusSymbol.values()) {
            bonusSymbolsMap.put(symbol, new SymbolDetails(symbol.getRewardMultiplier(), symbol.getType(), symbol.getImpact(), null));
        }
		return bonusSymbolsMap;
	}

	public static Map<StandardSymbols, SymbolDetails> fillStandardSymbols() {
		Map<StandardSymbols, SymbolDetails> standardSymbolsMap = new HashMap<>();
        for (StandardSymbols symbol : StandardSymbols.values()) {
            standardSymbolsMap.put(symbol, new SymbolDetails(symbol.getRewardMultiplier(), symbol.getType(), null, null));
        }
		return standardSymbolsMap;
	}

    public void printSymbolMatrix() {
        for (int i = 0; i < symbolMatrix.length; i++) {
            for (int j = 0; j < symbolMatrix[i].length; j++) {
                if (symbolMatrix[i][j] instanceof StandardSymbols) {
                    System.out.print(((StandardSymbols) symbolMatrix[i][j]).getSymbolName() + " ");
                } else if (symbolMatrix[i][j] instanceof BonusSymbol) {
                    System.out.print(((BonusSymbol) symbolMatrix[i][j]).getSymbolName() + " ");
                }
            }
            System.out.println(); //for spacing
        }
    }
    
    public double calculateWinningAmount() {
    	List<WinningCombinations> winningCombinationsList = new ArrayList<>();
        double totalWinningAmount = 0.0;
        Map<StandardSymbols, Integer> symbolCount = new HashMap<>();
        
        // Counters symbols in matrix
        for (int i = 0; i < symbolMatrix.length; i++) {
            for (int j = 0; j < symbolMatrix[i].length; j++) {
                if (symbolMatrix[i][j] instanceof StandardSymbols) {
                    StandardSymbols symbol = (StandardSymbols) symbolMatrix[i][j];
                    symbolCount.put(symbol, symbolCount.getOrDefault(symbol, 0) + 1);
                }
            }
        }

        // Calculations for each symbols
        for (Map.Entry<StandardSymbols, Integer> entry : symbolCount.entrySet()) {
            StandardSymbols symbol = entry.getKey();
            int count = entry.getValue();
            SymbolDetails symbolDetails = standardSymbols.get(symbol);

            // Check for symbols that have more or same counts with 3
            if (count >= 3) {
                WinningCombinationGroup winningGroup = getWinningGroup(count);
                if (winningGroup != null) {
                	winningCombinationsList.add(new WinningCombinations(
                			winningGroup.getRewardMultiplier(),
                            winningGroup.getWhen(),
                            winningGroup.getCount(),
                            winningGroup.getGroup(),
                            winningGroup.getName().toLowerCase()
                        ));
                    totalWinningAmount += user.getBetAmount() * symbolDetails.getRewardMultiplier() * winningGroup.getRewardMultiplier();
                }
            }
        }

        // Check for bonuses and simbols and add their rewards
        for (int i = 0; i < symbolMatrix.length; i++) {
            for (int j = 0; j < symbolMatrix[i].length; j++) {
                if (symbolMatrix[i][j] instanceof BonusSymbol) {
                    BonusSymbol bonusSymbol = (BonusSymbol) symbolMatrix[i][j];
                    SymbolDetails bonusDetails = bonusSymbols.get(bonusSymbol);
                    totalWinningAmount += bonusDetails.getRewardMultiplier(); //Add Bonus
                }
            }
        }
        saveWinningCombinationsToFile(winningCombinationsList);
        return totalWinningAmount;
    }

    private WinningCombinationGroup getWinningGroup(int count) {
        for (WinningCombinationGroup group : WinningCombinationGroup.values()) {
            if (group.getCount() == count) {
                return group;
            }
        }
        return null;
    }
  
    private void saveWinningCombinationsToFile(List<WinningCombinations> winningCombinationsList) {
        try {
            String projectPath = System.getProperty("user.dir");
            File file = new File(projectPath + "\\src\\main\\resources\\winning_combinations.json");
            file.getParentFile().mkdirs();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, winningCombinationsList);
            System.out.println("Winning combinations saved to: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
