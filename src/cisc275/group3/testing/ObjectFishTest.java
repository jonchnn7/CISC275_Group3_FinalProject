package cisc275.group3.testing;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import cisc275.group3.model.sceneobject.BetaFish;
import cisc275.group3.utility.ConstructFish;

public class ObjectFishTest {
	  // Left Fish
	  BetaFish leftFish1;
	  BetaFish leftFish2;
	  
	  // Right Fish
	  BetaFish rightFish1;
	  BetaFish rightFish2;

	  /**
	   * Before each test, create fresh
	   * instances of the test crabs.
	   */
	  @Before
	  public void createFish() {
	    // Left Crabs
	    leftFish1 = ConstructFish.constructLeftFish(3, 0, 400, 0);
	    leftFish2 = ConstructFish.constructLeftFish(4, 1, 600, 0);
	    
	    // Right Crabs
	    rightFish1 = ConstructFish.constructRightFish(5, 0, 800, 0);
	    rightFish2 = ConstructFish.constructRightFish(6, 1, 1000, 0);
	  }
	  
	  /**
	   * Tests the boolean leftFish getter.
	   */
	  @Test
	  public void testGetLeftFish() {
	    System.out.println("  Testing getLeftFish():");
	    
	    // Left Fish
	    System.out.println("    Testing Left Fish:");
	    assertEquals("Left Crab 1 Left = True", true, leftFish1.getLeftFish());
	    assertEquals("Left Crab 2 Left = True", true, leftFish2.getLeftFish());

	    // Right Fish
	    System.out.println("    Testing Right Fish:");
	    assertEquals("Right Fish 1 Left = False", false, rightFish1.getLeftFish());
	    assertEquals("Right Fish 2 Left = False", false, rightFish2.getLeftFish());
	  }
	  
	  /**
	   * Test the move() method by calling on each
	   * fish then checking the x location has moved
	   * appropriately.
	   */
	  @Test
	  public void testMove() {
	    System.out.println("  Testing move():");
	    
	    // Left Fish
	    System.out.println("    Testing Left Fish:");
	    leftFish1.move();
	    leftFish2.move();
	    assertEquals("Left Fish 1 x Location < 400", true, (leftFish1.getLocation().getX() < 400));
	    assertEquals("Left Fish 2 x Location < 600", true, (leftFish2.getLocation().getX() < 600));

	    // Right Fish
	    System.out.println("    Testing Right Fish:");
	    rightFish1.move();
	    rightFish2.move();
	    assertEquals("Right Fish 1 x Location > 800", true, (rightFish1.getLocation().getX() > 800));
	    assertEquals("Right Fish 2 x Location > 1000", true, (rightFish2.getLocation().getX() > 1000));
	  }
}
