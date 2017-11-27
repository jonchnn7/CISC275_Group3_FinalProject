package cisc275.group3.utility;

import java.util.Random;

/**
 * Data structure that holds all of the facts about various sceneObjects in the
 * game.
 * <p>
 * EstuaryFacts.java
 * 
 * @author Jon
 */
public final class EstuaryFacts {
	private String[][] facts = new String[5][5];
	private Random randGen = new Random();

	  /**
	   * Generates a 2D string array that has all of the facts
	   */
	public EstuaryFacts() {
		// Not Specific to Delaware Estuary, but list of facts of common animals found in estuary found nearby http://www.nj.gov/dep/fgw/artdelstudy_factsheets.htm
		// 0 - heron
		facts[0][0] = "Blue Herons are Massive Birds, they can stand up to four feet tall and have wingspans of up to six feet";
		facts[0][1] = "Blue Heron hatchlings can fly as soon as 60 days after hatching";
		facts[0][2] = "Blue Herons feed on a variety of things such as fish, amphibians, reptiles, and small mammals";
		facts[0][3] = "Blue Herons hunt by standing silently along the shore until their prey comes within lunging distance";
		facts[0][4] = "Blue Herons nest in colonies called Heronries, which can be up to 500 seperate nests in total";
		
		//1 - vegetation
		facts[1][0] = "Approximately 42% of all endangered species are at risk due to invasive plants and animals";
		facts[1][1] = "Most invasive species have been introduced into the enviornment by humans";
		facts[1][2] = "Invasive plants can spread quickly due to being more aggressive than native plants";
		facts[1][3] = "Hand removal, cutting, burning, and herbicides are all tactics used in reducing invasice plants";
		facts[1][4] = "Problems due to invasive species result in damage totalling over one billion dollars a year worldwide";
		
		//2 - Blue Crab  http://udel.edu/~spyzguyz/images/CommercialFishingPDE.pdf
		facts[2][0] = "Believe it or not, three ounces of steame blue crab contains 90 calories and only\r\n" + 
					  "one gram of fat, making it one of the healthiest food choices available locally.";
		facts[2][1] = "The Delaware Estraury has consistently produced at least 3 million pounds of blue crab a year!";
		facts[2][2] = "The average person will eat over a half-pound of crab per year, making\r\n" + 
						"crab one of the most consumed seafood in the United States!";
		facts[2][3] = "Commercial fishing has generated millions of dollars and is one of many ways\r\n" + 
						"that the estuary helps our region prosper! ";
		facts[2][4] = "Blue crab females only mate once in their lifetime!";	
		
	}

	  /**
	   * @param i- determines what the type of fact based on the sceneObject 
	   * @return a random fact that is found in the array
	   */
	public String getRandomFact(int i) {
		return facts[i][randGen.nextInt(5)];
	}

}
