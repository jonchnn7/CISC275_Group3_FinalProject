package cisc275.group3.model.scene;

import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.SceneId;
import java.util.ArrayList;
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
	
  public Scene(boolean click, SceneId mani, boolean vis) {
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
   * 
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