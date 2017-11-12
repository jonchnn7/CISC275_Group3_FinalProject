package cisc275.group3.model.scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import cisc275.group3.model.sceneobject.NavObject;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.SceneId;

public class SceneHQ extends Scene implements PropertyScored, PropertyTimed {
		
  public SceneHQ(SceneId mani) {
    super(mani);
    time = 300;
  }
	
  public SceneHQ(String n, double x, double y, double w, double h, String bg) {
    this(new SceneId(n, x, y, w, h, bg));
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
