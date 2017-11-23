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
 * 
 * @author Scott
 * @author Jon
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
	 * @return score
	 */
	@Override
	public int getScore() {
		return score;
	}

	/**
	 * Overridden from PropertyScored.java
	 * 
	 * Updates the static score by 1
	 */
	@Override
	public void updateScore() {
		score += 1;
	}

	/**
	 * Overridden from PropertyScored.java
	 * 
	 * Updates the static score by how much time is left in the mission
	 */
	@Override
	public void missionScore() {
		score += this.getTime();
	}

	/**
	 * Overridden from PropertyTimed.java
	 * 
	 * @return time
	 */
	@Override
	public int getTime() {
		return time;
	}

	/**
	 * Overridden from PropertyTimed.java
	 * 
	 * Updates the static time by 1
	 */
	@Override
	public void updateTime() {
		time -= 1;
	}

	/**
	 * Overridden from PropertyTimed.java
	 * 
	 * Updates the static time by setting it to 0
	 */
	@Override
	public void resetTime() {
		time = 0;
	}
}
