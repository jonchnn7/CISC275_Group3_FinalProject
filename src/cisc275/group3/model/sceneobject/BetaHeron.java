package cisc275.group3.model.sceneobject;

import java.awt.geom.Point2D;
import cisc275.group3.utility.ObjectId;

/**
 * Beta release mock-up for heron. Handles right-to-left and left-to-right
 * moving heron via a boolean. If leftFish is true, fish moving left-to-right.
 * 
 * <p>
 * BetaHeron.java
 * <p>
 * 
 * @author Jon
 */
public class BetaHeron extends SceneObject implements ActionMove {
	protected double speedX; // x-axis speed
	protected double speedY; // y-axis speed
	protected boolean landed; // determines if bird has landed (or is moving)
	protected boolean hasLanded; // determines if bird has/is landed at one point
	protected boolean leftHeron; // moving left

	public BetaHeron(ObjectId id, double x, double y, double sx, double sy, boolean lf) {
		super(id, x, y);
		speedX = sx;
		speedY = sy;
		landed = false;
		hasLanded = false;
		leftHeron = lf;
	}

	/**
	 * Creates a Beta Heron
	 * 
	 * @param id
	 *            ObjectID-heron's object id
	 * @param x
	 *            double-x-axis location
	 * @param y
	 *            double-y-axis location
	 * @param sx
	 *            double-speed on x-axis
	 * @param sy
	 *            double-speed on y-axis
	 * @param land
	 *            boolean-is the heron landed (not moving)
	 * @param hasland
	 *            boolean-has the heron landed ever
	 * @param lf
	 *            boolean-left moving heron
	 * 
	 */
	public BetaHeron(ObjectId id, double x, double y, double sx, double sy, boolean land, boolean hasland, boolean lf) {
		super(id, x, y);
		speedX = sx;
		speedY = sy;
		landed = land;
		hasLanded = hasland;
		leftHeron = lf;
	}

	/**
	 * Creates a Beta heron as well as its ObjectID
	 * <p>
	 * See ObjectId.java
	 * <p>
	 * 
	 * @param d
	 *            int-depth
	 * @param h
	 *            int-object height
	 * @param id
	 *            int-(deprecated) object type
	 * @param imFi
	 *            String-Image file string
	 * @param n
	 *            String-name for object
	 * @param w
	 *            int-object width
	 * @param x
	 *            double-x-axis location
	 * @param y
	 *            double-y-axis location
	 * @param sx
	 *            double-speed on x-axis
	 * @param sy
	 *            double-speed on y-axis
	 * @param land
	 *            boolean-is the heron landed (not moving)
	 * @param hasland
	 *            boolean-has the heron landed ever
	 * @param lf
	 *            boolean-left moving heron
	 */
	public BetaHeron(int d, int h, int id, String imFi, String n, int w, double x, double y, double sx, double sy,
			boolean land, boolean hasland, boolean lf) {
		this(new ObjectId(d, h, id, imFi, n, w), x, y, sx, sy, land, hasland, lf);
	}

	/**
	 * Overridden from action interface.
	 * <p>
	 * The move() first has three parts: 1) Is to determine if a flying (moving)
	 * heron should land (stop). This is set at a 13% chance or if it becomes too
	 * low in the view. 2) Is to determine if a landed heron should fly. This is set
	 * at 2% chance. 3) is to move all flying herons in the correct direction
	 */
	@Override
	public void move() {
		double dx = speedX;
		double dy = speedY;

		int i = randGen.nextInt(100);
		// 10 percent chance for a flying heron to land or when gets too closed to
		// bottom of screen
		if (((i < 13) && (location.getY() > 150) && (location.getX() > 200) && (location.getX() < 1080)
				&& (hasLanded == false)) || ((location.getY() > 500) && (hasLanded == false))) {
			this.landed = true;
			this.hasLanded = true;
		}
		// 3 percent chance for a landed heron to fly
		else if (this.getLanded() == true) {
			if (i < 2) {
				this.landed = false;
			}
		}
		// fly
		else {
			int dirX = (leftHeron) ? -1 : 1; // unit vector for direction
			int dirY = hasLanded ? -1 : 1;
			double x = location.getX() + dirX * dx;
			double y = location.getY() + dirY * dy;
			location = new Point2D.Double(x, y);
		}
	}

	/**
	 * @return leftHeron returns if heron is moving left
	 */
	public boolean getLeftHeron() {
		return leftHeron;
	}

	/**
	 * @return speedX returns x-axis speed
	 */
	public double getSpeedX() {
		return speedX;
	}

	/**
	 * @return landed returns if the heron is currently landed
	 */
	public boolean getLanded() {
		return landed;
	}

	/**
	 * @return hasLanded returns if the heron has every landed
	 */
	public boolean getHasLanded() {
		return hasLanded;
	}

	/**
	 * @return speedY returns y-axis speed
	 */
	public double getSpeedY() {
		return speedY;
	}
}
