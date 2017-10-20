import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BeachScene extends Scene {

	Random rand_gen = new Random();
	
	public BeachScene(int width, int height) {
		super(width, height, "Beach");
		this.scene_background = Color.yellow;
		this.time = 314;
		this.visible = true;
		this.fillScene();
	}

	protected void fillScene() {
		this.scene_items = new ArrayList<SceneObject>();
		
		for (int i=0; i < 10; i++)
			this.scene_items.add(new AlphaItem(rand_gen.nextInt(this.scene_width),
											   rand_gen.nextInt(this.scene_height),
											   rand_gen.nextInt(100) + 50,
											   rand_gen.nextInt(100) + 50) );
		Collections.sort(this.scene_items);
	}
	
}

