package cisc275.group3.utility;

/**
 * Data structure to hold immutable Scene parameters. Can also
 * be used to more cleanly pass Scene information.
 * <p>
 * SceneId.java
 * 
 * @param	height		double-scene height
 * @param	name		String-name of scene
 * @param	startX		double-top left x coordinate
 * @param 	startY		double-top left y coordinate
 * @param	width		double-scene width
 */
public class SceneId {
  private final double height;
  private final String name;
  private final double startX;
  private final double startY;
  private final double width;
  
  public SceneId (String n, double x, double y, double w, double h) {
    height = h;
    name = n;
    startX = x;
    startY = y;
    width = w;	  
  }
  
  @Override
  public String toString() {
    String outString = "\nName: " + name
			            +"\nStart X: " + startX
			            +"\nStart Y: " + startY
			            +"\nWidth: " + width
			            +"\nHeight: " + height;
    return outString;
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
}
