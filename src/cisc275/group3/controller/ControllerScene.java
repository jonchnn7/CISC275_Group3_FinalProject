package cisc275.group3.controller;

import javax.swing.JButton;
import javax.swing.JLayeredPane;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.HashMap;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;
import cisc275.group3.view.SceneView;

/**
 * Abstract controller class for scene logic and actions. This
 * class is necessary so all controllers can be held within a
 * collection.
 * <p>
 * ControllerScene.java
 * <p>
 * @author Scott
 */
public abstract class ControllerScene implements Serializable {
  // Window Parameters
  protected final int SCREEN_WIDTH;
  protected final int SCREEN_HEIGHT;
  protected final GameWindow GAME_FRAME;
  
  // Scene Variables
  protected Scene scene;
  protected ViewGame viewGame;
  protected static HashMap<String, Component> componentList;
  
  // Window Components
  protected JLayeredPane mainPane;
  
  /**
   * Abstract Scene Controller Constructor
   * <p>
   * Sets the  with, height and frame variables.
   * <p>
   * Updates the static componentList that holds the layer depths
   * for the JComponentLayer. This is necessary to retrieve layer
   * information.
   * @param w	int-scene width
   * @param h 	int-scene height
   * @param f 	GameWindow-JFrame container
   * @param cl 	HashMap-associations of scene controllers and layers
   */
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
  
  /**
   * Adds a mouse listener to the scene background and passes clicks
   * through to the model. 
   * <p>
   * Note: If the model implements scored, this must be overridden.
   */
  protected void addML() {
    viewGame.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
          String cursorName = mainPane.getComponentsInLayer(LayerCode.MainAll.getCode())[0].getCursor().getName();
          if ( scene.processClick(e.getX(), e.getY(), cursorName) ) {
            //scene.updateScore();
          }
        }
      }
    });
  }
}