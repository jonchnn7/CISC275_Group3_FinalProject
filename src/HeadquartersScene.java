import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
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
		
		for (int j=-10; j<10; j++)
			this.scene_items.add(new AlphaItem(rand_gen.nextInt(this.scene_width/2)+20,
											   rand_gen.nextInt(this.scene_height),
										   	   rand_gen.nextInt(100) + 50,
										       rand_gen.nextInt(100) + 50,
										       j) );
		for (int j=-10; j<10; j++)
			this.scene_items.add(new AlphaItem(rand_gen.nextInt(this.scene_width/2)+this.scene_width/2+20,
											   rand_gen.nextInt(this.scene_height),
										   	   rand_gen.nextInt(100) + 50,
										       rand_gen.nextInt(100) + 50,
										       j) );
		
		
		Collections.sort(this.scene_items);
	}
	
}
