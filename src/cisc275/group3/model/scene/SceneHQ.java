package cisc275.group3.model.scene;

import java.util.Collections;
import java.util.Iterator;

import cisc275.group3.exceptions.InsufficientDataException;
import cisc275.group3.model.sceneobject.BetaCrab;
import cisc275.group3.model.sceneobject.BetaPerson;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.ConstructCrab;
import cisc275.group3.utility.ConstructPerson;
import cisc275.group3.utility.SceneId;

/**
 * HQ scene/model.
 * <p>
 * The HQ scene implements scoring and timing functions via interface
 * implementations.
 * <p>
 * SceneHQ.java
 * <p>
 * 
 * @author Jon
 * @author Scott
 */
public class SceneHQ extends Scene {

	public SceneHQ(SceneId mani) {
		super(mani);
		time = 0;
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
	 *            int-type of scene
	 */
	public SceneHQ(String n, double x, double y, double w, double h, String bg, int sceneType) {
		this(new SceneId(n, x, y, w, h, sceneType, bg));
	}

	/**
	 * Overridden from Scene.java
	 */
	@Override
	protected void fillScene() {
		// TODO Auto-generated method stub
	}

	/**
	 * Overridden from Scene.java abstract method. People are generated that will be
	 * linked to their respective mission
	 * <p>
	 * Each person moves from right to left, stops in the middle of the screen until
	 * the mission is initialized and completed, then moves off the right side of
	 * the screen.
	 */
	@Override
	public void update() {
		if (this.getManifest().getSceneType() == 2) {
			if (sceneItems.size() < 1) {
				sceneItems.add(ConstructPerson.constructPerson(randGen.nextInt(20) - 10, // depth
						1, // type
						1280, // x location
						75)); // y location
			}
			// Move Crab
			for (SceneObject person : sceneItems) {
				if ((person.getLocation().getX() < 600) && ((((BetaPerson) person).getStatus()) == 1)) {
					((BetaPerson) person).setStatus(0);
				} else if (Scene.getCurrentMission().isDoneMission() && ((((BetaPerson) person).getStatus()) == 0)) {
					((BetaPerson) person).setStatus(-1);
				}
				((BetaPerson) person).move();
			}

			// Remove Off-screen crabs
			removePerson();

			// Sort by depth
			Collections.sort(sceneItems);
		}
	}

	/**
	 * Removes persons that are off-screen
	 */
	private void removePerson() {
		for (Iterator<SceneObject> iterator = sceneItems.iterator(); iterator.hasNext();) {
			BetaPerson person = (BetaPerson) iterator.next();

			if (person.getLocation().getX() >= (manifest.getWidth() + person.getPassport().getWidth())) {
				iterator.remove();
			}
		}
	}
}
