package cisc275.group3.utility;

import cisc275.group3.model.sceneobject.BetaCrab;

public interface ConstructCrab {
  // Crab File Location
  static final String[] CRAB_FILE = 
	  {"img/crab_red_icon.png", "img/crab_blue_icon.png"};

  // Crab Names
  static final String[] CRAB_NAME = 
    {"Cristmas Island Red Crab", "Atlantic Blue Crab"};
		  
  // Crab Width
  static final double[] CRAB_WIDTH = {100, 125};
	  
  // Crab Aspect Ratios (multiply by width for height)
  static final double[] CRAB_AR = {1.442, 0.5988};
		  
  // Crab ID Numbers
  static final int[] CRAB_ID = {100, 200};
		  
  // Crab x-axis Speed
  static final int[] CRAB_SPEED = {10, 0};
  
  /**
   * Returns a constructed BetaCrab object
   * @param 	depth	int-crab depth
   * @param		type	int-crab type [0,1]
   * @param 	x		double-x-axis location
   * @param		y		double-y-axis location
   * @return	BetaCrab
   */
  static public BetaCrab constructCrab(int depth, int type, double x, double y) {
    BetaCrab crab = new BetaCrab(depth, 
                                 (int)(CRAB_WIDTH[type]*CRAB_AR[type]), // height
                                 CRAB_ID[type], // id
                                 CRAB_FILE[type], // image file
                                 CRAB_NAME[type], // name
                                 (int)CRAB_WIDTH[type], // width
                                 x, // x position
                                 y, // y position
                                 CRAB_SPEED[type], // x-axis speed
                                 0); // y-axis speed
    return crab;
  }
}
