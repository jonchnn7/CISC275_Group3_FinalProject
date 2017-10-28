package cisc275.group3.utility;
/**
 * Data structure to hold immutable SceneObject Parameters. Can also
 * be used to more cleanly pass SceneObject information.
 * <p>
 * ObId.java (ObjectID)
 * 
 * @param	depth		comparable depth when drawn
 * @param	height		height of object and associated image
 * @param	id			(old) object type. comparable for item <-> tool
 * @param 	imageFile	String location of image file
 * @param	name		String name for object
 * @param 	width		width of object and associated image
 * 
 * Style Guide
 * https://google.github.io/styleguide/javaguide.html
 * http://www.oracle.com/technetwork/articles/java/index-137868.html # javadoc
 * 
 * Code Sources
 * https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html  # this
 * https://docs.oracle.com/javase/tutorial/uiswing/index.html  # swing tutorial
 * http://www.badlogicgames.com/wordpress/?p=2668 # general design
 */

public class ObId {
  private final int depth;
  private final int height;
  private final int id;
  private final String imageFile;
  private final String name;
  private final int width;
	
  public ObId(int d, int h, int id, String imFi, String n, int w) {
    this.depth = d;
    this.height = h;
    this.id = id;
    this.imageFile = imFi;
    this.name = n;
    this.width = w;
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
