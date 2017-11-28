package cisc275.group3.model.sceneobject;

import cisc275.group3.utility.ConstructVegetation;
import cisc275.group3.utility.ObjectId;

/**
 * Beta release mock-up for vegetation. Implements ConstructVegetation
 * enum to simplify code and create vegetation objects.
 * <p>
 * The filename was reversed from the previous version so, if we have multiple
 * objects, they appear next to each other in the workspace window.
 * <p>
 * BetaVegetation.java
 * <p>
 * @author Jon
 */
public class BetaVegetation extends SceneObject {

  public BetaVegetation(ObjectId id, double x, double y) {
    super(id, x, y);
  }
  
  public BetaVegetation(int d, int h, int id, String imFi, String n, int w, double x, double y) {
	  this(new ObjectId(d, h, id, imFi, n, w), x, y);
  }

  public String toString() {
    String outString = "\nBeta Vegetation" 
                      +"\n========="
                      +"\nLocation: " + location.toString()
                      +passport.toString();
    return outString;
  }
  
  public BetaVegetation grow() {
	  if(this.getPassport().getId() < 72) {
		  BetaVegetation vegetation =  ConstructVegetation.constructVegetation(this.getPassport().getDepth(),
				  (this.getPassport().getId()%10) +1,
				  this.getLocation().getX(),
				  this.getLocation().getY());;
		 return vegetation;
	  }
	  else {
		  return this;
	  }
	  
  }
}
