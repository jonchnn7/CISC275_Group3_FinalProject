import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MapScene extends Scene {

	Random rand_gen = new Random();
	
	public MapScene(int interface_width, int width, int height) {
		super(interface_width, width, height, "Map");
		this.scene_background = Color.white;
		this.time = 200;
		this.visible = true;
		
		this.nav_items.add(new NavObject(5, "HQ"));
		this.nav_items.add(new NavObject(40, "Bay"));
		this.nav_items.add(new NavObject(75, "Beach"));
		this.nav_items.add(new NavObject(110, "Wetlands"));
		
		this.fillScene();
	}

	protected void fillScene() {
		this.scene_items = new ArrayList<SceneObject>();
		
		for (int j=-10; j<10; j++)
			this.scene_items.add(new AlphaItem(rand_gen.nextInt(this.scene_width/2)-60,
											   rand_gen.nextInt(this.scene_height),
										   	   rand_gen.nextInt(100) + 50,
										       rand_gen.nextInt(100) + 50,
										       j) );
		for (int j=-10; j<10; j++)
			this.scene_items.add(new AlphaItem(rand_gen.nextInt(this.scene_width/2)+this.scene_width/2+60,
											   rand_gen.nextInt(this.scene_height),
										   	   rand_gen.nextInt(100) + 50,
										       rand_gen.nextInt(100) + 50,
										       j) );
		
		
		Collections.sort(this.scene_items);
	}


	
}
