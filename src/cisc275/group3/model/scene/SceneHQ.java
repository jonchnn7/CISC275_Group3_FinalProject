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
public class SceneHQ extends Scene {

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
}
