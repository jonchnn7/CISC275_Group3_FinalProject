package cisc275.group3.model.sceneobject;

public class ToolCage extends ToolObject {

  public ToolCage(int x, int y, int width, int height) {
    super(x, y, width, height);
    clickType = "Cage";
    toolName = "Cage";
  }

  @Override
  public int compareTo(ToolObject o) {
    return 0;
  }
}