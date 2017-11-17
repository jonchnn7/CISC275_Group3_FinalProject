package cisc275.group3.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.SceneBay;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewOverlayLabel;

/**
 * The Map controller is responsible for both the "model" 
 * and control of the map. 
 * <p>
 * This controller is only responsible for taking user input
 * and switching between game scenes. There is no
 * underlying model to manipulate. Therefore, the controller
 * also defines the JPanel and JButtons to display for
 * input.
 * <p>
 * ControllerMap.java
 * <p>
 * @author Scott
 */
public class ControllerMap extends ControllerScene {

  private JPanel mapPanel;
  private JButton hqButton;
  private JButton bayButton;
  private JButton beachButton;
  private JButton wetlandButton;
  private JButton beachMiniButton;
  private ImageIcon mapBg;
  
  public ControllerMap(int w, int h, GameWindow f, HashMap<String, Component> cl) {
    super(w, h, f, cl);
    
    mapBg = new ImageIcon("img/map_menu_icon.png");
  }
  
  @Override
  protected void createScene() {
    mapPanel = new JPanel(true) {
      @Override
      public void paintComponent(Graphics g) {
        Dimension size = new Dimension(mapBg.getIconWidth(), mapBg.getIconHeight());
        g.drawImage(mapBg.getImage(), 0, 0, size.width, size.height, this);
      }
    };
    
    mapPanel.setLayout(null);
    mapPanel.setPreferredSize(new Dimension(180, 429));
    mapPanel.setBounds(0, SCREEN_HEIGHT-mapPanel.getPreferredSize().height, mapPanel.getPreferredSize().width, SCREEN_HEIGHT);
    mapPanel.setBackground(Color.DARK_GRAY);
    mapPanel.setOpaque(true);
   
    addMapButtons();
    
    mainPane.setLayer(mapPanel, LayerCode.Map.getCode());
    mainPane.add(mapPanel, LayerCode.Map.getCode());
    componentList.put("Map", mapPanel);
  }
  
  private void addMapButtons() {
	  hqButton = new JButton("HQ");
	  hqButton.setFont(new Font("Roboto", Font.BOLD, 10));
	  hqButton.setBounds(95, 80, 75, 30);
	  
	  hqButton.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        Component hqComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("HQ")))[0];
	        
	        setDefaultLayers();
	        mainPane.setLayer(hqComponent, LayerCode.MainAll.getCode());
	        Component missionComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Mission")))[0];
	        mainPane.setLayer(missionComponent, LayerCode.Mission.getCode());
	      }
	    });
	    mapPanel.add(hqButton);
	  
    bayButton = new JButton("Bay");
    bayButton.setFont(new Font("Roboto", Font.BOLD, 10));
    bayButton.setBounds(95, 120, 75, 30);
    
    bayButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component bayComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Bay")))[0];
        
        setDefaultLayers();
        mainPane.setLayer(bayComponent, LayerCode.MainAll.getCode());
        Component missionComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Mission")))[0];
        mainPane.setLayer(missionComponent, -20);
      }
    });
    mapPanel.add(bayButton);
    
    beachButton = new JButton("Beach");
    beachButton.setFont(new Font("Roboto", Font.BOLD, 10));
    beachButton.setBounds(95, 160, 75, 30);
    
    beachButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component beachComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Beach")))[0];

        setDefaultLayers();
        mainPane.setLayer(beachComponent, LayerCode.MainAll.getCode());
        Component missionComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Mission")))[0];
        mainPane.setLayer(missionComponent, -20);
      }
    });
    mapPanel.add(beachButton);
    
    wetlandButton = new JButton("Wetland");
    wetlandButton.setFont(new Font("Roboto", Font.BOLD, 10));
    wetlandButton.setBounds(95, 200, 75, 30);
    
    wetlandButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component wetlandComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Wetland")))[0];
          
        setDefaultLayers();
        mainPane.setLayer(wetlandComponent, LayerCode.MainAll.getCode());
        Component missionComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Mission")))[0];
        mainPane.setLayer(missionComponent, -20);
      }
    });
    mapPanel.add(wetlandButton);
    
    beachMiniButton = new JButton("BEACH MINIGAME");
    beachMiniButton.setFont(new Font("Roboto", Font.BOLD, 14));
    beachMiniButton.setBounds(20, 400, 160, 30);
    
    beachMiniButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component beachMiniComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("BeachMini")))[0];
        
        setDefaultLayers();
        mainPane.setLayer(beachMiniComponent, LayerCode.MainMapToolsTime.getCode());
        Component missionComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Mission")))[0];
        mainPane.setLayer(missionComponent, -20);
      }
    });
    mapPanel.add(beachMiniButton);
  }

  /**
   * Every button press sets all but one layer
   * to its default layer. This method 
   * condenses that code.
   */
  private void setDefaultLayers() {
    Component mapComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Map")))[0];
    Component hqComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("HQ")))[0];
    Component bayComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Bay")))[0];
    Component beachComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Beach")))[0];
    Component wetlandComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Wetland")))[0];
    Component beachMiniComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("BeachMini")))[0];
    Component titleComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Title")))[0];
      
    mainPane.setLayer(mapComponent, LayerCode.Map.getCode());
    mainPane.setLayer(hqComponent, LayerCode.HQ.getCode());
    mainPane.setLayer(bayComponent, LayerCode.Bay.getCode());
    mainPane.setLayer(beachComponent, LayerCode.Beach.getCode());
    mainPane.setLayer(wetlandComponent, LayerCode.Wetland.getCode());
    mainPane.setLayer(beachMiniComponent, LayerCode.BeachMini.getCode());
    mainPane.setLayer(titleComponent, LayerCode.Title.getCode());
    
    Scene.setCurrentTool(null);
  }
}
