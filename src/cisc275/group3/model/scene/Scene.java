package cisc275.group3.model.scene;

import cisc275.group3.model.sceneobject.NavObject;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.SceneId;

import java.awt.Color;
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
 */
public abstract class Scene {
	
  // Scene Properties
  protected boolean clickable;
  protected SceneId manifest;
  protected ArrayList<SceneObject> sceneItems;
  protected int score;
  protected int time;
  protected boolean visible;
  protected ArrayList<NavObject> navObjects;
  protected Color backgroundColor;

	
  // RNG
  Random randGen = new Random();
	
  public Scene(SceneId mani, boolean click, boolean vis) {
    clickable = click;
    manifest = mani;
    visible = vis;
		
    sceneItems = new ArrayList<SceneObject>();
    navObjects = new ArrayList<NavObject>();

    
  }
	
  /**
   * Every subclass must define
   * how to update itself
   */
  abstract public void update();
  
  /**
   * Process Click Events from Controller
   */
  public boolean processClick(double clickX, double clickY) {
	  	System.out.println("CHECKING FOR CLICK");
	    for (Iterator<SceneObject> iterator = sceneItems.iterator(); iterator.hasNext();) {     
	        if (iterator.next().itemClicked(clickX, clickY)) {
	          iterator.remove();
	          return true;
	        }
	      }
	      return false;
  }
  
public String processNav(double clickX, double clickY){
		for(int i = 0; i < navObjects.size(); i++) {
			if(navObjects.get(i).itemClicked(clickX, clickY)) {
				return navObjects.get(i).navClick();
			}
		}	
	    return "NONE";
	}
  
	
  /**
   * Print Scene and Object Information
   */
//  public String toString() {
//    String outString = "\nName: " + manifest.getName()
//                      +"\nWidth: " + manifest.getWidth()
//                      +"\nHeight: " + manifest.getHeight()
//                      +"\nClickable: " + clickable
//                      +"\nVisible: " + visible
//                      +"\nScene Objects: " + sceneItems.size();
//    return outString;
//  }
  public String toString() {
	    return this.getManifest().getName();
	  }
	
  /**
   * @return clickable
   */
  public boolean getClickable() {
    return clickable;
  }
  
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
  
  public ArrayList<NavObject> getNavObjects() {
	  return navObjects;
  }
	
  /**
   * @return visible
   */
  public boolean getVisible() {
    return visible;
  }
  
  public Color getBackgroundColor() {
	  return this.backgroundColor;
  }
	
  /**
   * Toggles visibility boolean
   */
  public void toggleVisible() {
    visible = !this.visible;
  }	
	
  /**
   * Toggles clickablity boolean
   */
  public void toggleClickable() {
    clickable = !clickable;
  }
}