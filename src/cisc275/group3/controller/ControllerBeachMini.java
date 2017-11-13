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
import cisc275.group3.model.scene.SceneBeachMini;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;
import cisc275.group3.view.ViewOverlayLabel;
import cisc275.group3.view.SceneView;

/**
 * Contains the controller actions and logic for SceneBeachMini.java.
 * <p>
 * Extends the abstract ConstrollerScene class and adds dynamics
 * and timing attributes. Those interfaces require the controller
 * to pass an update call to the model on every timer tick, and
 * to update the time every second.
 * <p>
 * @see ControllerScene.java
 * <p>
 * ControllerBeachMini.java
 * <p>
 * @author Scott
 */
public class ControllerBeachMini extends ControllerScene implements LinkDynamics, LinkTime {
  private final String BG_IMAGE = "img/beach_sand_bg.png";
  
  public ControllerBeachMini(int w, int h, GameWindow f, HashMap<String, Component> cl) {
    super(w, h, f, cl);
  }

  @Override
  protected void createScene() {
    scene = new SceneBeachMini("Bay", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, BG_IMAGE);
    viewGame = new ViewGame(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), scene.getManifest().getBG());
    
    
    viewGame.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    viewGame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    viewGame.setDoubleBuffered(true);
    viewGame.setName("BeachMiniLayer");
    
    mainPane.setLayer(viewGame, LayerCode.BeachMini.getCode());
    mainPane.add(viewGame, LayerCode.BeachMini.getCode());
    
    componentList.put("BeachMini", viewGame);
  
    addML();
  }

  @Override
  protected void addML() {
    viewGame.addMouseMotionListener(new MouseAdapter() {
      int initialX;
      
      @Override
      public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
          initialX = e.getX();
        }
      }
      
      @Override
      public void mouseDragged(MouseEvent e) {
        ((SceneBeachMini)scene).update(0.004*(e.getX()-initialX));
      }
    });
  }
  
  /**
   * Connects the BeachMinigame model and BeachMinigame view. So
   * long as the Beach Minigame is the active pane, update the 
   * model and then pass the updated scene objects to the view.
   * <p>
   * Overridden from interface LinkDynamics.java
   */
  @Override
  public void update() {
	if (mainPane.getLayer(componentList.get("BeachMini")) == LayerCode.MainToolsTime.getCode()) {
      ((SceneBeachMini)scene).update();
      viewGame.updatePanel(scene.getSceneItems());
	}
  }
  
  /**
   * Updates the model's time variable and shares it with
   * the view.
   * <p>
   * Overridden from interface LinkTime.java
   */
  @Override
  public void updateTime() {
    ((SceneBeachMini)scene).updateTime();
      
    if (mainPane.getLayer(componentList.get("BeachMini")) == LayerCode.MainToolsTime.getCode()) {
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
    
    sceneTime = Integer.toString(((SceneBeachMini)scene).getTime());
    ((ViewOverlayLabel)componentList.get("TimeLabel")).updateLabel(sceneTime);
  }
  
  /**
   * Displays the model score in the shared score 
   * label.
   */
  /*public void displayScore() {
    String sceneScore;
    
    sceneScore = Integer.toString(((SceneBeachMini)scene).getScore());
    ((ViewOverlayLabel)componentList.get("ScoreLabel")).updateLabel(sceneScore);
  }*/
}
