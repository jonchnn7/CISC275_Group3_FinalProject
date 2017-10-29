package cisc275.group3.model.scene;

import java.util.Collections;
import java.util.Iterator;

import cisc275.group3.model.sceneobject.FishAlpha;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.ObjectId;
import cisc275.group3.utility.SceneId;

/**
 * Bay game scene. 
 * <p>
 * BayScene.java
 */
public class BayScene extends Scene implements PropertyScored, PropertyTimed {
  
  // Fish File Locations
  private static final String[] FISH_LEFT_FILES = 
	    {"img/fish_left_1.png", "img/fish_left_2.png", "img/fish_left_3.png"};
  private static final String[] FISH_RIGHT_FILES = 
	    {"img/fish_right_1.png", "img/fish_right_2.png", "img/fish_right_3.png"};
  
  // Fish Names
  private static final String[] FISH_LEFT_NAMES = 
    {"Butterflyfish", "Rainbow Cichlid", "Goldfish"};
  private static final String[] FISH_RIGHT_NAMES = 
	{"Angelfish", "Threadfin Butterflyfish", "Sergeant Major"};
  
  // Fish Dimensions
  private static final int[] FISH_LEFT_LENGTH = {125, 100, 80};
  private static final int[] FISH_RIGHT_LENGTH = {100, 120, 85};
  
  // Fish Aspect Ratios
  private static final double[] FISH_LEFT_AR = {0.6367, 0.7898, 0.5828};
  private static final double[] FISH_RIGHT_AR = {0.7047, 0.7453, 0.6};
  
  // Fish ID Numbers
  private static final int[] FISH_LEFT_ID = {1, 2, 3};
  private static final int[] FISH_RIGHT_ID = {4, 5, 6};
  

  public BayScene(SceneId mani, boolean click, boolean vis) {
    super(mani, click, vis);
    time = 350;
    
    fillScene();
  }
  
  /**
   * Used when SceneId must also be created
   */ 
  public BayScene(String n, double x, double y, double w, double h, boolean click, boolean vis) {
    this(new SceneId(n, x, y, w, h), click, vis);
  }
  
  /**
   * Creates initial screen of five left-to-right and
   * right-to left fish at different depths. List of 
   * fish is then sorted by depth.
   */
  private void fillScene() {
    for (int i=0; i<5; i++) {
      int fishType = randGen.nextInt(3);
      
      // Create Left Fish ID
      ObjectId leftFishId = createLeftFishId(randGen.nextInt(20)-10, fishType);
      
      // Create Right Fish ID
      ObjectId rightFishId = createRightFishId(randGen.nextInt(20)-10, fishType);
      
      // Add Left Fish to Scene
      sceneItems.add(new FishAlpha(
        leftFishId, // fish id
        manifest.getWidth()+randGen.nextInt(500), // x location
        i*140 + manifest.getStartY() + 10, // y location
        20, // speed x
        0, // speed y
        true)); // left moving fish?
      
      sceneItems.add(new FishAlpha(
        rightFishId, // fish id
        0 - randGen.nextInt(500), // x location
        i*140 + manifest.getStartY() + 10, // y location
        20, // speed x
        0, // speed y
        false)); // left moving fish?
    }
    Collections.sort(sceneItems); // sort by depth
  }
  
  /**
   * Overridden from Scene.java abstract method. On approx. 4% of calls,
   * a new left-to-right and right-to-left fish is created. The new fish
   * can occur anywhere on the y-axis with a random depth [5,15).
   * <p>
   * Every fish in the scene is then asked to move it along, and then removed
   * if they're off-screen.
   */
  @Override
  public void update() {
    // Generate new fish on ~4% of calls
    if (randGen.nextInt(100) <= 4) {
      sceneItems.add(new FishAlpha(
        createLeftFishId(randGen.nextInt(20)-10, randGen.nextInt(3)), // fish id	
        manifest.getWidth() + randGen.nextInt(75), // x location
        randGen.nextDouble()*manifest.getHeight() + manifest.getStartY(), // y location
        15, // speed x
        0, // speed y
        true)); // moving left?
      
      sceneItems.add(new FishAlpha(
 	    createRightFishId(randGen.nextInt(20)-10, randGen.nextInt(3)), // fish id	
        0 - randGen.nextInt(75), // x location
    	randGen.nextDouble()*manifest.getHeight() + manifest.getStartY(), // y location
    	15, // speed x
    	0, // speed y
    	false)); // moving left?
    }	
	
    // Move Fish
    for (SceneObject fish : sceneItems) {
      ((FishAlpha)fish).move();
    }	
	
    // Remove Off-screen Fish
    removeFish();
  }
  
  /**
   * Utility function to create a left fish id's
   * @param 	dpth		fish depth
   * @param		fishType	int for array selection
   * @return	leftFishId	returns created ObjectId
   */
  private ObjectId createLeftFishId(int dpth, int fishType) {
	// Create Left Fish ID
    ObjectId leftFishId = new ObjectId(
      dpth, // depth
      (int)(FISH_LEFT_LENGTH[fishType]*FISH_LEFT_AR[fishType]), // height
      FISH_LEFT_ID[fishType], // id
      FISH_LEFT_FILES[fishType], // image file
      FISH_LEFT_NAMES[fishType], // name
      FISH_LEFT_LENGTH[fishType] ); // width
	
    return leftFishId;
  }
  
  /**
   * Utility function to create a right fish id's
   * @param 	dpth		fish depth
   * @param		fishType	int for array selection
   * @return	rightFishId	returns created ObjectId
   */
  private ObjectId createRightFishId(int dpth, int fishType) {
	// Create Right Fish ID
    ObjectId rightFishId = new ObjectId(
      dpth, // depth
      (int)(FISH_RIGHT_LENGTH[fishType]*FISH_RIGHT_AR[fishType]), // height
      FISH_RIGHT_ID[fishType], // id
      FISH_RIGHT_FILES[fishType], // image file
      FISH_RIGHT_NAMES[fishType], // name
      FISH_RIGHT_LENGTH[fishType] );
    
    return rightFishId;
  }
  
  /**
   * Removes fish that are off-screen 
   */
  private void removeFish() {
    for (Iterator<SceneObject> iterator = sceneItems.iterator(); iterator.hasNext();) {
      FishAlpha fish = (FishAlpha)iterator.next();
      
      if ( !fish.getLeftFish() && fish.getLocation().getX() >= (manifest.getWidth()+fish.getPassport().getWidth()) ) {
        iterator.remove();
      } else if ( fish.getLeftFish() && fish.getLocation().getX() <= (0-fish.getPassport().getWidth()) ) { 
        iterator.remove();
      }
    }
  }
  
  /**
   * Overridden from PropertyTimed.java
   * @return	time
   */
  @Override
  public int getTime() {
  	return time;
  }

  /**
   * Overridden from PropertyScored.java
   * @return	score
   */
  @Override
  public int getScore() {
  	return score;
  }

  /**
   * Overridden from PropertyScored.java
   */
  @Override
  public void updateScore() {
  	// TODO Auto-generated method stub
  }

  /**
   * Overridden from PropertyTimed.java
   */
  @Override
  public void updateTime() {
	time -= 1;
  }
}