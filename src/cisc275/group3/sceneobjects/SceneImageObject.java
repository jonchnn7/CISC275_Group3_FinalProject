package cisc275.group3.sceneobjects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public abstract class SceneImageObject implements Comparable<SceneImageObject> {
	
	// Item Properties
	protected int item_x;
	protected int item_y;
	protected int item_type;
	protected int depth;
	protected String name;
	protected BufferedImage image;
	
	
	public SceneImageObject(int x, int y, int depth) {
		this.item_x = x;
		this.item_y = y;
		this.depth = depth;
	}
	 
	public int compareTo(SceneImageObject other_item) {
		return other_item.getDepth() - this.depth;
	}
	
	
	public void drawItem(Graphics g) {
		((Graphics2D) g).drawImage(image, item_x, item_y, null)	;
		}
	
	
	public boolean itemClicked(int click_x, int click_y) {
		System.out.println("IMAGE ITEM CLICKED");
		if((click_x > this.item_x) && (click_x < this.item_x + this.getWidth()) && (click_y > this.item_y) && (click_y < this.item_y + this.getHeight())) {
			System.out.println("Found Item with Image");
			return true;
		}
		else {
			return false;
		}
	}
	
//	//compareSceneObjects needs all sceneObjects added to it, then add those to the enumeration
//	public boolean compareSceneObjects(SceneObject s1, SceneObject s2) {
//		switch (s1.getClass().getName()) {
//			case "AlphaItem": return(SceneObjectType.AlphaItem.searchCompatability(s2.getClass().getName()));
//			default: return false;
//		}
//	}
	
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
		return this.image.getWidth();
	}
	
	public int getHeight() {
		return this.image.getHeight();
	}
	
	public String toString() {
		return "[" + this.name + ", (" + this.item_x + "," + this.item_y + "), " + this.depth + "]";
	}
}
