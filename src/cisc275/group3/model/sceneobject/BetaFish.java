package cisc275.group3.model.sceneobject;

import java.awt.geom.Point2D;
import cisc275.group3.utility.ObjectId;

/**
 * Beta release mock-up for fish. Handles right-to-left and left-to-right
 * moving fish via a boolean. If leftFish is true, fish moving left-to-right.
 * Currently, speedY isn't being used. It's still here, whenever we find a 
 * use for it.
 * <p>
 * The filename was reversed from the previous version so, if we have multiple
 * objects, they appear next to each other in the workspace window.
 * <p>
 * BetaFish.java
 * <p>
 * @author Scott
 * @author Thomas
 * @author Ryan
 */
public class BetaFish extends SceneObject implements ActionMove {
  protected double speedX; // x-axis speed
  protected double speedY; // y-axis speed
  protected boolean leftFish; // moving right to left?

  /**
   * Creates a Beta Fish
   * @param id		ObjectID-fish's object id
   * @param x		double-x-axis location
   * @param y		double-y-axis location
   * @param sx		double-speed on x-axis
   * @param sy		double-speed on y-axis
   * @param lf		boolean-left moving fish?
   */
  public BetaFish(ObjectId id, double x, double y, double sx, double sy, boolean lf) {
    super(id, x, y);
    speedX = sx; 
    speedY = sy;  // Not actually used?...
    leftFish = lf;
  }
  
  /**
   * Creates a Beta Fish as well as its ObjectID
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
   * @param sx		double-speed on x-axis
   * @param sy		double-speed on y-axis
   * @param lf		boolean-left moving fish?
   */
  public BetaFish(int d, int h, int id, String imFi, String n, int w, double x, double y, double sx, double sy, boolean lf) {
	  this(new ObjectId(d, h, id, imFi, n, w), x, y, sx, sy, lf);
  }

  /**
   * Calculates an offset, dx and dy, from the current location. The x-axis
   * offset takes 10% off speedX, and adds up to 20% based on a normal
   * distribution. This should keep the x-axis speed somewhat predictable, 
   * but add enough variability that movement doesn't look synchronized. The
   * y-axis offset is similar, defined by the sum of a positive and negative
   * Gaussian distribution times a scaling factor.
   * <p>
   * The offsets are used to update the location by component.
   * <p>
   * Overridden from action interface.
   */
  @Override
  public void move() {
	double dx = speedX - speedX*0.1 + randGen.nextGaussian()*speedX*0.2;
	double dy = 1*(randGen.nextGaussian() - randGen.nextGaussian());
	
	int dir =  (leftFish) ? -1 : 1; // unit vector for direction
    double x = location.getX() + dir*dx;
    double y = location.getY() + dir*dy;
	  
    location = new Point2D.Double(x,y);
  }
  
  /**
   * @return leftFish	returns fish moving left?
   */
  public boolean getLeftFish() {
    return leftFish;
  }
  
  /**
   * @return speedX	returns x-axis speed
   */
  public double getSpeedX() {
    return speedX;
  }
  
  /**
   * @return speedY	returns y-axis speed
   */
  public double getSpeedY() {
    return speedY;
  }
  
  /**
   * Provides a string-based representation
   * of the fish by using its location and
   * then printing the fish's ObjectId, 
   * held in the passport variable.
   * <p>
   * See ObjectID.java
   */
  public String toString() {
    String outString = "\nBeta Fish" 
                      +"\n========="
                      +"\nLocation: " + location.toString()
                      +passport.toString();
    return outString;
  }
}
