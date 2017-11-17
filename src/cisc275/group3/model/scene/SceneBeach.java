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
 * The beach scene implements scoring and timing functions via interface
 * implementations. The ConstructCrab interface holds component definitions for
 * crab objects, and static functions to return objects.
 * <p>
 * SceneBeach.java
 * <p>
 * 
 * @author Ryan
 */
public class SceneBeach extends Scene implements ConstructCrab, PropertyScored, PropertyTimed {

	public SceneBeach(SceneId mani) {
		super(mani);
		time = 350;

		// Fill scene with mission objects
		if (this.getManifest().getSceneType() == 2) {
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
	 * Creates initial screen of five left-to-right and right-to left crabs at
	 * different depths. List of crabs is then sorted by depth.
	 */
	@Override
	protected void fillScene() {
		for (int i = 0; i < 10; i++) {
			sceneItems.add(ConstructCrab.constructRightCrab(randGen.nextInt(20) - 10, // depth
					randGen.nextInt(2), manifest.getWidth() + randGen.nextInt(500), // x location
					((i * 140 + manifest.getStartY() + 10))+370)); // y location
			
			sceneItems.add(ConstructCrab.constructLeftCrab(randGen.nextInt(20) - 10, // depth
					randGen.nextInt(2), manifest.getWidth() + randGen.nextInt(500), // x location
					((i * 140 + manifest.getStartY() + 10))+370)); // y location

			int crabType = randGen.nextInt(2);

			// Add Left Crab
			sceneItems.add(ConstructCrab.constructLeftCrab(randGen.nextInt(20) - 10, // depth
					crabType, manifest.getWidth() + randGen.nextInt(500), // x location
					((i * 140 + manifest.getStartY() + 10))+370)); // y location

			// Add Right Crab
			sceneItems.add(ConstructCrab.constructRightCrab(randGen.nextInt(20) - 10, // depth
					crabType, 0 - randGen.nextInt(500), // x location
					((i * 140 + manifest.getStartY() + 10))+370)); // y location
		}
		Collections.sort(sceneItems); // sort by depth
	}

	/**
   * Overridden from Scene.java abstract method. On approx. 4% of calls,
   * a new left-to-right and right-to-left crab is created. The new crab
   * can occur anywhere on the y-axis with a random depth [5,15).
   * <p>
   * Every crab in the scene is then asked to move it along, and then removed
   * if they're off-screen.
   */
  @Override
  public void update() {
	  if(this.getManifest().getSceneType() == 2) {
		    // Generate new crab on ~7% of calls
		    if (randGen.nextInt(100) <= 7) {
		      sceneItems.add(ConstructCrab.constructLeftCrab(
		                     randGen.nextInt(20)-10, // depth
		                     randGen.nextInt(2),
		                     manifest.getWidth()+randGen.nextInt(500), // x location
		                    (( randGen.nextDouble()*manifest.getHeight() + manifest.getStartY())+370))); // y location
		      
		      sceneItems.add(ConstructCrab.constructRightCrab(
		                     randGen.nextInt(20)-10, // depth
		                     randGen.nextInt(2),
		                     0 - randGen.nextInt(75), // x location
		                     ((randGen.nextDouble()*manifest.getHeight() + manifest.getStartY())+370))); // y location
		    }
    // Move Crab
    for (SceneObject crab : sceneItems) {
      ((BetaCrab)crab).move();
    }	
	
    // Remove Off-screen crabs
    removeCrab();
    
    // Sort by depth
    Collections.sort(sceneItems);
  }}

	/**
	 * Removes crab that are off-screen
	 */
	private void removeCrab() {
		for (Iterator<SceneObject> iterator = sceneItems.iterator(); iterator.hasNext();) {
			BetaCrab crab = (BetaCrab) iterator.next();

			if (crab.getLocation().getX() >= (manifest.getWidth() + crab.getPassport().getWidth())) {
				iterator.remove();
			} else if (crab.getLocation().getX() <= (0 - crab.getPassport().getWidth())) {
				iterator.remove();
			}
		}
	}

	/**
	 * Overridden from PropertyTimed.java
	 * 
	 * @return time
	 */
	@Override
	public int getTime() {
		return time;
	}

	/**
	 * Overridden from PropertyScored.java
	 * 
	 * @return score
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