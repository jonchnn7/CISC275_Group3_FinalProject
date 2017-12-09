package cisc275.group3.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.sceneobject.ObjectCrab;
import cisc275.group3.utility.ConstructCrab;

public class ObjectCrabTest {
  // Impartial Crabs
  ObjectCrab testCrab1;
  ObjectCrab testCrab2;
  
  // Left Crabs
  ObjectCrab leftCrab1;
  ObjectCrab leftCrab2;
  
  // Right Crabs
  ObjectCrab rightCrab1;
  ObjectCrab rightCrab2;
  
  /**
   * Before each test, create fresh
   * instances of the test crabs.
   */
  @Before
  public void createCrab() {
    // Impartial Crabs
    testCrab1 = ConstructCrab.constructCrab(1, 0, 0, 0);
    testCrab2 = ConstructCrab.constructCrab(2, 1, 200, 0);
    
    // Left Crabs
    leftCrab1 = ConstructCrab.constructLeftCrab(3, 0, 400, 0);
    leftCrab2 = ConstructCrab.constructLeftCrab(4, 1, 600, 0);
    
    // Right Crabs
    rightCrab1 = ConstructCrab.constructRightCrab(5, 0, 800, 0);
    rightCrab2 = ConstructCrab.constructRightCrab(6, 1, 1000, 0);
  }
  
  /**
   * Tests the boolean leftCrab getter.
   */
  @Test
  public void testGetLeftCrab() {
    System.out.println("  Testing getLeftCrab():");
    
    // Impartial Crabs
    System.out.println("    Testing Impartial Crabs:");
    assertEquals("Impartial Crab 1 Left = False", false, testCrab1.getLeftCrab());
    assertEquals("Impartial Crab 2 Left = False", false, testCrab2.getLeftCrab());
    
    // Left Crabs
    System.out.println("    Testing Left Crabs:");
    assertEquals("Left Crab 1 Left = True", true, leftCrab1.getLeftCrab());
    assertEquals("Left Crab 2 Left = True", true, leftCrab2.getLeftCrab());

    // Right Crabs
    System.out.println("    Testing Right Crabs:");
    assertEquals("Right Crab 1 Left = False", false, rightCrab1.getLeftCrab());
    assertEquals("Right Crab 2 Left = False", false, rightCrab2.getLeftCrab());
  }
  
  /**
   * Test the move() method by calling on each
   * crab then checking the x location has moved
   * appropriately.
   */
  @Test
  public void testMove() {
    System.out.println("  Testing move():");
    
    // Impartial Crabs
    System.out.println("    Testing Impartial Crabs:");
    testCrab1.move();
    testCrab2.move();
    assertEquals("Impartial Crab 1 x Location > 0", true, (testCrab1.getLocation().getX() > 0));
    assertEquals("Impartial Crab 2 x Location > 200", true, (testCrab2.getLocation().getX() > 200));
    
    // Left Crabs
    System.out.println("    Testing Left Crabs:");
    leftCrab1.move();
    leftCrab2.move();
    assertEquals("Left Crab 1 x Location < 400", true, (leftCrab1.getLocation().getX() < 400));
    assertEquals("Left Crab 2 x Location < 600", true, (leftCrab2.getLocation().getX() < 600));

    // Right Crabs
    System.out.println("    Testing Right Crabs:");
    rightCrab1.move();
    rightCrab2.move();
    assertEquals("Right Crab 1 x Location > 800", true, (rightCrab1.getLocation().getX() > 800));
    assertEquals("Right Crab 2 x Location > 1000", true, (rightCrab2.getLocation().getX() > 1000));
  }
  
  /**
   * Test the move(double dx) method by calling
   * on each crab then checking the x location has
   * moved appropriately.
   */
  @Test
  public void testMoveDouble() {
    System.out.println("  Testing move(double dx):");
    
    // Impartial Crabs
    System.out.println("    Testing Impartial Crabs:");
    testCrab1.move(20);
    testCrab2.move(20);
    assertEquals("Impartial Crab 1 x Location > 0", true, (testCrab1.getLocation().getX() > 0));
    assertEquals("Impartial Crab 2 x Location > 200", true, (testCrab2.getLocation().getX() > 200));
    
    // Left Crabs
    System.out.println("    Testing Left Crabs:");
    leftCrab1.move(20);
    leftCrab2.move(20);
    assertEquals("Left Crab 1 x Location > 400", true, (leftCrab1.getLocation().getX() > 400));
    assertEquals("Left Crab 2 x Location > 600", true, (leftCrab2.getLocation().getX() > 600));

    // Right Crabs
    System.out.println("    Testing Right Crabs:");
    rightCrab1.move(20);
    rightCrab2.move(20);
    assertEquals("Right Crab 1 x Location > 800", true, (rightCrab1.getLocation().getX() > 800));
    assertEquals("Right Crab 2 x Location > 1000", true, (rightCrab2.getLocation().getX() > 1000));
    
  }
}
