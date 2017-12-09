package cisc275.group3.sceneobject;

import cisc275.group3.utility.ObjectId;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * Abstraction of base level scene object properties and methods. Subclasses are
 * created to extend unique functionality. Interfaces are created to extend
 * shared functionality.
 * <p>
 * Style changed in an attempt to more uniform and easier to read. See source
 * below.
 * <p>
 * SceneObject.java
 * <p>
 * Style Changes
 * <p>
 * <a href="https://google.github.io/styleguide/javaguide.html">Google Style
 * Guide</a>
 * <p>
 * <a href=
 * "http://www.oracle.com/technetwork/articles/java/index-137868.html">Javadoc</a>
 * <p>
 * <p>
 * Code Changes
 * <p>
 * <a href=
 * "https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html">when to
 * use this</a>
 * <p>
 * <a href="https://docs.oracle.com/javase/tutorial/uiswing/index.html">swing
 * tutorial </a>
 * <p>
 * <a href="http://www.badlogicgames.com/wordpress/?p=2668">general design</a>
 * <p>
 * <p>
 * 
 * @author Scott
 */
public abstract class SceneObject implements Comparable<SceneObject> {
	protected ObjectId passport;
	protected Point2D.Double location;
	protected Random randGen = new Random();

	/**
	 * 
	 * @param id
	 *            ObjectID
	 * @param x
	 *            double-x-axis location
	 * @param y
	 *            double-yaxis location
	 */
	public SceneObject(ObjectId id, double x, double y) {
		passport = id;
		location = new Point2D.Double(x, y);
	}

	/**
	 * Sort by depth
	 */
	public int compareTo(SceneObject other_item) {
		Integer myDepth = this.passport.getDepth();
		Integer urDepth = other_item.passport.getDepth();

		return urDepth.compareTo(myDepth);
	}

	/**
	 * prints object properties
	 */
	@Override
	public String toString() {
		String outString = "\nShort Name: " + Character.toString(passport.getName().charAt(0)) + "\nFull Name: "
				+ passport.getName() + "\nType ID: " + passport.getId() + "\nImage File : " + passport.getImageFile()
				+ "\nWidth: " + passport.getWidth() + "\nHeight: " + passport.getHeight() + "\nLocation: " + location;
		return outString;
	}

	/**
	 * 
	 * @param x
	 *            double - x coordinate
	 * @param y
	 *            double - y coordinate
	 * @return boolean - if item is clicked
	 */
	public boolean itemClicked(double x, double y) {
		return passport.checkClick(location, x, y);
	}

	/**
	 * @return location returns object location
	 */
	public Point2D.Double getLocation() {
		return location;
	}

	/**
	 * @return passport returns passport object
	 */
	public ObjectId getPassport() {
		return passport;
	}

	/**
	 * @return first character of object
	 */
	public String getShortName() {
		return Character.toString(passport.getName().charAt(0));
	}
}