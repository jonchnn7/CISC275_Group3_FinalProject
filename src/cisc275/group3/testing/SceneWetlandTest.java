package cisc275.group3.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.model.scene.SceneBay;
import cisc275.group3.model.scene.SceneWetland;
import cisc275.group3.model.sceneobject.BetaFish;
import cisc275.group3.utility.EnumSceneType;

/**
 * Test class for SceneWetland.java properties
 * and methods not included in the abstract
 * class Scene.java.
 * 
 * @author Scott
 */
public class SceneWetlandTest {
  // Scene Variables
  private final int SCENE_WIDTH = 1280;
  private final int SCENE_HEIGHT = 720;
  private SceneWetland testWetland;
 
//  // Testing Variables
//  private int leftFishCount = 0;
//  private int rightFishCount = 0;
  
  /**
   * Before each test, reset testBay
   * to a new instance of SceneBay.java
   */
  @Before
  public void sceneSetup() {
    testWetland = new SceneWetland("Test Wetland", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/wetland_bg.png", EnumSceneType.DEFAULT);
  }
  
  /**
   * Test scene is constructed/filled correctly.
   * <p>
   * There should be 6 items created when a 
   * wetland scene of type DEFAULT is initialized.
   */
  @Test
  public void testCreation() {    
    System.out.println("  Testing Initial Conditions"); 
    
    assertEquals("Created Vegetation = 6", 6, testWetland.getSceneItems().size());
  }
 
}
