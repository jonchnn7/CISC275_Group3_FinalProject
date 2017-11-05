package cisc275.group3.utility;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * Data structure to hold immutable SceneObject parameters. Can also
 * be used to more cleanly pass SceneObject information.
 * <p>
 * ObjectId.java
 * 
 * @param	depth		comparable depth when drawn
 * @param	height		height of object and associated image
 * @param	id			(old) object type. comparable for item <-> tool
 * @param 	imageFile	String location of image file
 * @param	name		String name for object
 * @param 	width		width of object and associated image
 */
public class ObjectId {
  private final int depth;
  private final double height;
  private final int id;
  private final String imageFile;
  private final String name;
  private final double width;
  private Ellipse2D.Double area;
	
  public ObjectId(int d, double h, int id, String imFi, String n, double w) {
    depth = d;
    height = h;
    this.id = id;
    imageFile = imFi;
    name = n;
    width = w;
  }
  
  /**
   * Utility function to check whether a click is within the area of
   * the object.
   * 
   * @param		location	Point2D.Double - Object location
   * @param 	clickX		double 
   * @param 	clickY		double
   * @return	boolean		returns whether the click is within the object
   */
  public boolean checkClick(Point2D.Double l, double x, double y) {
    area = new Ellipse2D.Double(l.getX(), l.getY(), width, height);   
    return area.contains(x, y);
  }
	
  /**
   * @return the depth
   */
  public int getDepth() {
    return depth;
  }

  /**
   * @return the height
   */
  public double getHeight() {
    return height;
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }
	
  /**
   * @return the image location
   */
  public String getImageFile() {
    return imageFile;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the width
   */
  public double getWidth() {
    return width;
  }
	
  public String toString() {
    String outString = "\nName: " + name
    	              +"\nID: " + id
    	              +"\nWidth: " + width
    	              +"\nHeight: " + height
    	              +"\nDepth: " + depth
    	              +"\nFile: " + imageFile;
    return outString;
  }
}
