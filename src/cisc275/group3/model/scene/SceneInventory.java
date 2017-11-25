package cisc275.group3.model.scene;


import java.util.Collections;
import cisc275.group3.controller.ControllerInventory;
import cisc275.group3.exceptions.InsufficientDataException;
import cisc275.group3.utility.SceneId;

/**
 *Inventory scene/model. 
 * <p>
 * The inventory scene tracks the items collected during 
 * missions and provides mechanisms for their retrieval.
 * <p>
 * The primary purpose of the inventory is to provide the
 * player with a list of items collected.
 * <p>
 * SceneInventory.java
 * <p>
 * @author Thomas 
 * @author Scott 
 */
@SuppressWarnings("serial")
public class SceneInventory extends Scene  {
  
  public SceneInventory(SceneId mani) {
    super(mani);
    //System.out.println("Created");
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
    //System.out.println("Filling");
    Collections.sort(sceneItems); // sort by depth
  }
  
  
  @Override
  public void update() {
	  //System.out.println("Inventory Called");
  }

}