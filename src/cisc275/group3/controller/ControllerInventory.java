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
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.SceneBay;
import cisc275.group3.model.scene.SceneInventory;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.model.sceneobject.ToolCamera;
import cisc275.group3.model.sceneobject.ToolNet;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;

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
public class ControllerInventory extends ControllerScene {

  private JPanel inventoryPanel;
  private ImageIcon inventoryBg;
  private static ArrayList<SceneObject> sceneFillItems = new ArrayList<SceneObject>();
  
  
  public ControllerInventory(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
	    super(w, h, f, cl, sceneType);
	    inventoryBg = new ImageIcon("img/inventory_menu.png");
  }
  
  @Override
  protected void createScene(int sceneType) {
	  
	 //scene = new SceneInventory("Inventory", 0, 0, 300, 300, "null");
	 //viewGame = new ViewGame(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), scene.getManifest().getBG());
	    

	  //viewGame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
	  //viewGame.setName("InventoryLayer");
	  
	  
    Dimension inventorySize = new Dimension(300, 300);
    inventoryPanel = new JPanel(true) {
      @Override
      public void paintComponent(Graphics g) {
        Dimension size = new Dimension(inventoryBg.getIconWidth(), inventoryBg.getIconHeight());
        g.drawImage(inventoryBg.getImage(), 0, 0, size.width, size.height, this);
      }
    };
    
    inventoryPanel.setLayout(null);
    inventoryPanel.setPreferredSize(inventorySize);
    inventoryPanel.setBounds(100, 0, inventorySize.width, inventorySize.height);
    inventoryPanel.setBackground(Color.orange);
    inventoryPanel.setOpaque(true);
   
    //addToolButtons();
    
    mainPane.setLayer(inventoryPanel, LayerCode.Inventory.getCode());
    mainPane.add(inventoryPanel, LayerCode.Inventory.getCode());
    //mainPane.add(viewGame, LayerCode.InventoryOverlay.getCode());
    componentList.put("Inventory", inventoryPanel);
    //componentList.put("InventoryOverlay", viewGame);
  }
  
  public static void addItem(SceneObject tmp)
  {
	  //create new fish
	  //System.out.println("Add Item");
	  sceneFillItems.add(tmp);
	  //System.out.println(sceneFillItems);
  }
  
  public static ArrayList<SceneObject> getSceneItems()
  {
	  //System.out.println("Get Item");
	  return sceneFillItems;
  }
 
  public void update()
  {
	  inventoryPanel.repaint();
	  mainPane.repaint();
	  
  }

  
  }