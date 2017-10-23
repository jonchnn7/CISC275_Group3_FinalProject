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
		
		for (int j=-10; j<10; j++)
			this.scene_items.add(new AlphaItem(rand_gen.nextInt(this.scene_width/2)+20,
											   rand_gen.nextInt(this.scene_height),
										   	   rand_gen.nextInt(100) + 50,
										       rand_gen.nextInt(100) + 50,
										       j) );
		for (int j=-10; j<10; j++)
			this.scene_items.add(new AlphaItem(rand_gen.nextInt(this.scene_width-interface_width)+interface_width,
											   rand_gen.nextInt(this.scene_height-interface_width)+interface_width,
										   	   rand_gen.nextInt(100) + 50,
										       rand_gen.nextInt(100) + 50,
										       j) );
		
		Collections.sort(scene_items);
	}

}
