import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BeachScene extends Scene {

	Random rand_gen = new Random();
	
	public BeachScene(int interface_width, int width, int height) {
		super(interface_width, width, height, "Beach");
		this.scene_background = Color.yellow;
		this.time = 314;
		this.visible = true;
		this.fillScene();
	}

	protected void fillScene() {
		this.scene_items = new ArrayList<SceneObject>();
		
		for (int i=0; i<4; i++) {
			this.scene_items.add(new AlphaCrab(200, 200+75*i));
		}
		
		this.scene_items.add(new AlphaCrabPlayer(200, 500));
		Collections.sort(this.scene_items);
	}
	
	@Override
	public void updateTime() {
		this.time -= 1;
		
		if (this.visible) {
			for (SceneObject crab : scene_items) 
				((AlphaCrab)crab).move();
		}
	}
	
}

