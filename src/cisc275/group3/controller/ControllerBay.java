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
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;
import cisc275.group3.view.SceneView;

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
 */
public class ControllerBay extends ControllerScene implements LinkDynamics {
  private final String BG_IMAGE = "img/bay_bg_1.jpg";
  
  public ControllerBay(int w, int h, GameWindow f, HashMap<String, Component> cl) {
    super(w, h, f, cl);
  }

  @Override
  protected void createScene() {    
    scene = new SceneBay("Bay", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, BG_IMAGE);
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
          if ( scene.processClick(e.getX(), e.getY()) ) {
            ((SceneBay)scene).updateScore();
            //sceneView.updateScore(((SceneBay)scene).getScore());
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
    if (mainPane.getLayer(componentList.get("Bay")) == LayerCode.Main.getCode()) {
      ((SceneBay)scene).update();
      viewGame.updatePanel(scene.getSceneItems());
    }
  }

  /**
   * Updates the model's time variable and shares it with
   * the view.
   * <p>
   * Overridden from interface LinkTime.java
   */
/*  public void updateTime() {
    ((SceneBay)scene).updateTime();
    sceneView.updateTime(((SceneBay)scene).getTime());
  }
*/
}
