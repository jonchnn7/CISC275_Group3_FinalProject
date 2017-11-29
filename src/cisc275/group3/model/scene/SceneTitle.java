package cisc275.group3.model.scene;

import javax.swing.JButton;

import cisc275.group3.utility.SceneId;
/**
 * SceneTitle extends scene and is used to represent the title screen
 * 
 * @author Scott
 * @author Ryan
 */
public class SceneTitle extends Scene{

	/**
	 * Constructor 
	 * @param mani sceneid used to distinguish between scenes
	 */
	public SceneTitle(SceneId mani) {
		super(mani);
		time = 0;

		if (this.getManifest().getSceneType() == 99) {
			fillScene();
		}
	}
	
	public SceneTitle(String n, double x, double y, double w, double h, String bg, int sceneType) {
		this(new SceneId(n, x, y, w, h, sceneType, bg));
	}

	@Override
	protected void fillScene() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public static void add(JButton hqButton) {
		// TODO Auto-generated method stub
		
	}

}
