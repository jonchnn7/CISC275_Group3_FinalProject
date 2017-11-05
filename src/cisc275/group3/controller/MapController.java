package cisc275.group3.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JPanel;

import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.SceneView;

public class MapController extends SceneController {

  private JPanel mapPanel;
  
  public MapController(int w, int h, GameWindow f, HashMap<String, Component> cl) {
    super(w, h, f, cl);
  }
  
  @Override
  protected void createScene() {
    mapPanel = new JPanel(true);
    mapPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    mapPanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    mapPanel.setBackground(Color.darkGray);
    mapPanel.setOpaque(true);
    
    sceneView = new SceneView(SCREEN_WIDTH, SCREEN_HEIGHT, mapPanel);
    
    sceneView.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    sceneView.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    sceneView.setName("MapLayer");
    
    mainPane.setLayer(sceneView, LayerCode.Map.getCode());
    mainPane.add(sceneView, LayerCode.Map.getCode());
    
    componentList.put("Map", sceneView);
  
    addMapButton();
  }

  @Override
  protected void addML() {
  }
  
  @Override
  protected void addMapButton() {
    mapButton = sceneView.getMapButton();
    
    mapButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component mapComponent = mainPane.getComponentsInLayer(LayerCode.Overlay.getCode())[0];
        mainPane.setLayer(mapComponent, LayerCode.Map.getCode());
      }
    });
  }
  
  @Override
  public void update() {
  }
}
