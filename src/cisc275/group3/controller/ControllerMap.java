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

import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.SceneView;

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
  private JButton bayButton;
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
    bayButton = new JButton("BAY");
    bayButton.setFont(new Font("Roboto", Font.BOLD, 18));
    bayButton.setBounds(95, 120, 75, 30);
    
    bayButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component mapComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Map")))[0];
        Component bayComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Bay")))[0];
        Component beachMiniComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("BeachMini")))[0];
        Component titleComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Title")))[0];
        
        mainPane.setLayer(mapComponent, LayerCode.Map.getCode());
        mainPane.setLayer(bayComponent, LayerCode.MainMapTools.getCode());
        mainPane.setLayer(beachMiniComponent, LayerCode.BeachMini.getCode());
        mainPane.setLayer(titleComponent, LayerCode.Title.getCode());

      }
    });
    mapPanel.add(bayButton);
    
    beachMiniButton = new JButton("BEACH MINIGAME");
    beachMiniButton.setFont(new Font("Roboto", Font.BOLD, 14));
    beachMiniButton.setBounds(20, 400, 160, 30);
    
    beachMiniButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component mapComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Map")))[0];
        Component bayComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Bay")))[0];
        Component beachMiniComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("BeachMini")))[0];
        Component titleComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Title")))[0];
        
        mainPane.setLayer(mapComponent, LayerCode.Map.getCode());
        mainPane.setLayer(bayComponent, LayerCode.Bay.getCode());
        mainPane.setLayer(beachMiniComponent, LayerCode.MainMapTools.getCode());
        mainPane.setLayer(titleComponent, LayerCode.Title.getCode());
      }
    });
    mapPanel.add(beachMiniButton);
  }
}
