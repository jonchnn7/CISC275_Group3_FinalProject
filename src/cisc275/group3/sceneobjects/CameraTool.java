package cisc275.group3.sceneobjects;
import java.awt.BasicStroke;
import java.awt.MouseInfo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.lang.Object;

public class CameraTool extends ToolObject {

	public CameraTool(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.click_type = "camea";
		this.tool_name = "camera";
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(ToolObject o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
