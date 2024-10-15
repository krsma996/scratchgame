package com.scratchgame;

import java.util.Map;
import java.util.Scanner;

import com.scratchgame.commands.Commands;
import com.scratchgame.config.ScratchGameConfig;
import com.scratchgame.config.SymbolMatrixGenerator;
import com.scratchgame.definition.Probabilities;
import com.scratchgame.definition.SymbolDetails;
import com.scratchgame.definition.User;
import com.scratchgame.symbols.BonusSymbol;
import com.scratchgame.symbols.StandardSymbols;

public class ScratchGameMainEntryPoint {

    public static void main(String[] args) {

    	Map<StandardSymbols, SymbolDetails> standardSymbolsMap = ScratchGameConfig.fillStandardSymbols();
        Map<BonusSymbol, SymbolDetails> bonusSymbolsMap = ScratchGameConfig.fillBonusSymbols();
        Probabilities probabilities = Probabilities.createProbabilities();
        Object[][] matrix = SymbolMatrixGenerator.generateSymbolMatrix(probabilities, 3, 3);
       
    	boolean gameStarted = true;
    	Scanner scanner = new Scanner(System.in);
    	while(gameStarted) {
    		User user = new User();
    		System.out.println("Welcome to the scratch game ! Please enter your Name");
    		String userName = scanner.nextLine();
    		System.out.println("Enter your bet amount");
    		double betAmount = scanner.nextDouble();
    		scanner.nextLine();//cleaning the buffer
    		System.out.println(" Hello " +userName + " your betAmount is = " + betAmount);
    		user.setBetAmount(betAmount);
    		user.setName(userName);
    		if(user.getName().isBlank() || user.getBetAmount()<=0) {
    			System.out.println("Please enter a valid information");
    			continue;
    		}else {
    			ScratchGameConfig gameConfigured = new ScratchGameConfig(standardSymbolsMap, bonusSymbolsMap, probabilities, matrix, user);
    			System.out.println("--- Enter  ' SPIN '  to start a game -----");
    			String enteredSpin = scanner.nextLine();
    			if(enteredSpin.equalsIgnoreCase(Commands.SPIN.name())) {
    				gameConfigured.printSymbolMatrix();	
    				double totalWinnings = gameConfigured.calculateWinningAmount();
                    System.out.println("Your total winnings: " + totalWinnings);
                    scanner.close();
                    break;
    			}
    			
    			
    		}
    		
    		 
    	}
    	scanner.close();	
    
    }
    
}
