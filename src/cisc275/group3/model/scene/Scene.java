package cisc275.group3.model.scene;

import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.SceneId;
import java.util.ArrayList;
import java.util.Random;

public abstract class Scene {
	/*	CISC 275 - Group 3 - Estuary Game
	 * 
	 *  Scene.java
	 * 
	 * 	This abstract class is used to establish scene requirements 
	 *  and allow disparate scenes to be compared and grouped.
	 */
	
	// Scene Constants
	final protected static int INTERFACE_HEIGHT = 75;
	
	// Scene Properties
	protected boolean clickable;
	protected SceneId manifest;
	protected ArrayList<SceneObject> scene_items;
	protected int score;
	protected int time;
	protected boolean visible;
	
	// RNG
	Random rand_gen = new Random();

		
	public Scene(boolean c, SceneId m, boolean v) {
		clickable = c;
		manifest = m;
		visible = v;
		
		
		this.clickable = true;
		this.scene_items = new ArrayList<SceneObject>();
	}
	
	public void updateTime() {
		this.time -= 1;
	}
	
	public boolean getClickable() {
		return this.clickable;
	}
	
	public boolean getVisible() {
		return visible;
	}
	
	public void toggleVisible() {
		visible = !this.visible;
	}	
	
	public void toggleClickable() {
		clickable = !clickable;
	}
	
	abstract protected void fillScene();
}