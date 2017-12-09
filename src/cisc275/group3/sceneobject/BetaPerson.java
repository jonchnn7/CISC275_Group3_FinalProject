package cisc275.group3.sceneobject;

import java.awt.geom.Point2D;
import cisc275.group3.utility.ObjectId;

/**
 * Beta release mock-up for person. Handles its move behaviors based on the
 * status int. (1- means moving right to left, 0- means stopped until mission is
 * completed and -1 means leaving the screen).
 * <p>
 * BetaPerson.java
 * <p>
 * 
 * @author Jon
 */
public class BetaPerson extends SceneObject implements ActionMove {
	protected double speedX; // x-axis speed
	protected double speedY; // y-axis speed
	protected int status; // 1- going to counter, 0- waiting at counter, -1- leaving counter

	/**
	 * Creates a BetaPerson
	 * 
	 * @param id
	 *            ObjectID-person's object id
	 * @param x
	 *            double-x-axis location
	 * @param y
	 *            double-y-axis location
	 * @param sx
	 *            double-speed on x-axis
	 * @param sy
	 *            double-speed on y-axis
	 * @param stat
	 *            int-determines the movement behavior of the person
	 */
	public BetaPerson(ObjectId id, double x, double y, double sx, double sy, int stat) {
		super(id, x, y);
		speedX = sx;
		speedY = sy;
		status = stat;
	}

	/**
	 * Creates a Beta Person as well as its ObjectID
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
	 * @param stat
	 *            int- movement behavior of the person
	 */
	public BetaPerson(int d, int h, int id, String imFi, String n, int w, double x, double y, double sx, double sy,
			int stat) {
		this(new ObjectId(d, h, id, imFi, n, w), x, y, sx, sy, stat);
	}

	/**
	 * Based on the status variable: 1 increments the person so they are moving
	 * right to left, 0 makes the person inanimate (still), -1 increments the person
	 * so they are moving left to right
	 */
	@Override
	public void move() {

		double dx = speedX;
		double dy = speedY;

		double x = location.getX();
		double y = location.getY();

		if (status == 1) {
			x = location.getX() + -1 * dx;
			y = location.getY() + -1 * dy;
		} else if (status == -1) {
			x = location.getX() + dx;
			y = location.getY() + dy;
		}

		location = new Point2D.Double(x, y);
	}

	/**
	 * @return stats returns the status of the person
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param i- sets the status of the person to "i"
	 */
	public void setStatus(int i) {
		status = i;
	}

	/**
	 * @return speedX returns x-axis speed
	 */
	public double getSpeedX() {
		return speedX;
	}

	/**
	 * @return speedY returns y-axis speed
	 */
	public double getSpeedY() {
		return speedY;
	}
}
