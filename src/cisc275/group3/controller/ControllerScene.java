package cisc275.group3.controller;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.SceneBay;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;
import cisc275.group3.view.ViewOverlayLabel;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.util.HashMap;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * Abstract controller class for scene logic and actions. This
 * class is necessary so all controllers can be held within a
 * collection.
 * <p>
 * ControllerScene.java
 * <p>
 * @author Scott
 * @author Jon  
 */
public abstract class ControllerScene implements Serializable {
  // Window Parameters
  protected final int SCREEN_WIDTH;
  protected final int SCREEN_HEIGHT;
  protected final GameWindow GAME_FRAME;
  
  // Scene Variables
  protected Scene scene;
  protected ViewGame viewGame;
  protected static JLabel mouseLabel;
  protected static HashMap<String, Component> componentList;
  
  // Window Components
  protected JLayeredPane mainPane;
  
  /**
   * Abstract Scene Controller Constructor
   * <p>
   * Sets the  with, height and frame variables.
   * <p>
   * Updates the static componentList that holds the layer depths
   * for the JComponentLayer. This is necessary to retrieve layer
   * information.
   * @param w	int-scene width
   * @param h 	int-scene height
   * @param f 	GameWindow-JFrame container
   * @param cl 	HashMap-associations of scene controllers and layers
   * @param sceneType int- indicates how the scene should be initialized/updated
   */
  public ControllerScene(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
    SCREEN_WIDTH = w;
    SCREEN_HEIGHT = h;
    GAME_FRAME = f;
 
    componentList = cl;
    mainPane = GAME_FRAME.getMainPane();
    createScene(sceneType);
  }
  
  /**
   * Constructs a scene by creating the model, view background, and
   * overlay. A mouse listener is then added to the view background
   * to pass clicks through to the scene model.
   * <p>
   * The view overlay uses JLayeredPane to place the toolbar items 
   * in the foreground and the game panel in the background.
   * 
   * @param sceneType int- indicates how the scene should be initialized/updated
   */
  abstract protected void createScene(int sceneType);
  
  /**
   * Adds a mouse listener to the scene background and passes clicks
   * through to the model. 
   * <p>
   * Note: If the model implements scored, this must be overridden.
   */
  protected void addML() {
    viewGame.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
          if ( scene.processClick(e.getX(), e.getY()) ) {
            displayScore();
            displayMission();
          }
        }
      }
    });
  }
  
  public void displayMission() {
	    String missionNum;
	    
	    
	    missionNum = Integer.toString(Scene.getCurrentMission().getObjectNum());
	    
	    if (((missionNum.equals("0")) && (Scene.getCurrentMission().getTargetObject() != null)) || (missionNum.equals("-2"))) {
	    	missionNum = "Complete!";
	    	Scene.setCurrentFact("Fact about " + Scene.getCurrentMission().getObjectName());
	    	Scene.getCurrentMission().setTargetObject(null);
	    	Scene.getCurrentMission().setObjectNum(-2);
	    	((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(null);
	    } else if (missionNum.equals("-1") || missionNum.equals("-5")) {
	    	missionNum = "";
	    }
	    
	    ((ViewOverlayLabel)componentList.get("MissionLabel")).updateLabel(missionNum);
  }
  
  /**
   * Displays the model score in the shared score 
   * label.
   */
  public void displayScore() {
    String sceneScore;
    
    sceneScore = Integer.toString(scene.getScore());
    ((ViewOverlayLabel)componentList.get("ScoreLabel")).updateLabel(sceneScore);
  }
}