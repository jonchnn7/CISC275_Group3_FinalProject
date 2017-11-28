package cisc275.group3.model.sceneobject;

/**
 * Creating a camera tool 
 * <p>
 * ToolCamera.java
 * <p>
 * @author Jolyne
 */

public class ToolCamera extends ToolObject {

  public ToolCamera(int x, int y, int width, int height) {
    super(x, y, width, height);
    clickType = "Camera";
    toolName = "Camera";
  }

  @Override
  public int compareTo(ToolObject o) {
    return 0;
  }
}
