package cisc275.group3.model.scene;

import cisc275.group3.utility.SceneId;

public class SceneHQ extends Scene implements PropertyScored, PropertyTimed {
		
  public SceneHQ(SceneId mani) {
    super(mani);
    time = 300;
  }
	
  public SceneHQ(String n, double x, double y, double w, double h, int sceneType, String bg) {
    this(new SceneId(n, x, y, w, h, sceneType, bg));
  }
	
  @Override
  protected void fillScene() {
    // TODO Auto-generated method stub
  }
	
  public void update() {
    // TODO Auto-generated method stub
  }

  @Override
  public int getTime() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void updateTime() {
    // TODO Auto-generated method stub
  }

  @Override
  public int getScore() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void updateScore() {
    // TODO Auto-generated method stub
  }
}
