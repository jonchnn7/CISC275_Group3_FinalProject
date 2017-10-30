package cisc275.group3.utility;

import java.awt.geom.Ellipse2D;

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
  private final int height;
  private final int id;
  private final String imageFile;
  private final String name;
  private final int width;
	
  public ObjectId(int d, int h, int id, String imFi, String n, int w) {
    depth = d;
    height = h;
    this.id = id;
    imageFile = imFi;
    name = n;
    width = w;
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
  public int getHeight() {
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
  public int getWidth() {
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
