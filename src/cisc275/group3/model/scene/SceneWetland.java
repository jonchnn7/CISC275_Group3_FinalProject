package cisc275.group3.model.scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import cisc275.group3.model.sceneobject.ActionMove;
import cisc275.group3.model.sceneobject.BetaHeron;
import cisc275.group3.model.sceneobject.BetaVegetation;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.ConstructHeron;
import cisc275.group3.utility.ConstructVegetation;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.utility.SceneId;

/**
 * Wetland scene/model.
 * <p>
 * The Wetland scene implements scoring and timing functions via interface
 * implementations. The ConstructVegetation and ConstructHeron interface holds
 * component definitions for vegetation and heron objects, and static functions
 * to return vegetation and heron objects.
 * <p>
 * SceneWetland.java
 * <p>
 * 
 * @author Jon
 * @author Ryan
 * @author Scott
 */
public class SceneWetland extends Scene {

	/**
	 * Constructor
	 * 
	 * @param mani
	 *            sceneid used to distinguish between scenes
	 */
	public SceneWetland(SceneId mani) {
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
	 *            String-scene name
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
	public SceneWetland(String n, double x, double y, double w, double h, String bg, EnumSceneType sceneType) {
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
			sceneItems.add(ConstructVegetation.constructVegetation(
			    randGen.nextInt(20) - 10, // depth
					2, // type
					randGen.nextInt(1280), // x location
					i * 140 + manifest.getStartY() + 10)); // y location
		}
		Collections.sort(sceneItems); // sort by depth
	}

	/**
	 * Overridden from Scene.java abstract method. sceneType from manifest is used
	 * to determine how to update each scene model
	 * 
	 * <p>
	 * For mission related scene models: On approx. 1.5% of calls, a new instance of
	 * a BetaHeron will be added. On approx. 3% of calls a new instance of a
	 * BetaVegetation will be added
	 * <p>
	 * On every tick, the herons will call the move() method.
	 * <p>
	 * modifySceneItems() method is responsible for the removal of sceneObjects and
	 * changing the sceneObject type if necessary
	 */
	@Override
	public void update() {
		if (this.getManifest().getSceneType() == EnumSceneType.DEFAULT) {
		  switch (randGen.nextInt(100) ) {
		  case 3:
		    vegeGen();
		    break;
		  case 2:
		  case 1:
		  case 0:
		    heronGen();
		    vegeGen();
		    break;
		  }
		  
		  flyHerons();
			// Remove Off-screen Herons, change heron image, grow Vegetation
			modifySceneItems();

			Collections.sort(sceneItems);
		}
	}

  /**
   * Creates new, flying Heron with
   * a 50/50 chance of them adding to
   * the left/right side of the screen.
   */
  private void heronGen() {
    if (randGen.nextInt(2) == 1) {
      sceneItems.add(ConstructHeron.constructLeftHeron(randGen.nextInt(40) - 20, // depth
          1, // type
          manifest.getWidth() + randGen.nextInt(100), // x location
          randGen.nextDouble() * randGen.nextInt(450), false, false)); // y
    } else {
      sceneItems.add(ConstructHeron.constructRightHeron(
          randGen.nextInt(40) - 20, // depth
          1, // type
          0 - randGen.nextInt(100) - 50, // x location
          randGen.nextDouble() * randGen.nextInt(450), false, false)); // y
    }
  }
  
  /**
   * Moves Herons with ids of 100 or 200
   */
  private void flyHerons() {
    // Fly herons
    sceneItems.forEach(heron-> {
      switch (heron.getPassport().getId()) {
      case 100:
      case 200:
        ((ActionMove)heron).move();
      }
    });
  }
  
  /**
   * Generates new vegetation at 
   * a random x and y location if
   * the number of items < 10.
   */
  private void vegeGen() {
    if (sceneItems.size() < 10) {
      sceneItems.add(ConstructVegetation.constructVegetation(
          randGen.nextInt(20) - 10, // depth
          0, // type
          randGen.nextInt(1280), // x location
          randGen.nextInt(650) + 70));
      
    }
  }
  
	/**
	 * Responsible for the removal of sceneObjects and changing the sceneObject type
	 * if necessary. Explicitly updates BetaVegetation with grow() method.
	 * Implicitly updates BetaHeron by calling the modifyHeron() method
	 */
	private void modifySceneItems() {
		@SuppressWarnings("unchecked")
		ArrayList<SceneObject> tempSceneObjects = (ArrayList<SceneObject>) sceneItems.clone();
		sceneItems.clear();

		for (Iterator<SceneObject> iterator = tempSceneObjects.iterator(); iterator.hasNext();) {
			SceneObject tempObject = (SceneObject) iterator.next();
			// Determine if tempObject is a Heron
			if ((tempObject.getPassport().getId() == 100) || (tempObject.getPassport().getId() == 200)) {
				modifyHeron((BetaHeron) tempObject);
				// Determine if tempObject is a Vegetation
			} else if ((tempObject.getPassport().getId() == 70) || (tempObject.getPassport().getId() == 71)
					|| (tempObject.getPassport().getId() == 72)) {
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
}