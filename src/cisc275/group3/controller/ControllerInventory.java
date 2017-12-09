package cisc275.group3.controller;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JPanel;

import cisc275.group3.scene.SceneInventory;
import cisc275.group3.sceneobject.BetaCrab;
import cisc275.group3.sceneobject.BetaFish;
import cisc275.group3.sceneobject.BetaHeron;
import cisc275.group3.sceneobject.BetaVegetation;
import cisc275.group3.sceneobject.SceneObject;
import cisc275.group3.utility.ConstructCrab;
import cisc275.group3.utility.ConstructFish;
import cisc275.group3.utility.ConstructHeron;
import cisc275.group3.utility.EnumLayerCode;
import cisc275.group3.utility.EnumLayerCodeTutorial;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;

/**
 * The Inventory controller is responsible for both the "model" and control of
 * the inventory. ControllerInventory.java
 * 
 * @author Thomas
 * @author Scott
 * @author Jon
 */
public class ControllerInventory extends ControllerScene {
  private final String BG_IMAGE = "img/inventoryPics/inventory_menu_small.png";
	// Parameter and sizes for JPanel and images
	private JPanel inventoryPanel;
	private static ArrayList<SceneObject> sceneFillItems = new ArrayList<SceneObject>();
	private final static int INV_WIDTH = 340;
	private final static int INV_HEIGHT = 300;

	// Variables to keep track of next inventory slot
	private static double inventory_x = 0;
	private static double inventory_y = 0;
	private static double inventory_y_max = 0;

	/**
	 * Constructor that calls ControllerScene super and places proper background
	 * image
	 * 
	* @param w
	 *            int-scene width
	 * @param h
	 *            int-scene height
	 * @param f
	 *            GameWindow-JFrame container
	 * @param cl
	 *            HashMap-associations of scene controllers and layers
	 * @param sceneType
	 *            EnumSceneType-type of scene to be rendered
	 */
	public ControllerInventory(int w, int h, GameWindow f, HashMap<String, Component> cl, EnumSceneType sceneType) {
		super(w, h, f, cl, sceneType);
	}

	/**
	 * Creates the scene and adds it to the main pain. Sets the layers and component
	 * list for the inventory.
	 */
	@Override
	protected void createScene() {

		scene = new SceneInventory("Inventory", 0, 0, 340, 300, EnumSceneType.MENU, BG_IMAGE);
		viewGame = new ViewGame(340, 300, scene.getSceneItems(), scene.getManifest().getBG());

		viewGame.setBounds(100, 0, INV_WIDTH, INV_HEIGHT);
		viewGame.setName("InventoryLayer");

		if (sceneType == EnumSceneType.TUTORIAL) {
			mainPane.setLayer(viewGame, EnumLayerCodeTutorial.InventoryHidden.getCode());
			mainPane.add(viewGame, EnumLayerCodeTutorial.InventoryHidden.getCode());
		} else {
			mainPane.setLayer(viewGame, EnumLayerCode.Inventory.getCode());
			mainPane.add(viewGame, EnumLayerCode.Inventory.getCode());
		}

		componentList.put("Inventory", viewGame);
	}

	/**
	 * Takes in an object and adds a new instance of it to the inventory
	 * 
	 * @param tmp
	 *            sceneobject that is passed to inventory and cloned/placed in
	 *            inventory
	 * 
	 */
	public static void addItem(SceneObject tmp) {
		// Add Item
		if (tmp instanceof BetaFish) {
			System.out.println(tmp.getPassport().getName());
			if (tmp.getPassport().getName() == "American Shad")
			{//150x66
				if (inventory_x + 170 > INV_WIDTH) {
					inventory_x = 0;
					inventory_y = inventory_y + 70;
				}
				BetaFish tFish = ConstructFish.constructRightFish(0,0,inventory_x,inventory_y);
				sceneFillItems.add(tFish);
				inventory_x = inventory_x + tmp.getPassport().getWidth();
			}
			else {
				if (tmp.getPassport().getHeight() > inventory_y_max) {
					inventory_y_max = tmp.getPassport().getHeight();
				}
				if (inventory_x + tmp.getPassport().getWidth() > INV_WIDTH) {
					inventory_x = 0;
					inventory_y += inventory_y_max;
					inventory_y_max = 0;
				}
				sceneFillItems.add(new BetaFish(tmp.getPassport(), inventory_x, inventory_y, 0, 0, true));
				inventory_x = inventory_x + tmp.getPassport().getWidth()+20;
			}
		}

		else if (tmp instanceof BetaCrab) {
			if (tmp.getPassport().getName() == "Horseshoe Crab")
			{
				if (inventory_x + tmp.getPassport().getWidth() > INV_WIDTH) {
					System.out.println("here");
					inventory_x = 0;
					inventory_y += inventory_y + tmp.getPassport().getHeight()+20;
				}
				BetaCrab hCrab = ConstructCrab.constructLeftCrab(0, 1, inventory_x, inventory_y);
				sceneFillItems.add(hCrab);
				inventory_x = inventory_x + tmp.getPassport().getWidth();		
			}
			
			else if (tmp.getPassport().getName() == "Atlantic Blue Crab")
			{
				if (inventory_x + tmp.getPassport().getWidth() > INV_WIDTH) {
					inventory_x = 0;
					inventory_y += inventory_y += tmp.getPassport().getHeight();
				}
				BetaCrab bCrab = ConstructCrab.constructLeftCrab(0, 0, inventory_x, inventory_y);
				sceneFillItems.add(bCrab);
				inventory_x = inventory_x + tmp.getPassport().getWidth();		
			}

		}

		else if (tmp instanceof BetaHeron) {
			if (inventory_x + 150 > INV_WIDTH) {
				inventory_x = 0;
				inventory_y += inventory_y += 100;
			}
			BetaHeron tmpHeron = ConstructHeron.constructLeftHeron(0, 1, inventory_x - 10, inventory_y, false, false);
			sceneFillItems.add(tmpHeron);// new BetaHeron(tmp.getPassport(), inventory_x, inventory_y, 0, 0, true)
			inventory_x = inventory_x + 150;
		}

		else if (tmp instanceof BetaVegetation) {
			if (inventory_x + 100 > 340) {
				inventory_x = 0;
				inventory_y += 100;
			}
			sceneFillItems.add(new BetaVegetation(tmp.getPassport(), inventory_x, inventory_y-80));
			inventory_x = inventory_x + 100;
		}

	}

	/**
	 * Removes a given item from inventory and redraws it.
	 * 
	 * @param tmp
	 *            string that is used to find an object in the inventory
	 */
	public static void removeItem(String tmp) {
		for (Iterator<SceneObject> iterator = sceneFillItems.iterator(); iterator.hasNext();) {
			SceneObject sceneItem = iterator.next();

			if (sceneItem.getPassport().getName() == tmp) {
				iterator.remove();
			}
		}
		if(tmp == "All") {
			sceneFillItems.clear();
		}

		ArrayList<SceneObject> tmp_list = new ArrayList<SceneObject>();

		for (SceneObject tmp_object : sceneFillItems) {
			tmp_list.add(tmp_object);
		}
		sceneFillItems.clear();
		inventory_x = 0;
		inventory_y = 0;
		for (SceneObject tmp_object : tmp_list) {
			addItem(tmp_object);
		}
		tmp_list.clear();

	}

	/**
	 * returns the scene items to be drawn
	 * 
	 * @return array list of the sceneitems
	 */
	public static ArrayList<SceneObject> getSceneItems() {
		return sceneFillItems;
	}

	/**
	 * Update inventory/repaint it
	 */
	public void update() {
		inventoryPanel.repaint();
		mainPane.repaint();

	}

}