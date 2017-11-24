package cisc275.group3.utility;

import cisc275.group3.model.sceneobject.BetaHeron;

/**
 * Interface to simplify the construction of heron objects. This
 * code used to be within SceneWetland.java, but was transitioned
 * into an interface to reduce code size and increase 
 * extensibility.
 */
public interface ConstructHeron {
	// Heron File Location
	static final String[] LEFT_FILE = { "img/heron_standing_left.png", "img/heron_flying_left.png" };
	static final String[] RIGHT_FILE = { "img/heron_standing_right.png", "img/heron_flying_right.png" };

	// Heron Names
	static final String[] HERON_NAME = { "Great Blue Heron: standing", "Great Blue Heron: flying" };

	// Heron Width
	static final double[] HERON_WIDTH = { 155, 177 };

	// Heron Aspect Ratios (multiply by width for height)
	static final double[] HERON_AR = { 0.67, 1.3 };

	// Heron ID Numbers
	static final int[] HERON_ID = { 100, 200 };

	// Heron x-axis Speed
	static final int HERON_XSPEED = 20;

	// Heron y-axis Speed
	static final int HERON_YSPEED = 10;

	/**
	 * Returns a constructed Beta Heron object
	 * 
	 * @param depth
	 *            int-heron depth
	 * @param type
	 *            int-heron type [0,1]
	 * @param x
	 *            double-x-axis location
	 * @param y
	 *            double-y-axis location
	 * @return BetaHeron
	 */
	static public BetaHeron constructLeftHeron(int depth, int type, double x, double y, boolean land, boolean hasland) {
		BetaHeron leftHeron = new BetaHeron(depth, (int) (HERON_WIDTH[type] * HERON_AR[type]), // height
				HERON_ID[type], // id
				LEFT_FILE[type], // image file
				HERON_NAME[type], // name
				(int) HERON_WIDTH[type], // width
				x, // x position
				y, // y position
				HERON_XSPEED, // x-axis speed
				HERON_YSPEED, // y-axis speed
				land, hasland,
				true);

		return leftHeron;
	}

	static public BetaHeron constructRightHeron(int depth, int type, double x, double y, boolean land, boolean hasland) {
		BetaHeron rightHeron = new BetaHeron(depth, (int) (HERON_WIDTH[type] * HERON_AR[type]), // height
				HERON_ID[type], // id
				RIGHT_FILE[type], // image file
				HERON_NAME[type], // name
				(int) HERON_WIDTH[type], // width
				x, // x position
				y, // y position
				HERON_XSPEED, // x-axis speed
				HERON_YSPEED, // y-axis speed
				land, hasland,
				false);
		return rightHeron;
	}
}
