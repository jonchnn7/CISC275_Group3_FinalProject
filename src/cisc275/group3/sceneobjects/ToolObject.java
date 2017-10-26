package cisc275.group3.sceneobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.geom.Ellipse2D;

public abstract class ToolObject implements Comparable<ToolObject> {
	
	/*
	 * TolObject.java Class
	 * 
	 * Abstract class that defines the properties and methods of all the ToolObjects
	 * in the game.
	 * 
	 */

	// Item Properties
	protected int item_x;
	protected int item_y;
	protected int item_width;
	protected int item_height;
	protected String click_type;
	protected String tool_name;
	

	public ToolObject(int x, int y, int width, int height) {
		this.item_x = x;
		this.item_y = y;
		this.item_width = width;
		this.item_height = height;
		
	}
	public void mouseLocator() {
		int mouseY = MouseInfo.getPointerInfo().getLocation().y;
		int mouseX = MouseInfo.getPointerInfo().getLocation().x;
		item_x = mouseX;
		item_y = mouseY;
	}
	
	

}