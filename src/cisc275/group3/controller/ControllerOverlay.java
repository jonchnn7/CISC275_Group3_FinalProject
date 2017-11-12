package cisc275.group3.controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewOverlayButton;

public class ControllerOverlay extends ControllerScene {
  private ImageIcon mapButtonImage;
  private ImageIcon mapButtonRolloverImage;
  private int mapButtonWidth;
  private int mapButtonHeight;
  private ViewOverlayButton mapButtonPanel;

  public ControllerOverlay(int w, int h, GameWindow f, HashMap<String, Component> cl) {
    super(w, h, f, cl);
    
    mapButtonImage = new ImageIcon("img/map_icon.png");
    mapButtonRolloverImage = new ImageIcon("img/map_icon_invert.png");
    mapButtonWidth = 75;
    mapButtonHeight = 75;
    
    createScene();
  }

  @Override
  protected void createScene() {
    createMapButton();

  }
  
  private void createMapButton() {
    mapButtonPanel = new ViewOverlayButton(mapButtonImage, mapButtonRolloverImage, mapButtonWidth, mapButtonHeight);
    mapButtonPanel.setBounds(180, SCREEN_HEIGHT-mapButtonHeight, mapButtonWidth,mapButtonHeight);
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
}
