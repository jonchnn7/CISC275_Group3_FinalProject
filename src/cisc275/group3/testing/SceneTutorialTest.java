package cisc275.group3.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.model.scene.SceneTitle;
import cisc275.group3.model.scene.SceneTutorial;
import cisc275.group3.utility.EnumSceneType;

public class SceneTutorialTest {
	// Scene Variables
	  private final int SCENE_WIDTH = 1280;
	  private final int SCENE_HEIGHT = 720;
	  private SceneTutorial testTutorial;
	  
	 /**
	   * Before each test, reset testTitle
	   * to a new instance of SceneTitle.java
	   */
	  @Before
	  public void sceneSetup() {
	    testTutorial = new SceneTutorial("Test Tutorial", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/tutorial_bg_2.png", EnumSceneType.TUTORIAL);
	    testTutorial.update();
	  }
	  
	  /**
	   * test the initial attributes of the scene
	   */
	  @Test
	  public void testCreation() {    
		    System.out.println("  Testing Initial Conditions");		    
		    assertEquals("SceneTitle Time = 0", 0, testTutorial.getTime());

		    assertEquals("Scene has a crab", "Atlantic Blue Crab", testTutorial.getSceneItems().get(0).getPassport().getName());
		    assertEquals("Scene has a striped bass = 0", "Striped Bass", testTutorial.getSceneItems().get(1).getPassport().getName());
		    assertEquals("Scene has a heron", "Great Blue Heron", testTutorial.getSceneItems().get(2).getPassport().getName());
		    
		  }
	  
	  
}