package cisc275.group3.scene;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import cisc275.group3.sceneobjects.AlphaItem;
import cisc275.group3.sceneobjects.NavObject;
import cisc275.group3.sceneobjects.SceneObject;

public class HeadquartersScene extends Scene {

	Random rand_gen = new Random();
	private ArrayList<SceneObject> nav_items;
	
	public HeadquartersScene(int width, int height) {
		super(0, INTERFACE_HEIGHT, width, height-2*INTERFACE_HEIGHT, "Headquarters");
		this.scene_background_color = Color.green;
		this.time = 200;
		this.visible = true;
		this.fillScene();
	}

	protected void fillScene() {
		this.nav_items = new ArrayList<SceneObject>();
		this.nav_items.add(new NavObject(this.scene_width/2-100, this.start_y+70, 200, 100, "Missions"));	
	}
	
	@Override
	public void drawScene(Graphics g) {
		super.drawScene(g);
        		
		nav_items.forEach((item)->{
			item.drawItem(g);
		});

    }
	
	public String navClick(int click_x, int click_y) {		
		for (SceneObject nav : nav_items ) {
			if (nav.itemClicked(click_x, click_y))
				return ((NavObject)nav).navClick();
		}
		
		return null;
	}
	
}