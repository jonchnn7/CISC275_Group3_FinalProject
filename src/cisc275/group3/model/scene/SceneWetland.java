package cisc275.group3.model.scene;

import java.util.ArrayList;
import java.util.Collections;

import cisc275.group3.model.sceneobject.BetaVegetation;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.ConstructVegetation;
import cisc275.group3.utility.SceneId;

/**
 * Wetland scene/model.
 * <p>
 * The Wetland scene implements scoring and timing functions via interface
 * implementations. The ConstructVegetation interface holds component
 * definitions for vegetation objects, and static functions to return fish
 * objects.
 * <p>
 * SceneWetland.java
 * <p>
 * 
 * @author Jon
 * @author Ryan
 */
public class SceneWetland extends Scene implements PropertyScored, PropertyTimed {

	public SceneWetland(SceneId mani) {
		super(mani);
		time = 0;

		// Fill scene with mission objects
		if (this.getManifest().getSceneType() == 2) {
			fillScene();
		}
	}

	/**
	 * Used when SceneId must also be created
	 */
	public SceneWetland(String n, double x, double y, double w, double h, int sceneType, String bg) {
		this(new SceneId(n, x, y, w, h, sceneType, bg));
	}

	/**
	 * Creates the initial mission scene with 7 BetaVegetation placed randomly on
	 * the screen. The BetaVegetation is then sorted by depth.
	 */
	@Override
	protected void fillScene() {
		for (int i = 0; i < 8; i++) {
			sceneItems.add(ConstructVegetation.constructVegetation(randGen.nextInt(20) - 10, // depth
					2, randGen.nextInt(1280), // x location
					i * 140 + manifest.getStartY() + 10)); // y location

			Collections.sort(sceneItems); // sort by depth
		}

	}

	/**
	 * Overridden from Scene.java abstract method. sceneType from manifest is used
	 * to determine how to update each scene model
	 * 
	 * <p>
	 * For mission related scene models: On approx. 2% of calls, a new instance of a
	 * BetaVegetation will be added. The new BetaVegetation can occur anywhere.
	 * <p>
	 * On approx. 5% of calls, the current BetaVegetation will be grown
	 */
	@Override
	public void update() {
		if (this.getManifest().getSceneType() == 2) {
			// Generate new vegetation on ~1% of calls
			if (sceneItems.size() < 10) {
				if (randGen.nextInt(100) <= 2) {
					sceneItems.add(ConstructVegetation.constructVegetation(randGen.nextInt(20) - 10, // depth
							0, randGen.nextInt(1280), // x location
							randGen.nextInt(650) + 70));
				}
			}

			if (randGen.nextInt(100) <= 5) {
				// Grow vegetation
				ArrayList<SceneObject> tempVegetation = (ArrayList<SceneObject>) sceneItems.clone();
				sceneItems.clear();
				for (SceneObject vegetation : tempVegetation) {
					sceneItems.add(((BetaVegetation) vegetation).grow());
				}
			}
			Collections.sort(sceneItems);
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
	 * Overridden from PropertyScored.java
	 */
	@Override
	public void missionScore() {
		score += this.getTime();
	}

	/**
	 * Overridden from PropertyTimed.java
	 */
	@Override
	public void updateTime() {
		time -= 1;
	}

	/**
	 * Overridden from PropertyTimed.java
	 */
	@Override
	public void resetTime() {
		time = 0;
	}
}