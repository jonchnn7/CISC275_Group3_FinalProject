package cisc275.group3.model.sceneobject;

import java.awt.geom.Point2D;

import cisc275.group3.utility.ObjectId;

/**
 * Beta release mockup for crabs.
 * <p>
 * For console output, the toString prints the first letter of the fish name.
 * <p>
 * The filename was reversed from the previous version so, if we have multiple
 * objects, they appear next to each other in the workspace window.
 * <p>
 * BetaCrab.java
 * <p>
 * @author Scott 
 * @author Ryan 
 */
public class BetaCrab extends SceneObject implements ActionMove {
  private double speedX; // x-axis speed
  private double speedY; // y-axis speed
  private boolean leftCrab; //moving right to left?

  public BetaCrab(ObjectId id, double x, double y, double sx, double sy, boolean lc) {
    super(id, x, y);
    speedX = sx; 
    speedY = sy;  // Not actually used?...
    leftCrab = lc;
  }
	  
  /**
   * Constructor also creates an ObjectId
   */
  public BetaCrab(int d, int h, int id, String imFi, String n, int w, double x, double y, double sx, double sy, boolean lc) {
    this(new ObjectId(d, h, id, imFi, n, w), x, y, sx, sy, lc);
  }
	
  @Override
  public void move() {
	  double dx = speedX - speedX*0.1 + randGen.nextGaussian()*speedX*0.2;
		double dy = 1*(randGen.nextGaussian() - randGen.nextGaussian());
		
	int dir = (leftCrab) ? -1 : 1;
    double x = location.getX() + dir*dx;
    double y = location.getY() + dir*dy;
		  
    location = new Point2D.Double(x,y);
  }  
  
  /**
   * @return leftFish	returns fish moving left?
   */
  public boolean getLeftCrab() {
    return leftCrab;
  }
  
  /**
   * Defines the dx/dy changes and updates
   * the crab's location accordingly.
   * <p>
   * @param dx	double-delta x offset
   */
  public void move(double dx) {		
    double x = location.getX() + dx;
    double y = location.getY();
			  
    location = new Point2D.Double(x,y);
  }
  
  /**
   * Provides a string-based representation
   * of the crab by using its location and
   * then printing the crab's ObjectId, 
   * held in the passport variable.
   * <p>
   * @see ObjectID.java
   */
  public String toString() {
	    String outString = "\nBeta Crab" 
                          +"\n========="
	                      +"\nLocation: " + location.toString()
	                      +passport.toString();
	    return outString;
	  }
}
