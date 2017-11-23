package cisc275.group3.model.sceneobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.geom.Ellipse2D;

/** 
 * Abstract class that defines the properties and methods of all the ToolObjects
 * in the game.
 * <p>
 * ToolObject.java Class
 * <p>
 * @author FILLmeIN
 */
public abstract class ToolObject implements Comparable<ToolObject> {

  // Item Properties
  protected int itemX;
  protected int itemY;
  protected int itemWidth;
  protected int itemHeight;
  protected String clickType;
  protected String toolName;
	

  public ToolObject(int x, int y, int width, int height) {
    itemX = x;
    itemY = y;
    itemWidth = width;
    itemHeight = height;
  }
	
  public void mouseLocator() {
    itemX = MouseInfo.getPointerInfo().getLocation().x;
    itemY = MouseInfo.getPointerInfo().getLocation().y;
  }
	
  public String getName() {
    return toolName;
  }

}
