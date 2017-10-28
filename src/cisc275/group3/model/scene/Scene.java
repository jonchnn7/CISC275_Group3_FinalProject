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
	Random rand_gen = new Random();

		
	public Scene(boolean click, SceneId mani, boolean vis) {
		clickable = click;
		manifest = mani;
		visible = vis;
		
		
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
}