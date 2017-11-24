package cisc275.group3.model.sceneobject;

import java.awt.MouseInfo;

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
