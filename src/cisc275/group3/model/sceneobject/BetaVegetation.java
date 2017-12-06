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
	
	  /**
	   * Creates a Beta Vegetation
	   * @param id		ObjectID-vegetation's object id
	   * @param x		double-x-axis location
	   * @param y		double-y-axis location
	   */
  public BetaVegetation(ObjectId id, double x, double y) {
    super(id, x, y);
  }
  
  /**
   * Creates a Beta Vegetation as well as its ObjectID
   * <p>
   * See ObjectId.java
   * <p>
   * @param d		int-depth
   * @param h		int-object height
   * @param id		int-(deprecated) object type
   * @param imFi	String-Image file string
   * @param n		String-name for object
   * @param w		int-object width
   * @param x		double-x-axis location
   * @param y		double-y-axis location
   */
  public BetaVegetation(int d, int h, int id, String imFi, String n, int w, double x, double y) {
	  this(new ObjectId(d, h, id, imFi, n, w), x, y);
  }
  
  /**
   * Checks to see the size of vegetation
   * and increases its size if it is below
   * the third length
   */
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
