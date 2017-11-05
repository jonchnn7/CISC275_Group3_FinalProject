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

public class MapController extends SceneController {

  private JPanel mapPanel;
  private JButton bayButton;
  private JButton beachMiniButton;
  
  public MapController(int w, int h, GameWindow f, HashMap<String, Component> cl) {
    super(w, h, f, cl);
  }
  
  @Override
  protected void createScene() {
    mapPanel = new JPanel(true);
    mapPanel.setLayout(null);
    mapPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    mapPanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    mapPanel.setBackground(Color.getHSBColor(195f, .02f, .93f));
    mapPanel.setOpaque(true);
    
    addMapButtons();
    
    sceneView = new SceneView(SCREEN_WIDTH, SCREEN_HEIGHT, mapPanel);
    
    sceneView.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    sceneView.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    sceneView.setName("MapLayer");
    
    mainPane.setLayer(sceneView, LayerCode.Map.getCode());
    mainPane.add(sceneView, LayerCode.Map.getCode());
    
    componentList.put("Map", sceneView);
  
    addMapButton();
  }
  
  private void addMapButtons() {
    bayButton = new JButton("BAY");
    bayButton.setFont(new Font("Roboto", Font.BOLD, 36));
    bayButton.setBounds(550, 200, 200, 100);
    
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
    beachMiniButton.setBounds(471, 320, 350, 100);
    
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
