import java.awt.Color;
import java.awt.Graphics;

public abstract class SceneObject implements Comparable<SceneObject> {
	/*	CISC 275 - Group 3 - Estuary Game
	 * 
	 *  SceneObject.java
	 * 
	 * 	This abstract class defines the basic structure, properties
	 *  and methods of all in game objects.
	 *  
	 *  Implements Comparable to sort objects by depth. Sorting by depth
	 *  ensures the first object found in an array is the front-most ? 
	 *  object at a given location. 
	 */
	
	// Item Properties
	protected int item_x;
	protected int item_y;
	protected int item_width;
	protected int item_height;
	protected int item_type;
	protected int depth;
	protected Color item_color;
	
	
	public SceneObject(int x, int y, int width, int height) {
		this.item_x = x;
		this.item_y = y;
		
		this.item_width = width;
		this.item_height = height;
	}
	
	
	public int compareTo(SceneObject other_item) {
		return other_item.getDepth() - this.depth;
	}
	
	
	public void drawItem(Graphics g) {
		g.setColor(this.item_color);
        g.fillOval(this.item_x, this.item_y, (this.item_width/2), (this.item_height/2));
        g.setColor(Color.white);
        g.drawOval(this.item_x, this.item_y, this.item_width, this.item_height);
	}
	
	
	public boolean itemClicked(int click_x, int click_y) {
		double x_squared = Math.pow( (Math.max(this.item_x, click_x) - Math.min(this.item_x, click_x)), 2);
		double y_squared = Math.pow( (Math.max(this.item_y, click_y) - Math.min(this.item_y, click_y)), 2);
		double max_radius = Math.pow( (this.item_width/2 + this.item_height/2), 2);
		
		if (x_squared + y_squared <= max_radius)
			return true;
		
		return false;
	}
	
	protected int getDepth() {
		return this.depth;
	}
}
