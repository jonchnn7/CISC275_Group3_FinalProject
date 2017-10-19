import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class HeadquartersScene extends Scene {

	Random rand_gen = new Random();
	
	public HeadquartersScene(int width, int height) {
		super(width, height, "Headquarters");
		this.scene_background = Color.green;
		this.time = 200;
		this.visible = true;
		this.fillScene();
	}

	protected void fillScene() {
		this.scene_items = new ArrayList<SceneObject>();
		
		for (int i=0; i < 10; i++)
			this.scene_items.add(new AlphaItem(rand_gen.nextInt(this.scene_width),
											   rand_gen.nextInt(this.scene_height),
											   rand_gen.nextInt(150) + 50,
											   rand_gen.nextInt(150) + 50) );
	}
}
