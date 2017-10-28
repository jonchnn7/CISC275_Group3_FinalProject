package cisc275.group3.utility;

public class SceneId {
  private final double height;
  private final String name;
  private final double start_x;
  private final double start_y;
  private final double width;
  
  public SceneId (double h, String n, double x, double y, double w) {
    height = h;
    name = n;
    start_x = x;
    start_y = y;
    width = w;	  
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
  public double getStart_x() {
    return start_x;
  }

  /**
   * @return the start_y
   */
  public double getStart_y() {
    return start_y;
  }

  /**
   * @return the width
   */
  public double getWidth() {
    return width;
  }
}
