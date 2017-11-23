package cisc275.group3.model.sceneobject;

public class ToolNet extends ToolObject {

  public ToolNet(int x, int y, int width, int height) {
    super(x, y, width, height);
    clickType = "Net";
    toolName = "Net";
  }

  @Override
  public int compareTo(ToolObject o) {
    return 0;
  }
}