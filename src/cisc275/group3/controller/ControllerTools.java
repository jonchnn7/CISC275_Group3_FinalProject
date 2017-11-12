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
 * The Tools controller is responsible for both the "model" and
 * control of the toolbox. 
 * <p>
 * The toolbox augments the mouse and sets a "click type" that
 * can be checked against the object type to determine compatibility.
 * Because there is no underlying model, the controller implements
 * the corresponding logic.
 * <p>
 * ControllerTool.java
 * <p>
 * @author Scott
 */
public class ControllerTools extends ControllerScene {

  private JPanel toolPanel;
  private ImageIcon toolBg;
  
  public ControllerTools(int w, int h, GameWindow f, HashMap<String, Component> cl) {
    super(w, h, f, cl);
    toolBg = new ImageIcon("img/toolbox_vert_menu.png");
  }
  
  @Override
  protected void createScene() {
    Dimension toolSize = new Dimension(75, 300);
    toolPanel = new JPanel(true) {
    	 @Override
         public void paintComponent(Graphics g) {
           Dimension size = new Dimension(toolBg.getIconWidth(), toolBg.getIconHeight());
           g.drawImage(toolBg.getImage(), 0, 0, size.width, size.height, this);
         }
    };
    
    toolPanel.setLayout(null);
    toolPanel.setPreferredSize(toolSize);
    toolPanel.setBounds(SCREEN_WIDTH-toolSize.width, 5, toolSize.width, toolSize.height);
    toolPanel.setBackground(Color.orange);
    toolPanel.setOpaque(true);
   
    //addMapButtons();
    
    mainPane.setLayer(toolPanel, LayerCode.Tools.getCode());
    mainPane.add(toolPanel, LayerCode.Tools.getCode());
    componentList.put("Tools", toolPanel);
  }

  @Override
  protected void addML() {
  }
}