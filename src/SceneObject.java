import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
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
	
	
	public SceneObject(int x, int y, int width, int height) {
		this.item_x = x;
		this.item_y = y;
		this.item_width = width;
		this.item_height = height;
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
        g.fillOval(this.item_x, this.item_y, (this.item_width), (this.item_height));
        g.setColor(Color.white);
        g.drawOval(this.item_x, this.item_y, this.item_width, this.item_height);
	}
	
	
	public boolean itemClicked(int click_x, int click_y) {
		return shape.contains(click_x, click_y);
	}
	//compareSceneObjects needs all sceneObjects added to it, then add those to the enumeration
	public boolean compareSceneObjects(SceneObject s1, SceneObject s2) {
		switch (s1.getClass().getName()) {
			case "AlphaItem": return(SceneObjectType.AlphaItem.searchCompatability(s2.getClass().getName()));
			default: return false;
		}
	}
	
	protected int getDepth() {
		return this.depth;
	}
	
	protected void setDepth(int depth) {
		this.depth = depth;
	}
}
