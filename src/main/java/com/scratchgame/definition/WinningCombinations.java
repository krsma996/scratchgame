package com.scratchgame.definition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//only used for serialize to json file like grouping result
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WinningCombinations {

	 
	 private double rewardMultiplier;
	 private String when;
	 private int count;
	 private String group;
	 private String groupName;
	
	
}
