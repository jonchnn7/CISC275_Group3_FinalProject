package cisc275.group3.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.sceneobject.ObjectPerson;
import cisc275.group3.utility.ConstructPerson;

public class ObjectPersonTest {
  //Persons
	ObjectPerson testPerson1;
	ObjectPerson testPerson2;
	ObjectPerson testPerson3;
	ObjectPerson testPerson4;
  
  /**
   * Before each test, create fresh
   * instances of the test persons.
   */
  @Before
  public void createPerson() {
    //Person
	testPerson1 = ConstructPerson.constructPerson(1, 0, 100, 0);
	testPerson2 = ConstructPerson.constructPerson(2, 1, 200, 0);
	testPerson3 = ConstructPerson.constructPerson(1, 2, 300, 0);
	testPerson4 = ConstructPerson.constructPerson(2, 3, 400, 0);
  }

  /**
   * Tests the move().
   */
  @Test
  public void testMoves() {
    System.out.println("  Testing move():");
    
    testPerson3.setStatus(0);
    testPerson4.setStatus(-1);
    
    testPerson1.move();
    testPerson2.move();
    testPerson3.move();
    testPerson4.move();

    
    // Persons
    assertEquals("testPerson1 = 40", 40, testPerson1.getLocation().getX(), 0.2);
    assertEquals("testPerson2 = 140", 140, testPerson2.getLocation().getX(), 0.2);
    assertEquals("testPerson3 = 15", 300, testPerson3.getLocation().getX(), 0.2);
    assertEquals("testPerson4 = 460", 460, testPerson4.getLocation().getX(), 0.2);

  }
  
  /**
   * Tests the get and set status methods.
   */
  @Test
  public void testGetSetStatus() {
    System.out.println("  Testing getSetStatus():");
    
    testPerson3.setStatus(0);
    testPerson4.setStatus(-1);
    
    // Persons
    assertEquals("testPerson1 = 15", 1, testPerson1.getStatus());
    assertEquals("testPerson2 = 15", 1, testPerson2.getStatus());
    assertEquals("testPerson3 = 15", 0, testPerson3.getStatus());
    assertEquals("testPerson4 = 15", -1, testPerson4.getStatus());

  }
  
  /**
   * Tests the get speedX getter.
   */
  @Test
  public void testGetSpeedX() {
    System.out.println("  Testing getSpeedX():");
    // Persons
    assertEquals("testPerson1 = 60", 60, testPerson1.getSpeedX(), 0.2);
    assertEquals("testPerson2 = 60", 60, testPerson2.getSpeedX(), 0.2);
    assertEquals("testPerson3 = 60", 60, testPerson3.getSpeedX(), 0.2);
    assertEquals("testPerson4 = 60", 60, testPerson4.getSpeedX(), 0.2);

  }
  
  /**
   * Tests the get speedY getter.
   */
  @Test
  public void testGetSpeedY() {
    System.out.println("  Testing getSpeedY():");
    // Persons
    assertEquals("testPerson1 = 15", 0, testPerson1.getSpeedY(), 0.2);
    assertEquals("testPerson2 = 15", 0, testPerson2.getSpeedY(), 0.2);
    assertEquals("testPerson3 = 15", 0, testPerson3.getSpeedY(), 0.2);
    assertEquals("testPerson4 = 15", 0, testPerson4.getSpeedY(), 0.2);

  }
}
