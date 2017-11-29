package cisc275.group3.utility;

import java.util.Random;

/**
 * Data structure that holds all of the facts about various sceneObjects in the
 * game.
 * <p>
 * EstuaryFacts.java
 * <p>
 * 
 * @author Jon
 * @author Thomas
 */
public final class EstuaryFacts {
	private String[][] facts = new String[7][5];
	private Random randGen = new Random();

	/**
	 * Generates a 2D string array that has all of the facts
	 */
	public EstuaryFacts() {
		// Not Specific to Delaware Estuary, but list of facts of common animals found
		// in estuary found nearby http://www.nj.gov/dep/fgw/artdelstudy_factsheets.htm
		// 0 - heron
		facts[0][0] = "<html>Blue Herons are Massive Birds, they can stand up to four feet tall and have wingspans of up to six feet!</html>";
		facts[0][1] = "<html>Blue Heron hatchlings can fly as soon as 60 days after hatching!</html>";
		facts[0][2] = "<html>Blue Herons feed on a variety of things such as fish, amphibians, reptiles, and small mammals!</html>";
		facts[0][3] = "<html>Blue Herons hunt by standing silently along the shore until their prey comes within lunging distance!</html>";
		facts[0][4] = "<html>Blue Herons nest in colonies called Heronries, which can be up to 500 seperate nests in total!</html>";

		// 1 - vegetation
		facts[1][0] = "<html>Approximately 42% of all endangered species are at risk due to invasive plants and animals!</html>";
		facts[1][1] = "<html>Most invasive species have been introduced into the enviornment by humans!</html>";
		facts[1][2] = "<html>Invasive plants can spread quickly due to being more aggressive than native plants!</html>";
		facts[1][3] = "<html>Hand removal, cutting, burning, and herbicides are all tactics used in reducing invasice plants!</html>";
		facts[1][4] = "<html>Problems due to invasive species result in damage totalling over one billion dollars a year worldwide!</html>";

		// 2 - Blue Crab http://udel.edu/~spyzguyz/images/CommercialFishingPDE.pdf
		facts[2][0] = "<html>Believe it or not, three ounces of steame blue crab contains 90 calories and only one gram of fat, making it one of the healthiest food choices available locally.</html>";
		facts[2][1] = "<html>The Delaware Estraury has consistently produced at least 3 million pounds of blue crab a year!</html>";
		facts[2][2] = "<html>The average person will eat over a half-pound of crab per year, making crab one of the most consumed seafood in the United States!</html>";
		facts[2][3] = "<html>Commercial fishing has generated millions of dollars and is one of many ways that the estuary helps our region prosper!</html>";
		facts[2][4] = "<html>Blue crab females only mate once in their lifetime!</html>";

		// 3 - Horsesoe Crab
		// https://s3.amazonaws.com/delawareestuary/publications/factsheets/HORSECRA.PDF
		facts[3][0] = "<html>The Delaware Estraury is home to the largest population of horshoe crabs!</html>";
		facts[3][1] = "<html>Adult horseshoe crabs migrate from the Atlanic Ocean to the Delaware beaches to spawn every spring!</html>";
		facts[3][2] = "<html>The female digs several inches into the sand and lays a series of \"clusters\" of eggs!</html>";
		facts[3][3] = "<html>Female horshoe crabs lay eggs in clusters that can contain upwards of 4,000 eggs!</html>";
		facts[3][4] = "<html>The male crab attaches to the back of a female crab's shell as she comes ashore to spawn!</html>";

		// 4- Shortnosed Sturgeon
		facts[4][0] = "<html>Shortnosed Sturgeon have been known to breach, or jump out of the water. Scientists are still unsure out why these fish do this</html>";
		facts[4][1] = "<html>Shortnosed Sturgeon are slow growing but live long. The largest recorded Sturgeon weighed in at 90lbs!</html>";
		facts[4][2] = "<html>Shortnosed Sturgeon are an endangered species, due to overfishing and loss of habitat</html>";
		facts[4][3] = "<html>Shortnosed Sturgeon only spawn for 1-2 weeks a year. If the enviornemntal conditions are not ideal, they will wait until the following year.</html>";
		facts[4][4] = "<html>Shortnose sturgeon could be called Bigmouth sturgeon, their mouth width is greater than 60 percent of the width of their head</html>";

		// 5 - American Shad
		facts[5][0] = "<html>The American Shad can live up to 11 years!</html>";
		facts[5][1] = "<html>The American Shad can grow up to 20 inches in length!</html>";
		facts[5][2] = "<html>American Shad have a freshwater diet that includes copepods, crustacean zooplankton, cladocerans, aquatic insect larvae, and adult aquatic and terrestrial insects!</html>";
		facts[5][3] = "<html>American Shad spend most of their life at sea along the Atlantic coast and enter freshwater as adults in the spring to spawn!</html>";
		facts[5][4] = "<html>American Shad have supported valuable commercial fisheries along the entire Atlantic coast!</html>";

		// 6 - Striped Bass
		facts[6][0] = "<html>Striped Bass females migrate in and out of the estraury, but males can be foundd in the estraury year round!</html>";
		facts[6][1] = "<html>The Delaware Division of Fish and Wildlife (DFW) conduct tag-recapture studies in the spring on the Delaware River providing researchers with value information on their spawning grounds!</html>";
		facts[6][2] = "<html>Commercial fishing for Stripped Bass has brought Delaware fisheries over $500,000 in revenue a year!</html>";
		facts[6][3] = "<html>Striped bass feed primarily on fish, but also consume larger invertebrates!</html>";
		facts[6][4] = "<html>Striped bass don't exceed more than 4 inches in their first growing seasson!</html>";
	}

	/**
	 * @param i-
	 *            determines what the type of fact based on the sceneObject
	 * @return a random fact that is found in the array
	 */
	public String getRandomFact(int i) {
		return facts[i][randGen.nextInt(5)];
	}

}
