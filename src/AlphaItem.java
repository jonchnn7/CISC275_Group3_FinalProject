import java.awt.Color;
import java.util.Random;

public class AlphaItem extends SceneObject {
	Color[] color_list = {Color.black, Color.white, Color.cyan, Color.darkGray, 
						  Color.magenta, Color.red, Color.yellow};
	
	Random rand_gen = new Random();

	public AlphaItem(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.item_color = color_list[rand_gen.nextInt(color_list.length)];
		this.depth = rand_gen.nextInt(2);
		this.name = "Alpha Item";
	}
	
	public String toString() {
		return ("[" + this.name + ", " + this.depth + "]");
	}
}
