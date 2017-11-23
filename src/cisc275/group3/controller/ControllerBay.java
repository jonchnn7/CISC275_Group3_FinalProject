package cisc275.group3.controller;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import cisc275.group3.model.scene.SceneBay;
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
public class ControllerBay extends ControllerScene implements LinkDynamics, LinkTime {
  private final String BG_IMAGE = "img/bay_bg_1.jpg";
  
  public ControllerBay(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
    super(w, h, f, cl, sceneType);
  }

  @Override
  protected void createScene(int sceneType) {    
    scene = new SceneBay("Bay", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, BG_IMAGE, sceneType);
    viewGame = new ViewGame(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), scene.getManifest().getBG());
    

    viewGame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    viewGame.setName("BayLayer");
    
    mainPane.setLayer(viewGame, LayerCode.Bay.getCode());
    mainPane.add(viewGame, LayerCode.Bay.getCode());
    
    componentList.put("Bay", viewGame);
  
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
            ((SceneBay)scene).updateScore();
            displayScore();
            displayMission();
          }
        }
      }
    });
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
      ((SceneBay)scene).update();
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
    ((SceneBay)scene).updateTime();
    
    if (mainPane.getLayer(componentList.get("Bay")) == LayerCode.MainAll.getCode()) {
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
    
    sceneTime = Integer.toString(((SceneBay)scene).getTime());
    ((ViewOverlayLabel)componentList.get("TimeLabel")).updateLabel(sceneTime);
  }
  
  /**
   * Displays the model score in the shared score 
   * label.
   */
  public void displayScore() {
    String sceneScore;
    
    sceneScore = Integer.toString(((SceneBay)scene).getScore());
    ((ViewOverlayLabel)componentList.get("ScoreLabel")).updateLabel(sceneScore);
  }
}
