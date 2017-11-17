package cisc275.group3.model.scene;

import cisc275.group3.controller.ControllerInventory;
import cisc275.group3.model.sceneobject.BetaCrab;
import cisc275.group3.model.sceneobject.BetaFish;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.model.sceneobject.ToolObject;
import cisc275.group3.utility.Mission;
import cisc275.group3.utility.SceneId;
import cisc275.group3.utility.SceneObjectType;
import cisc275.group3.view.ViewOverlayLabel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


/**
 * Simplest base class of a scene supporting methods shared
 * by all subclasses. Additional, unique functionality should
 * be implemented by subclasses, and shared functionality by
 * interfaces.
 * <p>
 * Scene.java
 * <p>
 * @author Scott
 * <p>
 * @author Jolyne
 */
public abstract class Scene implements Serializable {
	
  // Scene Properties
  protected SceneId manifest;
  protected ArrayList<SceneObject> sceneItems;
  protected int score;
  protected int time;
  protected static ToolObject currentTool;
  protected static Mission currentMission;

	
  // RNG
  protected Random randGen = new Random();
	
  public Scene(SceneId mani) {
    manifest = mani;
    currentTool = null;
    currentMission = new Mission(null, 0);
    sceneItems = new ArrayList<SceneObject>();
  }
  
  /**
   * Every subclass must define its initial fill.
   */
  abstract protected void fillScene();
  
  /**
   * Every subclass must define how to update itself
   */
  abstract public void update();
  
  /**
   * Process Click Events from Controller. If a scene 
   * object is clicked on, its name is printed to console.
   * This is probably a good place to check "click 
   * compatibility".
   * @param		clickX	double-x-axis coordinate of click
   * @param		clickY	double-y-axis coordinate of click
   * @return	boolean is click on clickable object?
   */
  public boolean processClick(double clickX, double clickY, String cursorName) {
    for (Iterator<SceneObject> iterator = sceneItems.iterator(); iterator.hasNext();) {     
      SceneObject sceneItem = iterator.next();
	    	
      // Compatibility Check
      if ((sceneItem instanceof BetaFish) && (currentTool != null) && (SceneObjectType.BetaFish.searchCompatability(currentTool.getName()))) {
    	  if (sceneItem.itemClicked(clickX, clickY)) {
    	  //if (sceneItem.itemClicked(clickX, clickY) && cursorName.equalsIgnoreCase("Net")) {
    		  System.out.println("Clicked on: " + sceneItem.getPassport().getName());
    		  if ((Scene.getCurrentMission().getTargetObject() != null) &&(Scene.getCurrentMission().getTargetObject().equals("BetaFish")) && (Scene.getCurrentMission().getObjectName().equals(sceneItem.getPassport().getName()))) {
    			  Scene.getCurrentMission().decreaseNum();
    		  }
    		  ControllerInventory.addItem(sceneItem);
    		  iterator.remove();
    		  return true;
    	  }
      }
      if ((sceneItem instanceof BetaCrab) && (currentTool != null) && (SceneObjectType.BetaCrab.searchCompatability(currentTool.getName()))) {
    	  if (sceneItem.itemClicked(clickX, clickY)) {
    	  //if (sceneItem.itemClicked(clickX, clickY) && cursorName.equalsIgnoreCase("Net")) {
    		  System.out.println("Clicked on: " + sceneItem.getPassport().getName());
    		  if ((Scene.getCurrentMission().getTargetObject() != null) &&(Scene.getCurrentMission().getTargetObject().equals("BetaCrab")) && (Scene.getCurrentMission().getObjectName().equals(sceneItem.getPassport().getName()))) {
    			  Scene.getCurrentMission().decreaseNum();
    		  }
    		  ControllerInventory.addItem(sceneItem);
    		  iterator.remove();
    		  return true;
    	  }
      }
    }
    return false;
  }
	
  /**
   * Represents Scene as a String by printing its 
   * parameters.
   * @return multiline string of parameter states
   */
  public String toString() {
    String outString = "\nName: " + manifest.getName()
                      +"\nWidth: " + manifest.getWidth()
                      +"\nHeight: " + manifest.getHeight()
                      +"\nScene Objects: " + sceneItems.size();
    return outString;
  }
  
  // Alternate toString
  //public String toString() {
  //  return this.getManifest().getName();
  //}
  
  /**
   * @return manifest
   */
  public SceneId getManifest() {
	  return manifest;
  }
  
  /**
   * @return currentTool
   */
  public static ToolObject getCurrentTool() {
    return currentTool;
  }
  
  /**
   * Updates the current tool to the input parameter
   * @param t ToolObject-new tool
   */
  public static void setCurrentTool(ToolObject t) {
    currentTool = t;
  }
  
  /**
   * @return currentTool
   */
  public static Mission getCurrentMission() {
    return currentMission;
  }
  
  /**
   * Updates the current tool to the input parameter
   * @param t ToolObject-new tool
   */
  public static void setCurrentMission(Mission m) {
    currentMission = m;
  }
  
  /**
   * Used by View import objects. Changes must
   * be compatible with View's drawObjects()
   * @return sceneItems
   */
  public ArrayList<SceneObject> getSceneItems() {
	  return sceneItems;
  }
}