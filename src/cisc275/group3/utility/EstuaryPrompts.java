package cisc275.group3.utility;

import cisc275.group3.scene.Scene;

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
//	private String[][] prompt = new String[7][2];

	  /**
	   * Generates a string array that has all of the prompts
	   */
//	public EstuaryPrompts() {

		
//	}
	
	/**
	 * Based on the mission generate the appropriate prompt
	 * @param m Mission - Mission that you want to load a prompt for
	 * 
	 * @return String - the image path for the prompt image
	 */
	public String getPrompt(Mission m) {
		switch (Scene.getCurrentMission().getTargetNameForFact()) {
		case "Striped Bass":
			return "img/estuaryPromtPics/speech_bubble_left_striped_bass.png";
		case "American Shad":
			return "img/estuaryPromtPics/speech_bubble_left_american_shad.png";
		case "Shortnose Sturgeon":
			return "img/estuaryPromtPics/speech_bubble_left_shortnose_sturgeon.png";
		case "Atlantic Blue Crab":
			return "img/estuaryPromtPics/speech_bubble_left_blue_crab.png";
		case "Horseshoe Crab":
			return "img/estuaryPromtPics/speech_bubble_left_horseshoe_crabs.png";
		case "Great Blue Heron":
			return "img/estuaryPromtPics/speech_bubble_left_heron.png";
		case "Invasive Plant":
			return "img/estuaryPromtPics/speech_bubble_left_vegetation.png";
		}
		return null;
	}
	
}
