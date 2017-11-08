package cisc275.group3.controller;

import cisc275.group3.view.GameWindow;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.Timer;


public class GameController implements Serializable {
  
  // Game Parameters
  private final int SCREEN_WIDTH;
  private final int SCREEN_HEIGHT;
  private final GameWindow GAME_FRAME;
  
  // Game Variables
  private int totalTime;
  private HashMap<String, ControllerScene> controlMap;
  private HashMap<String, Component> layerMap;
  
  public GameController(int x, int y) {
    SCREEN_WIDTH = x;
    SCREEN_HEIGHT = y;
    
    // Create game window
    GAME_FRAME = new GameWindow(SCREEN_WIDTH, SCREEN_HEIGHT);
    
    // Initialize Game
    controlMap = new HashMap<String, ControllerScene>();
    layerMap = new HashMap<String, Component>();
    initGame();
  }
    
  private void initGame() {
    controlMap.put("Bay", new ControllerBay(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap));
    controlMap.put("BeachMini", new ControllerBeachMini(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap));
    controlMap.put("Map", new ControllerMap(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap));
    controlMap.put("Title", new ControllerTitle(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_FRAME, layerMap));
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
            ((ControllerBay)v).update();
            if (totalTime % 1000 == 0) { ((ControllerBay)v).updateTime(); }
         
          } else if (k == "BeachMini") {
            ((ControllerBeachMini)v).update();
            if (totalTime % 1000 == 0) { ((ControllerBeachMini)v).updateTime(); }              
          }  
        });
        totalTime += 100;
      }
    });
    timer.start();
  }
}
