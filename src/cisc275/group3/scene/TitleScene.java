package cisc275.group3.scene;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import cisc275.group3.sceneobjects.AlphaItem;
import cisc275.group3.sceneobjects.SceneObject;

///IS thsi working?

public class TitleScene extends Scene {

	Random rand_gen = new Random();
	
	public TitleScene(int width, int height) {
		super(0, INTERFACE_HEIGHT, width, height-2*INTERFACE_HEIGHT, "Wetlands");
		this.scene_background_color = Color.black;
		this.visible = true;
		this.fillScene();
	}

	protected void fillScene() {
		this.scene_items = new ArrayList<SceneObject>();
		
		
		Collections.sort(this.scene_items);
	}
	
}