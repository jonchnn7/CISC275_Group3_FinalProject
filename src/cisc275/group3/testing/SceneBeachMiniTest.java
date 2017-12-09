package cisc275.group3.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.scene.SceneBay;
import cisc275.group3.scene.SceneBeachMini;
import cisc275.group3.sceneobject.BetaFish;
import cisc275.group3.utility.EnumSceneType;

/**
 * Test class for SceneBay.java properties
 * and methods not included in the abstract
 * class Scene.java.
 * 
 * @author Jon
 */
public class SceneBeachMiniTest {
  // Scene Variables
  private final int SCENE_WIDTH = 1280;
  private final int SCENE_HEIGHT = 720;
  private SceneBeachMini testBeachMini;
  
  /**
   * Before each test, reset testBay
   * to a new instance of SceneBeachMini.java
   */
  @Before
  public void sceneSetup() {
    testBeachMini = new SceneBeachMini("Test BeachMini", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/beach_bg.png", EnumSceneType.DEFAULT);
  }
  
  /**
   * Test scene is constructed/filled correctly.
   */
  @Test
  public void testCreation() {    
    System.out.println("  Testing Initial Conditions"); 
    assertEquals("Created Crabs = 3", 3, testBeachMini.getSceneItems().size());
    
  }
  
  /**
   * Test scene is constructed/filled correctly.
   */
  @Test
  public void testUpdate() {    
    System.out.println("  Testing Update Conditions"); 
    testBeachMini.update();
    testBeachMini.update(20);
    assertEquals("Crab 1: location = 63", 63, testBeachMini.getSceneItems().get(0).getLocation().getX(), 5);
    assertEquals("Crab 1: location = 70", 70, testBeachMini.getSceneItems().get(2).getLocation().getX(), 3);
  }
  
}
