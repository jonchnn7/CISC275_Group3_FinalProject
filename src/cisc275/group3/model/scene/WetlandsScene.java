package cisc275.group3.model.scene;

import java.awt.Color;

import cisc275.group3.model.sceneobject.NavObject;
import cisc275.group3.utility.SceneId;

public class WetlandsScene extends Scene{
	public WetlandsScene(SceneId mani, boolean click, boolean vis) {
		super(mani, click, vis);
		navObjects.add(new NavObject(100,100, "Map"));
		backgroundColor = Color.MAGENTA;
	}

	public WetlandsScene(String n, double x, double y, double w, double h, boolean click, boolean vis) {
		this(new SceneId(n, x, y, w, h), click, vis);
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
