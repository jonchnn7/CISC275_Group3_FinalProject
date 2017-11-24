package cisc275.group3.model.sceneobject;

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
