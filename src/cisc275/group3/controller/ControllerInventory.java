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
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.SceneBay;
import cisc275.group3.model.scene.SceneInventory;
import cisc275.group3.model.sceneobject.BetaCrab;
import cisc275.group3.model.sceneobject.BetaFish;
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
 * @author Scott <p>
 * @author Jolyne <p>
 */
public class ControllerInventory extends ControllerScene {

  private JPanel inventoryPanel;
  private ImageIcon inventoryBg;
  private static ArrayList<SceneObject> sceneFillItems = new ArrayList<SceneObject>();
  
  private static int inventory_x = 0;
  private static int inventory_y = 0;
  
  
  public ControllerInventory(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
	    super(w, h, f, cl, sceneType);
	    inventoryBg = new ImageIcon("img/inventory_menu.png");
  }
  
  @Override
  protected void createScene(int sceneType) {
	  
    scene = new SceneInventory("Inventory", 0, 0, 300, 300, 3, "img/inventory_menu_small.png");
    viewGame = new ViewGame(300, 300, scene.getSceneItems(), scene.getManifest().getBG());
	    

    viewGame.setBounds(100, 0, 300, 300);
    viewGame.setName("InventoryLayer");

    mainPane.setLayer(viewGame, LayerCode.Inventory.getCode());
    mainPane.add(viewGame, LayerCode.Inventory.getCode());
    componentList.put("Inventory", viewGame);
  }
  
  public static void addItem(SceneObject tmp)
  {
    // Add Item
	  if (tmp instanceof BetaFish)
	  {
		  sceneFillItems.add(new BetaFish(tmp.getPassport(), inventory_x, inventory_y, 0, 0, true));
	  }
	  else if (tmp instanceof BetaCrab)
	  {
		  sceneFillItems.add(new BetaCrab(tmp.getPassport(), inventory_x, inventory_y, 0, 0, true));
	  }
	  
	  inventory_x = inventory_x + 120;
	  if (inventory_x > 300)
	  {
		  inventory_x = 0;
		  inventory_y = inventory_y + 100;
	  }
	  
    //sceneFillItems.add(tmp);
  }
  
  //Takes a type of sceneObject and removes the amount of that particular object you want to remove from the inventory 
  public static void removeItem(SceneObject tmp, int count)
  {
	  int found_count = 0;
  
	  for (Iterator<SceneObject> iterator = sceneFillItems.iterator(); iterator.hasNext();) {     
	      SceneObject sceneItem = iterator.next();
	      
	      //System.out.println(sceneItem.getShortName() + " " + tmp.getShortName() + " " + found_count+ " " + count);
	      if(sceneItem.getShortName().equals(tmp.getShortName()) && found_count < count)
	      {
	    	  iterator.remove();
	    	  found_count++;
	    	  //System.out.println("found " + found_count + " of " + tmp.getShortName());
	      }
	      //System.out.println("looping");
	  }

	  /*now basically redraw the inventory
	  * basically create a new tmp list that hold all remaining fish in inventory
	  * clears the inventory
	  * readds to the inventory clones of the old objects but with new location attributes
	  * clears tmp list
	  * Harvey will probably kill me for this
	  */
	   ArrayList<SceneObject> tmp_list = new ArrayList<SceneObject>();
	   
	  for (SceneObject tmp_object : sceneFillItems)
	  {
		  tmp_list.add(tmp_object);
	  }
	  sceneFillItems.clear();
	  inventory_x = 0;
	  inventory_y = 0;
	  for(SceneObject tmp_object : tmp_list)
	  {
		  addItem(tmp_object);
	  }
	  tmp_list.clear();
	  
	  
  }
  
  public static ArrayList<SceneObject> getSceneItems()
  {
	  return sceneFillItems;
  }
 
  public void update()
  {
	  inventoryPanel.repaint();
	  mainPane.repaint();
	  
  }

  
  }