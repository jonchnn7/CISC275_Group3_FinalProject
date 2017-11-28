package cisc275.group3.model.sceneobject;

/**
 * Creating a trimmer tool 
 * <p>
 * ToolTrimmer.java
 * <p>
 * @author Jolyne
 */

public class ToolTrimmer extends ToolObject {

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
