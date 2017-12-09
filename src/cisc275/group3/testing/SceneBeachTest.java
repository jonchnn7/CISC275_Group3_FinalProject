package cisc275.group3.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.scene.SceneBeach;
import cisc275.group3.sceneobject.BetaCrab;
import cisc275.group3.utility.EnumSceneType;

/**
 * Test class for SceneBeach.java properties
 * and methods not included in the abstract
 * class Scene.java.
 * 
 * @author Ryan
 */
public class SceneBeachTest {
	  // Scene Variables
	  private final int SCENE_WIDTH = 1280;
	  private final int SCENE_HEIGHT = 720;
	  private SceneBeach testBeach;
	 
	  // Testing Variables
	  private int leftCrabCount = 0;
	  private int rightCrabCount = 0;
	  
	  /**
	   * Before each test, reset testBeach
	   * to a new instance of SceneBeach.java
	   */
	  @Before
	  public void sceneSetup() {
	    testBeach = new SceneBeach("Test Beach", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/backgrounds/beach_bg.jpg", EnumSceneType.DEFAULT);
	  }
	  
	  /**
	   * Test scene is constructed/filled correctly.
	   * <p>
	   * There should be 10 items created when a 
	   * beach scene of type 2 is initialized. 
	   * Specifically, 5 each of left facing and
	   * right facing crabs.
	   */
	  @Test
	  public void testCreation() {    
	    System.out.println("  Testing Initial Conditions");
	    
	    assertEquals("Created Crabs = 10", 10, testBeach.getSceneItems().size());
	    
	    // Count left and right crabs
	    testBeach.getSceneItems().forEach((crab)->{
	      if (((BetaCrab)crab).getLeftCrab()) {
	        leftCrabCount += 1;
	      } else {
	        rightCrabCount += 1;
	      }
	    });
	    
	    // Left crab should = right crab
	    assertEquals("Number Left Crabs - Number Right Crabs = 0", 0, leftCrabCount - rightCrabCount);
	  }
	  
	  /**
	   * Scene update should result in at least as
	   * many total crabs as initially created. 
	   * <p>
	   * In all cases, the variance of crabs with
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
	    for (int i=0; i < testBeach.getSceneItems().size(); i++) {
	      varianceInit += Math.pow((testBeach.getSceneItems().get(i).getLocation().getX() - midpoint), 2);
	    }
	    
	    varianceInit = varianceInit / testBeach.getSceneItems().size();
	    
	    testBeach.update();
	    
	    // Calculate updated variance
	    for (int i=0; i < testBeach.getSceneItems().size(); i++) {
	      varianceFinal += Math.pow((testBeach.getSceneItems().get(i).getLocation().getX() - midpoint), 2);
	    }
	    
	    varianceFinal = varianceFinal / testBeach.getSceneItems().size();
	    
	    // Print standard deviations (\u03C3 = sigma)
	    System.out.println("    Initial \u03C3: " + Math.sqrt(varianceInit));
	    System.out.println("    Final \u03C3: " + Math.sqrt(varianceFinal));
	    
	    // Final should be less than Init
	    assertEquals("Crabs Nearer Midpoint = True", true, (varianceFinal - varianceInit < 0));
	  }
	  
	  /**
	   * Tests new crab generation via update
	   * method.
	   * <p>
	   * Update is called one less time than 
	   * would allow crabs to cross the screen.
	   * The final state should have greater
	   * than or equal number of crabs as the
	   * initial state.
	   */
	  @Test
	  public void testCrabGen() {
	    System.out.println("  Testing New Crab Generation");
	    double updateCount = SCENE_WIDTH / (((BetaCrab)testBeach.getSceneItems().get(0)).getSpeedX()*1.2);
	    int countInitial = testBeach.getSceneItems().size();
	    
	    for (int i=0; i < updateCount; i++) {
	      testBeach.update();
	    }
	    
	    int countFinal = testBeach.getSceneItems().size();

	    // Print counts
	    System.out.println("    Initial Count: " + countInitial);
	    System.out.println("    Final Count: " + countFinal);
	    
	  }

}
