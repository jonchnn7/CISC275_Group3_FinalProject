package cisc275.group3.model.scene;

import cisc275.group3.model.sceneobject.NavObject;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.SceneId;

import java.awt.Color;
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
 */
public abstract class Scene implements Serializable {
	
  // Scene Properties
  protected SceneId manifest;
  protected ArrayList<SceneObject> sceneItems;
  protected int score;
  protected int time;

	
  // RNG
  protected Random randGen = new Random();
	
  public Scene(SceneId mani) {
    manifest = mani;
		
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
   * @param		clickX	double - x-axis coordinate of click
   * @param		clickY	double - y-axis coordinate of click
   * @return	boolean	is click on clickable object?
   */
  public boolean processClick(double clickX, double clickY) {
	    for (Iterator<SceneObject> iterator = sceneItems.iterator(); iterator.hasNext();) {     
	    	SceneObject sceneItem = iterator.next();
	    	
	    	// Compatibility Check
	    	// if ( mouse.getTool() == sceneItem.getType() ) { continue; }       ? Maybe ?
	    	
	        if (sceneItem.itemClicked(clickX, clickY)) {
	          System.out.println("Clicked on: " + sceneItem.getPassport().getName());
	          iterator.remove();
	          return true;
	        }
	      }
	      return false;
  }
	
  /**
   * Represents Scene as a String by printing its 
   * parameters.
   * @return multi-line string of parameter states
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
   * Used by View import objects. Changes must
   * be compatible with View's drawObjects()
   * @return sceneItems
   */
  public ArrayList<SceneObject> getSceneItems() {
	  return sceneItems;
  }
}