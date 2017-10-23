import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
		
		for (int j=0; j<5; j++) {
			int length = rand_gen.nextInt(20) + 15;
			this.scene_items.add(new AlphaFish(0, 
											   j*140 + 10,
											   length,
											   length/2,
											   j+1,
											   true));
			this.scene_items.add(new AlphaFish(this.scene_width, 
					   j*140 + 10,
					   length,
					   length/2,
					   -1*j-1,
					   false));
		
		Collections.sort(scene_items);	
		}
	}
	
	public void move() {
		int length = rand_gen.nextInt(20) + 15;
		
		// Generate new fish on ~4% of calls
		if (rand_gen.nextInt(25) == 1) {
			this.scene_items.add(new AlphaFish(0, 
					   						   rand_gen.nextInt(this.scene_height),
					   						   length,
					   						   length/2,
					   						   rand_gen.nextInt(5)+5,
					   						   true));
			this.scene_items.add(new AlphaFish(this.scene_width, 
					               			   rand_gen.nextInt(this.scene_height),
					               			   length,
					               			   length/2,
					               			   -1*rand_gen.nextInt(5)+5,
					               			   false));		
		}
		
		for (SceneObject fish : scene_items)
			((AlphaFish)fish).move();
		
		removeFish();
	}
	
	private void removeFish() {
		for (Iterator<SceneObject> iterator = scene_items.iterator(); iterator.hasNext();) {
			AlphaFish fish = (AlphaFish)iterator.next();
			if ( fish.left_to_right && fish.item_x >= this.scene_width ) {
				iterator.remove();
			
			} else if ( !fish.left_to_right && fish.item_x <= 0 ) { 
				iterator.remove();
			}
		}
	}
}
