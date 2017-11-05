package cisc275.group3.model.sceneobject;

import java.awt.BasicStroke;
import java.awt.MouseInfo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.lang.Object;

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
