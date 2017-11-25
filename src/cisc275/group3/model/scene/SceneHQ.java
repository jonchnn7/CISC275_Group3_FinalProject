package cisc275.group3.model.scene;

import cisc275.group3.exceptions.InsufficientDataException;
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
	 * @param n		String-scene name
	 * @param x		double-x-coordinate of upper left corner
	 * @param y		double-y-coordinate of upper left corner
	 * @param w		double-scene width
	 * @param h		double-scene height
	 * @param bg	String-file location of bg image
	 * @param sceneType	int-type of scene
	 */
	public SceneHQ(String n, double x, double y, double w, double h, String bg, int sceneType) {
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
