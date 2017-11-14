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
import cisc275.group3.model.scene.SceneWetland;
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
 * @author Scott
 * <p>
 * @author Jolyne
 */
public class ControllerWetland extends ControllerScene implements LinkDynamics, LinkTime {
  private final String BG_IMAGE = "img/wetland_bg.jpg";
  
  public ControllerWetland(int w, int h, GameWindow f, HashMap<String, Component> cl) {
    super(w, h, f, cl);
  }

  @Override
  protected void createScene() {    
    scene = new SceneWetland("Wetland", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, BG_IMAGE);
    viewGame = new ViewGame(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), scene.getManifest().getBG());
    

    viewGame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    viewGame.setName("WetlandLayer");
    
    mainPane.setLayer(viewGame, LayerCode.Wetland.getCode());
    mainPane.add(viewGame, LayerCode.Wetland.getCode());
    
    componentList.put("Wetland", viewGame);
  
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
            ((SceneWetland)scene).updateScore();
            displayScore();
          }
        }
      }
    });
  }

  /**
   * Connects the Wetland model and Wetland view. So long as the Wetland
   * scene is the active pane, update the model and then pass 
   * the updated scene objects to the view.
   * <p>
   * Overridden from interface LinkDynamics.java
   */
  @Override
  public void update() {
    if (mainPane.getLayer(componentList.get("Wetland")) == LayerCode.MainAll.getCode()) {
      // Update Model
      ((SceneWetland)scene).update();
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
    ((SceneWetland)scene).updateTime();
    
    if (mainPane.getLayer(componentList.get("Wetland")) == LayerCode.MainAll.getCode()) {
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
    
    sceneTime = Integer.toString(((SceneWetland)scene).getTime());
    ((ViewOverlayLabel)componentList.get("TimeLabel")).updateLabel(sceneTime);
  }
  
  /**
   * Displays the model score in the shared score 
   * label.
   */
  public void displayScore() {
    String sceneScore;
    
    sceneScore = Integer.toString(((SceneWetland)scene).getScore());
    ((ViewOverlayLabel)componentList.get("ScoreLabel")).updateLabel(sceneScore);
  }
}
