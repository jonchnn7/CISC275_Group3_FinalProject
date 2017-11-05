package cisc275.group3.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.SceneView;

public class TitleController extends SceneController {

  private JPanel titlePanel;
  private JLabel titleLabel;
  
  public TitleController(int w, int h, GameWindow f, HashMap<String, Component> cl) {
    super(w, h, f, cl);
  }
  
  @Override
  protected void createScene() {
    titlePanel = new JPanel(new BorderLayout(), true);
    titlePanel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    titlePanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    titlePanel.setBackground(Color.black);
    titlePanel.setOpaque(true);
    
    titleLabel = new JLabel("Estuary Click Adventure");
    titleLabel.setFont(new Font("Roboto", Font.BOLD, 64));
    titleLabel.setForeground(Color.white);
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
    titlePanel.add(titleLabel);
    
    sceneView = new SceneView(SCREEN_WIDTH, SCREEN_HEIGHT, titlePanel);
    
    sceneView.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    sceneView.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    sceneView.setName("TitleLayer");
    
    mainPane.setLayer(sceneView, LayerCode.Title.getCode());
    mainPane.add(sceneView, LayerCode.Title.getCode());
    
    componentList.put("Title", sceneView);
  
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
        Component mapComponent = mainPane.getComponentsInLayer(LayerCode.Map.getCode())[0];       
        mainPane.setLayer(mapComponent, LayerCode.Overlay.getCode());
      }
    });
  }
  
  @Override
  public void update() {
  }
}