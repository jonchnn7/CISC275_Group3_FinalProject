package cisc275.group3.model.scene;

import java.util.Collections;
import java.util.Iterator;

import cisc275.group3.model.sceneobject.BetaFish;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.ConstructFish;
import cisc275.group3.utility.SceneId;

/**
 * Wetland scene/model. 
 * <p>
 * The Wetland scene implements scoring and timing functions 
 * via interface implementations. The ConstructFish 
 * interface holds component definitions for fish objects,
 * and static functions to return fish objects. 
 * <p>
 * SceneWetland.java
 * <p>
 * @author Ryan
 */
public class SceneWetland extends Scene implements PropertyScored, PropertyTimed {

  public SceneWetland(SceneId mani) {
    super(mani);
    time = 350;

    fillScene();
  }
  
  /**
   * Used when SceneId must also be created
   */ 
  public SceneWetland(String n, double x, double y, double w, double h, String bg) {
    this(new SceneId(n, x, y, w, h, bg));
  }

  
  /**
   * Overridden from PropertyTimed.java
   * @return	time
   */
  @Override
  public int getTime() {
  	return time;
  }

  /**
   * Overridden from PropertyScored.java
   * @return	score
   */
  @Override
  public int getScore() {
  	return score;
  }

  /**
   * Overridden from PropertyScored.java
   */
  @Override
  public void updateScore() {
  	score += 1;
  }

  /**
   * Overridden from PropertyTimed.java
   */
  @Override
  public void updateTime() {
	time -= 1;
  }

@Override
protected void fillScene() {
	// TODO Auto-generated method stub
	
}

@Override
public void update() {
	// TODO Auto-generated method stub
	
}
}