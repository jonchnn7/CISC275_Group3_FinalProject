package cisc275.group3.model.sceneobject;

/**
 * Creating a trimmer tool 
 * <p>
 * ToolTrimmer.java
 * <p>
 * @author Jolyne
 */

public class ToolTrimmer extends ToolObject {

  /**
   * Creates a trimmer tool object
   * @param x       int-x axis location
   * @param y       int-y axis location
   * @param width   int-object width
   * @param height  int-object height
   */
  public ToolTrimmer(int x, int y, int width, int height) {
    super(x, y, width, height);
    clickType = "Trimmer";
    toolName = "Trimmer";
  }

  
  @Override
  public int compareTo(ToolObject o) {
    return 0;
  }
}
