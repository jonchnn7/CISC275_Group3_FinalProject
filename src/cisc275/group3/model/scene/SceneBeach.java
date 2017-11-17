package cisc275.group3.model.scene;

import java.util.Collections;
import java.util.Iterator;

import cisc275.group3.model.sceneobject.BetaCrab;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.ConstructCrab;
import cisc275.group3.utility.SceneId;

/**
 * Beach scene/model. 
 * <p>
 * The beach scene implements scoring and timing functions 
 * via interface implementations. The ConstructFish 
 * interface holds component definitions for fish objects,
 * and static functions to return fish objects. 
 * <p>
 * SceneBeach.java
 * <p>
 * @author Scott
 */
public class SceneBeach extends Scene implements ConstructCrab, PropertyScored, PropertyTimed {

  public SceneBeach(SceneId mani) {
    super(mani);
    time = 350;

    //Fill scene with mission objects
    if(this.getManifest().getSceneType() == 2) {
        fillScene();	
    }
  }
  
  /**
   * Used when SceneId must also be created
   */ 
  public SceneBeach(String n, double x, double y, double w, double h, int sceneType, String bg) {
    this(new SceneId(n, x, y, w, h, sceneType, bg));
  }
  
  /**
   * Creates initial screen of five left-to-right and
   * right-to left fish at different depths. List of 
   * fish is then sorted by depth.
   */
  @Override
  protected void fillScene() {
    for (int i=0; i<1; i++) {
    	System.out.println("Adding crab");
    	sceneItems.add(ConstructCrab.constructCrab(
              randGen.nextInt(20)-10, // depth
              randGen.nextInt(2),
              manifest.getWidth()+randGen.nextInt(500), // x location
              i*140 + manifest.getStartY() + 10));
    }
//      int fishType = randGen.nextInt(3);
//      
//      // Add Left Fish
//      sceneItems.add(ConstructFish.constructLeftFish(
//                     randGen.nextInt(20)-10, // depth
//                     fishType,
//                     manifest.getWidth()+randGen.nextInt(500), // x location
//                     i*140 + manifest.getStartY() + 10)); // y location
//      
//      // Add Right Fish
//      sceneItems.add(ConstructFish.constructRightFish(
//                     randGen.nextInt(20)-10, // depth
//                     fishType,
//                     0 - randGen.nextInt(500), // x location
//                     i*140 + manifest.getStartY() + 10)); // y location
//    }
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
      sceneItems.add(ConstructCrab.constructCrab(
    		  randGen.nextInt(20)-10, // depth
              randGen.nextInt(2),
              manifest.getWidth()+randGen.nextInt(500), // x location
              randGen.nextDouble()*manifest.getHeight() + manifest.getStartY())); // y location
    }
    // Move Fish
    for (SceneObject crab : sceneItems) {
    	System.out.println(crab);
      ((BetaCrab)crab).move();
    }	
	
    // Remove Off-screen Fish
    removeFish();
    
    // Sort by depth
    Collections.sort(sceneItems);
  }
  
  /**
   * Removes fish that are off-screen 
   */
  private void removeFish() {
    for (Iterator<SceneObject> iterator = sceneItems.iterator(); iterator.hasNext();) {
      BetaCrab crab = (BetaCrab)iterator.next();
      
      if (crab.getLocation().getX() >= (manifest.getWidth()+crab.getPassport().getWidth()) ) {
        iterator.remove();
      } 
      else if (crab.getLocation().getX() <= (0-crab.getPassport().getWidth()) ) { 
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
  	score += 1;
  }

  /**
   * Overridden from PropertyTimed.java
   */
  @Override
  public void updateTime() {
	time -= 1;
  }
}