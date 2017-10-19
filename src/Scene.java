import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public abstract class Scene {
	/*	CISC 275 - Group 3 - Estuary Game
	 * 
	 *  Scene.java
	 * 
	 * 	This abstract class is used to establish scene requirements 
	 *  and allow disparate scenes to be compared and grouped.
	 */
	
	// Scene Properties
	protected int time;
	protected int scene_width;
	protected int scene_height;
	protected boolean visible;
	protected String scene_name;
	protected Color scene_background;
	protected ArrayList<SceneObject> scene_items;
	
	
	public Scene(int width, int height, String name) {
		this.scene_width = width;
		this.scene_height = height;
		this.scene_name = name;
	}
	
	public void drawScene(Graphics g) {
        g.setColor(this.scene_background);
        g.fillRect(0, 0, scene_width, scene_height);
        
        Collections.reverse(scene_items);
        for (SceneObject item : scene_items) {
        	item.drawItem(g);
        }
        Collections.sort(scene_items);
        
        g.setColor(Color.white);
		g.setFont(new Font("Sans Serif", Font.BOLD, 42));
		g.drawString(Integer.toString(this.time),
				    (this.scene_width-g.getFontMetrics().stringWidth(Integer.toString(this.time)))/2,
				    50);
    }
	
	public void updateTime() {
		this.time -= 1;
	}
	
	public void setVisible() {
		this.visible = true;
	}
	
	public void setHidden() {
		this.visible = false;
	}
	
	public void toggleVissible() {
		this.visible = !this.visible;
	}

	public boolean processClick(int click_x, int click_y) {
		Collections.sort(scene_items);
		System.out.println(scene_items);
		
		for (Iterator<SceneObject> iterator = scene_items.iterator(); iterator.hasNext();) {
			if ( iterator.next().itemClicked(click_x, click_y) ) {
				iterator.remove();
				return true;
			}
		}
				
		return false;
	}
	
	abstract protected void fillScene();
}
