package cisc275.group3.controller;

import java.awt.Component;
import java.util.HashMap;
import cisc275.group3.model.scene.SceneTutorial;
import cisc275.group3.utility.EnumGameState;
import cisc275.group3.utility.EnumLayerCode;
import cisc275.group3.utility.EnumLayerCodeTutorial;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;
import cisc275.group3.view.ViewOverlayLabel;

/**
 * Contains the controller actions and logic for SceneBay.java.
 * <p>
 * Extends the abstract ConstrollerScene class and adds dynamics and timing
 * attributes. Those interfaces require the controller to pass an update call to
 * the model on every timer tick, and to update the time every second.
 * <p>
 * See cisc275.group3.controller.ControllerScene.java
 * <p>
 * ControllerBay.java
 * <p>
 * 
 * @author Scott
 * @author Jon
 */
public class ControllerTutorial extends ControllerScene implements LinkDynamics, LinkTime {
	private final String BG_IMAGE = "img/tutorial_bg_2.jpg";
  private EnumGameState gameState;
  
	/**
	 * Constructor
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
	 *            EnumSceneType-type of scene to be constructed
	 */
	public ControllerTutorial(int w, int h, GameWindow f, HashMap<String, Component> cl, EnumSceneType sceneType) {
		super(w, h, f, cl, sceneType);
		gameState = EnumGameState.IN_TUTORIAL;
	}

	/**
	 * Creates the scene and adds it to the main pain. Sets the layers and component
	 * list for the Tutorial.
	 */
	@Override
	protected void createScene() {
		scene = new SceneTutorial("Tutorial", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, BG_IMAGE, sceneType);
		viewGame = new ViewGame(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), scene.getManifest().getBG());

		viewGame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		viewGame.setName("TutorialLayer");

		mainPane.setLayer(viewGame, EnumLayerCodeTutorial.TutorialScreen.getCode());
		mainPane.add(viewGame, EnumLayerCodeTutorial.TutorialScreen.getCode());

		componentList.put("Tutorial", viewGame);

		addBasicML();
	}

	/**
	 * Connects the Bay model and Bay view. So long as the Bay scene is the active
	 * pane, update the model and then pass the updated scene objects to the view.
	 * <p>
	 * Overridden from interface LinkDynamics.java
	 */
	@Override
	public void update() {
		// Update Model
		scene.update();
		viewGame.updatePanel(scene.getSceneItems());
		
		if (tutorialDone()) {
		  gameState = EnumGameState.START;
		}
	}

	/**
	 * Updates the model's time variable and calls displayTime() to share it with
	 * the view.
	 * <p>
	 * Overridden from interface LinkTime.java
	 */
	@Override
	public void updateTime() {
		((LinkTime) scene).updateTime();

		if (mainPane.getLayer(componentList.get("Tutorial")) == EnumLayerCode.MainTop.getCode()) {
			displayTime();
		}
	}

	/**
	 * Displays the model time in the shared time label.
	 * <p>
	 * Overridden from interface LinkTime.java
	 */
	@Override
	public void displayTime() {
		String sceneTime;

		sceneTime = Integer.toString(scene.getTime());
		((ViewOverlayLabel) componentList.get("TimeLabel")).updateLabel(sceneTime);
	}

	/**
	 * Determines if the tutorial is done
	 * 
	 * @return true if tutorial is completed, else false
	 */
	private boolean tutorialDone() {
		if (scene.getSceneItems().size() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * @return the game state
	 */
	public EnumGameState getGameState() {
	  return gameState;
	}

}