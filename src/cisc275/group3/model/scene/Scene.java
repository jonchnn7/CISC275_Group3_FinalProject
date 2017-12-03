package cisc275.group3.model.scene;

import cisc275.group3.controller.ControllerInventory;
import cisc275.group3.model.sceneobject.BetaVegetation;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.model.sceneobject.ToolObject;

import cisc275.group3.utility.ConstructVegetation;
import cisc275.group3.utility.Mission;
import cisc275.group3.utility.SceneId;
import cisc275.group3.utility.SceneObjectType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Simplest base class of a scene supporting methods shared by all subclasses.
 * Additional, unique functionality should be implemented by subclasses, and
 * shared functionality by interfaces.
 * <p>
 * Scene.java
 * <p>
 * 
 * @author Scott
 * @author Jon
 * @author Jolyne
 * @author Thomas
 */
public abstract class Scene implements Serializable {

	// Scene Properties
	protected SceneId manifest;
	protected ArrayList<SceneObject> sceneItems;
	protected static int score;
	protected static int time;
	protected static ToolObject currentTool;
	protected static Mission currentMission;
	protected static String currentFact;

	// RNG
	protected Random randGen = new Random();

	/**
	 * Create scene
	 * 
	 * @param mani
	 *            sceneid used to distinguish scenes
	 */
	public Scene(SceneId mani) {
		manifest = mani;
		currentTool = null;
		currentMission = new Mission(null, -1);
		currentMission.setDoneMission(true);
		currentFact = "";
		sceneItems = new ArrayList<SceneObject>();
	}

	/**
	 * Every subclass must define its initial fill.
	 */
	abstract protected void fillScene();

	/**
	 * Every subclass must define how to update itself
	 */
	abstract public void update();

	/**
	 * Check the click with the compatible tool, mission is not needed
	 * 
	 * @param clickX
	 *            x-coordinate of click
	 * @param clickY
	 *            y-coordinate of click
	 * @return if the right tool was used return true, else return false
	 */
	public boolean basicClick(double clickX, double clickY) {
		for (Iterator<SceneObject> iterator = sceneItems.iterator(); iterator.hasNext();) {
			SceneObject sceneItem = iterator.next();

			// Compatibility Check
			if (currentTool == null) {
				return false;
			}

			switch (sceneItem.getPassport().getName()) {
			// Beta Crabs
			case "Cristmas Island Red Crab":
			case "Atlantic Blue Crab":
			case "Horseshoe Crab":
				if ((SceneObjectType.BetaCrab.searchCompatability(currentTool.getName()))
						&& (sceneItem.itemClicked(clickX, clickY))) {
					ControllerInventory.addItem(sceneItem);
					iterator.remove();
					return true;
				}
				break;

			// Beta Fishies
			case "Striped Bass":
			case "Shortnose Sturgeon":
			case "American Shad":
				if ((SceneObjectType.BetaFish.searchCompatability(currentTool.getName()))
						&& (sceneItem.itemClicked(clickX, clickY))) {
					ControllerInventory.addItem(sceneItem);
					iterator.remove();
					return true;
				}
				break;

			// Beta Heronz
			case "Great Blue Heron":
				if ((SceneObjectType.BetaHeron.searchCompatability(currentTool.getName()))
						&& (sceneItem.itemClicked(clickX, clickY))) {
					ControllerInventory.addItem(sceneItem);
					iterator.remove();
					return true;
				}
				break;
			}
		}
		return false;
	}

	/**
	 * Process Click Events from Controller. If a scene object is clicked on, its
	 * name is printed to console. This is probably a good place to check "click
	 * compatibility".
	 * 
	 * @param clickX
	 *            double-x-axis coordinate of click
	 * @param clickY
	 *            double-y-axis coordinate of click
	 * @return boolean is click on clickable object?
	 */
	public boolean processClick(double clickX, double clickY) {
		for (Iterator<SceneObject> iterator = sceneItems.iterator(); iterator.hasNext();) {
			SceneObject sceneItem = iterator.next();

			// Compatibility Check
			if (currentTool == null) {
				return false;
			}

			switch (sceneItem.getPassport().getName()) {
			// Beta Crabs
			case "Cristmas Island Red Crab":
			case "Atlantic Blue Crab":
			case "Horseshoe Crab":
				if (SceneObjectType.BetaCrab.searchCompatability(currentTool.getName())) {
					if (compatClick(sceneItem, clickX, clickY)) {
						iterator.remove();
						return true;
					}
				}
				break;

			// Beta Fishies
			case "Striped Bass":
			case "Shortnose Sturgeon":
			case "American Shad":
				if (SceneObjectType.BetaFish.searchCompatability(currentTool.getName())) {
					if (compatClick(sceneItem, clickX, clickY)) {
						iterator.remove();
						return true;
					}
				}
				break;

			// Beta Heronz
			case "Great Blue Heron":
				if (SceneObjectType.BetaHeron.searchCompatability(currentTool.getName())) {
					if (compatClick(sceneItem, clickX, clickY)) {
						iterator.remove();
						return true;
					}
				}
				break;

			// Beta Veggies
			case "Invasive Plant":

				if (SceneObjectType.BetaVegetation.searchCompatability(currentTool.getName())) {
					if (compatClick(sceneItem, clickX, clickY)) {
						BetaVegetation vegetation = null;

						if (sceneItem.getPassport().getId() > 70) {
							// Vegetation needs mowed down
							// Swap current veg object for mowed down version
							vegetation = ConstructVegetation.constructVegetation(sceneItem.getPassport().getDepth(),
									(sceneItem.getPassport().getId() % 10) - 1, // GetID
									sceneItem.getLocation().getX(), sceneItem.getLocation().getY());

							iterator.remove();
							sceneItems.add(vegetation);

						} else {
							// Vegetation already mowed down
							iterator.remove();
						}
						return true;
					}
				}
				break;
			}
		}
		return false;
	}

	/**
	 * Helper method for processClick()
	 * <p>
	 * Takes a SceneObject and a click location to determine whether the object has
	 * been clicked on. If so, it further processes whether the object is a mission
	 * requirement.
	 * <p>
	 * Returns true so long as an object has been clicked.
	 * 
	 * @param item
	 *            SceneObject-current object in question
	 * @param clickX
	 *            double-x axis coordinate
	 * @param clickY
	 *            double-y axis coordinate
	 * @return boolean has the object been clicked
	 */
	private boolean compatClick(SceneObject item, double clickX, double clickY) {
		if (item.itemClicked(clickX, clickY)) {
			System.out.println("Clicked on: " + item.getPassport().getName());

			if (Scene.getCurrentMission().getObjectName().equals(item.getPassport().getName())
					&& (Scene.getCurrentMission().getObjectNum() > 0)) {
				if ((item.getPassport().getId() == 71) || (item.getPassport().getId() == 72)) {
					return true;
				}

				Scene.getCurrentMission().decreaseNum();
				ControllerInventory.addItem(item);
				return true;

			} else {
				updateScoreMinus();
				return false;
			}
			// return true;
		}

		return false;
	}

	/**
	 * Represents Scene as a String by printing its parameters.
	 * 
	 * @return multiline string of parameter states
	 */
	public String toString() {
		String outString = "\nName: " + manifest.getName() + "\nWidth: " + manifest.getWidth() + "\nHeight: "
				+ manifest.getHeight() + "\nScene Objects: " + sceneItems.size();
		return outString;
	}

	/**
	 * @return manifest
	 */
	public SceneId getManifest() {
		return manifest;
	}

	/**
	 * @return currentTool
	 */
	public static ToolObject getCurrentTool() {
		return currentTool;
	}

	/**
	 * Updates the current tool to the input parameter
	 * 
	 * @param t
	 *            ToolObject-new tool
	 */
	public static void setCurrentTool(ToolObject t) {
		currentTool = t;
	}

	/**
	 * @return currentTool
	 */
	public static Mission getCurrentMission() {
		return currentMission;
	}

	/**
	 * Updates the current tool to the input parameter
	 * 
	 * @param m
	 *            Mission-mission object
	 */
	public static void setCurrentMission(Mission m) {
		currentMission = m;
		time = 100;
	}

	/**
	 * @return currentFact
	 */
	public static String getCurrentFact() {
		return currentFact;
	}

	/**
	 * Updates the current fact to the input parameter
	 * 
	 * @param s
	 *            String-s
	 */
	public static void setCurrentFact(String s) {
		currentFact = s;
	}

	/**
	 * Used by View import objects. Changes must be compatible with View's
	 * drawObjects()
	 * 
	 * @return sceneItems
	 */
	public ArrayList<SceneObject> getSceneItems() {
		return sceneItems;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @return the score
	 */
	public static int getScore() {
		return score;
	}
	
	/**
	 * Sets the score.
	 * <p>
	 * Allows for continued games
	 * to have a nonzero initial score.
	 */
	public static void setScore(int carryScore) {
	  Scene.score = carryScore;
	}

	/**
	 * Update score by adding 1
	 */
	public void updateScore() {
		score += 1;
	}

	/**
	 * Update score by subtracting 1
	 */
	public void updateScoreMinus() {
		score -= 1;
	}

	/**
	 * Update time by subtracting 1
	 */
	public void updateTime() {
		time -= 1;
	}

	/**
	 * Reset time to zero
	 */
	public void resetTime() {
		time = 0;
	}

	/**
	 * Update score by adding remaining time
	 */
	public void missionScore() {
		score += this.getTime();
	}

	/**
	 * Update score by subtracting 50
	 */
	public void missionScoreFail() {
		score -= 50;
	}

	/**
	 * Reset Score to 0
	 */
	public void resetScore() {
		score = 0;
	}

}