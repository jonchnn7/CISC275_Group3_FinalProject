package cisc275.group3.model.scene;

import cisc275.group3.model.sceneobject.BetaFish;
import cisc275.group3.model.sceneobject.SceneObject;

import java.util.Collections;
import java.util.Iterator;
import cisc275.group3.utility.ConstructFish;
import cisc275.group3.utility.SceneId;

/**
 * Bay scene/model.
 * <p>
 * The bay scene implements scoring and timing functions via interface
 * implementations. The ConstructFish interface holds component definitions for
 * fish objects, and static functions to return fish objects.
 * <p>
 * SceneBay.java
 * <p>
 * 
 * @author Scott
 * @author Jon
 */
public class SceneBay extends Scene implements ConstructFish, PropertyScored, PropertyTimed {

	public SceneBay(SceneId mani) {
		super(mani);
		time = 0;

		if (this.getManifest().getSceneType() == 2) {
			fillScene();
		}
	}

	/**
	 * Used when SceneId must also be created
	 */
	public SceneBay(String n, double x, double y, double w, double h, String bg, int sceneType) {
		this(new SceneId(n, x, y, w, h, sceneType, bg));
	}

	/**
	 * Creates initial screen of five left-to-right and right-to left fish at
	 * different depths. List of fish is then sorted by depth.
	 */
	@Override
	protected void fillScene() {
		for (int i = 0; i < 5; i++) {
			int fishType = randGen.nextInt(3);

			// Add Left Fish
			sceneItems.add(ConstructFish.constructLeftFish(randGen.nextInt(20) - 10, // depth
					fishType, manifest.getWidth() + randGen.nextInt(500), // x location
					i * 140 + manifest.getStartY() + 10)); // y location

			// Add Right Fish
			sceneItems.add(ConstructFish.constructRightFish(randGen.nextInt(20) - 10, // depth
					fishType, 0 - randGen.nextInt(500), // x location
					i * 140 + manifest.getStartY() + 10)); // y location
		}
		Collections.sort(sceneItems); // sort by depth
	}

	/**
	 * Overridden from Scene.java abstract method. sceneType from manifest is used
	 * to determine how to update each scene model
	 * 
	 * <p>
	 * For mission related scene models: On approx. 4% of calls, a new left-to-right
	 * and right-to-left fish is created. The new fish can occur anywhere on the
	 * y-axis with a random depth [5,15).
	 * <p>
	 * Every fish in the scene is then asked to move it along, and then removed if
	 * they're off-screen.
	 */
	@Override
	public void update() {
		if (this.getManifest().getSceneType() == 2) {
			// Generate new fish on ~4% of calls
			if (randGen.nextInt(100) <= 4) {
				sceneItems.add(ConstructFish.constructLeftFish(randGen.nextInt(20) - 10, // depth
						randGen.nextInt(3), manifest.getWidth() + randGen.nextInt(500), // x location
						randGen.nextDouble() * manifest.getHeight() + manifest.getStartY())); // y location

				sceneItems.add(ConstructFish.constructRightFish(randGen.nextInt(20) - 10, // depth
						randGen.nextInt(3), 0 - randGen.nextInt(75), // x location
						randGen.nextDouble() * manifest.getHeight() + manifest.getStartY())); // y location
			}

			// Move Fish
			for (SceneObject fish : sceneItems) {
				((BetaFish) fish).move();
			}

			// Remove Off-screen Fish
			removeFish();

			// Sort by depth
			Collections.sort(sceneItems);
		}
	}

	/**
	 * Removes fish that are off-screen
	 */
	private void removeFish() {
		for (Iterator<SceneObject> iterator = sceneItems.iterator(); iterator.hasNext();) {
			BetaFish fish = (BetaFish) iterator.next();

			if (!fish.getLeftFish()
					&& fish.getLocation().getX() >= (manifest.getWidth() + fish.getPassport().getWidth())) {
				iterator.remove();
			} else if (fish.getLeftFish() && fish.getLocation().getX() <= (0 - fish.getPassport().getWidth())) {
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

	/**
	 * Overridden from PropertyTimed.java
	 */
	@Override
	public void resetTime() {
		time = 0;
	}

	/**
	 * Overridden from PropertyScored.java
	 */
	@Override
	public void missionScore() {
		score += this.getTime();
	}
}