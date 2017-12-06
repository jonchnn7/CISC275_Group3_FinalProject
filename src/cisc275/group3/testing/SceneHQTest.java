package cisc275.group3.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.model.scene.SceneHQ;
import cisc275.group3.utility.EnumSceneType;


/**
 * Test class for SceneHQ.java properties
 * and methods not included in the abstract
 * class Scene.java.
 * 
 * @author Jolyne
 */
public class SceneHQTest {
	// Scene Variables
	 private final int SCENE_WIDTH = 1280;
	 private final int SCENE_HEIGHT = 720;
	 private SceneHQ testHQ;
	 
	// Testing Variables
	  private int Person = 0;
	 
	 
	 /**
	   * Before each test, reset testHQ
	   * to a new instance of SceneHQ.java
	   */
	  @Before
	  public void sceneSetup() {
	    testHQ = new SceneHQ("Test HQ", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/backgrounds/HQ_bg.jpg", EnumSceneType.DEFAULT);

	  }
	  
	  /**
	   * Test scene is constructed/filled correctly.
	   * <p>
	   */
	  @Test
	  public void testCreation() {    
	    System.out.println("  Testing Initial Conditions");
	    
	    
	    
	    testHQ.update();
	  }
}
