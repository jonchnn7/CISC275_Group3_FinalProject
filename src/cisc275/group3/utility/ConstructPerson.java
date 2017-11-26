package cisc275.group3.utility;

import cisc275.group3.model.sceneobject.BetaPerson;

/**
 * Interface to simplify the construction of person objects. This code used to be
 * within SceneHQ.java, but was transitioned into an interface to reduce code
 * size and increase extensibility.
 */
public interface ConstructPerson {
	// Person File Locations
	static final String[] FILE = { "img/birdWatcher_v2.png",  "img/parkRangerPerson_v2.png", "img/scientistPerson.png"};

	// Person Names
	static final String[] NAME = { "Bird Watcher", "Park Ranger", "Scientist" };

	// Person Dimensions
	static final int LENGTH = 358;

	// Person Aspect Ratios
	static final double AR = 0.66;

	// Person ID Numbers
	static final int[] ID = { 1, 2, 3 };

	// Person x-axis Speed
	static final int SPEED = 15;

	/**
	 * Returns a constructed BetaPerson object
	 * 
	 * @param depth
	 *            int - Person depth
	 * @param type
	 *            int - Person type [0,2]
	 * @param x
	 *            double - x-axis location
	 * @param y
	 *            double - y-axis location
	 * @return BetaPerson
	 */
	static public BetaPerson constructPerson(int depth, int type, double x, double y) {
		BetaPerson person = new BetaPerson(depth, (int) (LENGTH * AR), // height
				ID[type], // id
				FILE[type], // image file
				NAME[type], // name
				(int) LENGTH, // width
				x, // x position
				y, // y position
				SPEED, // x-axis speed
				0, // y-axis speed
				1); // left moving
		return person;
	}

}
