package cisc275.group3.sceneobjects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

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
	protected String name;
	protected Color item_color;
	protected Shape shape;
	
	
	public SceneObject(int x, int y, int width, int height, int depth) {
		this.item_x = x;
		this.item_y = y;
		this.item_width = width;
		this.item_height = height;
		this.depth = depth;
		this.shape = new Ellipse2D.Double(x, y, width, height);
	}
	
	@Override 
	public int compareTo(SceneObject other_item) {
		//if (other_item.getDepth() - this.depth == 0) {
		//	other_item.setDepth(this.depth - 1);;
		//}
		return other_item.getDepth() - this.depth;
	}
	
	
	public void drawItem(Graphics g) {
		g.setColor(this.item_color);
		((Graphics2D) g).fill(this.shape);
		g.setColor(Color.white);
		((Graphics2D) g).draw(this.shape);
	}
	
	
	public boolean itemClicked(int click_x, int click_y) {
		return shape.contains(click_x, click_y);
	}
	
	public int getDepth() {
		return this.depth;
	}
	
	protected void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getX() {
		return this.item_x;
	}
	
	public int getY() {
		return this.item_y;
	}
	
	public int getWidth() {
		return this.item_width;
	}
	
	public Color getColor() {
		return this.item_color;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return "[" + this.name + ", (" + this.item_x + "," + this.item_y + "), " + this.depth + "]";
	}
}
