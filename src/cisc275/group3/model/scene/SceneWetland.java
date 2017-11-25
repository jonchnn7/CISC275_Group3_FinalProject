package cisc275.group3.model.scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import cisc275.group3.exceptions.InsufficientDataException;
import cisc275.group3.model.sceneobject.BetaHeron;
import cisc275.group3.model.sceneobject.BetaVegetation;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.ConstructHeron;
import cisc275.group3.utility.ConstructVegetation;
import cisc275.group3.utility.SceneId;

/**
 * Wetland scene/model.
 * <p>
 * The Wetland scene implements scoring and timing functions via interface
 * implementations. The ConstructVegetation and ConstructHeron interface holds component
 * definitions for vegetation and heron objects, and static functions to return vegetation and heron
 * objects.
 * <p>
 * SceneWetland.java
 * <p>
 * @author Jon 
 * @author Ryan 
 * @author Scott
 */
public class SceneWetland extends Scene {
  
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
	 * @param n		String-scene name
	 * @param x		double-x-coordinate of upper left corner
	 * @param y		double-y-coordinate of upper left corner
	 * @param w		double-scene width
	 * @param h		double-scene height
	 * @param bg	String-file location of bg image
	 * @param sceneType	int-type of scene
	 */
	public SceneWetland(String n, double x, double y, double w, double h, String bg, int sceneType) {
		this(new SceneId(n, x, y, w, h, sceneType, bg));
	}

	/**
	 * Creates the initial mission scene with 6 BetaVegetation placed randomly on
	 * the screen. The BetaVegetation is then sorted by depth.
	 */
	@Override
	protected void fillScene() {
		// Initializes Screen with 6 vegetation, no herons
		for (int i = 0; i < 6; i++) {
			sceneItems.add(ConstructVegetation.constructVegetation(randGen.nextInt(20) - 10, // depth
					2, randGen.nextInt(1280), // x location
					i * 140 + manifest.getStartY() + 10)); // y location
		}
		Collections.sort(sceneItems); // sort by depth
	}

	/**
	 * Overridden from Scene.java abstract method. sceneType from manifest is used
	 * to determine how to update each scene model
	 * 
	 * <p>
	 * For mission related scene models: On approx. 1.5% of calls, a new instance of a
	 * BetaHeron will be added. On approx. 3% of calls a new instance of a
	 * BetaVegetation will be added
	 * <p>
	 * On every tick, the herons will call the move() method.
	 * <p>
	 * modifySceneItems() method is responsible for the removal of sceneObjects and
	 * changing the sceneObject type if necessary
	 */
	@Override
	public void update() {
    if (this.getManifest().getSceneType() == 2) {
      // 2% to Add new Heron
      if (randGen.nextInt(200) < 3) {
        // 50/50 chance to pick right or left
        if (randGen.nextInt(10) < 5) {
          sceneItems.add(ConstructHeron.constructLeftHeron(randGen.nextInt(20) - 10, // depth
              1, manifest.getWidth() + randGen.nextInt(500), // x location
              randGen.nextDouble() * randGen.nextInt(450), false, false)); // y
        } else {
          sceneItems.add(ConstructHeron.constructRightHeron(randGen.nextInt(20) - 10, // depth
              1, 0 - randGen.nextInt(75), // x location
              randGen.nextDouble() * randGen.nextInt(450), false, false)); // y
        }
      }
      // Generate new vegetation on 3% of calls
      if (sceneItems.size() < 10) {
        if (randGen.nextInt(100) < 3) {
          sceneItems.add(ConstructVegetation.constructVegetation(randGen.nextInt(20) - 10, // depth
              0, randGen.nextInt(1280), // x location
              randGen.nextInt(650) + 70));
        }
      }

      // Fly herons
      for (SceneObject tempItem : sceneItems) {
        // System.out.print(heron);
        if ((tempItem.getPassport().getId() == 100) || (tempItem.getPassport().getId() == 200)) {
          ((BetaHeron) tempItem).move();
        }
      }

      // Remove Off-screen Herons, change heron image, grow Vegetation
      modifySceneItems();

      Collections.sort(sceneItems);
    }
	}

	/**
	 * Responsible for the removal of sceneObjects and changing the sceneObject type
	 * if necessary. Explicitly updates BetaVegetation with grow() method.
	 * Implicitly updates BetaHeron by calling the modifyHeron() method
	 */
	private void modifySceneItems() {
		@SuppressWarnings("unchecked")
    ArrayList<SceneObject> tempSceneObjects = (ArrayList<SceneObject>)sceneItems.clone();
		sceneItems.clear();

		for (Iterator<SceneObject> iterator = tempSceneObjects.iterator(); iterator.hasNext();) {
			SceneObject tempObject = (SceneObject) iterator.next();
			// Determine if tempObject is a Heron
			if ((tempObject.getPassport().getId() == 100) || (tempObject.getPassport().getId() == 200)) {
				modifyHeron((BetaHeron) tempObject);
				// Determine if tempObject is a Vegetation
			} else if ((tempObject.getPassport().getId() == 0) || (tempObject.getPassport().getId() == 1)
					|| (tempObject.getPassport().getId() == 2)) {
				if (randGen.nextInt(100) < 5) {
					sceneItems.add(((BetaVegetation) tempObject).grow());
				} else {
					sceneItems.add(tempObject);
				}
			}
		}
	}

	/**
	 * Responsible to modify the BetaHeronSceneObjects. Put in a separate method to
	 * organize code. Three main instances: 1) change image of a landed heron to the
	 * landed image, 2) change image of a flying heron to the flying image, 3)
	 * remove out of bounds herons
	 */
	public void modifyHeron(BetaHeron theHeron) {
		// Check to see if herons need to change to landed image
		if ((theHeron.getLanded() == true) && (theHeron.getPassport().getId() == 200)) {
			// change left heron
			if (theHeron.getLeftHeron()) {
				sceneItems.add(ConstructHeron.constructLeftHeron(theHeron.getPassport().getDepth(), 0,
						theHeron.getLocation().getX(), theHeron.getLocation().getY(), true, true));
			} else {
				sceneItems.add(ConstructHeron.constructRightHeron(theHeron.getPassport().getDepth(), 0,
						theHeron.getLocation().getX(), theHeron.getLocation().getY(), true, true));
			}
		} else if ((theHeron.getLanded() == false) && (theHeron.getPassport().getId() == 100)) {
			if (theHeron.getLeftHeron()) {
				sceneItems.add(ConstructHeron.constructLeftHeron(theHeron.getPassport().getDepth(), 1,
						theHeron.getLocation().getX(), theHeron.getLocation().getY(), false, true));
			} else {
				sceneItems.add(ConstructHeron.constructRightHeron(theHeron.getPassport().getDepth(), 1,
						theHeron.getLocation().getX(), theHeron.getLocation().getY(), false, true));
			}
		}

		// Remove out of bounds Herons
		else if (!theHeron.getLeftHeron()
				&& theHeron.getLocation().getX() >= (manifest.getWidth() + theHeron.getPassport().getWidth())) {
		} else if (!(theHeron.getLeftHeron()
				&& theHeron.getLocation().getX() <= (0 - (theHeron.getPassport().getWidth())))) {
			sceneItems.add(theHeron);
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