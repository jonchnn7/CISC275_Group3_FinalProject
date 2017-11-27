package cisc275.group3.utility;

import cisc275.group3.model.sceneobject.BetaFish;

/**
 * Interface to simplify the construction of fish objects. This
 * code used to be within SceneBay.java, but was transitioned
 * into an interface to reduce code size and increase 
 * extensibility.
 */
public interface ConstructFish {
  // Fish File Locations
  static final String[] LEFT_FILE = 
	    {"img/shad_left.png", "img/fish_left_2.png", "img/fish_left_3.png"};
  static final String[] RIGHT_FILE = 
	    {"img/shad_right.png", "img/fish_right_2.png", "img/fish_right_3.png"};
	  
  // Fish Names
  static final String[] LEFT_NAME = 
    {"Butterflyfish", "Rainbow Cichlid", "Goldfish"};
  static final String[] RIGHT_NAME = 
	{"Angelfish", "Threadfin Butterflyfish", "Sergeant Major"};
	  
  // Fish Dimensions
  static final int[] LEFT_LENGTH = {125, 100, 80};
  static final int[] RIGHT_LENGTH = {100, 120, 85};
  
  // Fish Aspect Ratios
  static final double[] LEFT_AR = {0.6367, 0.7898, 0.5828};
  static final double[] RIGHT_AR = {0.7047, 0.7453, 0.6};
	  
  // Fish ID Numbers
  static final int[] LEFT_ID = {1, 2, 3};
  static final int[] RIGHT_ID = {4, 5, 6};
	  
  // Fish x-axis Speed
  static final int[] SPEED = {19, 17, 13};
  
  /**
   * Returns a constructed BetaFish object
   * @param 	depth	int - fish depth
   * @param		type	int - fish type [0,2]
   * @param 	x		double - x-axis location
   * @param		y		double - y-axis location
   * @return	BetaFish
   */
  static public BetaFish constructLeftFish(int depth, int type, double x, double y) {
    BetaFish leftFish = new BetaFish(depth, 
                                     (int)(LEFT_LENGTH[type]*LEFT_AR[type]), // height
                                     LEFT_ID[type], // id
                                     LEFT_FILE[type], // image file
                                     LEFT_NAME[type], // name
                                     (int)LEFT_LENGTH[type], // width
                                     x, // x position
                                     y, // y position
                                     SPEED[type], // x-axis speed
                                     0, // y-axis speed
                                     true); // left moving?
    return leftFish;
  }
  
  /**
   * Returns a constructed BetaFish object
   * @param 	depth	int - fish depth
   * @param		type	int - fish type [0,2]
   * @param 	x		double - x-axis location
   * @param		y		double - y-axis location
   * @return	BetaFish
   */
  static public BetaFish constructRightFish(int depth, int type, double x, double y) {
    BetaFish rightFish = new BetaFish(depth, 
	                                 (int)(RIGHT_LENGTH[type]*RIGHT_AR[type]), // height
                                     RIGHT_ID[type], // id
                                     RIGHT_FILE[type], // image file
                                     RIGHT_NAME[type], // name
                                     (int)RIGHT_LENGTH[type], // width
                                     x, // x position
                                     y, // y position
                                     SPEED[type], // x-axis speed
                                     0, // y-axis speed
                                     false); // left moving?
    return rightFish;
  }
}
