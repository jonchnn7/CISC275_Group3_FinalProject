package cisc275.group3.utility;

import cisc275.group3.sceneobject.ObjectHeron;

/**
 * Interface to simplify the construction of heron objects. This code used to be
 * within SceneWetland.java, but is transitioned into an interface to reduce
 * code size and increase extensibility.
 * <p>
 * ConstructHeron.java
 * <p>
 * 
 * @author Jon
 */
public interface ConstructHeron {
	// Heron File Location
	static final String[] LEFT_FILE = { "img/betaHeronPics/heron_standing_left.png", "img/betaHeronPics/heron_flying_left.png" };
	static final String[] RIGHT_FILE = { "img/betaHeronPics/heron_standing_right.png", "img/betaHeronPics/heron_flying_right.png" };

	// Heron Names
	static final String HERON_NAME = "Great Blue Heron";

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
	 * Returns a constructed Beta Heron object. This heron will move left
	 * 
	 * @param depth
	 *            int-heron depth
	 * @param type
	 *            int-heron type [0,1] (0 = landed , 1 = flying)
	 * @param x
	 *            double-x-axis location
	 * @param y
	 *            double-y-axis location
	 * @param land
	 *            boolean-determines if the heron has landed (is not moving)
	 * @param hasLand
	 *            boolean-determines if the heron has ever landed. If it has landed,
	 *            it will not land again
	 * @return BetaHeron
	 */
	static public ObjectHeron constructLeftHeron(int depth, int type, double x, double y, boolean land, boolean hasland) {
		ObjectHeron leftHeron = new ObjectHeron(depth, (int) (HERON_WIDTH[type] * HERON_AR[type]), // height
				HERON_ID[type], // id
				LEFT_FILE[type], // image file
				HERON_NAME, // name
				(int) HERON_WIDTH[type], // width
				x, // x position
				y, // y position
				HERON_XSPEED, // x-axis speed
				HERON_YSPEED, // y-axis speed
				land, hasland, true);

		return leftHeron;
	}

	/**
	 * Returns a constructed Beta Heron object. This heron will move right
	 * 
	 * @param depth
	 *            int-heron depth
	 * @param type
	 *            int-heron type [0,1]
	 * @param x
	 *            double-x-axis location
	 * @param y
	 *            double-y-axis location
	 * @param land
	 *            boolean-determines if the heron has landed (is not moving)
	 * @param hasLand
	 *            boolean-determines if the heron has ever landed. If it has landed,
	 *            it will not land again
	 * @return BetaHeron
	 */
	static public ObjectHeron constructRightHeron(int depth, int type, double x, double y, boolean land,
			boolean hasland) {
		ObjectHeron rightHeron = new ObjectHeron(depth, (int) (HERON_WIDTH[type] * HERON_AR[type]), // height
				HERON_ID[type], // id
				RIGHT_FILE[type], // image file
				HERON_NAME, // name
				(int) HERON_WIDTH[type], // width
				x, // x position
				y, // y position
				HERON_XSPEED, // x-axis speed
				HERON_YSPEED, // y-axis speed
				land, hasland, false);
		return rightHeron;
	}
}
