package cisc275.group3.utility;

/**
 * Data structure to hold immutable Scene parameters. Can also
 * be used to more cleanly pass Scene information.
 * <p>
 * SceneId.java
 * 
 * @param	height		comparable depth when drawn
 * @param	name		height of object and associated image
 * @param	startX			(old) object type. comparable for item <-> tool
 * @param 	startY	String location of image file
 * @param	width		String name for object
 * @param 	width		width of object and associated image
 */
public class SceneId {
  private final double height;
  private final String name;
  private final double startX;
  private final double startY;
  private final double width;
  
  public SceneId (double h, String n, double x, double y, double w) {
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
