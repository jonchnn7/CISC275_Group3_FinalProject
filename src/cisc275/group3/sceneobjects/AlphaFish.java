package cisc275.group3.sceneobjects;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class AlphaFish extends SceneObject {
	boolean left_to_right;
	Color[] color_list = {Color.black, Color.cyan, Color.darkGray, Color.magenta,
						  Color.red, Color.yellow, Color.orange};
	
	Random rand_gen = new Random();

	public AlphaFish(int x, int y, int width, int height, int d, boolean ltr) {
		super(x, y, width, height, d);
		this.item_color = color_list[rand_gen.nextInt(color_list.length)];
		this.name = "Alpha Fish";
		this.left_to_right = ltr;
	}
	
	public void move() {
		if (left_to_right)
			this.item_x += rand_gen.nextInt(10) + 5;
		else
			this.item_x -= (rand_gen.nextInt(10) + 5);
		
		this.item_y += rand_gen.nextInt(10) - rand_gen.nextInt(10);
		
		this.shape = new Ellipse2D.Double(this.item_x, this.item_y, 100, 50);
	}
	
	public boolean getLTR() {
		return this.left_to_right;
	}
}