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
		// 0 - heron
		facts[0][0] = "Blue Herons are Massive Birds, they can stand up to four feet tall and have wingspans of up to six feet";
		facts[0][1] = "Blue Heron hatchlings can fly as soon as 60 days after hatching";
		facts[0][2] = "Blue Herons feed on a variety of things such as fish, amphibians, reptiles, and small mammals";
		facts[0][3] = "Blue Herons hunt by standing silently along the shore until their prey comes within lunging distance";
		facts[0][4] = "Blue Herons nest in colonies called Heronries, which can be up to 500 seperate nests in total";
	}

	  /**
	   * @param i- determines what the type of fact based on the sceneObject 
	   * @return a random fact that is found in the array
	   */
	public String getRandomFact(int i) {
		return facts[i][randGen.nextInt(5)];
	}

}
