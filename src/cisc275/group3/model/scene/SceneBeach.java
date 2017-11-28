package cisc275.group3.model.scene;

import java.util.Collections;
import java.util.Iterator;

import cisc275.group3.exceptions.InsufficientDataException;
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
 * @author Jon 
 * @author Ryan 
 * @author Scott
 * @author Thomas
 */
public class SceneBeach extends Scene implements ConstructCrab {
  
	public SceneBeach(SceneId mani) {
		super(mani);
		time = 0;

		// Fill scene with mission objects
		if (this.getManifest().getSceneType() == 2) {
			fillScene();
		}
	}

	/**
	 * Used when SceneId must also be created
	 * @param n		String-scene name
	 * @param x		double-x-coordinate of upper left corner
	 * @param y		double-y-coordinate of upper left corner
	 * @param w		double-scene width
	 * @param h		double-scene height
	 * @param bg	String-file location of bg image
	 * @param sceneType	int-type of scene
	 */
	public SceneBeach(String n, double x, double y, double w, double h, String bg, int sceneType) {
		this(new SceneId(n, x, y, w, h, sceneType, bg));
	}

	/**
	 * Creates initial screen of five left-to-right and right-to left crabs at
	 * different depths. List of crabs is then sorted by depth.
	 */
	@Override
	protected void fillScene() {
		for (int i = 0; i < 10; i++) {
			int crabType = randGen.nextInt(2) ;

			// Add Left Crab
			sceneItems.add(ConstructCrab.constructLeftCrab(
			    randGen.nextInt(20) - 10, // depth
					crabType, // type
					manifest.getWidth() + randGen.nextInt(500), // x location
					((i * 140 + manifest.getStartY() + 10)) + 370)); // y location

			// Add Right Crab
			sceneItems.add(ConstructCrab.constructRightCrab(
			    randGen.nextInt(20) - 10, // depth
					crabType, // type
					0 - randGen.nextInt(500), // x location
					((i * 140 + manifest.getStartY() + 10)) + 370)); // y location
			
			
			
		}
		Collections.sort(sceneItems); // sort by depth
	}

	/**
	 * Overridden from Scene.java abstract method. On approx. 7% of calls, a new
	 * left-to-right and right-to-left crab is created. The new crab can occur
	 * anywhere on the y-axis with a random depth [-10,10).
	 * <p>
	 * Every crab in the scene is then asked to move it along, and then removed if
	 * they're off-screen.
	 */
	@Override
	public void update() {
		if (this.getManifest().getSceneType() == 2) {
			// Generate new crab on ~7% of calls
			if (randGen.nextInt(100) <= 7) {
				sceneItems.add(ConstructCrab.constructLeftCrab(
				    randGen.nextInt(20) - 10, // depth
						randGen.nextInt(2), // type
						manifest.getWidth() + randGen.nextInt(500), // x location
						((randGen.nextDouble() * manifest.getHeight() + manifest.getStartY()) + 370))); // y location

				sceneItems.add(ConstructCrab.constructRightCrab(
				    randGen.nextInt(20) - 10, // depth
						randGen.nextInt(2), // type
						0 - randGen.nextInt(75), // x location
						((randGen.nextDouble() * manifest.getHeight() + manifest.getStartY()) + 370))); // y location
			}
			// Move Crab
			for (SceneObject crab : sceneItems) {
				((BetaCrab) crab).move();
			}

			// Remove Off-screen crabs
			removeCrab();

			// Sort by depth
			Collections.sort(sceneItems);
		}
	}

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
}