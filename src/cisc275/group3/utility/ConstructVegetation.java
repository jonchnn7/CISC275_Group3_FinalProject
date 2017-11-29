package cisc275.group3.utility;

import cisc275.group3.model.sceneobject.BetaVegetation;

/**
 * Interface to simplify the construction of vegetation objects. This code used
 * to be within SceneWetland.java, but was transitioned into an interface to
 * reduce code size and increase extensibility.
 * <p>
 * ConstructVegetation.java
 * <p>
 * 
 * @author Jon
 */
public interface ConstructVegetation {
	// Veg File Locations
	static final String[] VEG_FILE = { "img/betaVegetationPics/weeds3.png", "img/betaVegetationPics/weeds2.png",
			"img/betaVegetationPics/weeds1.png" };

	// Veg Names
	static final String VEG_NAME = "Invasive Plant";

	// Veg Dimensions
	static final int VEG_WIDTH = 175;

	// Veg Aspect Ratios
	static final double VEG_AR = 1.129;

	// Veg ID Numbers
	static final int[] VEG_ID = { 70, 71, 72 };

	/**
	 * Returns a constructed BetaVegetation object
	 * 
	 * @param depth
	 *            int - veg depth
	 * @param type
	 *            int - veg type [0,2] (0 = mostly cut, 1 = partly cut, 2= full
	 *            plant)
	 * @param x
	 *            double - x-axis location
	 * @param y
	 *            double - y-axis location
	 * @return BetaVegetation
	 */
	static public BetaVegetation constructVegetation(int depth, int type, double x, double y) {
		BetaVegetation vegetation = new BetaVegetation(new ObjectId(depth, (int) (VEG_WIDTH * VEG_AR), // height
				VEG_ID[type], // id
				VEG_FILE[type], // image file
				VEG_NAME, // name
				(int) VEG_WIDTH), // width
				x, // x position
				y); // y position
		return vegetation;
	}

}