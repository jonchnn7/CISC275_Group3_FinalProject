package cisc275.group3.model.scene;

import java.util.ArrayList;

import cisc275.group3.utility.SceneId;



public class BayScene extends Scene implements PropertyScored, PropertyTimed {
	
	public BayScene(boolean c, SceneId m, boolean v) {
		super(c, m, v);
		time = 350;
		visible = false;
		fillScene();
	}

	protected void fillScene() {		
		for (int j=0; j<5; j++) {
			int length = rand_gen.nextInt(20) + 15;
			scene_items.add(new FishAlpha(0-length, 
				j*140 + this.start_y + 10,
				length,
				length/2,
	  		    j+1,
				true));
			scene_items.add(new AlphaFish(this.scene_width+length, 
				j*140 + this.start_y + 10,
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
			this.scene_items.add(new AlphaFish(0-length, 
                rand_gen.nextInt(this.scene_height) + this.start_y,
			    length,
				length/2,
				rand_gen.nextInt(10)+5,
				true));
			this.scene_items.add(new AlphaFish(this.scene_width+length, 
				rand_gen.nextInt(this.scene_height) + this.start_y,
				length,
				length/2,
				-1*rand_gen.nextInt(10)-5,
				false));		
		}
		
		for (SceneObject fish : scene_items)
			((AlphaFish)fish).move();
		
		removeFish();
	}
	
	private void removeFish() {
		for (Iterator<SceneObject> iterator = scene_items.iterator(); iterator.hasNext();) {
			AlphaFish fish = (AlphaFish)iterator.next();
			if ( fish.getLTR() && fish.getX() >= (this.scene_width+fish.getWidth()) ) {
				iterator.remove();
			
			} else if ( !fish.getLTR() && fish.getX() <= (0-fish.getWidth()) ) { 
				iterator.remove();
			}
		}
	}
}