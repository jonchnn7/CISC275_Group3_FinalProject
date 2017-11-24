package cisc275.group3.testing;

import static org.junit.Assert.*;

import java.util.HashMap;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cisc275.group3.exceptions.InsufficientDataException;
import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.SceneBay;
import cisc275.group3.model.scene.SceneBeach;
import cisc275.group3.model.scene.SceneBeachMini;
import cisc275.group3.model.scene.SceneWetland;
import cisc275.group3.model.sceneobject.ToolCamera;
import cisc275.group3.model.sceneobject.ToolNet;
import cisc275.group3.utility.ConstructCrab;
import cisc275.group3.utility.ConstructFish;
import cisc275.group3.utility.ConstructVegetation;
import cisc275.group3.utility.Mission;

/**
 * A series of methods to test common/shared 
 * functionality across all dynamic scenes.
 * @author Scott
 */
public class SceneTests implements ConstructCrab, ConstructFish, ConstructVegetation {
  private static final int SCENE_WIDTH = 1280;
  private static final int SCENE_HEIGHT = 720;
  
  private static HashMap<String, Scene> testList;
  
  /**
   * Create a set of scenes to test
   */
  @BeforeClass
  public static void sceneSetup() {
	  testList = new HashMap<String, Scene>();
	  
	  testList.put("Bay", new SceneBay("Bay Test", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/bay_bg_1.png", 0));
	  testList.put("Beach", new SceneBeach("Beach Test", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/bay_bg_1.png", 0));
	  testList.put("BeachMini", new SceneBeachMini("Beach Mini Test", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/bay_bg_1.png", 0));
	  testList.put("Wetland", new SceneWetland("Wetland Test", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/bay_bg_1.png", 0));
	  
	  baySetup();
	  beachSetup();
	  beachMiniSetup();
	  wetlandSetup();
  }  
  
  /**
   * Tests that empty constructor calls throw
   * the appropriate error.
   */
  @Test
  public void testEmptyCall() {
    System.out.println("  Testing Empty Constructor");
    
    // Bay Test
    System.out.println("    Testing Bay");
    try {
      new SceneBay();
      fail();
    } catch (InsufficientDataException e) {
      // Expected 
    }
    
    // Beach Test
    System.out.println("    Testing Beach");
    try {
      new SceneBeach();
      fail();
    } catch (InsufficientDataException e) {
      // Expected 
    }
    
    // BeachMini Test
    System.out.println("    Testing BeachMini");
    try {
      new SceneBeachMini();
      fail();
    } catch (InsufficientDataException e) {
      // Expected 
    }
    
    // Wetland Test
    System.out.println("    Testing Wetland");
    try {
      new SceneWetland();
      fail();
    } catch (InsufficientDataException e) {
      // Expected 
    }
  }
  
  /**
   * Tests processClick() by setting tools and
   * clicking in the appropriate areas.
   */
  @Test
  public void testProcessClick() {
    // Net Tool
    Scene.setCurrentTool(new ToolNet(0,0,0,0));
    
  }
  
  /**
   * Tests the static variables: tool, mission,
   * fact. Ensures all scenes point to the same
   * variable.
   */
  @Test
  @SuppressWarnings("static-access")
  public void testStaticVariables() {
    System.out.println("  Testing Static Variables");
    testList.forEach((k,v)->{
      System.out.println("    Testing " + k);
      assertEquals("Current Tool = null", null, Scene.getCurrentTool()); 
      //assertEquals("Current Mission = Completed!", "Completed!", Scene.getCurrentMission());
      assertEquals("Set Done Mission = true", true, Scene.getCurrentMission().isDoneMission());
      assertEquals("Current Fact = null fact", "null fact", Scene.getCurrentFact());
    });
    
    // Update Static Variables
    testList.get("Bay").setCurrentMission(new Mission(null, -1));
    testList.get("Bay").setCurrentTool(new ToolCamera(0,0,0,0));
    testList.get("Bay").setCurrentFact("HI!");
    
    // Test Statics Pairwise
    System.out.println("  Testing All Scenes Using Static");
    
    System.out.println("    Bay == Beach");
    assertEquals("Bay.Score == Beach.Score", true,
    		testList.get("Bay").getScore() == testList.get("Beach").getScore());
    assertEquals("Bay.Time == Beach.Time", true,
    		testList.get("Bay").getTime() == testList.get("Beach").getTime());
    assertEquals("Bay.Mission == Beach.Mission", true,
    		testList.get("Bay").getCurrentMission() == testList.get("Beach").getCurrentMission());
    assertEquals("Bay.Tool == Beach.Tool", true, 
    		testList.get("Bay").getCurrentTool() == testList.get("Beach").getCurrentTool());
    assertEquals("Bay.Fact == Beach.Fact", true,
    		testList.get("Bay").getCurrentFact() == testList.get("Beach").getCurrentFact());
    
    System.out.println("    Beach == BeachMini");
    assertEquals("Beach.Score == BeachMini.Score", true,
    		testList.get("Beach").getScore() == testList.get("BeachMini").getScore());
    assertEquals("Beach.Time == BeachMini.Time", true,
    		testList.get("Beach").getTime() == testList.get("BeachMini").getTime());
    assertEquals("Beach.Mission == BeachMini.Mission", true,
    		testList.get("Beach").getCurrentMission() == testList.get("BeachMini").getCurrentMission());
    assertEquals("Beach.Tool == BeachMini.Tool", true, 
    		testList.get("Beach").getCurrentTool() == testList.get("BeachMini").getCurrentTool());
    assertEquals("Beach.Fact == BeachMini.Fact", true,
    		testList.get("Beach").getCurrentFact() == testList.get("BeachMini").getCurrentFact());
    
    System.out.println("    BeachMini == Wetland");
    assertEquals("BeachMini.Score == Wetland.Score", true,
    		testList.get("BeachMini").getScore() == testList.get("Wetland").getScore());
    assertEquals("BeachMini.Time == Wetland.Time", true,
    		testList.get("BeachMini").getTime() == testList.get("Wetland").getTime());
    assertEquals("BeachMini.Mission == Wetland.Mission", true,
    		testList.get("BeachMini").getCurrentMission() == testList.get("Wetland").getCurrentMission());
    assertEquals("BeachMini.Tool == Wetland.Tool", true, 
    		testList.get("BeachMini").getCurrentTool() == testList.get("Wetland").getCurrentTool());
    assertEquals("BeachMini.Fact == Wetland.Fact", true,
    		testList.get("BeachMini").getCurrentFact() == testList.get("Wetland").getCurrentFact());
  }
  
  /**
   * Initial setup for bay scene.
   */
  private static void baySetup() {
    testList.get("Bay").getSceneItems().add(ConstructFish.constructLeftFish(-5, 0, SCENE_WIDTH, SCENE_HEIGHT/2));
    testList.get("Bay").getSceneItems().add(ConstructFish.constructRightFish(5, 1, 0, SCENE_HEIGHT/2));
    testList.get("Bay").getSceneItems().add(ConstructFish.constructRightFish(5, 2, 0, SCENE_HEIGHT/2));
  }
  
  /**
   * Initial setup for beach scene.
   */
  private static void beachSetup() {
    testList.get("Beach").getSceneItems().add(ConstructCrab.constructLeftCrab(-5, 0, SCENE_WIDTH, SCENE_HEIGHT/2));
    testList.get("Beach").getSceneItems().add(ConstructCrab.constructRightCrab(5, 1, 0, SCENE_HEIGHT/2));
  }
  
  /**
   * Initial setup for beach minigame.
   */
  private static void beachMiniSetup() {
    testList.get("BeachMini").getSceneItems().add(ConstructCrab.constructRightCrab(5, 1, 0, SCENE_HEIGHT/2));
  }
  
  /**
   * Initial setup for wetland scene.
   */
  private static void wetlandSetup() {
    testList.get("Wetland").getSceneItems().add(ConstructVegetation.constructVegetation(5, 1, SCENE_WIDTH/2, SCENE_HEIGHT/2));
  }
}
