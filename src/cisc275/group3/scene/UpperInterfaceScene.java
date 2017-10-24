package cisc275.group3.scene;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import cisc275.group3.sceneobjects.NavObject;
import cisc275.group3.sceneobjects.SceneObject;

public class UpperInterfaceScene extends Scene {		
	
	protected ArrayList<SceneObject> interface_items;
	protected ArrayList<SceneObject> nav_items;

	public UpperInterfaceScene(int width, String name) {
		super(0, 0, width, INTERFACE_HEIGHT, name);
		this.scene_background_color = Color.darkGray;
	
		nav_items = new ArrayList<SceneObject>();
		this.nav_items.add(new NavObject(5, 5, "HQ"));
		this.nav_items.add(new NavObject(5, 40, "Bay"));
		this.nav_items.add(new NavObject(110, 5, "Beach"));
		this.nav_items.add(new NavObject(110, 40, "Wetlands"));
	}

	@Override
	protected void fillScene() {
		// TODO Auto-generated method stub
		
	}
	
	public void drawScene(Graphics g, int score) {
        g.setColor(this.scene_background_color);
        g.fillRect(0, 0, this.scene_width, INTERFACE_HEIGHT);
        
        g.setColor(Color.white);
		g.setFont(new Font("Sans Serif", Font.BOLD, 42));
		g.drawString("Estuary Click Adventure!",(this.scene_width/2)-g.getFontMetrics().stringWidth("Estuary Click Adventure!")/2,50);
		
        g.setColor(Color.white);
		g.setFont(new Font("Sans Serif", Font.BOLD, 25));
		g.drawString("Score: " + score, this.scene_width-150, this.scene_height-25);
		
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
