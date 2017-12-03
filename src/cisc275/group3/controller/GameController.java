package cisc275.group3.controller;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.utility.EnumGameState;
import cisc275.group3.utility.EnumLayerCode;
import cisc275.group3.view.GameWindow;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.HashMap;
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
public class GameController implements Serializable {

	// Game Parameters
	private final int SCREEN_WIDTH;
	private final int SCREEN_HEIGHT;
	private final GameWindow GAME_FRAME;
	private EnumGameState gameState; 

	// Game Variables
	private int totalTime;
	private int carryScore;
	private boolean loopRun;
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
		gameState = EnumGameState.TITLE;

		// Create game window
		GAME_FRAME = new GameWindow(SCREEN_WIDTH, SCREEN_HEIGHT);

		// Initialize Game
		controlMap = new HashMap<String, ControllerScene>();
		layerMap = new HashMap<String, Component>();
		loopRun = true;
		carryScore = 0;

    // Boot-up
		initTitle();
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
			  case TUTORIAL:
			    clearWindow();
			    initTutorial();
			    gameState = EnumGameState.IN_TUTORIAL;
			    break;
			  case GAME:
			    clearWindow();
			    initGame(carryScore);
			    
			    totalTime = 0;
	        gameState = EnumGameState.IN_GAME;
			    break;
			  case IN_GAME:
			    // Only update total time if in game.
			    totalTime += 100;
			  case TITLE:
			  case IN_TUTORIAL:
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
        
        // End Game Check
        if (gameState == EnumGameState.IN_GAME && totalTime == 3000) {
          gameState = EnumGameState.END_GAME;
          endGame();
        }
      }
    });
			  
	/*		  
			  
				// Checks to see any button presses from the Title Screen
				if (gameState == EnumGameState.Tutorial.getCode()) {
					if (((ControllerTitle) controlMap.get("Title")).getAction() == 1) {
						gameState = 1;
					} else if (((ControllerTitle) controlMap.get("Title")).getAction() == 2) {
						gameState = 3;
					}
				}
				// Initializes tutorial and sets the layers
				else if (gameState == 1) {
					initTutorial();
					((ControllerTitle) controlMap.get("Title")).tutShuffle();
					gameState = 2;
					// Playing the tutorial, resets to title screen when tutorial complete
				} else if (gameState == 2) {
					if (((ControllerTutorial) controlMap.get("Tutorial")).tutorialDone()) {
						controlMap.clear();
						layerMap.clear();
						ControllerInventory.removeItem("All");
						GAME_FRAME.getMainPane().removeAll();
						controlMap.put("Title",
								new ControllerTitle(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 3));
						gameState = 0;
					}
					// Initializes game and sets the layers
				} else if (gameState == 3) {
					initGame();
					((ControllerTitle) controlMap.get("Title")).startShuffle();
					gameState = 4;
					// Playing the game, when totalTime reaches value, endgame is triggered
				} else if (gameState == 4) {
					// Update Time Counter
					totalTime += 100;
					// 5 min
					if (totalTime == 300000) {
						GAME_FRAME.getMainPane().setLayer(GAME_FRAME.getMainPane().getComponentsInLayer(-18)[0],
								EnumLayerCode.EndGame.getCode());
						gameState = 5;
					}
				} else if (gameState == 5) {
					if (((ControllerEndGame) controlMap.get("EndGame")).getReset() == true) {
						totalTime = 0;
						controlMap.clear();
						layerMap.clear();
						ControllerInventory.removeItem("All");
						GAME_FRAME.getMainPane().removeAll();
						controlMap.put("Title",
								new ControllerTitle(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 3));
						gameState = 0;
					}
					else if (((ControllerEndGame) controlMap.get("EndGame")).getCont() == true) {
						totalTime = 0;
						((ControllerEndGame) controlMap.get("EndGame")).setCont(false);
						gameState = 4;
					}
				}
*/
		timer.start(); // Start it up!
	}
	
	 /**
   * Creates title scene for initial, between
   * state, and end states.
   */
  private void initTitle() {
    controlMap.put("Title", new ControllerTitle(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 3));
    
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
    controlMap.put("Tutorial", new ControllerTutorial(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 1));
    controlMap.put("Overlay", new ControllerOverlay(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 1));
    controlMap.put("Inventory", new ControllerInventory(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 1));
    controlMap.put("HQ", new ControllerHQ(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 1, 0));
    controlMap.put("Tools", new ControllerTools(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 1));

  }

  /**
   * Initializes the game by creating the 
   * individual scenes and placing them in
   * the controller map.
   * @param score int-initial game score
   */
  private void initGame(int score) {
    controlMap.put("Mission", new ControllerMission(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 3));
    controlMap.put("HQ", new ControllerHQ(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 2, score));
    controlMap.put("Bay", new ControllerBay(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 2));
    controlMap.put("Beach", new ControllerBeach(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap,2));
    controlMap.put("Wetland", new ControllerWetland(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 2));
    controlMap.put("BeachMini", new ControllerBeachMini(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 2));
    controlMap.put("Map", new ControllerMap(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 2));
    controlMap.put("Overlay", new ControllerOverlay(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap,2));
    controlMap.put("Tools", new ControllerTools(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 2));
    controlMap.put("Inventory", new ControllerInventory(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 2));
  }
  
  /**
   * End game state.
   * <p>
   * Places the end game overlay and sets
   * listeners for state changes.
   */
  private void endGame() {
    controlMap.put("EndGame", new ControllerEndGame(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap, 2));
    
    // Continue Listener
    ((ControllerEndGame)controlMap.get("EndGame")).getContinueButton().addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          int tmpScore = Scene.getScore();
        
          clearWindow();
          gameState = EnumGameState.IN_GAME;
          initGame(tmpScore);
        }
      }
    );
    
    // Reset Listener
    ((ControllerEndGame)controlMap.get("EndGame")).getResetButton().addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          clearWindow();
          gameState = EnumGameState.TITLE;
          initTitle();
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
}
