package cisc275.group3.scene;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import cisc275.group3.sceneobjects.AlphaItem;
import cisc275.group3.sceneobjects.MissionFish;
import cisc275.group3.sceneobjects.SceneImageObject;
import cisc275.group3.sceneobjects.SceneObject;

public class WetlandsScene extends Scene {

	Random rand_gen = new Random();
	
	public WetlandsScene(int width, int height) {
		super(0, INTERFACE_HEIGHT, width, height-2*INTERFACE_HEIGHT, "Wetlands");
		this.scene_background_color = Color.lightGray;
		this.time = 271;
		this.visible = true;
		this.fillScene();
	}

	protected void fillScene() {
		for (int j=-10; j<10; j++)
			this.scene_items.add(new AlphaItem(rand_gen.nextInt(this.scene_width/2)+20,
											   rand_gen.nextInt(this.scene_height),
										   	   rand_gen.nextInt(100) + 50,
										       rand_gen.nextInt(100) + 50,
										       j) );
//		for (int j=-10; j<10; j++)
//			this.scene_items.add(new AlphaItem(rand_gen.nextInt(this.scene_width/2)+this.scene_width/2+20,
//											   rand_gen.nextInt(this.scene_height),
//										   	   rand_gen.nextInt(100) + 50,
//										       rand_gen.nextInt(100) + 50,
//										       j) );
		Collections.sort(this.scene_items);
		
		this.scene_items_images.add(new MissionFish(250,250,3));
		
		
	}
	
}