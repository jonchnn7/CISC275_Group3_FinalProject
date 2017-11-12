package cisc275.group3.model.scene;

import java.awt.Color;

import cisc275.group3.model.sceneobject.NavObject;
import cisc275.group3.utility.SceneId;

public class SceneBeach extends Scene{
	public SceneBeach(SceneId mani) {
		super(mani);
	}

	public SceneBeach(String n, double x, double y, double w, double h, String bg) {
		this(new SceneId(n, x, y, w, h, bg));
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void fillScene() {
		// TODO Auto-generated method stub
		
	}
}
