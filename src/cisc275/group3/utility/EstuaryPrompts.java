package cisc275.group3.utility;

import java.util.Random;

/**
 * Data structure that holds all of the facts about various sceneObjects in the
 * game.
 * <p>
 * EstuaryFacts.java
 * 
 * @author Jon
 * @author Thomas
 */
public final class EstuaryPrompts {
	private String[][] prompt = new String[7][2];

	  /**
	   * Generates a string array that has all of the prompts
	   */
	public EstuaryPrompts() {
		// Not Specific to Delaware Estuary, but list of facts of common animals found in estuary found nearby http://www.nj.gov/dep/fgw/artdelstudy_factsheets.htm
		// 0- SuperMarket Guy (Fish/Blue Crab)
		prompt[0][0] = "Hello there, can you catch me "; // Add fish quanitity and name
		prompt[0][1] = "to provide food to the locals";
					
		prompt[1][0] = "Hey, its crab season and are stock is low, catch ";
		prompt[1][1] = " for me";
		
		
		//BirdWatcher (Heron)
		prompt[2][0] = "I've heard Herons love the estuary, can you take pictures of ";
		prompt[2][1] = "for me";
		
		//Scientist
		prompt[3][0] = "Can you catch";
		prompt[3][1] = "so we can use their blood for some cutting edge research!";
		
		//Betty
		prompt[4][0] = "Some invasive vegetation is growing at an alarming rate, can you collect";
		prompt[4][1] = " bushels of plants";
		
		
		
	}
}
