package cisc275.group3.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.scene.SceneHQ;
import cisc275.group3.sceneobject.ObjectPerson;
import cisc275.group3.utility.ConstructPerson;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.utility.ObjectId;


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
	 private SceneHQ testHQTut;

	 
	// Testing Variables
	  private int Person = 0;
	 
	 
	 /**
	   * Before each test, reset testHQ
	   * to a new instance of SceneHQ.java
	   */
	  @Before
	  public void sceneSetup() {
	    testHQ = new SceneHQ("Test HQ", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/backgrounds/HQ_bg.jpg", EnumSceneType.DEFAULT);
	    testHQTut = new SceneHQ("Test HQ", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/backgrounds/HQ_bg.jpg", EnumSceneType.TUTORIAL);
	    
	  }
	  
	  /**
	   * Test scene is constructed/filled correctly.
	   */
	  @Test
	  public void testCreation() {    
	    System.out.println("  Testing Initial Conditions");
	    
		assertEquals("Time = 0", 0, testHQ.getTime());
	  }
	  
	  /**
	   * Test scene is constructed/filled correctly.
	   */
	  @Test
	  public void testUpdate() {    
	    System.out.println("  Testing Update");
	    
	    testHQ.update();
		assertEquals("sceneItems.size = 1" , 1, testHQ.getSceneItems().size());
		assertEquals("prevPerson != currentPerson.id" , true, testHQ.getPrevPerson() != testHQ.getSceneItems().get(0).getPassport().getId());
		assertEquals("Person moved to X = 1" , 1220, testHQ.getSceneItems().get(0).getLocation().getX(),5);
		
		
	    //Person Changing to state 0
		testHQ.getSceneItems().clear();
		testHQ.getSceneItems().add(ConstructPerson.constructPerson(5, 3, 550, SCENE_HEIGHT/4));
		testHQ.update();
		assertEquals("Person2.status = 0", 0, ((ObjectPerson)testHQ.getSceneItems().get(0)).getStatus());
		
	  }

	  
	  /**
	   * Testing the removePerson method
	   */
	  @Test
	  public void removePersonTest() {
			testHQ.getSceneItems().add(ConstructPerson.constructPerson(5, 3, SCENE_WIDTH+4000, SCENE_HEIGHT/4));
			testHQ.update();
			
			assertEquals("sceneItems.size = 0" , 0, testHQ.getSceneItems().size());
	  }
	  
	  /**
	   * Testing the isMissionClickable method
	   */
	  @Test
	  public void isMissionClickableTest() {
		  	assertEquals("isClickable = false", false, testHQ.isMissionClickable());
			testHQ.getSceneItems().add(new ObjectPerson(new ObjectId(10, 50, 50, "", "Tut Person", 50), 550, 500, 0, 0, 1));			
		  	assertEquals("isClickable = false", false, testHQ.isMissionClickable());
		  	testHQ.getSceneItems().clear();
			testHQ.getSceneItems().add(new ObjectPerson(new ObjectId(10, 50, 50, "", "Tut Person", 50), 550, 500, 0, 0, 0));
		  	assertEquals("isClickable = true", true, testHQ.isMissionClickable());
	  }
	  
}
