package cisc275.group3.scene;

import java.util.Collections;
import java.util.Iterator;

import cisc275.group3.sceneobject.ActionMove;
import cisc275.group3.sceneobject.BetaCrab;
import cisc275.group3.sceneobject.SceneObject;
import cisc275.group3.utility.ConstructCrab;
import cisc275.group3.utility.EnumSceneType;
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
 * @author Jon
 * @author Ryan
 * @author Scott
 * @author Thomas
 */
public class SceneBeach extends Scene implements ConstructCrab {

	/**
	 * Constructor
	 * 
	 * @param mani
	 *            sceneid used to distinguish between secenes
	 */
	public SceneBeach(SceneId mani) {
		super(mani);
		time = 0;

		// Fill scene with mission objects
		if (this.getManifest().getSceneType() == EnumSceneType.DEFAULT) {
			fillScene();
		}
	}

	/**
	 * Used when SceneId must also be created
	 * 
	 * @param n
	 *            String-scene nameSceneBay(in ...)
	 * @param x
	 *            double-x-coordinate of upper left corner
	 * @param y
	 *            double-y-coordinate of upper left corner
	 * @param w
	 *            double-scene width
	 * @param h
	 *            double-scene height
	 * @param bg
	 *            String-file location of bg image
	 * @param sceneType
	 *            EnumSceneType-type of scene
	 */
	public SceneBeach(String n, double x, double y, double w, double h, String bg, EnumSceneType sceneType) {
		this(new SceneId(n, x, y, w, h, sceneType, bg));
	}

	/**
	 * Creates initial screen of five left-to-right and right-to left crabs at
	 * different depths. List of crabs is then sorted by depth.
	 */
	@Override
	protected void fillScene() {
		for (int i = 0; i < 5; i++) {
			int crabType = randGen.nextInt(2);

			// Add Left Crab
			sceneItems.add(ConstructCrab.constructLeftCrab(
			        randGen.nextInt(20) - 10, // depth
			        crabType, // type
			        manifest.getWidth() + randGen.nextInt(500), // x location
			        (i * getManifest().getHeight()/12) + getManifest().getHeight()*13/25 )); // y location

			// Add Right Crab
			sceneItems.add(ConstructCrab.constructRightCrab(
			        randGen.nextInt(20) - 10, // depth
			        crabType, // type
			        0 - randGen.nextInt(500), // x location
			        (i * getManifest().getHeight()/12 + manifest.getStartY()) + getManifest().getHeight()*13/25 )); // y location
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
		if (this.getManifest().getSceneType() == EnumSceneType.DEFAULT) {
			// Generate new crab on ~7% of calls		  
			if (randGen.nextInt(100) <= 7) {
				sceneItems.add(ConstructCrab.constructLeftCrab(
				        randGen.nextInt(20) - 10, // depth
				        randGen.nextInt(2), // type
				        manifest.getWidth() + randGen.nextInt(200) + 100, // x location
				        (randGen.nextInt(5) * manifest.getHeight()/12 + manifest.getStartY() + getManifest().getHeight()*13/25))); // y location
				sceneItems.add(ConstructCrab.constructRightCrab(
				        randGen.nextInt(20) - 10, // depth
				        randGen.nextInt(2), // type
				        0 - randGen.nextInt(200) - 100, // x location
				        (randGen.nextInt(5) * manifest.getHeight()/12 + manifest.getStartY() + getManifest().getHeight()*13/25))); // y location
			}
			// Move Crab
			for (SceneObject crab : sceneItems) {
				((ActionMove) crab).move();
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