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
    speedY = sy;
    leftFish = lf;
  }

  @Override
  public void move() {
	double dx = rand_gen.nextGaussian()*10 + 5;
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
}
