package cisc275.group3.model.scene;


import java.util.Collections;
import java.util.Iterator;

import cisc275.group3.controller.ControllerInventory;
import cisc275.group3.model.sceneobject.BetaFish;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.ConstructFish;
import cisc275.group3.utility.SceneId;

/**
 * Bay scene/model. 
 * <p>
 * The bay scene implements scoring and timing functions 
 * via interface implementations. The ConstructFish 
 * interface holds component definitions for fish objects,
 * and static functions to return fish objects. 
 * <p>
 * SceneBay.java
 * <p>
 * @author Thomas
 */
@SuppressWarnings("serial")
public class SceneInventory extends Scene  {

  public SceneInventory(SceneId mani) {
    super(mani);
    System.out.println("Created");
    fillScene();
  }
  
  /**
   * Used when SceneId must also be created
   */ 
  public SceneInventory(String n, double x, double y, double w, double h, int sceneType, String bg) {
	    this(new SceneId(n, x, y, w, h, sceneType, bg));
	  }
  
  /**
   * Creates initial screen of five left-to-right and
   * right-to left fish at different depths. List of 
   * fish is then sorted by depth.
   */
  @Override
  protected void fillScene() {
    sceneItems = ControllerInventory.getSceneItems();
    System.out.println("Filling");
    Collections.sort(sceneItems); // sort by depth
  }
  
  
  @Override
  public void update() {
	  System.out.println("Inventory Called");
  }

}