package cisc275.group3.utility;

import java.awt.Dimension;
import java.awt.Toolkit;

import cisc275.group3.model.sceneobject.BetaPerson;

/**
 * Interface to simplify the construction of person objects. This code used to
 * be within SceneHQ.java, but is transitioned into an interface to reduce code
 * size and increase extensibility.
 * <p>
 * ConstructPerson.java
 * <p>
 * 
 * @author Jon
 */
public interface ConstructPerson {
	// Person File Locations
	static final String[] FILE = { "img/betaPersonPics/birdWatcher.png", "img/betaPersonPics/parkRanger.png",
			"img/betaPersonPics/scientist.png" };

	// Person Names
	static final String[] NAME = { "Bird Watcher", "Park Ranger", "Scientist" };

	// Person Dimensions
	static final int LENGTH = 358;

	// Person Aspect Ratios (multiply by width for height)
	static final double AR = 0.66;

	// Person ID Numbers
	static final int[] ID = { 50, 51, 52 };

	// Person x-axis Speed
	static final int SPEED = 15;

	/**
	 * Returns a constructed BetaPerson object
	 * 
	 * @param depth
	 *            int - Person depth
	 * @param type
	 *            int - Person type [0,2] (0 = BirdWatcher, 1 = Park Ranger, 2 =
	 *            Scientist)
	 * @param x
	 *            double - x-axis location
	 * @param y
	 *            double - y-axis location
	 * @return BetaPerson
	 */
	static public BetaPerson constructPerson(int depth, int type, double x, double y) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		
		BetaPerson person = new BetaPerson(depth, (int) (width/1280*LENGTH * AR), // height
				ID[type], // id
				FILE[type], // image file
				NAME[type], // name
				(int) LENGTH/1280 *width, // width
				x, // x position
				y, // y position
				SPEED, // x-axis speed
				0, // y-axis speed
				1); // left moving
		return person;
	}

}
