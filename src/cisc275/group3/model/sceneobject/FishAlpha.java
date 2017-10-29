package cisc275.group3.model.sceneobject;

import java.awt.geom.Point2D;
import cisc275.group3.utility.ObjectId;

/**
 * Alpha release mockup for fish. Handles right-to-left and left-to-right
 * moving fish via a boolean. If leftFish is true, fish moving left-to-right.
 * Currently, speedY isn't being used. It's still here, whenever we find a 
 * use for it.
 * <p>
 * For console output, the toString prints the first letter of the fish name.
 * <p>
 * The filename was reversed from the previous version so, if we have multiple
 * fish, they appear next to each other in the workspace window.
 * <p>
 * FishAlpha.java
 * 
 * @param	speedX		type class to hold immutable properties
 * @param	speedY		current location stored as a 2D point
 * @param	leftFish	RNG, mostly for subclasses
 */
public class FishAlpha extends SceneObject implements ActionMove {
  protected double speedX; // x-axis speed
  protected double speedY; // y-axis speed
  protected boolean leftFish; // moving left-to-right?

  public FishAlpha(ObjectId id, double x, double y, double sx, double sy, boolean lf) {
    super(id, x, y);
    speedX = sx; 
    speedY = sy;  // Not actually used?...
    leftFish = lf;
  }
  
  /**
   * Constructor also creates an ObjectId
   */
  public FishAlpha(int d, int h, int id, String imFi, String n, int w, double x, double y, double sx, double sy, boolean lf) {
	  this(new ObjectId(d, h, id, imFi, n, w), x, y, sx, sy, lf);
  }

  /**
   * Overridden from action interface.
   * <p>
   * Calculates an offset, dx and dy, from the current location. The x-axis
   * offset takes 10% off speedX, and adds up to 20% based on a normal
   * distribution. This should keep the x-axis speed somewhat predictable, 
   * but add enough variability that movement doesn't look synchronized. The
   * y-axis offset is similar, defined by the sum of a positive and negative
   * gaussian distribution scaled to 3.
   * <p>
   * The offsets are used to update the location by component.
   */
  @Override
  public void move() {
	double dx = speedX - speedX*0.1 + randGen.nextGaussian()*speedX*0.2;
	double dy = randGen.nextGaussian()*3 - randGen.nextGaussian()*3;
	
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
}
