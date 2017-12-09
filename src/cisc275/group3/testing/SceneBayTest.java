package cisc275.group3.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.scene.SceneBay;
import cisc275.group3.sceneobject.ObjectFish;
import cisc275.group3.utility.EnumSceneType;

/**
 * Test class for SceneBay.java properties
 * and methods not included in the abstract
 * class Scene.java.
 * 
 * @author Scott
 */
public class SceneBayTest {
  // Scene Variables
  private final int SCENE_WIDTH = 1280;
  private final int SCENE_HEIGHT = 720;
  private SceneBay testBay;
 
  // Testing Variables
  private int leftFishCount = 0;
  private int rightFishCount = 0;
  
  /**
   * Before each test, reset testBay
   * to a new instance of SceneBay.java
   */
  @Before
  public void sceneSetup() {
    testBay = new SceneBay("Test Bay", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/bay_bg_1.png", EnumSceneType.DEFAULT);
  }
  
  /**
   * Test scene is constructed/filled correctly.
   * <p>
   * There should be 10 items created when a 
   * bay scene of type 2 is initialized. 
   * Specifically, 5 each of left facing and
   * right facing fish.
   */
  @Test
  public void testCreation() {    
    System.out.println("  Testing Initial Conditions");
    
    assertEquals("Created Fish = 10", 10, testBay.getSceneItems().size());
    
    // Count left and right fish
    testBay.getSceneItems().forEach((fish)->{
      if (((ObjectFish)fish).getLeftFish()) {
        leftFishCount += 1;
      } else {
        rightFishCount += 1;
      }
    });
    
    // Left fish should = right fish
    assertEquals("Number Left Fish - Number Right Fish = 0", 0, leftFishCount - rightFishCount);
  }
  
  /**
   * Scene update should result in at least as
   * many total fish as initially created. 
   * <p>
   * In all cases, the variance of fish with
   * respect to the scene midpoint (x-axis) 
   * should be smaller after update. 
   */
  @Test
  public void testUpdate() {
    double varianceInit = 0;
    double varianceFinal = 0;
    double midpoint = SCENE_WIDTH/2;
    
    System.out.println("  Testing Update");
    
    // Calculate initial variance
    for (int i=0; i < testBay.getSceneItems().size(); i++) {
      varianceInit += Math.pow((testBay.getSceneItems().get(i).getLocation().getX() - midpoint), 2);
    }
    
    varianceInit = varianceInit / testBay.getSceneItems().size();
    
    testBay.update();
    
    // Calculate updated variance
    for (int i=0; i < testBay.getSceneItems().size(); i++) {
      varianceFinal += Math.pow((testBay.getSceneItems().get(i).getLocation().getX() - midpoint), 2);
    }
    
    varianceFinal = varianceFinal / testBay.getSceneItems().size();
    
    // Print standard deviations (\u03C3 = sigma)
    System.out.println("    Initial \u03C3: " + Math.sqrt(varianceInit));
    System.out.println("    Final \u03C3: " + Math.sqrt(varianceFinal));
    
    // Final should be less than Init
    assertEquals("Fish Nearer Midpoint = True", true, (varianceFinal - varianceInit < 0));
  }
  
  /**
   * Tests new fish generation via update
   * method.
   * <p>
   * Update is called one less time than 
   * would allow fish to cross the screen.
   * The final state should have greater
   * than or equal number of fish as the
   * initial state.
   */
  @Test
  public void testFishGen() {
    System.out.println("  Testing New Fish Generation");
    double updateCount = SCENE_WIDTH / (((ObjectFish)testBay.getSceneItems().get(0)).getSpeedX()*1.2);
    int countInitial = testBay.getSceneItems().size();
    
    for (int i=0; i < updateCount; i++) {
      testBay.update();
    }
    
    int countFinal = testBay.getSceneItems().size();

    // Print counts
    System.out.println("    Initial Count: " + countInitial);
    System.out.println("    Final Count: " + countFinal);
    
    // Final should be greater or equal to Initial
    assertEquals("Updated Fish Count >= Initial Count", true, (countFinal - countInitial >= 0));
    
  }
  
}
