package cisc275.group3.utility;

import cisc275.group3.sceneobject.BetaCrab;

/**
 * Interface to simplify the construction of crab objects. This code used to be
 * within SceneBeach.java, but is transitioned into an interface to reduce code
 * size and increase extensibility.
 * <p>
 * ConstructCrab.java
 * <p>
 *
 * @author Scott
 * @author Ryan
 * @author Thomas
 *
 */
public interface ConstructCrab {
	// Crab File Location
	static final String[] LEFT_FILE = { "img/betaCrabPics/crab_blue_icon.png",
			"img/betaCrabPics/horseshoe_crab_left.png" };
	static final String[] RIGHT_FILE = { "img/betaCrabPics/crab_blue_icon.png",
			"img/betaCrabPics/horseshoe_crab_right.png" };

	// Crab Names
	static final String[] CRAB_NAME = { "Atlantic Blue Crab", "Horseshoe Crab" };

	// Crab Width
	static final double[] CRAB_WIDTH = { 125, 166 };

	// Crab Aspect Ratios (multiply by width for height)
	static final double[] CRAB_AR = { 0.5988, 0.512 };

	// Crab ID Numbers
	static final int[] CRAB_ID = { 200, 300 };

	// Crab x-axis Speed
	static final int[] CRAB_SPEED = { 13, 10 };

	/**
	 * Returns a constructed BetaCrab object. This crab will move left
	 * 
	 * @param depth
	 *            int-crab depth
	 * @param type
	 *            int-crab type [0,1] (Blue = 0, Horseshoe = 1)
	 * @param x
	 *            double-x-axis location
	 * @param y
	 *            double-y-axis location
	 * @return BetaCrab
	 */
	static public BetaCrab constructLeftCrab(int depth, int type, double x, double y) {
		BetaCrab leftCrab = new BetaCrab(depth, (int) (CRAB_WIDTH[type] * CRAB_AR[type]), // height
				CRAB_ID[type], // id
				LEFT_FILE[type], // image file
				CRAB_NAME[type], // name
				(int) CRAB_WIDTH[type], // width
				x, // x position
				y, // y position
				CRAB_SPEED[type], // x-axis speed
				0, // y-axis speed
				true);

		return leftCrab;
	}

	/**
	 * Returns a constructed BetaCrab object. This crab will move right
	 * 
	 * @param depth
	 *            int-crab depth
	 * @param type
	 *            int-crab type [0,1]
	 * @param x
	 *            double-x-axis location
	 * @param y
	 *            double-y-axis location
	 * @return BetaCrab
	 */
	static public BetaCrab constructRightCrab(int depth, int type, double x, double y) {
		BetaCrab rightCrab = new BetaCrab(depth, (int) (CRAB_WIDTH[type] * CRAB_AR[type]), // height
				CRAB_ID[type], // id
				RIGHT_FILE[type], // image file
				CRAB_NAME[type], // name
				(int) CRAB_WIDTH[type], // width
				x, // x position
				y, // y position
				CRAB_SPEED[type], // x-axis speed
				0, // y-axis speed
				false);
		return rightCrab;
	}

	/**
	 * Returns an instance of a BetaCrab
	 * 
	 * @param depth
	 *            int-crab depth
	 * @param type
	 *            int-crab type [0,1]
	 * @param x
	 *            double-x-axis location
	 * @param y
	 *            double-y-axis location
	 * @return BetaCrab
	 */
	static public BetaCrab constructCrab(int depth, int type, double x, double y) {
		BetaCrab crab = new BetaCrab(depth, (int) (CRAB_WIDTH[type] * CRAB_AR[type]), // height
				CRAB_ID[type], // id
				RIGHT_FILE[type], // image file
				CRAB_NAME[type], // name
				(int) CRAB_WIDTH[type], // width
				x, // x position
				y, // y position
				CRAB_SPEED[type], // x-axis speed
				0, // y-axis speed
				false);
		return crab;
	}
}
