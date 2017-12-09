package cisc275.group3.sceneobject;

/** 
 * Abstract class that defines the properties and methods of all the ToolObjects
 * in the game.
 * <p>
 * ToolObject.java Class
 * <p>
 * @author Jolyne
 * @author Scott
 */
public abstract class ToolObject {

  // Item Properties
  protected String clickType;
  protected String toolName;
	
  /**
   * Abstract constructor.
   * <p>
   * Nothing required here. All parameters 
   * are sub-class specific.
   */
  public ToolObject() {
  }
	
  /**
   * @return the object name
   */
  public String getName() {
    return toolName;
  }

}
