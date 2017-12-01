package cisc275.group3.utility;

import java.util.Random;

import cisc275.group3.model.scene.Scene;

/**
 * Data structure that holds all of the facts about various sceneObjects in the
 * game.
 * <p>
 * EstuaryFacts.java
 * 
 * @author Jon
 * @author Thomas
 * @author Jolyne
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
		prompt[0][1] = " to provide food to the locals?";
					
		prompt[1][0] = "Hey, its crab season and our stock is low, catch ";
		prompt[1][1] = " for me?";
		
		//Scientist
		prompt[2][0] = "Can you catch ";
		prompt[2][1] = " so we can use their blood for some cutting-edge research?";
		
		//BirdWatcher (Heron)
		prompt[3][0] = "I've heard Herons love the estuary, can you take pictures of ";
		prompt[3][1] = " for me?";
		
		//Betty
		prompt[4][0] = "Some invasive vegetation is growing at an alarming rate, can you collect ";
		prompt[4][1] = " for me?";
		
		
		
	}
	
	public String getPrompt(Mission m) {
		switch (Scene.getCurrentMission().getTargetNameForFact()) {
		case "Striped Bass":
		case "American Shad":
		case "Shortnose Sturgeon":
			return ("<html>" + prompt[0][0] + m.toString() + prompt[0][1] + "</html>");
		case "Atlantic Blue Crab":
			return ("<html>" + prompt[1][0] + m.toString() + prompt[1][1] + "</html>");
		case "Horseshoe Crab":
			return ("<html>" + prompt[2][0] + m.toString() + prompt[2][1] + "</html>");
		case "Great Blue Heron":
			return ("<html>" + prompt[3][0] + m.toString() + prompt[3][1] + "</html>");
		case "Invasive Plant":
			return ("<html>" + prompt[4][0] + m.toString() + prompt[4][1] + "</html>");
		}
		return null;
	}
	
}
