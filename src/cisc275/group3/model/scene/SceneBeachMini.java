package cisc275.group3.model.scene;

import cisc275.group3.model.sceneobject.BetaCrab;
import cisc275.group3.utility.ObjectId;
import cisc275.group3.utility.SceneId;

public class SceneBeachMini extends Scene implements PropertyTimed {
	
  // Crab File Location
  private static final String[] CRAB_FILES = 
	    {"img/crab_red_icon.png", "img/crab_blue_icon.png"};
  
  // Crab Names
  private static final String[] CRAB_NAMES = 
    {"Cristmas Island Red Crab", "Atlantic Blue Crab"};
	  
  // Crab Width
  private static final double[] CRAB_WIDTH = {100, 125};
	  
  // Crab Aspect Ratios (multiply by width for height)
  private static final double[] CRAB_AR = {1.442, 0.5988};
	  
  // Crab ID Numbers
  private static final int[] CRAB_ID = {100, 200};
	  
  // Crab x-axis Speed
  private static final int[] CRAB_SPEED = {10, 0};

  public SceneBeachMini(SceneId mani, boolean click, boolean vis) {
	super(mani, click, vis);
	
	time = 0;
	fillScene();
  }
  
  /**
   * Used when SceneId must also be created
   */ 
  public SceneBeachMini(String n, double x, double y, double w, double h, boolean click, boolean vis) {
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
      
      sceneItems.add(new BetaCrab(crabId, // crab id
    	                          0+50, // x location
    	                          i*200 + manifest.getStartY() + 10, // y location
    	                          CRAB_SPEED[0]+randGen.nextInt(4), // speed x
    	                          0)); // speed y
    }
    
    // Player Crab
    ObjectId crabId = new ObjectId(5, // depth
                                   CRAB_WIDTH[1]*CRAB_AR[1], // height
                                   CRAB_ID[1], // id
                                   CRAB_FILES[1], // file name
                                   CRAB_NAMES[1], // crab name
                                   CRAB_WIDTH[1]); // width

    sceneItems.add(new BetaCrab(crabId, // crab id
                                0+50, // x location
                                600, // y location
                                0, // speed x
                                0)); // speed y
    
  }
  @Override
  public void update() {
    sceneItems.forEach((crab)->{
      if (crab.getPassport().getId() == 100) {
        ((BetaCrab)crab).move();
      }
    });	
  }
  
  public void update(double dx) {
    sceneItems.forEach((crab)->{
      if (crab.getPassport().getId() == 200) {
	    ((BetaCrab)crab).move(dx);
	  }
	});	 
  }

  @Override
  public int getTime() {
    return time;
  }

  @Override
  public void updateTime() {
    time += 1;
  }
}
