package cisc275.group3.model.sceneobject;

import java.awt.geom.Point2D;

import cisc275.group3.utility.ObjectId;

public class FishAlpha extends SceneObject implements ActionMove {
  protected double speedX;
  protected double speedY;
  protected boolean leftFish;

  public FishAlpha(ObjectId id, double x, double y, double sx, double sy, boolean lf) {
    super(id, x, y);
    speedX = sx; 
    speedY = sy;  // Not actually used?...
    leftFish = lf;
  }

  @Override
  public void move() {
	double dx = speedX - speedX*0.1 + rand_gen.nextGaussian()*speedX*0.2;
	double dy = rand_gen.nextGaussian()*10 - rand_gen.nextGaussian()*10;
	
	int dir =  (leftFish) ? -1 : 1;
    double x = location.getX() + dir*dx;
    double y = location.getY() + dir*dy;
	  
    location = new Point2D.Double(x,y);
  }
  
  @Override
  public String toString() {
	  return Character.toString(passport.getName().charAt(0));
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
