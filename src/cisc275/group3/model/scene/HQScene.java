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
    time = 300;
  }
	
  public HQScene(String n, double x, double y, double w, double h, boolean click, boolean vis) {
    this(new SceneId(n, x, y, w, h), click, vis);
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
