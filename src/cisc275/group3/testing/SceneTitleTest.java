package cisc275.group3.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.model.scene.SceneTitle;
import cisc275.group3.utility.EnumSceneType;

public class SceneTitleTest {
	// Scene Variables
	  private final int SCENE_WIDTH = 1280;
	  private final int SCENE_HEIGHT = 720;
	  private SceneTitle testTitle;
	  
	 /**
	   * Before each test, reset testTitle
	   * to a new instance of SceneTitle.java
	   */
	  @Before
	  public void sceneSetup() {
	    testTitle = new SceneTitle("Test Title", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/backrounds/titleScreen_bg.png", EnumSceneType.DEFAULT);
	    testTitle.update();
	  }
	  
	  @Test
	  public void testCreation() {    
		    System.out.println("  Testing Initial Conditions");		    
		    assertEquals("SceneTitle Time = 0", 0, testTitle.getTime());
		  }
	  
	  
}
