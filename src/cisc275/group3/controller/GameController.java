package cisc275.group3.controller;

import cisc275.group3.view.GameWindow;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.Timer;


public class GameController {
  
  // Game Parameters
  private final int SCREEN_WIDTH;
  private final int SCREEN_HEIGHT;
  private final GameWindow GAME_FRAME;
  
  // Game Variables
  private int totalTime;
  private HashMap<String, SceneController> controlMap;
  private HashMap<String, Component> layerMap;
  
  public GameController(int x, int y) {
    SCREEN_WIDTH = x;
    SCREEN_HEIGHT = y;
    
    // Create game window
    GAME_FRAME = new GameWindow(SCREEN_WIDTH, SCREEN_HEIGHT);
    
    // Initialize Game
    controlMap = new HashMap<String, SceneController>();
    layerMap = new HashMap<String, Component>();
    initGame();
  }
    
  private void initGame() {
    controlMap.put("Bay", new BayController(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap));
    controlMap.put("Map", new MapController(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap));
    controlMap.put("BeachMini", new BeachMiniController(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap));
    gameTime();
  }
    
   
  /**
   * Updates the model and display every 100ms
   */
  private void gameTime() { 
    Timer timer = new Timer(100, new ActionListener() {
      public void actionPerformed(ActionEvent e) { 
        controlMap.forEach((k,v)->{
          if (k == "Bay") {
            ((BayController)v).update();
            if (totalTime % 1000 == 0) { ((BayController)v).updateTime(); }
         
          } else if (k == "BeachMini") {
            ((BeachMiniController)v).update();
            if (totalTime % 1000 == 0) { ((BeachMiniController)v).updateTime(); }              
          }  
        });
        totalTime += 100;
      }
    });
    timer.start();
  }
}
