package cisc275.group3.scene;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import cisc275.group3.sceneobjects.NavObject;
import cisc275.group3.sceneobjects.SceneObject;

public class LowerInterfaceScene extends Scene {		
	
	protected ArrayList<SceneObject> interface_items;
	protected ArrayList<SceneObject> nav_items;
	
	private String time_string;
	private String score_string;

	public LowerInterfaceScene(int width, int height, String name) {
		super(0, height-INTERFACE_HEIGHT, width, INTERFACE_HEIGHT, name);
		this.scene_background_color = Color.darkGray;
	}

	@Override
	protected void fillScene() {
		// TODO Auto-generated method stub
		
	}
	
	public void drawScene(Graphics g, int time, int score) {
		time_string = "Time: " + time;
		score_string = "Score: " + score;
		
        g.setColor(this.scene_background_color);
        g.fillRect(this.start_x, this.start_y, this.scene_width, this.scene_height);
        
        g.setColor(Color.white);
		g.setFont(new Font("Sans Serif", Font.BOLD, 38));
		g.drawString(time_string,
		     	     (this.scene_width+this.start_x-g.getFontMetrics().stringWidth(time_string))/2,
		    	     50+this.start_y);
		
		g.setColor(Color.white);
		g.setFont(new Font("Sans Serif", Font.BOLD, 25));
		g.drawString(score_string, 
				     this.scene_width-g.getFontMetrics().stringWidth(score_string)-10, 
				     this.start_y+this.scene_height-g.getFontMetrics().getHeight());
    }

}
