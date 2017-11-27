package cisc275.group3.testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import org.junit.BeforeClass;
import org.junit.Test;

import cisc275.group3.model.sceneobject.BetaCrab;
import cisc275.group3.model.sceneobject.BetaFish;
import cisc275.group3.model.sceneobject.BetaHeron;
import cisc275.group3.model.sceneobject.BetaVegetation;
import cisc275.group3.model.sceneobject.SceneObject;
import cisc275.group3.utility.ConstructCrab;
import cisc275.group3.utility.ConstructFish;
import cisc275.group3.utility.ConstructHeron;
import cisc275.group3.utility.ConstructVegetation;


/**
 * Testing class for abstract/shared properties and
 * methods of SceneObject.java. 
 * <p>
 * Creates a list of concrete classes to test the
 * code held in the abstract class.
 * 
 * @author Scott
 */
public class AbstractSceneObjectTests {
  // List of concrete scene objects 
  // that extend abstract scene object
  private static HashMap<String, SceneObject> testObjects;
  
  /**
   * Create a set of scene objects to test before
   * any tests are run
   */
  @BeforeClass
  public static void objectSetup() {
    testObjects = new HashMap<String, SceneObject>();
    
    addCrabs();
    addFish();
    addHeron();
    addVeggies();
  } 
  
  /**
   * Test sort by depth. 
   * <p>
   * Setup adds items with increasing depth.
   * A sort call on testObjects' values should 
   * result in a predictable, testable outcome.
   */
  @Test
  public void testSort() {    
    Collection<SceneObject> testValues = testObjects.values();
    ArrayList<SceneObject> sortList = new ArrayList<SceneObject>(testValues);
    
    System.out.println("  Testing Comparable");
 
    System.out.print("    Initial Depths: ");   
    sortList.forEach((item)->{
      System.out.print(item.getPassport().getDepth() + " ");
    });
    System.out.println();
    
    Collections.sort(sortList);
    
    System.out.print("    Sorted Depths:  ");
    sortList.forEach((item)->{
      System.out.print(item.getPassport().getDepth() + " ");
    });
    System.out.println();
    
    for (int i=0; i < sortList.size()-1; i++) {
      assertEquals("Pair Comparison: " + i, true, 
          sortList.get(i).getPassport().getDepth() >= sortList.get(i+1).getPassport().getDepth());
    }
  }
  
  /**
   * Tests the short name method.
   * <p>
   * Should return the first character of the
   * object's name.
   */
  @Test
  public void testShortName() {
    System.out.println("  Testing Short Name");
    
    testObjects.forEach((k,v)->{
      System.out.println("    Full Name:  " + v.getPassport().getName());
      System.out.println("    Short Name: " + v.getShortName());
      
      assertEquals("Full Name to Short Name", true, v.getPassport().getName().charAt(0) == v.getShortName().toCharArray()[0]);
    });
  }
  
  /**
   * Create one crab of each type found
   * in ConstructCrab.java, and add it
   * to the testObjects list.
   */
  private static void addCrabs() {
    BetaCrab tmpCrab;
    
    // Neutral, non-moving crab
    tmpCrab = ConstructCrab.constructCrab(1, 0, 0, 0);
    testObjects.put("Crab1", tmpCrab);
    
    // Right facing crab
    tmpCrab = ConstructCrab.constructRightCrab(2, 1, 100, 0);
    testObjects.put("Crab2", tmpCrab);
    
    // Left facing crab
    tmpCrab = ConstructCrab.constructLeftCrab(3, 0, 200, 0);
    testObjects.put("Crab3", tmpCrab);
  }
  
  /**
   * Create one fish of each type found
   * in ConstructFish.java, and add it
   * to the testObjects list.
   */
  private static void addFish() {
    BetaFish tmpFish;
    
    // Left Fish - Type 0
    tmpFish = ConstructFish.constructLeftFish(4, 0, 300, 0);
    testObjects.put("Fish1", tmpFish);
    
    // Left Fish - Type 1
    tmpFish = ConstructFish.constructLeftFish(5, 1, 400, 0);
    testObjects.put("Fish2", tmpFish);
    
    // Left Fish - Type 2
    tmpFish = ConstructFish.constructLeftFish(6, 2, 500, 0);
    testObjects.put("Fish3", tmpFish);
    
    // Right Fish - Type 0
    tmpFish = ConstructFish.constructRightFish(7, 0, 600, 0);
    testObjects.put("Fish4", tmpFish);
    
    // Right Fish - Type 1
    tmpFish = ConstructFish.constructRightFish(8, 1, 700, 0);
    testObjects.put("Fish5", tmpFish);
    
    // Right Fish - Type 2
    tmpFish = ConstructFish.constructRightFish(9, 2, 800, 0);
    testObjects.put("Fish6", tmpFish);
  }
  
  /**
   * Create one heron of each type found
   * in ConstructHeron.java, and add it
   * to the testObjects list.
   */
  private static void addHeron() {
    BetaHeron tmpHeron;
    
    // Left Heron - Standing
    tmpHeron = ConstructHeron.constructLeftHeron(10, 0, 900, 0, true, true);
    testObjects.put("Heron1", tmpHeron);
    
    // Left Heron - Flying
    tmpHeron = ConstructHeron.constructLeftHeron(11, 1, 1000, 0, true, true);
    testObjects.put("Heron2", tmpHeron);
    
    // Right Heron - Standing
    tmpHeron = ConstructHeron.constructRightHeron(12, 0, 1100, 0, true, true);
    testObjects.put("Heron3", tmpHeron);
    
    // Right Heron - Flying
    tmpHeron = ConstructHeron.constructRightHeron(13, 1, 1200, 0, true, true);
    testObjects.put("Heron4", tmpHeron);
  }
  
  /**
   * Create one vegetation of each type found
   * in ConstructVegetation.java, and add it
   * to the testObjects list.
   */
  private static void addVeggies() {
    BetaVegetation tmpVeg;
    
    // Full Weeds
    tmpVeg = ConstructVegetation.constructVegetation(14, 0, 1300, 0);
    testObjects.put("Weeds1", tmpVeg);
    
    // Medium Weeds
    tmpVeg = ConstructVegetation.constructVegetation(15, 1, 1400, 0);
    testObjects.put("Weeds2", tmpVeg);
    
    // Low Weeds
    tmpVeg = ConstructVegetation.constructVegetation(16, 2, 1500, 0);
    testObjects.put("Weeds3", tmpVeg);
    
  }
  
}