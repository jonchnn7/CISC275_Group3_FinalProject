import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BayScene extends Scene {

	Random rand_gen = new Random();
	
	public BayScene(int interface_width, int width, int height) {
		super(interface_width, width, height, "Bay");
		this.scene_background = Color.blue;
		this.time = 350;
		this.visible = false;
		this.fillScene();
	}

	protected void fillScene() {
		this.scene_items = new ArrayList<SceneObject>();
		
		for (int j=0; j<10; j++) {
			int length = rand_gen.nextInt(20) + 15;
			this.scene_items.add(new AlphaFish(0, 
											   j*70 + 10,
											   length,
											   length/2,
											   j,
											   true));
			this.scene_items.add(new AlphaFish(this.scene_width, 
					   j*70 + 10,
					   length,
					   length/2,
					   -1*j,
					   false));
		
		Collections.sort(scene_items);	
		}
	}
	
	public void move() {
		for (SceneObject fish : scene_items)
			((AlphaFish)fish).move();
	}
}
