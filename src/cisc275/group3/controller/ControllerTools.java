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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.SceneBeachMini;
import cisc275.group3.model.sceneobject.ToolCage;
import cisc275.group3.model.sceneobject.ToolCamera;
import cisc275.group3.model.sceneobject.ToolNet;
import cisc275.group3.model.sceneobject.ToolTrimmer;
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
 * @author Jolyne 
 */
public class ControllerTools extends ControllerScene {

  private JPanel toolPanel;
  private JButton netButton;
  private JButton cameraButton;
  private JButton cageButton;
  private JButton trimmerButton;
  private ImageIcon toolBg;
  
  public ControllerTools(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
    super(w, h, f, cl, sceneType);
    toolBg = new ImageIcon("img/toolbox_vert_menu.png");
  }
  
  @Override
  protected void createScene(int sceneType) {
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
    
    toolOverlay();
  }
  
  private void addToolButtons() {
    netButton = new JButton("NET");
    netButton.setFont(new Font("Roboto", Font.BOLD, 18));
    netButton.setBounds(0, 20, 75, 30);
	
    netButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component toolComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Tools")))[0];
        
        mainPane.setLayer(toolComponent, LayerCode.Tools.getCode());
        if (Scene.getCurrentTool() instanceof ToolNet) {
          Scene.setCurrentTool(null);
          mouseLabel.setIcon(new ImageIcon("img/mouse_empty.png"));
          mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else {
          Scene.setCurrentTool(new ToolNet(0,0,0,0));
          mouseLabel.setIcon(new ImageIcon("img/mouse_net.png"));
          mouseLabel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        }
      }
    });
    toolPanel.add(netButton);
	    
    cameraButton = new JButton("CMR");
    cameraButton.setFont(new Font("Roboto", Font.BOLD, 18));
    cameraButton.setBounds(0, 95, 75, 30);
	    
    cameraButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component toolComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Tools")))[0];
	        
        mainPane.setLayer(toolComponent, LayerCode.Tools.getCode());
          if (Scene.getCurrentTool() instanceof ToolCamera) {
            Scene.setCurrentTool(null);
            mouseLabel.setIcon(new ImageIcon("img/mouse_empty.png"));
            mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
          } 
          else {
            Scene.setCurrentTool(new ToolCamera(0,0,0,0));
            mouseLabel.setIcon(new ImageIcon("img/mouse_cam.png"));
            mouseLabel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
          }
        }
      });
      toolPanel.add(cameraButton);
      
      cageButton = new JButton("CGE");
      cageButton.setFont(new Font("Roboto", Font.BOLD, 18));
      cageButton.setBounds(0, 170, 75, 30);
  	
      cageButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Component toolComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Tools")))[0];
          
          mainPane.setLayer(toolComponent, LayerCode.Tools.getCode());
          if (Scene.getCurrentTool() instanceof ToolCage) {
            Scene.setCurrentTool(null);
            mouseLabel.setIcon(new ImageIcon("img/mouse_empty.png"));
            mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
          }
          else {
            Scene.setCurrentTool(new ToolCage(0,0,0,0));
            mouseLabel.setIcon(new ImageIcon("img/mouse_cage.png"));
            mouseLabel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

          }
        }
      });
      toolPanel.add(cageButton);
      
      trimmerButton = new JButton("TRM");
      trimmerButton.setFont(new Font("Roboto", Font.BOLD, 18));
      trimmerButton.setBounds(0, 245, 75, 30);
  	
      trimmerButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Component toolComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Tools")))[0];
          
          mainPane.setLayer(toolComponent, LayerCode.Tools.getCode());
          if (Scene.getCurrentTool() instanceof ToolTrimmer) {
            Scene.setCurrentTool(null);
            mouseLabel.setIcon(new ImageIcon("img/mouse_empty.png"));
            mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
          }
          else {
            Scene.setCurrentTool(new ToolTrimmer(0,0,0,0));
            mouseLabel.setIcon(new ImageIcon("img/mouse_trim.png"));
            mouseLabel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
          }
        }
      });
      toolPanel.add(trimmerButton);
    }
  
  private void toolOverlay() {
    mouseLabel = new JLabel(new ImageIcon("img/mouse_empty.png"));
    mouseLabel.setBounds(0, 0, 100, 100);
    mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
    mainPane.setLayer(mouseLabel, JLayeredPane.MODAL_LAYER);
    mainPane.add(mouseLabel, JLayeredPane.MODAL_LAYER);
    
    componentList.get("Bay").addMouseMotionListener(new MouseAdapter() {
      @Override 
      public void mouseMoved(MouseEvent e) {
        mouseLabel.setLocation(e.getX()-50, e.getY()-50);
      }
    });
    
    componentList.get("Beach").addMouseMotionListener(new MouseAdapter() {
      @Override 
      public void mouseMoved(MouseEvent e) {
        mouseLabel.setLocation(e.getX()-50, e.getY()-50);
      }
    });
    
    componentList.get("Wetland").addMouseMotionListener(new MouseAdapter() {
      @Override 
      public void mouseMoved(MouseEvent e) {
        mouseLabel.setLocation(e.getX()-50, e.getY()-50);
      }
    });
  }
 }