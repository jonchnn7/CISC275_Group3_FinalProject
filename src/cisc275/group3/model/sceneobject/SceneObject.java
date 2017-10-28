package cisc275.group3.model.sceneobject;


import cisc275.goup3.utility.ObId;
import java.awt.geom.Point2D;


public abstract class SceneObject implements Comparable<SceneObject> {
  protected ObId passport;
  protected Point2D.Double location;

  public SceneObject(ObId id, double x, double y) {
	passport = id;
    location = new Point2D.Double(x,y);
  }

  /**
   * Sort by depth
   */
  public int compareTo(SceneObject other_item) {
    Integer myDepth = this.passport.getDepth();
    Integer urDepth = other_item.passport.getDepth();
    
	return myDepth.compareTo(urDepth);
  }

  public String toString() {
    return "O";
  }
 }