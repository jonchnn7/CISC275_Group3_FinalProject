package cisc275.group3.model.scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import cisc275.group3.model.sceneobject.NavObject;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.SceneId;

public class HQScene extends Scene implements PropertyScored, PropertyTimed {
		
	public HQScene(SceneId mani, boolean click, boolean vis) {
		super(mani, click, vis);
		navObjects.add(new NavObject(100,100, "Map"));
		backgroundColor = Color.BLACK;
		//time = 300;
	}
	
	public HQScene(String n, double x, double y, double w, double h, boolean click, boolean vis) {
		this(new SceneId(n, x, y, w, h), click, vis);
		
	}
	
	public void updateTime() {}
	public void updateScore() {}
	public int getTime() {
		return 0;
	}
	public int getScore() {
		return 0;
	}
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
