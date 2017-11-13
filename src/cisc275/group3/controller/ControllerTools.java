package cisc275.group3.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.sceneobject.ToolCamera;
import cisc275.group3.model.sceneobject.ToolNet;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;

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
 * <p>
 * @author Jolyne
 */
public class ControllerTools extends ControllerScene {

  private JPanel toolPanel;
  private JButton netButton;
  private JButton cameraButton;
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
   
    addToolButtons();
    
    mainPane.setLayer(toolPanel, LayerCode.Tools.getCode());
    mainPane.add(toolPanel, LayerCode.Tools.getCode());
    componentList.put("Tools", toolPanel);
  }
  
  private void addToolButtons() {
    netButton = new JButton("NET");
    netButton.setFont(new Font("Roboto", Font.BOLD, 18));
    netButton.setBounds(0, 35, 75, 30);
	    
    netButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component toolComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Tools")))[0];
        
        mainPane.setLayer(toolComponent, LayerCode.Tools.getCode());
        if (Scene.getCurrentTool() instanceof ToolNet) {
          Scene.setCurrentTool(null);
          mainPane.getComponentsInLayer(LayerCode.MainAll.getCode())[0].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        } else {
          Scene.setCurrentTool(new ToolNet(0,0,0,0));
          Toolkit toolkit = Toolkit.getDefaultToolkit();
          Image image = toolkit.getImage("img/fence_net_mouse.png");

          Cursor netCursor = toolkit.createCustomCursor(image , new Point(mainPane.getX()+image.getWidth(null)/2, 
                     mainPane.getY()+image.getHeight(null)/2), "Net");
          mainPane.getComponentsInLayer(LayerCode.MainAll.getCode())[0].setCursor(netCursor);

        }
      }
    });
    toolPanel.add(netButton);
	    
    cameraButton = new JButton("CMR");
    cameraButton.setFont(new Font("Roboto", Font.BOLD, 18));
    cameraButton.setBounds(0, 140, 75, 30);
	    
    cameraButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component toolComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Tools")))[0];
	        
        mainPane.setLayer(toolComponent, LayerCode.Tools.getCode());
          if (Scene.getCurrentTool() instanceof ToolCamera) {
            Scene.setCurrentTool(null);
          } else {
            Scene.setCurrentTool(new ToolCamera(0,0,0,0));
          }
        }
      });
      toolPanel.add(cameraButton);
    }
  }