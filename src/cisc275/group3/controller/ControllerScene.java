package cisc275.group3.controller;

import javax.swing.JButton;
import javax.swing.JLayeredPane;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.HashMap;
import java.awt.event.MouseEvent;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.SceneLayer;
import cisc275.group3.view.SceneView;

/**
 * Abstract controller class for scene logic and actions. This
 * class is necessary so all controllers can be held within a
 * collection.
 */
public abstract class ControllerScene {
  // Window Parameters
  protected final int SCREEN_WIDTH;
  protected final int SCREEN_HEIGHT;
  protected final GameWindow GAME_FRAME;
  
  // Scene Variables
  protected Scene scene;
  protected SceneLayer sceneLayer;
  protected SceneView sceneView;
  protected static HashMap<String, Component> componentList;
  
  // Window Components
  protected JButton mapButton;
  protected JLayeredPane mainPane;
  
  public ControllerScene(int w, int h, GameWindow f, HashMap<String, Component> cl) {
    SCREEN_WIDTH = w;
    SCREEN_HEIGHT = h;
    GAME_FRAME = f;
 
    componentList = cl;
    mainPane = GAME_FRAME.getMainPane();
    createScene();
  }
  
  /**
   * Constructs a scene by creating the model, view background, and
   * overlay. A mouse listener is then added to the view background
   * to pass clicks through to the scene model.
   * <p>
   * The view overlay uses JLayeredPane to place the toolbar items 
   * in the foreground and the game panel in the background.
   * <p>
   * Note: This method must be overridden
   */
  abstract protected void createScene();
  
  abstract protected void update();
  
  /**
   * Adds a mouse listener to the scene background and passes clicks
   * through to the model. 
   * <p>
   * Note: If the model implements scored, this must be overridden.
   */
  protected void addML() {
    sceneLayer.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
          if ( scene.processClick(e.getX(), e.getY()) ) {
            //scene.updateScore();
          }
        }
      }
    });
  }
  
  /**
   * Grabs the map menu button and adds an action. If the map is
   * currently in the map layer, move it to the overlay layer.
   * Otherwise, do the opposite to hide it.
   */
  protected void addMapMenuButton() {
    mapButton = sceneView.getMapButton();
	    
    mapButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component mapComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Map")))[0];
        
        if (mainPane.getLayer(mapComponent) == LayerCode.Map.getCode()) {
          mainPane.setLayer(mapComponent, LayerCode.Overlay.getCode()); 
        } else {
          mainPane.setLayer(mapComponent, LayerCode.Map.getCode());
        }
      }
    });
  }
}