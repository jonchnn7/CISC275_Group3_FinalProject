package cisc275.group3.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.sceneobject.ObjectVegetation;
import cisc275.group3.utility.ConstructVegetation;

public class ObjectVegetationTest {
  //Vegetation
  ObjectVegetation testVeg1;
  ObjectVegetation testVeg2;
  ObjectVegetation testVeg3;

  
  /**
   * Before each test, create fresh
   * instances of the test vegetation.
   */
  @Before
  public void createVegetation() {
    // Vegetation
	  testVeg1 = ConstructVegetation.constructVegetation(1, 0, 0, 0);
	  testVeg2 = ConstructVegetation.constructVegetation(2, 1, 100, 0);
	  testVeg3 = ConstructVegetation.constructVegetation(2, 2, 200, 0);
	  
  }
  
  /**
   * Tests the grow function.
   */
  @Test
  public void testGrow() {
    System.out.println("  Testing grow():");
    
    testVeg1 = testVeg1.grow();
    testVeg2 = testVeg2.grow();
    testVeg3 = testVeg3.grow();

    System.out.println("    Testing Grown Vegetation:");
    assertEquals("testVeg1 ID = 71", 71, testVeg1.getPassport().getId());
    assertEquals("testVeg2 ID = 72", 72, testVeg2.getPassport().getId());
    assertEquals("testVeg3 ID = 72", 72, testVeg3.getPassport().getId());
  }
}
