package cisc275.group3.controller;

import java.awt.Component;
import java.util.HashMap;
import cisc275.group3.model.scene.SceneTutorial;
import cisc275.group3.model.scene.Scene;
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
 * See cisc275.group3.controller.ControllerScene.java
 * <p>
 * ControllerBay.java
 * <p>
 * @author Scott 
 * @author Jon 
 * @author Jolyne 
 */
public class ControllerTutorial extends ControllerScene implements LinkDynamics, LinkTime {
  private final String BG_IMAGE = "img/tutorial_bg.jpg";
  
  public ControllerTutorial(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
    super(w, h, f, cl, sceneType);
  }

  @Override
  protected void createScene(int sceneType) {    
    scene = new SceneTutorial("Tutorial", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, BG_IMAGE, sceneType);
    viewGame = new ViewGame(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), scene.getManifest().getBG());
    

    viewGame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    viewGame.setName("TutorialLayer");
    
    mainPane.setLayer(viewGame, LayerCode.Tutorial.getCode());
    mainPane.add(viewGame, LayerCode.Tutorial.getCode());
    
    componentList.put("Tutorial", viewGame);
  
   addML();
  }

  /**
   * Connects the Bay model and Bay view. So long as the Bay 
   * scene is the active pane, update the model and then pass 
   * the updated scene objects to the view.
   * <p>
   * Overridden from interface LinkDynamics.java
   */
  @Override
  public void update() {
    if (mainPane.getLayer(componentList.get("Bay")) == LayerCode.MainAll.getCode()) {
      // Update Model
      scene.update();
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
    ((LinkTime)scene).updateTime();
    
    if (mainPane.getLayer(componentList.get("Tutorial")) == LayerCode.MainAll.getCode()) {
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
    
    sceneTime = Integer.toString(scene.getTime());
    ((ViewOverlayLabel)componentList.get("TimeLabel")).updateLabel(sceneTime);
  }
}