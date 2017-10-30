package cisc275.group3.model.scene;

import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.SceneId;
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
	
  // RNG
  Random randGen = new Random();
	
  public Scene(SceneId mani, boolean click, boolean vis) {
    clickable = click;
    manifest = mani;
    visible = vis;
		
    sceneItems = new ArrayList<SceneObject>();
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
    for (Iterator<SceneObject> iterator = sceneItems.iterator(); iterator.hasNext();) {     
      if (iterator.next().itemClicked(clickX, clickY)) {
        iterator.remove();
        return true;
      }
    }
    return false;
  }
	
  /**
   * Print Scene and Object Information
   */
  public String toString() {
    String outString = "\nName: " + manifest.getName()
                      +"\nWidth: " + manifest.getWidth()
                      +"\nHeight: " + manifest.getHeight()
                      +"\nClickable: " + clickable
                      +"\nVisible: " + visible
                      +"\nScene Objects: " + sceneItems.size();
    return outString;
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
	
  /**
   * @return visible
   */
  public boolean getVisible() {
    return visible;
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