package cisc275.group3.scene;

import cisc275.group3.utility.ConstructCrab;
import cisc275.group3.utility.ConstructFish;
import cisc275.group3.utility.ConstructHeron;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.utility.SceneId;

/**
 * SceneTutorial.java is a special instance of Scene.java
 * <p>
 * The purpose of this class is to provide the model for a functional tutorial.
 * There are elements of the Bay, Beach and Wetland scenes.
 * <p>
 * See Scene.java, SceneBay.java, SceneBeach.java, SceneWetland.java
 * 
 * @author Scott
 */
public class SceneTutorial extends Scene implements ConstructCrab, ConstructFish, ConstructHeron {

	/**
	 * Constructor
	 * 
	 * @param mani
	 *            sceneid used to distinguish between scenes
	 */
	public SceneTutorial(SceneId mani) {
		super(mani);

		time = 0;
		if (this.getManifest().getSceneType() == EnumSceneType.TUTORIAL) {
			fillScene();
		}
	}

	/**
	 * Used when SceneId must also be created
	 * 
	 * @param n
	 *            String-scene name
	 * @param x
	 *            double-x-coordinate of upper left corner
	 * @param y
	 *            double-y-coordinate of upper left corner
	 * @param w
	 *            double-scene width
	 * @param h
	 *            double-scene height
	 * @param bg
	 *            String-file location of bg image
	 * @param sceneType
	 *            EnumSceneType-type of scene
	 */
	public SceneTutorial(String n, double x, double y, double w, double h, String bg, EnumSceneType sceneType) {
		this(new SceneId(n, x, y, w, h, sceneType, bg));
	}

	/**
	 * Creates a crab, fish and heron 
	 * for the tutorial.
	 */
	@Override
	protected void fillScene() {

		// Add Crab
		sceneItems.add(ConstructCrab.constructCrab(
		    5, // depth
				1, // type
				getManifest().getWidth()/2 - 63, // x location
				getManifest().getHeight() * 4 / 5 - 50)); // y location

		// Add Fish
		sceneItems.add(ConstructFish.constructRightFish(
		    5, // depth
				1, // type
				getManifest().getWidth()/6 - 50, // x location
				getManifest().getHeight() * 4 / 5 - 60)); // y location

		// Add Heron
		sceneItems.add(ConstructHeron.constructRightHeron(
		    5, // depth
				1, // type
				getManifest().getWidth()*5/6 - 90, // x location
				getManifest().getHeight() * 4 / 5 - 80, // y location
				true, true));
	}

	/**
	 * Required by Scene.java
	 */
	@Override
	public void update() {
	}
}