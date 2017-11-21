package cisc275.group3.utility;

import cisc275.group3.model.sceneobject.BetaVegetation;

/**
 * Interface to simplify the construction of vegetation objects. This
 * code used to be within SceneWetland.java, but was transitioned
 * into an interface to reduce code size and increase 
 * extensibility.
 * <p>
 * ClickAdventure.java
 * <p>
 * @author Jon
 */
public interface ConstructVegetation {
  // Veg File Locations
  static final String[] VEG_FILE = 
	    {"img/weeds3_resized.png", "img/weeds2_resized.png", "img/weeds1_resized.png"};
	  
  // Veg Names
  static final String[] VEG_NAME = 
	{"Plant: 1/3", "Plant: 2/3", "Plant: 3/3"};
	  
  // Veg Dimensions
  static final int[] VEG_WIDTH = {175, 175, 175};
  
  // Veg Aspect Ratios
  static final double[] VEG_AR = {1.129, 1.129, 1.129};
  
  // Veg ID Numbers
  static final int[] VEG_ID = { 0, 1, 2};
	    
  /**
   * Returns a constructed BetaVegetation object
   * @param 	depth	int - veg depth
   * @param		type	int - veg type [0,2]
   * @param 	x		double - x-axis location
   * @param		y		double - y-axis location
   * @return	BetaVegetation
   */
  static public BetaVegetation constructVegetation(int depth, int type, double x, double y) {
    BetaVegetation vegetation = new BetaVegetation(new ObjectId(depth, 
                                     (int)(VEG_WIDTH[type]*VEG_AR[type]), // height
                                     VEG_ID[type], // id
                                     VEG_FILE[type], // image file
                                     VEG_NAME[type], // name
                                     (int)VEG_WIDTH[type]), // width
                                     x, // x position
                                     y); // y position
    return vegetation;
  }
  
}