package cisc275.group3.scene;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import cisc275.group3.sceneobjects.NavObject;
import cisc275.group3.sceneobjects.SceneObject;

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
	protected int time;
	protected int score;
	protected int scene_width;
	protected int scene_height;
	protected int start_x;
	protected int start_y;
	protected boolean visible;
	protected boolean clickable;
	protected String scene_name;
	protected Color scene_background_color;
	protected ArrayList<SceneObject> scene_items;
	
		
	public Scene(int start_x, int start_y, int width, int height, String name) {
		this.start_x = start_x;
		this.start_y = start_y;
		this.scene_width = width;
		this.scene_height = height;
		this.scene_name = name;
<<<<<<< HEAD:src/Scene.java
		this.nav_items.add(new NavObject(400, "Inventory"));
=======
		this.clickable = true;
>>>>>>> mvc:src/cisc275/group3/scene/Scene.java
	}
	
	public void drawScene(Graphics g) {
        g.setColor(this.scene_background_color);
        g.fillRect(this.start_x, this.start_y,  this.scene_width, this.scene_height);
        
        if (this.scene_items.size() > 0) {
	        Collections.reverse(this.scene_items);
	        for (SceneObject item : this.scene_items) {
	        	item.drawItem(g);
	        }
	        Collections.sort(this.scene_items);
        }
    }
	
	public void updateTime() {
		this.time -= 1;
	}
	
	public boolean getClickable() {
		return this.clickable;
	}
	
	public String getName() {
		return this.scene_name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public boolean getVisible() {
		return this.visible;
	}
	public void setVisible() {
		this.visible = true;
	}
	
	public void setHidden() {
		this.visible = false;
	}
	
	public void toggleVisible() {
		this.visible = !this.visible;
	}	
	
	public void toggleClickable() {
		this.clickable = !this.clickable;
	}

	public boolean processClick(int click_x, int click_y) {
		Collections.sort(scene_items);
		System.out.println(this.scene_name + " Items: " + scene_items);  // DEBUG - REMOVE
		
		for (Iterator<SceneObject> iterator = scene_items.iterator(); iterator.hasNext();) {
			if ( iterator.next().itemClicked(click_x, click_y) ) {
				iterator.remove();
				return true;
			}
		}
				
		return false;
	}
	
	public void processScore() {
		this.score++;
	}
	
	abstract protected void fillScene();
}
