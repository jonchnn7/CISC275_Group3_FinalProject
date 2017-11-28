package cisc275.group3.controller;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import cisc275.group3.model.scene.SceneInventory;
import cisc275.group3.model.sceneobject.BetaCrab;
import cisc275.group3.model.sceneobject.BetaFish;
import cisc275.group3.model.sceneobject.BetaHeron;
import cisc275.group3.model.sceneobject.BetaVegetation;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.ConstructHeron;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.utility.LayerCodeTutorial;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;

/**
 * The Inventory controller is responsible for both the "model" and
 * control of the inventory. 
 * ControllerInventory.java
 * @author Thomas
 * @author Scott
 */
public class ControllerInventory extends ControllerScene {

//Parameter and sizes for JPanel and images
  private JPanel inventoryPanel;
  private ImageIcon inventoryBg;
  private static ArrayList<SceneObject> sceneFillItems = new ArrayList<SceneObject>();
  
 //Variables to keep track of next inventory slot
  private static double inventory_x = 0;
  private static double inventory_y = 0;
  private static double inventory_y_max = 0;
  
  /**
   * Constructor that calls ControllerScene super
   * and places proper background image
   */
  public ControllerInventory(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
	    super(w, h, f, cl, sceneType);
	    inventoryBg = new ImageIcon("img/inventory_menu.png");
  }
  
  /**
   * Creates the scene and adds it to
   * the main pain. Sets the layers and component list
   * for the inventory. 
   */
  @Override
  protected void createScene() {
	  
    scene = new SceneInventory("Inventory", 0, 0, 300, 300, 3, "img/inventory_menu_small.png");
    viewGame = new ViewGame(300, 300, scene.getSceneItems(), scene.getManifest().getBG());
	    

    viewGame.setBounds(100, 0, 300, 300);
    viewGame.setName("InventoryLayer");

    if (sceneType == 1) {
      mainPane.setLayer(viewGame, LayerCodeTutorial.InventoryHidden.getCode());
      mainPane.add(viewGame, LayerCodeTutorial.InventoryHidden.getCode());
    } else {
      mainPane.setLayer(viewGame, LayerCode.Inventory.getCode());
      mainPane.add(viewGame, LayerCode.Inventory.getCode());
    }
    
    componentList.put("Inventory", viewGame);
  }
  
  /**
   * Takes in an object and adds a new instance
   * of it to the inventory
   * 
   * @param tmp sceneobject that is passed to inventory and cloned/placed in inventory
   * 	
   */
  public static void addItem(SceneObject tmp)
  {
    // Add Item
	  if (tmp instanceof BetaFish)
	  {
		  if(tmp.getPassport().getHeight() > inventory_y_max)
		  {
			  inventory_y_max = tmp.getPassport().getHeight();
		  }
		  if(inventory_x + tmp.getPassport().getWidth() > 300)
		  {
			  inventory_x = 0;
			  inventory_y += inventory_y_max;
			  inventory_y_max = 0;
		  }
		  sceneFillItems.add(new BetaFish(tmp.getPassport(), inventory_x, inventory_y, 0, 0, true));
		  inventory_x = inventory_x + tmp.getPassport().getWidth();	
	  }
	  
	  else if (tmp instanceof BetaCrab)
	  {
		  if(tmp.getPassport().getHeight() > inventory_y_max)
		  {
			  inventory_y_max = tmp.getPassport().getHeight();
		  }
		  if(inventory_x + tmp.getPassport().getWidth() > 300)
		  {
			  inventory_x = 0;
			  inventory_y += inventory_y_max;
			  inventory_y_max = 0;
		  }
		  sceneFillItems.add(new BetaCrab(tmp.getPassport(), inventory_x, inventory_y, 0, 0, true));
		  inventory_x = inventory_x + tmp.getPassport().getWidth();
	  }
	  
	  else if (tmp instanceof BetaHeron)
	  { 
		  if(inventory_x + 150 > 300)
		  {
			  inventory_x = 0;
			  inventory_y += inventory_y += 100;
		  }
		  BetaHeron tmpHeron = ConstructHeron.constructLeftHeron(0, 1, inventory_x-10 , inventory_y, false, false);
		  sceneFillItems.add(tmpHeron);//new BetaHeron(tmp.getPassport(), inventory_x, inventory_y, 0, 0, true)
		  inventory_x = inventory_x + 150;
	  }
	  
	  else if (tmp instanceof BetaVegetation)
	  {
		  if(inventory_x + 100 > 300)
		  {
			  inventory_x = 0;
			  inventory_y += 100;
		  }
		  sceneFillItems.add(new BetaVegetation(tmp.getPassport(), inventory_x-40, inventory_y-60));
		  inventory_x = inventory_x + 100;
	  }
	  
  }
  
  /**
   * Removes a given item from inventory and redraws it.
   * 
   * @param tmp string that is used to find an object in the inventory
   */
  public static void removeItem(String tmp)
  {
	  for (Iterator<SceneObject> iterator = sceneFillItems.iterator(); iterator.hasNext();) {     
	      SceneObject sceneItem = iterator.next();
	     
	      if(sceneItem.getPassport().getName() == tmp)
	      {
	    	  iterator.remove();
	      }
	  }
  
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
  
  /**
   * returns the scene items to be drawn
   * 
   * @return array list of the sceneitems
   */
  public static ArrayList<SceneObject> getSceneItems()
  {
	  return sceneFillItems;
  }
 
  /**
   * Update inventory/repaint it
   */
  public void update()
  {
	  inventoryPanel.repaint();
	  mainPane.repaint();
	  
  }

  
 }