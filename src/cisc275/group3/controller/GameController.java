package cisc275.group3.controller;

import cisc275.group3.controller.ControllerTutorial;
import cisc275.group3.scene.Scene;
import cisc275.group3.utility.EnumGameState;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.view.GameWindow;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 * The main controller class.
 * <p>
 * This controller is responsible for constructing the game scene-by-scene. As
 * the different scenes are created, they are added to a hash map for easy
 * retrieval.
 * <p>
 * This controller is also responsible for creating and acting on timer events.
 * These events currently occur every 100ms and pass an update call to dynamic
 * models.
 * <p>
 * GameController.java
 * <p>
 * 
 * @author Scott
 * @author Jon
 */
public class GameController {

	// Game Parameters
	private final int SCREEN_WIDTH;
	private final int SCREEN_HEIGHT;
	private final GameWindow GAME_FRAME;
	private EnumGameState gameState; 

	// Game Variables
	private int totalTime;
	private int carryScore;
	private HashMap<String, ControllerScene> controlMap;
	private HashMap<String, Component> layerMap;

	/**
	 * Creates the overarching controller responsible for tracking the individual
	 * game scenes. The input parameters set the screen dimensions, which can then
	 * be passed to each scene.
	 * 
	 * @param x
	 *            int-Window width
	 * @param y
	 *            int-Window height
	 */
	public GameController(int x, int y) {
		SCREEN_WIDTH = x;
		SCREEN_HEIGHT = y;

		// Set state to title screen
		gameState = EnumGameState.START;

		// Create game window
		GAME_FRAME = new GameWindow(SCREEN_WIDTH, SCREEN_HEIGHT);
		
		// Initialize Game
		controlMap = new HashMap<String, ControllerScene>();
		layerMap = new HashMap<String, Component>();
		carryScore = 0;
		exitKeyListener();

    // Boot-up
		gameTime();
	}
	
	/**
	 * Responds to game state changes, and updates 
	 * dynamic models every 100ms and the time every 1000ms
	 */
	private void gameTime() {
		Timer timer = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  
			  // Game State Updates
			  switch (gameState) {
			  case START:
			    clearWindow();
			    initTitle();
			    gameState = EnumGameState.TITLE;
			    break;
			  case TUTORIAL:
			    clearWindow();
			    initTutorial();
			    gameState = EnumGameState.IN_TUTORIAL;
			    break;
			  case GAME:
			    clearWindow();
			    initGame();
			    
			    totalTime = 0;
			    Scene.setScore(carryScore);
	        gameState = EnumGameState.IN_GAME;
			    break;
			  case IN_TUTORIAL:
			    gameState = ((ControllerTutorial)controlMap.get("Tutorial")).getGameState();
			    break;
			  case IN_GAME:
			    // Check if time is up
			    if (totalTime == 180000) {//3 mintues 180000
	          gameState = EnumGameState.END_GAME;
	          endGame();
			    }
	        // Only update total time if in game.
			    totalTime += 100;
			  case TITLE:
			  case END_GAME:
			    // Do nothing. Wait for update
			    break;
			  }
			  
			  // Model and Time Updates
			  controlMap.forEach((k, v) -> {
          // Model Object Updates
          switch (k) {
          case "HQ":
          case "Bay":
          case "Beach":
          case "Wetland":
          case "BeachMini":
          case "EndGame":
          case "Tutorial":
            ((LinkDynamics) v).update();
            break;
          }

          // Time Update
          if (totalTime % 1000 == 0) {
            switch (k) {
            case "HQ":
              ((LinkTime) v).updateTime();
            case "Bay":
            case "Beach":
            case "Wetland":
            case "BeachMini":
              ((LinkTime) v).displayTime();
              break;
            }
          }
			  });
      }
    });
		timer.start(); // Start it up!
	}
	
	 /**
   * Creates title scene for initial, between
   * state, and end states.
   */
  private void initTitle() {
    controlMap.put("Title", new ControllerTitle(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap,  EnumSceneType.MENU));
    
    // Start Game Listener
    ((ControllerTitle)controlMap.get("Title")).getStartButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        gameState = EnumGameState.GAME;
      }
    });
    
    // Tutorial Listener
    ((ControllerTitle)controlMap.get("Title")).getTutorialButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        gameState = EnumGameState.TUTORIAL;
      }
    });
  }

  /**
   * Initializes scene to the controller map 
   * only for scenes needed for tutorial
   */
  private void initTutorial() {
    controlMap.put("Tutorial", new ControllerTutorial(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, EnumSceneType.TUTORIAL));
    controlMap.put("Overlay", new ControllerOverlay(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, EnumSceneType.TUTORIAL));
    controlMap.put("Inventory", new ControllerInventory(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, EnumSceneType.TUTORIAL));
    controlMap.put("HQ", new ControllerHQ(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, EnumSceneType.TUTORIAL));
    controlMap.put("Tools", new ControllerTools(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, EnumSceneType.TUTORIAL));

  }

  /**
   * Initializes the game by creating the 
   * individual scenes and placing them in
   * the controller map.
   */
  private void initGame() {
    controlMap.put("Mission", new ControllerMission(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, EnumSceneType.MENU));
    controlMap.put("HQ", new ControllerHQ(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, EnumSceneType.DEFAULT));
    controlMap.put("Bay", new ControllerBay(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap,  EnumSceneType.DEFAULT));
    controlMap.put("Beach", new ControllerBeach(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, EnumSceneType.DEFAULT));
    controlMap.put("Wetland", new ControllerWetland(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap,  EnumSceneType.DEFAULT));
    controlMap.put("BeachMini", new ControllerBeachMini(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap,  EnumSceneType.DEFAULT));
    controlMap.put("Map", new ControllerMap(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap,  EnumSceneType.DEFAULT));
    controlMap.put("Overlay", new ControllerOverlay(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, EnumSceneType.DEFAULT));
    controlMap.put("Tools", new ControllerTools(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap,  EnumSceneType.DEFAULT));
    controlMap.put("Inventory", new ControllerInventory(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap,  EnumSceneType.DEFAULT));
  }
  
  /**
   * End game state.
   * <p>
   * Places the end game overlay and sets
   * listeners for state changes.
   */
  private void endGame() {
    controlMap.put("EndGame", new ControllerEndGame(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap,  EnumSceneType.DEFAULT));
    
    // Continue Listener
    ((ControllerEndGame)controlMap.get("EndGame")).getContinueButton().addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          carryScore = Scene.getScore();
          gameState = EnumGameState.GAME;
        }
      }
    );
    
    // Reset Listener
    ((ControllerEndGame)controlMap.get("EndGame")).getResetButton().addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          clearWindow();
          gameState = EnumGameState.START;
        }
      }
    );
  }
	
	/**
	 * Clears the game window and all 
	 * tracking variables. Used to
	 * initiate a new game or tutorial
	 */
	private void clearWindow() {   
	  if ( controlMap != null ) controlMap.clear();
    if ( layerMap != null ) layerMap.clear();
    if ( ControllerInventory.getSceneItems() != null ) 
     ControllerInventory.removeItem("All");
    
    GAME_FRAME.getMainPane().removeAll();	  
	}
	
	/**
	 * Establishes the escape key to quit 
	 * the program.
	 */
	@SuppressWarnings("serial")
  private void exitKeyListener() {
	  // Add Key Event
    GAME_FRAME.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Quit"); 
    
    // Add Action
    GAME_FRAME.getRootPane().getActionMap().put("Quit", new AbstractAction(){ 
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
	}
}
