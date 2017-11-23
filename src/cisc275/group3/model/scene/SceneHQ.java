package cisc275.group3.model.scene;

import cisc275.group3.utility.SceneId;

/**
 * HQ scene/model.
 * <p>
 * The HQ scene implements scoring and timing functions via interface
 * implementations.
 * <p>
 * SceneHQ.java
 * <p>
 * @author Jon 
 * @author Scott
 */
public class SceneHQ extends Scene implements PropertyScored, PropertyTimed {

	public SceneHQ(SceneId mani) {
		super(mani);
		time = 0;
	}

	/**
	 * Used when SceneId must also be created
	 */
	public SceneHQ(String n, double x, double y, double w, double h, int sceneType, String bg) {
		this(new SceneId(n, x, y, w, h, sceneType, bg));
	}

	/**
	 * Overridden from Scene.java
	 */
	@Override
	protected void fillScene() {
		// TODO Auto-generated method stub
	}

	/**
	 * Overridden from Scene.java
	 */
	public void update() {
		// TODO Auto-generated method stub
	}

	/**
	 * Overridden from PropertyScored.java
	 * 
	 * @return the score
	 */
	@Override
	public int getScore() {
		return score;
	}

	/**
	 * Increases the static score by 1
	 * <p>
	 * Overridden from PropertyScored.java
	 */
	@Override
	public void updateScore() {
		score += 1;
	}

	/**
	 * Updates the static score with the time left in the mission
	 * <p>
	 * Overridden from PropertyScored.java
	 */
	@Override
	public void missionScore() {
		score += this.getTime();
	}

	/**
	 * Overridden from PropertyTimed.java
	 * @return time
	 */
	@Override
	public int getTime() {
		return time;
	}

	/**
	 * Updates the static time by subtracting 1
	 * <p> 
	 * Overridden from PropertyTimed.java
	 */
	@Override
	public void updateTime() {
		time -= 1;
	}

	/**
	 * Resets the static time to 0
	 * <p>
	 * Overridden from PropertyTimed.java
	 */
	@Override
	public void resetTime() {
		time = 0;
	}
}
