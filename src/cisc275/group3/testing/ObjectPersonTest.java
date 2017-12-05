package cisc275.group3.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.model.sceneobject.BetaPerson;
import cisc275.group3.utility.ConstructPerson;

public class ObjectPersonTest {
  //Persons
	BetaPerson testPerson1;
	BetaPerson testPerson2;
	BetaPerson testPerson3;
	BetaPerson testPerson4;
  
  /**
   * Before each test, create fresh
   * instances of the test crabs.
   */
  @Before
  public void createCrab() {
    //Person
	BetaPerson testPerson1 = ConstructPerson.constructPerson(1, 0, 0, 0);
	BetaPerson testPerson2 = ConstructPerson.constructPerson(2, 1, 200, 0);
	BetaPerson testPerson3 = ConstructPerson.constructPerson(1, 2, 300, 0);
	BetaPerson testPerson4 = ConstructPerson.constructPerson(2, 3, 400, 0);
  }
  
  /**
   * Tests the get speedX getter.
   */
  @Test
  public void testGetSpeedX() {
    System.out.println("  Testing getSpeedX():");
    System.out.println("Testing........." +  testPerson1.getSpeedX());
    // Persons
    assertEquals("testPerson1 = 15", 15, testPerson1.getSpeedX(), 0.2);
    assertEquals("testPerson2 = 15", 15, testPerson2.getSpeedX(), 0.2);
    assertEquals("testPerson3 = 15", 15, testPerson3.getSpeedX(), 0.2);
    assertEquals("testPerson4 = 15", 15, testPerson4.getSpeedX(), 0.2);

  }
//  
//  /**
//   * Test the move() method by calling on each
//   * crab then checking the x location has moved
//   * appropriately.
//   */
//  @Test
//  public void testMove() {
//    System.out.println("  Testing move():");
//    
//    // Impartial Crabs
//    System.out.println("    Testing Impartial Crabs:");
//    testCrab1.move();
//    testCrab2.move();
//    assertEquals("Impartial Crab 1 x Location > 0", true, (testCrab1.getLocation().getX() > 0));
//    assertEquals("Impartial Crab 2 x Location > 200", true, (testCrab2.getLocation().getX() > 200));
//    
//    // Left Crabs
//    System.out.println("    Testing Left Crabs:");
//    leftCrab1.move();
//    leftCrab2.move();
//    assertEquals("Left Crab 1 x Location < 400", true, (leftCrab1.getLocation().getX() < 400));
//    assertEquals("Left Crab 2 x Location < 600", true, (leftCrab2.getLocation().getX() < 600));
//
//    // Right Crabs
//    System.out.println("    Testing Right Crabs:");
//    rightCrab1.move();
//    rightCrab2.move();
//    assertEquals("Right Crab 1 x Location > 800", true, (rightCrab1.getLocation().getX() > 800));
//    assertEquals("Right Crab 2 x Location > 1000", true, (rightCrab2.getLocation().getX() > 1000));
//  }
//  
//  /**
//   * Test the move(double dx) method by calling
//   * on each crab then checking the x location has
//   * moved appropriately.
//   */
//  @Test
//  public void testMoveDouble() {
//    System.out.println("  Testing move(double dx):");
//    
//    // Impartial Crabs
//    System.out.println("    Testing Impartial Crabs:");
//    testCrab1.move(20);
//    testCrab2.move(20);
//    assertEquals("Impartial Crab 1 x Location > 0", true, (testCrab1.getLocation().getX() > 0));
//    assertEquals("Impartial Crab 2 x Location > 200", true, (testCrab2.getLocation().getX() > 200));
//    
//    // Left Crabs
//    System.out.println("    Testing Left Crabs:");
//    leftCrab1.move(20);
//    leftCrab2.move(20);
//    assertEquals("Left Crab 1 x Location > 400", true, (leftCrab1.getLocation().getX() > 400));
//    assertEquals("Left Crab 2 x Location > 600", true, (leftCrab2.getLocation().getX() > 600));
//
//    // Right Crabs
//    System.out.println("    Testing Right Crabs:");
//    rightCrab1.move(20);
//    rightCrab2.move(20);
//    assertEquals("Right Crab 1 x Location > 800", true, (rightCrab1.getLocation().getX() > 800));
//    assertEquals("Right Crab 2 x Location > 1000", true, (rightCrab2.getLocation().getX() > 1000));
//    
//  }
}
