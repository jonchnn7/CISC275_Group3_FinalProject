package cisc275.group3.scene;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import cisc275.group3.sceneobjects.AlphaCrab;
import cisc275.group3.sceneobjects.AlphaCrabPlayer;
import cisc275.group3.sceneobjects.SceneObject;

public class BeachScene extends Scene {

	Random rand_gen = new Random();
	boolean start_game;
	
	public BeachScene(int width, int height) {
		super(0, INTERFACE_HEIGHT, width, height-2*INTERFACE_HEIGHT, "Beach");
		this.scene_background_color = Color.yellow;
		this.time = 314;
		this.visible = true;
		this.start_game = false;
		this.fillScene();
	}

	protected void fillScene() {
		this.scene_items = new ArrayList<SceneObject>();
		
		for (int i=0; i<4; i++) {
			this.scene_items.add(new AlphaCrab(100, 200+75*i, 1));
		}
		
		this.scene_items.add(new AlphaCrabPlayer(100, 500));
	}
	
	@Override
	public Color processClick(int click_x, int click_y) {
		System.out.println(this.scene_items);
		this.start_game = true;
		((AlphaCrabPlayer)scene_items.get(4)).move();

		return null;
	}

	public void moveCrabs() {
		if (this.start_game) {
			((AlphaCrab)scene_items.get(0)).move();
			((AlphaCrab)scene_items.get(1)).move();
			((AlphaCrab)scene_items.get(2)).move();
			((AlphaCrab)scene_items.get(3)).move();
		}
	}
	
}

