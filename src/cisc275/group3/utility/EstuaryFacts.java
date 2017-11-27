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
public final class EstuaryFacts {
	private String[][] facts = new String[6][5];
	private Random randGen = new Random();

	  /**
	   * Generates a 2D string array that has all of the facts
	   */
	public EstuaryFacts() {
		// Not Specific to Delaware Estuary, but list of facts of common animals found in estuary found nearby http://www.nj.gov/dep/fgw/artdelstudy_factsheets.htm
		// 0 - heron
		facts[0][0] = "Blue Herons are Massive Birds, they can stand up to four feet tall and have wingspans of up to six feet!";
		facts[0][1] = "Blue Heron hatchlings can fly as soon as 60 days after hatching!";
		facts[0][2] = "Blue Herons feed on a variety of things such as fish, amphibians, reptiles, and small mammals!";
		facts[0][3] = "Blue Herons hunt by standing silently along the shore until their prey comes within lunging distance!";
		facts[0][4] = "Blue Herons nest in colonies called Heronries, which can be up to 500 seperate nests in total!";
		
		//1 - vegetation
		facts[1][0] = "Approximately 42% of all endangered species are at risk due to invasive plants and animals!";
		facts[1][1] = "Most invasive species have been introduced into the enviornment by humans!";
		facts[1][2] = "Invasive plants can spread quickly due to being more aggressive than native plants!";
		facts[1][3] = "Hand removal, cutting, burning, and herbicides are all tactics used in reducing invasice plants!";
		facts[1][4] = "Problems due to invasive species result in damage totalling over one billion dollars a year worldwide!";
		
		//2 - Blue Crab  http://udel.edu/~spyzguyz/images/CommercialFishingPDE.pdf
		facts[2][0] = "Believe it or not, three ounces of steame blue crab contains 90 calories and only\r\n" + 
					  "one gram of fat, making it one of the healthiest food choices available locally.";
		facts[2][1] = "The Delaware Estraury has consistently produced at least 3 million pounds of blue crab a year!";
		facts[2][2] = "The average person will eat over a half-pound of crab per year, making\r\n" + 
						"crab one of the most consumed seafood in the United States!";
		facts[2][3] = "Commercial fishing has generated millions of dollars and is one of many ways\r\n" + 
						"that the estuary helps our region prosper! ";
		facts[2][4] = "Blue crab females only mate once in their lifetime!";
		
		//3 - Horsesoe Crab  https://s3.amazonaws.com/delawareestuary/publications/factsheets/HORSECRA.PDF
		facts[3][0] = "The Delaware Estraury is home to the largest population of horshoe crabs!";
		facts[3][1] = "Adult horseshoe crabs migrate from the Atlanic Ocean to the Delaware beaches to spawn every spring!";
		facts[3][2] = "The female digs several inches into the sand and lays a series of “clusters” of eggs!";
		facts[3][3] = "Female horshoe crabs lay eggs in clusters that can contain upwards of 4,000 eggs!";
		facts[3][4] = "The male crab attaches to the back of a female crab’s shell as she comes ashore to spawn!";
		
		//4- Shortnosed Sturgeon
		facts[4][0] = "Shortnosed Sturgeon have been known to breach, or jump out of the water. Scientists\r\n " +
				"are still unsure out why these fish do this";
		facts[4][1] = "Shortnosed Sturgeon are slow growing but live long. The largest recorded Sturgeon \r\n" + 
				"weighed in at 90lbs!";
		facts[4][2] = "Shortnosed Sturgeon are an endangered species, due to overfishing and loss of habitat";
		facts[4][3] = "Shortnosed Sturgeon only spawn for 1-2 weeks a year. If the enviornemntal conditions are \r\n" + 
				"not ideal, they will wait until the following year.";
		facts[4][4] = "Shortnose sturgeon could be called Bigmouth sturgeon, their mouth width is greater than \r\n" +
				"60 percent of the width of their head";
		
		//5 - American Shad  
		facts[5][0] = "The American Shad can live up to 11 years!";
		facts[5][1] = "The American Shad can grow up to 20 inches in length!";
		facts[5][2] = "American Shad have a freshwater diet that includes copepods,\r\n"
				+ " crustacean zooplankton, cladocerans, aquatic insect larvae, and adult aquatic and terrestrial insects!";
		facts[5][3] = "American Shad spend most of their life at sea along the Atlantic coast and enter freshwater as adults in\r\n" + 
				"the spring to spawn!";
		facts[5][4] = "American Shad have supported valuable commercial fisheries along the entire Atlantic coast!";
		
		//6 - Striped Bass  
		facts[6][0] = "Striped Bass females migrate in and out of the estraury, but males can be foundd in the estraury year round!";
		facts[6][1] = "The Delaware Division of Fish and Wildlife (DFW) conduct tag-recapture studies\n\n"
				+ "in the spring on the Delaware River providing researchers with value information on their spawning grounds!";
		facts[6][2] = "Commercial fishing for Stripped Bass has brought Delaware fisheries over $500,000 in revenue a year!";
		facts[6][3] = "Striped bass feed primarily on fish, but also consume larger invertebrates!";
		facts[6][4] = "Striped bass don't exceed more than 4 inches in their first growing seasson!";
}

	  /**
	   * @param i- determines what the type of fact based on the sceneObject 
	   * @return a random fact that is found in the array
	   */
	public String getRandomFact(int i) {
		return facts[i][randGen.nextInt(5)];
	}

}
