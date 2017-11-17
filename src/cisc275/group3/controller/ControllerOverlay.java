package cisc275.group3.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.ImageIcon;

import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewOverlayButton;
import cisc275.group3.view.ViewOverlayLabel;

/** 
 * Responsible for creating the interface overlay buttons/labels,
 * and adding them to the main JLayeredPane (from GameWindow.java).
 * After the button has been added, the associated action listener 
 * and action is added.
 * <p>
 * @author Scott
 */
public class ControllerOverlay extends ControllerScene {
  private ImageIcon mapButtonImage;
  private ImageIcon mapButtonRolloverImage;
  private int mapButtonWidth;
  private int mapButtonHeight;
  private ViewOverlayButton mapButtonPanel;
  
  private ImageIcon toolsButtonImage;
  private ImageIcon toolsButtonRolloverImage;
  private int toolsButtonWidth;
  private int toolsButtonHeight;
  private ViewOverlayButton toolsButtonPanel;
  
  private ImageIcon timeLabelBg;
  private ImageIcon timeLabelImage;
  private int timeLabelWidth;
  private int timeLabelHeight;
  private String timeLabelString;
  private ViewOverlayLabel timeLabelPanel;
  
  private ImageIcon scoreLabelBg;
  private ImageIcon scoreLabelImage;
  private int scoreLabelWidth;
  private int scoreLabelHeight;
  private String scoreLabelString;
  private ViewOverlayLabel scoreLabelPanel;
  
  private ImageIcon inventoryButtonImage;
  private ImageIcon inventoryButtonRolloverImage;
  private int inventoryButtonWidth;
  private int inventoryButtonHeight;
  private ViewOverlayButton inventoryButtonPanel;

  /**
   * Default scene controller parameters. After they are 
   * passed to super(), the menu button/label parameters
   * are set.
   * <p>
   * @param w   int-width
   * @param h   int-height
   * @param f   GameWindow-main game window
   * @param cl  HashMap-map of component name to component
   */
  public ControllerOverlay(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
    super(w, h, f, cl, sceneType);
    
    // Map Button Parameters
    mapButtonImage = new ImageIcon("img/map_icon.png");
    mapButtonRolloverImage = new ImageIcon("img/map_icon_invert.png");
    mapButtonWidth = 75;
    mapButtonHeight = 75;
    
    // Tool Button Parameters
    toolsButtonImage = new ImageIcon("img/toolbox_menu.png");
    toolsButtonRolloverImage = new ImageIcon("img/toolbox_menu_invert.png");
    toolsButtonWidth = 107;
    toolsButtonHeight = 70;
    
    // Score Label Parameters
    scoreLabelBg = new ImageIcon("img/time_bg.png");
    scoreLabelImage = new ImageIcon("img/coins_icon.png");
    scoreLabelWidth = 110;
    scoreLabelHeight = 70;
    scoreLabelString = "0";
    
    // Time Label Parameters
    timeLabelBg = new ImageIcon("img/time_bg.png");
    timeLabelImage = new ImageIcon("img/clock_icon.png");
    timeLabelWidth = 150;
    timeLabelHeight = 85;
    timeLabelString = "0";
    
    //Inventory Button Parameters
    inventoryButtonImage = new ImageIcon("img/inventory.png");
    inventoryButtonRolloverImage = new ImageIcon("img/inventory.png");
    inventoryButtonWidth = 100;
    inventoryButtonHeight = 130;

    
    createScene(sceneType);
  }

  /**
   * Call private functions to create and 
   * add individual interface buttons.
   * <p>
   * Overridden from ControllerScene.java
   */
  @Override
  protected void createScene(int sceneType) {
    // Create Buttons
    createMapButton();
    createToolsButton();
    
    // Create Labels
    createScoreLabel();
    createTimeLabel();
    
  }
  
  /**
   * Creates the map JPanel/JButton combination
   * and places it inside the game window at
   * its defined layer. An action is then created
   * to toggle moving the map (ControllerMap.java)
   * between the overlay layer and its hidden 
   * storage layer.
   */
  private void createMapButton() {
    mapButtonPanel = new ViewOverlayButton(mapButtonImage, mapButtonRolloverImage, mapButtonWidth, mapButtonHeight);
    mapButtonPanel.setBounds(180, SCREEN_HEIGHT-mapButtonHeight, mapButtonWidth, mapButtonHeight);
    mapButtonPanel.setName("MapButton");
    
    mainPane.setLayer(mapButtonPanel, LayerCode.MapButton.getCode());
    mainPane.add(mapButtonPanel, LayerCode.MapButton.getCode());
	    
    componentList.put("MapButton", mapButtonPanel);
    
    mapButtonPanel.getOverButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component mapComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Map")))[0];
         
        if (mainPane.getLayer(mapComponent) == LayerCode.Map.getCode()) {
          mainPane.setLayer(mapComponent, LayerCode.MapOverlay.getCode());
        } else {
          mainPane.setLayer(mapComponent, LayerCode.Map.getCode());
        }
      }
    });
  }
  
  /**
   * Creates the tools JPanel/JButton combination
   * and places it inside the game window at
   * its defined layer. An action is then created
   * to toggle moving the toolbox 
   * (ControllerTools.java) between the overlay 
   * layer and its hidden storage layer.
   */
  private void createToolsButton() {
    toolsButtonPanel = new ViewOverlayButton(toolsButtonImage, toolsButtonRolloverImage, toolsButtonWidth, toolsButtonHeight);
    toolsButtonPanel.setBounds(SCREEN_WIDTH-75-toolsButtonWidth, 0, toolsButtonWidth, toolsButtonHeight);
    toolsButtonPanel.setName("ToolsButton");
      
    mainPane.setLayer(toolsButtonPanel, LayerCode.ToolsButton.getCode());
    mainPane.add(toolsButtonPanel, LayerCode.ToolsButton.getCode());
          
    componentList.put("ToolsButton", toolsButtonPanel);
      
    toolsButtonPanel.getOverButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component mapComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Tools")))[0];
           
        if (mainPane.getLayer(mapComponent) == LayerCode.Tools.getCode()) {
          mainPane.setLayer(mapComponent, LayerCode.ToolsOverlay.getCode()); 
        } else {
          mainPane.setLayer(mapComponent, LayerCode.Tools.getCode());
        }
      }
    });    
  }
  
  /**
   * Creates the score JPanel/JLabel combination
   * and places it inside the game window at
   * its defined layer. 
   */
  private void createScoreLabel() {
    scoreLabelPanel = new ViewOverlayLabel(scoreLabelImage, scoreLabelBg, scoreLabelWidth, scoreLabelHeight, scoreLabelString);
    scoreLabelPanel.setBounds(SCREEN_WIDTH-2*scoreLabelWidth, SCREEN_HEIGHT-scoreLabelHeight, scoreLabelWidth, scoreLabelHeight);
    scoreLabelPanel.setName("ScoreLabel");
    
    mainPane.setLayer(scoreLabelPanel, LayerCode.ScoreLabel.getCode());
    mainPane.add(scoreLabelPanel, LayerCode.ScoreLabel.getCode());
    
    componentList.put("ScoreLabel", scoreLabelPanel);
  }
  
  /**
   * Creates the time JPanel/JLabel combination
   * and places it inside the game window at
   * its defined layer. 
   */
  private void createTimeLabel() {
    timeLabelPanel = new ViewOverlayLabel(timeLabelImage, timeLabelBg, timeLabelWidth, timeLabelHeight, timeLabelString);
    timeLabelPanel.setBounds((SCREEN_WIDTH-timeLabelWidth)/2, SCREEN_HEIGHT-timeLabelHeight, timeLabelWidth, timeLabelHeight);
    timeLabelPanel.setName("TimeLabel");
    
    mainPane.setLayer(timeLabelPanel, LayerCode.TimeLabel.getCode());
    mainPane.add(timeLabelPanel, LayerCode.TimeLabel.getCode());
    
    componentList.put("TimeLabel", timeLabelPanel);
  }
}
