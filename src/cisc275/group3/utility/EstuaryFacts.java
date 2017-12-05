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
		facts[0][0] = "img/estruaryFactsPics/speech_bubble_right_0_0.png";
		facts[0][1] = "img/estruaryFactsPics/speech_bubble_right_0_1.png";
		facts[0][2] = "img/estruaryFactsPics/speech_bubble_right_0_2.png";
		facts[0][3] = "img/estruaryFactsPics/speech_bubble_right_0_3.png";
		facts[0][4] = "img/estruaryFactsPics/speech_bubble_right_0_4.png";

		// 1 - vegetation
		facts[1][0] = "img/estruaryFactsPics/speech_bubble_right_1_0.png";
		facts[1][1] = "img/estruaryFactsPics/speech_bubble_right_1_1.png";
		facts[1][2] = "img/estruaryFactsPics/speech_bubble_right_1_2.png";
		facts[1][3] = "img/estruaryFactsPics/speech_bubble_right_1_3.png";
		facts[1][4] = "img/estruaryFactsPics/speech_bubble_right_1_4.png";

		// 2 - Blue Crab http://udel.edu/~spyzguyz/images/CommercialFishingPDE.pdf
		facts[2][0] = "img/estruaryFactsPics/speech_bubble_right_2_0.png";
		facts[2][1] = "img/estruaryFactsPics/speech_bubble_right_2_1.png";
		facts[2][2] = "img/estruaryFactsPics/speech_bubble_right_2_2.png";
		facts[2][3] = "img/estruaryFactsPics/speech_bubble_right_2_3.png";
		facts[2][4] = "img/estruaryFactsPics/speech_bubble_right_2_4.png";

		// 3 - Horsesoe Crab
		// https://s3.amazonaws.com/delawareestuary/publications/factsheets/HORSECRA.PDF
		facts[3][0] = "img/estruaryFactsPics/speech_bubble_right_3_0.png";
		facts[3][1] = "img/estruaryFactsPics/speech_bubble_right_3_1.png";
		facts[3][2] = "img/estruaryFactsPics/speech_bubble_right_3_2.png";
		facts[3][3] = "img/estruaryFactsPics/speech_bubble_right_3_3.png";
		facts[3][4] = "img/estruaryFactsPics/speech_bubble_right_3_4.png";

		// 4- Shortnosed Sturgeon - Technical Report
		facts[4][0] = "img/estruaryFactsPics/speech_bubble_right_4_0.png";
		facts[4][1] = "img/estruaryFactsPics/speech_bubble_right_4_1.png";
		facts[4][2] = "img/estruaryFactsPics/speech_bubble_right_4_2.png";
		facts[4][3] = "img/estruaryFactsPics/speech_bubble_right_4_3.png";
		facts[4][4] = "img/estruaryFactsPics/speech_bubble_right_4_4.png";

		// 5 - American Shad - Technical Report
		facts[5][0] = "img/estruaryFactsPics/speech_bubble_right_5_0.png";
		facts[5][1] = "img/estruaryFactsPics/speech_bubble_right_5_1.png";
		facts[5][2] = "img/estruaryFactsPics/speech_bubble_right_5_2.png";
		facts[5][3] = "img/estruaryFactsPics/speech_bubble_right_5_3.png";
		facts[5][4] = "img/estruaryFactsPics/speech_bubble_right_5_4.png";

		// 6 - Striped Bass - Technical Report
		facts[6][0] = "img/estruaryFactsPics/speech_bubble_right_6_0.png";
		facts[6][1] = "img/estruaryFactsPics/speech_bubble_right_6_1.png";
		facts[6][2] = "img/estruaryFactsPics/speech_bubble_right_6_2.png";
		facts[6][3] = "img/estruaryFactsPics/speech_bubble_right_6_3.png";
		facts[6][4] = "img/estruaryFactsPics/speech_bubble_right_6_4.png";
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
