package cisc275.group3.model.sceneobject;

import java.awt.BasicStroke;
import java.awt.MouseInfo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.lang.Object;

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