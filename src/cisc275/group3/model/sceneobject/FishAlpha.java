package cisc275.group3.model.sceneobject;

import cisc275.goup3.utility.ObId;
import java.awt.geom.Point2D;

public class FishAlpha extends SceneObject implements ActionMove {
  protected double speedX;
  protected double speedY;
  protected boolean leftFish;

  public FishAlpha(ObId id, double x, double y, double sx, double sy, boolean lf) {
    super(id, x, y);
    speedX = sx;
    speedY = sy;
    leftFish = lf;
  }

  @Override
  public void move(double dx, double dy) {
	int dir =  (leftFish) ? -1 : 1;;
    double x = location.getX() + dir*dx;
    double y = location.getY() + dir*dy;
	  
    location = new Point2D.Double(x,y);
  }
}
