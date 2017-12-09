package cisc275.group3.utility;

import cisc275.group3.sceneobject.ObjectFish;

/**
 * Interface to simplify the construction of fish objects. This code used to be
 * within SceneBay.java, but is transitioned into an interface to reduce code
 * size and increase extensibility.
 * <p>
 * ConstructFish.java
 * 
 * @author Scott
 */
public interface ConstructFish {
	// Fish File Locations
	static final String[] LEFT_FILE = { "img/betaFishPics/shad_left.png", "img/betaFishPics/striped_bass_left.png",
			"img/betaFishPics/shortnose_left.png" };
	static final String[] RIGHT_FILE = { "img/betaFishPics/shad_right.png", "img/betaFishPics/striped_bass_right.png",
			"img/betaFishPics/shortnose_right.png" };

	// Fish Names
	static final String[] NAME = { "American Shad", "Striped Bass", "Shortnose Sturgeon" };

	// Fish Dimensions
	static final int[] LEFT_LENGTH = { 120, 180, 150 };
	static final int[] RIGHT_LENGTH = { 150, 180, 150 };

	// Fish Aspect Ratios (multiply by width for height)
	static final double[] LEFT_AR = { 0.4333, 0.6055, 0.28 };
	static final double[] RIGHT_AR = { 0.44, 0.6055, 0.28 };

	// Fish ID Numbers
	static final int[] LEFT_ID = { 1, 2, 3 };
	static final int[] RIGHT_ID = { 4, 5, 6 };

	// Fish x-axis Speed
	static final int[] SPEED = { 19, 17, 13 };

	/**
	 * Returns a constructed BetaFish object. This fish will move left
	 * 
	 * @param depth
	 *            int - fish depth
	 * @param type
	 *            int - fish type [0,2] (0 = Shad, 1 = Striped Bass, 2 = Shortnosed
	 *            Sturgeon)
	 * @param x
	 *            double - x-axis location
	 * @param y
	 *            double - y-axis location
	 * @return BetaFish
	 */
	static public ObjectFish constructLeftFish(int depth, int type, double x, double y) {
		ObjectFish leftFish = new ObjectFish(depth, (int) (LEFT_LENGTH[type] * LEFT_AR[type]), // height
				LEFT_ID[type], // id
				LEFT_FILE[type], // image file
				NAME[type], // name
				(int) LEFT_LENGTH[type], // width
				x, // x position
				y, // y position
				SPEED[type], // x-axis speed
				0, // y-axis speed
				true); // left moving
		return leftFish;
	}

	/**
	 * Returns a constructed BetaFish object. This fish will move right
	 * 
	 * @param depth
	 *            int - fish depth
	 * @param type
	 *            int - fish type [0,2]
	 * @param x
	 *            double - x-axis location
	 * @param y
	 *            double - y-axis location
	 * @return BetaFish
	 */
	static public ObjectFish constructRightFish(int depth, int type, double x, double y) {
		ObjectFish rightFish = new ObjectFish(depth, (int) (RIGHT_LENGTH[type] * RIGHT_AR[type]), // height
				RIGHT_ID[type], // id
				RIGHT_FILE[type], // image file
				NAME[type], // name
				(int) RIGHT_LENGTH[type], // width
				x, // x position
				y, // y position
				SPEED[type], // x-axis speed
				0, // y-axis speed
				false); // left moving?
		return rightFish;
	}
}
