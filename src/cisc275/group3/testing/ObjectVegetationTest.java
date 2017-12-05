package cisc275.group3.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.model.sceneobject.BetaCrab;
import cisc275.group3.model.sceneobject.BetaVegetation;
import cisc275.group3.utility.ConstructCrab;
import cisc275.group3.utility.ConstructVegetation;

public class ObjectVegetationTest {
  //Vegetation
  BetaVegetation testVeg1;
  BetaVegetation testVeg2;
  BetaVegetation testVeg3;

  
  /**
   * Before each test, create fresh
   * instances of the test crabs.
   */
  @Before
  public void createCrab() {
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
    
    testVeg1.grow();
    testVeg2.grow();
    testVeg3.grow();

    System.out.println("    Testing Grown Vegetation:");
    assertEquals("testVeg1 ID = 71", 71, testVeg1.getPassport().getId());
    assertEquals("testVeg2 ID = 72", 72, testVeg2.getPassport().getId());
    assertEquals("testVeg3 ID = 72", 72, testVeg3.getPassport().getId());

  }
}
