package cisc275.group3.model.scene;

import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.utility.SceneId;

/**
 * SceneTitle extends scene and is used to represent the title screen
 * 
 * @author Scott
 * @author Ryan
 */
public class SceneTitle extends Scene {

	/**
	 * Constructor
	 * 
	 * @param mani
	 *            sceneid used to distinguish between scenes
	 */
	public SceneTitle(SceneId mani) {
		super(mani);
		time = 0;
	}

	/**
	 * 
	 * @param n
	 *            Name of the scene
	 * @param x
	 *            x-coordinate of scene
	 * @param y
	 *            y-coordinate of scene
	 * @param w
	 *            width of scene
	 * @param h
	 *            height of scene
	 * @param bg
	 *            background image
	 * @param sceneType
	 *            type of scene
	 */
	public SceneTitle(String n, double x, double y, double w, double h, String bg, EnumSceneType sceneType) {
		this(new SceneId(n, x, y, w, h, sceneType, bg));
	}

	/**
	 * Abstract method must be defined
	 * <p>
	 * Overridden from Scene.java
	 */
	@Override
	protected void fillScene() {
		// TODO Auto-generated method stub
	}

  /**
   * Abstract method must be defined
   * <p>
   * Overridden from Scene.java
   */
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
}
