import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class WetlandsScene extends Scene {

	Random rand_gen = new Random();
	
	public WetlandsScene(int width, int height) {
		super(width, height, "Wetlands");
		this.scene_background = Color.lightGray;
		this.time = 200;
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