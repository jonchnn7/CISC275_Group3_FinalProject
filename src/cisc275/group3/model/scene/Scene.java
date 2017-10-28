package cisc275.group3.model.scene;

import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.SceneId;
import java.util.ArrayList;
import java.util.Random;

public abstract class Scene {
	
	// Scene Properties
	protected boolean clickable;
	protected SceneId manifest;
	protected ArrayList<SceneObject> scene_items;
	protected int score;
	protected int time;
	protected boolean visible;
	
	// RNG
	Random randGen = new Random();
	
	public Scene(boolean click, SceneId mani, boolean vis) {
		clickable = click;
		manifest = mani;
		visible = vis;
		
		scene_items = new ArrayList<SceneObject>();
	}
	
	/**
	 * Every subclass must define
	 * how to update itself
	 */
	abstract public void update();
	
	/**
	 * @return clickable
	 */
	public boolean getClickable() {
		return clickable;
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