package cisc275.group3.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.SceneView;

/**
 * Map Controller is responsible for both the "model" and
 * control of the map. There are no objects in the map 
 * scene that aren't clickable (buttons/images/labels), so
 * this controller constructs the background panel.
 */
public class ControllerMap extends ControllerScene {

  private JPanel mapPanel;
  private JButton bayButton;
  private JButton beachMiniButton;
  
  public ControllerMap(int w, int h, GameWindow f, HashMap<String, Component> cl) {
    super(w, h, f, cl);
  }
  
  @Override
  protected void createScene() {
    mapPanel = new JPanel(true);
    mapPanel.setLayout(null);
    mapPanel.setPreferredSize(new Dimension(SCREEN_WIDTH-200, SCREEN_HEIGHT-200));
    mapPanel.setBounds(100, 100, SCREEN_WIDTH-200, SCREEN_HEIGHT-200);
    mapPanel.setBackground(Color.DARK_GRAY);
    mapPanel.setOpaque(true);
   
    addMapButtons();
    
    mainPane.setLayer(mapPanel, LayerCode.Map.getCode());
    mainPane.add(mapPanel, LayerCode.Map.getCode());
    /*
    sceneView = new SceneView(SCREEN_WIDTH, SCREEN_HEIGHT, mapPanel);
    
    sceneView.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    sceneView.setBounds(100, 100, SCREEN_WIDTH-200, SCREEN_HEIGHT-200);
    sceneView.setName("MapLayer");
    
    mainPane.setLayer(sceneView, LayerCode.Map.getCode());
    mainPane.add(sceneView, LayerCode.Map.getCode());
    */
    componentList.put("Map", mapPanel);
  }
  
  private void addMapButtons() {
    bayButton = new JButton("BAY");
    bayButton.setFont(new Font("Roboto", Font.BOLD, 36));
    bayButton.setBounds(445, 100, 200, 100);
    
    bayButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component mapComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Map")))[0];
        Component bayComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Bay")))[0];
        Component beachMiniComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("BeachMini")))[0];
        
        mainPane.setLayer(mapComponent, LayerCode.Map.getCode());
        mainPane.setLayer(bayComponent, LayerCode.Main.getCode());
        mainPane.setLayer(beachMiniComponent, LayerCode.BeachMini.getCode());
      }
    });
    mapPanel.add(bayButton);
    
    beachMiniButton = new JButton("BEACH MINIGAME");
    beachMiniButton.setFont(new Font("Roboto", Font.BOLD, 36));
    beachMiniButton.setBounds(371, 220, 350, 100);
    
    beachMiniButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component mapComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Map")))[0];
        Component bayComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Bay")))[0];
        Component beachMiniComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("BeachMini")))[0];
        
        mainPane.setLayer(mapComponent, LayerCode.Map.getCode());
        mainPane.setLayer(bayComponent, LayerCode.Bay.getCode());
        mainPane.setLayer(beachMiniComponent, LayerCode.Main.getCode());
      }
    });
    mapPanel.add(beachMiniButton);
  }

  @Override
  protected void addML() {
  }
  
  @Override
  protected void addMapMenuButton() {
  /*  
    mapButton = sceneView.getMapButton();
    
    mapButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component mapComponent = mainPane.getComponentsInLayer(LayerCode.Overlay.getCode())[0];
        mainPane.setLayer(mapComponent, LayerCode.Map.getCode());
      }
    });
  */
  }
  
  @Override
  public void update() {
  }
}
