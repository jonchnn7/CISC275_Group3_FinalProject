package cisc275.group3.model.sceneobject;

import cisc275.group3.utility.ObjectId;

/**
 * Beta release mockup for vegetation. Implements ConstructVegetation
 * enum to simplify code and create vegetation objects.
 * <p>
 * The filename was reversed from the previous version so, if we have multiple
 * objects, they appear next to each other in the workspace window.
 * <p>
 * BetaVegetation.java
 * 
 * @param	invasive	boolean - this plant is invasive?
 */
public class BetaVegetation extends SceneObject {

  public BetaVegetation(ObjectId id, double x, double y) {
    super(id, x, y);
  }

  public String toString() {
    String outString = "\nBeta Vegetation" 
                      +"\n========="
                      +"\nLocation: " + location.toString()
                      +passport.toString();
    return outString;
  }
}
