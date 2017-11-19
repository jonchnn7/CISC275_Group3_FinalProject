package cisc275.group3.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import cisc275.group3.model.scene.SceneBay;
import cisc275.group3.model.scene.SceneBeach;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;
import cisc275.group3.view.ViewOverlayLabel;

/**
 * Contains the controller actions and logic for SceneBay.java.
 * <p>
 * Extends the abstract ConstrollerScene class and adds dynamics
 * and timing attributes. Those interfaces require the controller
 * to pass an update call to the model on every timer tick, and
 * to update the time every second.
 * <p>
 * @see ControllerScene.java
 * <p>
 * ControllerBay.java
 * <p>
 * @author Jon
 * @author Ryan
 */
public class ControllerBeach extends ControllerScene implements LinkDynamics, LinkTime {
  private final String BG_IMAGE = "img/beach_bg.jpg";

  
  public ControllerBeach(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
    super(w, h, f, cl, sceneType);
  }

  @Override
  protected void createScene(int sceneType) {    
    scene = new SceneBeach("Beach", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, sceneType, BG_IMAGE);
    viewGame = new ViewGame(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), scene.getManifest().getBG());
    

    viewGame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    viewGame.setName("BeachLayer");
    
    mainPane.setLayer(viewGame, LayerCode.Beach.getCode());
    mainPane.add(viewGame, LayerCode.Beach.getCode());
    
    componentList.put("Beach", viewGame);
  
   addML();
  }

  @Override
  protected void addML() {
    viewGame.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {

          //String cursorName = mainPane.getComponentsInLayer(LayerCode.MainMapTools.getCode())[0].getCursor().getName();
        	String cursorName = "";

          if ( scene.processClick(e.getX(), e.getY(), cursorName) ) {
            ((SceneBeach)scene).updateScore();
            displayScore();
            displayMission();
          }
        }
      }
    });
  }

  /**
   * Connects the Beach model and Beach view. So long as the Beach
   * scene is the active pane, update the model and then pass 
   * the updated scene objects to the view.
   * <p>
   * Overridden from interface LinkDynamics.java
   */
  @Override
  public void update() {
    if (mainPane.getLayer(componentList.get("Beach")) == LayerCode.MainAll.getCode()) {
      // Update Model
      ((SceneBeach)scene).update();
      viewGame.updatePanel(scene.getSceneItems());
    }
  }

  /**
   * Updates the model's time variable and calls
   * displayTime() to share it with the view.
   * <p>
   * Overridden from interface LinkTime.java
   */
  @Override
  public void updateTime() {
    ((SceneBeach)scene).updateTime();
    
    if (mainPane.getLayer(componentList.get("Beach")) == LayerCode.MainAll.getCode()) {
      displayTime();
    }
  }
  
  /**
   * Displays the model time in the shared time 
   * label.
   * <p>
   * Overridden from interface LinkTime.java
   */
  @Override
  public void displayTime() {
    String sceneTime;
    
    sceneTime = Integer.toString(((SceneBeach)scene).getTime());
    ((ViewOverlayLabel)componentList.get("TimeLabel")).updateLabel(sceneTime);
  }
  
  /**
   * Displays the model score in the shared score 
   * label.
   */
  public void displayScore() {
    String sceneScore;
    
    sceneScore = Integer.toString(((SceneBeach)scene).getScore());
    ((ViewOverlayLabel)componentList.get("ScoreLabel")).updateLabel(sceneScore);
  }
}
