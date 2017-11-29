package cisc275.group3.model.scene;

import java.util.Collections;
import cisc275.group3.controller.ControllerInventory;
import cisc275.group3.exceptions.InsufficientDataException;
import cisc275.group3.utility.SceneId;

/**
 * Inventory scene/model.
 * <p>
 * The inventory scene tracks the items collected during missions and provides
 * mechanisms for their retrieval.
 * <p>
 * The primary purpose of the inventory is to provide the player with a list of
 * items collected.
 * <p>
 * SceneInventory.java
 * <p>
 * 
 * @author Thomas
 * @author Scott
 */
@SuppressWarnings("serial")
public class SceneInventory extends Scene {

	/**
	 * Constructor
	 * 
	 * @param mani
	 *            sceneid to identify inventory
	 */
	public SceneInventory(SceneId mani) {
		super(mani);
		fillScene();
	}

	/**
	 * Constructor for SceneInventory
	 * 
	 * @param n
	 *            name
	 * @param x
	 *            x-coordinate
	 * @param y
	 *            y-coordinate
	 * @param w
	 *            width
	 * @param h
	 *            height
	 * @param sceneType
	 *            type of scene
	 * @param bg
	 *            backround image
	 */
	public SceneInventory(String n, double x, double y, double w, double h, int sceneType, String bg) {
		this(new SceneId(n, x, y, w, h, sceneType, bg));
	}

	/**
	 * Creates initial screen of five left-to-right and right-to left fish at
	 * different depths. List of fish is then sorted by depth.
	 */
	@Override
	protected void fillScene() {
		sceneItems = ControllerInventory.getSceneItems();
		Collections.sort(sceneItems); // sort by depth
	}

	/**
	 * Update nothing, needed for abstract class
	 */
	@Override
	public void update() {

	}

}