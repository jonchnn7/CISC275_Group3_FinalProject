package cisc275.group3.controller;

import cisc275.group3.scene.Scene;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.utility.EstuaryFacts;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;
import cisc275.group3.view.ViewOverlayLabel;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.util.HashMap;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * Abstract controller class for scene logic and actions. This class is
 * necessary so all controllers can be held within a collection.
 * <p>
 * ControllerScene.java
 * <p>
 * 
 * @author Scott
 * @author Jon
 * @author Jolyne
 */
public abstract class ControllerScene {
	// Window Parameters
	protected final int SCREEN_WIDTH;
	protected final int SCREEN_HEIGHT;
	protected final GameWindow GAME_FRAME;

	// Scene Variables
	protected Scene scene;
	protected ViewGame viewGame;
	protected EnumSceneType sceneType;
	protected static JLabel mouseLabel;
	protected static HashMap<String, Component> componentList;
	protected static boolean missionClickable;

	// Window Components
	protected JLayeredPane mainPane;

	/**
	 * Abstract Scene Controller Constructor
	 * <p>
	 * Sets the width, height and frame variables.
	 * <p>
	 * Updates the static componentList that holds the layer depths for the
	 * JComponentLayer. This is necessary to retrieve layer information.
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
	public ControllerScene(int w, int h, GameWindow f, HashMap<String, Component> cl, EnumSceneType sceneType) {
		SCREEN_WIDTH = w;
		SCREEN_HEIGHT = h;
		GAME_FRAME = f;

		missionClickable = false;

		componentList = cl;
		this.sceneType = sceneType;
		mainPane = GAME_FRAME.getMainPane();
		createScene();
	}

	/**
	 * Constructs a scene by creating the model, view background, and overlay. It is
	 * then added to its specified layer in the JLayerdPane. A mouse listener is
	 * then added to the view background to pass clicks through to the scene model.
	 * <p>
	 * The view overlay uses JLayeredPane to determine what interfaces, buttons and
	 * scenes are displayed by moving the scenes into specified layers
	 * (LayerCode.java).
	 */
	abstract protected void createScene();

	/**
	 * Adds a mouse listener to the scene background and passes clicks through to
	 * the model.
	 * <p>
	 * Note: If the model implements scored, this must be overridden.
	 */
	protected void addML() {
		viewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
				  if (sceneType == EnumSceneType.TUTORIAL) {
		          scene.basicClick(e.getX(), e.getY());
				  } else {
  					if (scene.processClick(e.getX(), e.getY())) {
  						displayScore();
  						displayMission();
  					}
				  }
				}
			}
		});
	}

	/**
	 * Displays a random fact about the given mission
	 */
	public void displayMission() {
		String missionNum;

		EstuaryFacts facts = new EstuaryFacts(); // facts.getRandomFact(1);

		missionNum = Integer.toString(Scene.getCurrentMission().getObjectNum());

		if (((missionNum.equals("0")) && (Scene.getCurrentMission().getTargetObject() != null))
				|| (missionNum.equals("-2"))) {
			missionNum = "  Complete!";
			Scene.getCurrentMission().setTargetObject(null);
			Scene.getCurrentMission().setObjectNum(-2);
			((ViewOverlayLabel) componentList.get("MissionLabel")).updateIcon(null);
		} else if (missionNum.equals("-1") || missionNum.equals("-7")) {
			missionNum = "";
			switch (Scene.getCurrentMission().getTargetNameForFact()) {
			case "Striped Bass":
				Scene.setCurrentFact(facts.getRandomFact(6));
				break;
			case "American Shad":
				Scene.setCurrentFact(facts.getRandomFact(5));
				break;
			case "Shortnose Sturgeon":
				Scene.setCurrentFact(facts.getRandomFact(4));
				break;
			case "Atlantic Blue Crab":
				Scene.setCurrentFact(facts.getRandomFact(2));
				break;
			case "Horseshoe Crab":
				Scene.setCurrentFact(facts.getRandomFact(3));
				break;
			case "Great Blue Heron":
				Scene.setCurrentFact(facts.getRandomFact(0));
				break;
			case "Invasive Plant":
				Scene.setCurrentFact(facts.getRandomFact(1));
				break;
			}
		}

		((ViewOverlayLabel) componentList.get("MissionLabel")).updateLabel(missionNum);
	}

	/**
	 * Displays the model score in the shared score label.
	 */
	public void displayScore() {
		String sceneScore;

		sceneScore = Integer.toString(Scene.getScore());
		((ViewOverlayLabel) componentList.get("ScoreLabel")).updateLabel(sceneScore);
	}
}