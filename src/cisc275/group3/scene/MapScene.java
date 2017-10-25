package cisc275.group3.scene;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import cisc275.group3.sceneobjects.NavObject;
import cisc275.group3.sceneobjects.SceneObject;

public class MapScene extends Scene {

	Collection<SceneObject> nav_items;
	Random rand_gen = new Random();
	
	public MapScene(int width, int height) {
		super(0, INTERFACE_HEIGHT, width, height-2*INTERFACE_HEIGHT, "Map");
		this.scene_background_color = Color.white;
		this.time = 200;
		this.visible = false;
		
		this.nav_items = new ArrayList<SceneObject>();
		this.nav_items.add(new NavObject(this.scene_width/2-100, this.start_y+70, 200, 100, "HQ"));
		this.nav_items.add(new NavObject(this.scene_width/2-100, this.start_y+175, 200, 100, "Bay"));
		this.nav_items.add(new NavObject(this.scene_width/2-100, this.start_y+280, 200, 100, "Beach"));
		this.nav_items.add(new NavObject(this.scene_width/2-100, this.start_y+385, 200, 100, "Wetlands"));
	}
	
	
	@Override
	public void drawScene(Graphics g) {
        g.setColor(this.scene_background_color);
        g.fillRect(this.start_x, this.start_y, this.scene_width, this.scene_height);
        		
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
	
	
	@Override
	protected void fillScene() {
		// TODO Auto-generated method stub
		
	}	
}
