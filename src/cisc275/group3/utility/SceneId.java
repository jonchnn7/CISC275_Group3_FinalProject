package cisc275.group3.utility;

/**
 * Data structure to hold immutable Scene parameters. Can also be used to more
 * cleanly pass Scene information.
 * <p>
 * sceneType is an integer that encodes the type of scene
 * <p>
 * \t 0 = empty scene
 * <p>
 * \t 1 = non-mission
 * <p>
 * \t 2 = mission
 * <p>
 * \t 3 = misc. (interface/menu)
 * <p>
 * SceneId.java
 * <p>
 * 
 * @author Scott
 * @author Jon
 */
public class SceneId {
	private final String bgImage;
	private final double height;
	private final String name;
	private final double startX;
	private final double startY;
	private final double width;
	private final EnumSceneType sceneType;

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
	 * @param t
	 *            EnumSceneType - Scene type identifier
	 */
	public SceneId(String n, double x, double y, double w, double h, EnumSceneType t, String bg) {
		height = h;
		name = n;
		startX = x;
		startY = y;
		width = w;
		sceneType = t;
		bgImage = bg;

	}

	@Override
	public String toString() {
		String outString = "\nName: " + name + "\nStart X: " + startX + "\nStart Y: " + startY + "\nWidth: " + width
				+ "\nHeight: " + height + "\nSceneType: " + sceneType;

		return outString;
	}

	/**
	 * @return the bgImage file
	 */
	public String getBG() {
		return bgImage;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the start_x
	 */
	public double getStartX() {
		return startX;
	}

	/**
	 * @return the start_y
	 */
	public double getStartY() {
		return startY;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @return the sceneType
	 */
	public EnumSceneType getSceneType() {
		return sceneType;
	}
}
