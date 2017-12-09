package cisc275.group3.scene;

import cisc275.group3.sceneobject.ActionMove;
import cisc275.group3.sceneobject.BetaCrab;
import cisc275.group3.utility.ConstructCrab;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.utility.SceneId;

/**
 * Bonus Beach mini-game to be unlocked after completing a beach mission.
 * Primarily used to introduce fun, alternative play mechanics with little to no
 * educational value.
 * <p>
 * The objective of this game is to "drag" your crab across the screen in a race
 * against two npc crabs.
 * <p>
 * SceneBeachMini.java
 * <p>
 * 
 * @author Scott
 */
public class SceneBeachMini extends Scene implements ConstructCrab {

	public SceneBeachMini(SceneId mani) {
		super(mani);

		time = 0;
		if (this.getManifest().getSceneType() == EnumSceneType.DEFAULT) {
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
	public SceneBeachMini(String n, double x, double y, double w, double h, String bg, EnumSceneType sceneType) {
		this(new SceneId(n, x, y, w, h, sceneType, bg));
	}

	/**
	 * Creates three NPC crabs and a Player Crab
	 */
	@Override
	protected void fillScene() {
		for (int i = 1; i < 3; i++) {

			// Add NPC Crab
			sceneItems.add(ConstructCrab.constructCrab(5, // depth
					0, // type
					0 + 50, // x location
					i * 200 + manifest.getStartY() + 10)); // y location
		}

		// Player Crab
		sceneItems.add(ConstructCrab.constructCrab(5, // depth
				1, // type
				0 + 50, // x location
				600)); // y location
	}

	/**
	 * Movement for npc crabs. NPC crabs are
	 * differentiated by their ID.
	 */
	@Override
	public void update() {
		sceneItems.forEach((crab) -> {
			if (crab.getPassport().getId() == 200) {
				((ActionMove) crab).move();
			}
		});
	}

	/**
	 * Overloaded movement for user controlled 
	 * crab. User crab differentiated by ID.
	 * @param dx double-displacement along x-axis
	 */
	public void update(double dx) {
		sceneItems.forEach((crab) -> {
			if (crab.getPassport().getId() == 300) {
				((BetaCrab) crab).move(dx);
			}
		});
	}
}
