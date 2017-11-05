package cisc275.group3.model.scene;

import java.awt.Color;

import cisc275.group3.utility.ObjectId;
import cisc275.group3.utility.SceneId;

public class BeachMiniScene extends Scene implements PropertyTimed {
	
  // Crab File Location
  private static final String[] CRAB_FILES = 
	    {"img/crab_red_icon.png", "img/crab_blue_icon"};
  
  // Crab Names
  private static final String[] CRAB_NAMES = 
    {"Cristmas Island Red Crab", "Atlantic Blue Crab"};
	  
  // Crab Width
  private static final double[] CRAB_WIDTH = {104, 167};
	  
  // Crab Aspect Ratios (multiply by width for height)
  private static final double[] CRAB_AR = {1.442, 0.5988};
	  
  // Crab ID Numbers
  private static final int[] CRAB_ID = {100, 200};
	  
  // Crab x-axis Speed
  private static final int[] CRAB_SPEED = {10, 0};

  public BeachMiniScene(SceneId mani, boolean click, boolean vis) {
	super(mani, click, vis);
	
	time = 0;
	backgroundColor = Color.yellow;
	
	fillScene();
  }
  
  /**
   * Used when SceneId must also be created
   */ 
  public BeachMiniScene(String n, double x, double y, double w, double h, boolean click, boolean vis) {
    this(new SceneId(n, x, y, w, h), click, vis);
  }

  
  /**
   * Creates three NPC crabs and a Player Crab
   */
  @Override
  protected void fillScene() {
    for (int i=0; i<3; i++) {
      // Create Crab ID
      ObjectId crabId = new ObjectId(5, // depth
    		                         CRAB_WIDTH[0]*CRAB_AR[0], // height
    		                         CRAB_ID[0], // id
    		                         CRAB_FILES[0], // file name
    		                         CRAB_NAMES[0], // crab name
    		                         CRAB_WIDTH[0]); // width
    }
  }
  @Override
  public void update() {
    // TODO Auto-generated method stub
		
  }

  @Override
  public int getTime() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void updateTime() {
    // TODO Auto-generated method stub
  }
}
