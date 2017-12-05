package cisc275.group3.testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Central testing class.
 * <p>
 * Runs all testing classes and outputs results and
 * error messages.
 * 
 * @author Scott
 */
public class TestRunner {
  private static Result result;
  
	public static void main(String[] args) {
	  abstractSceneObjectTests();
	  printSeparator();
	  
	  objectCrabTests();
	  printSeparator();
	  
	  objectFishTests();
    printSeparator();
	  
		sceneBayTests();
		printSeparator();
		
		abstractTests(); 
		printSeparator();
	}
	
	 /**
   * Runs the Generic/Shared tests for
   * AbstractObjectTests.java
   */
  private static void abstractSceneObjectTests() {
    // Generic Scene Object Tests
    System.out.println("\nRunning Generic Scene Object Tests...");
    
    result = JUnitCore.runClasses(AbstractSceneObjectTests.class);

    for (Failure failure : result.getFailures()) {
       System.out.println("Failure: " + failure.toString());
    }
      
    System.out.println("Generic Scene Object Tests Successful: " + result.wasSuccessful());
  } 
  
  /**
  * Runs the tests for ObjectCrab.java
  */
 private static void objectCrabTests() {
   // Scene Object Tests
   System.out.println("\nRunning Object Crab Tests...");
   
   result = JUnitCore.runClasses(ObjectCrabTest.class);

   for (Failure failure : result.getFailures()) {
      System.out.println("Failure: " + failure.toString());
   }
     
   System.out.println("Running Object Crab Tests Successful: " + result.wasSuccessful());
 } 
 
 /**
 * Runs the tests for ObjectFish.java
 */
private static void objectFishTests() {
  // Scene Object Tests
  System.out.println("\nRunning Object Fish Tests...");
  
  result = JUnitCore.runClasses(ObjectFishTest.class);

  for (Failure failure : result.getFailures()) {
     System.out.println("Failure: " + failure.toString());
  }
    
  System.out.println("Running Object Fish Tests Successful: " + result.wasSuccessful());
} 
	
	/**
	 * Runs the Bay Specific tests for
	 * SceneBay.java
	 */
	private static void sceneBayTests() {
	  // Bay Specific Tests
    System.out.println("\nRunning Bay Specific Scene Tests...");
    
    result = JUnitCore.runClasses(SceneBayTest.class);

    for (Failure failure : result.getFailures()) {
       System.out.println("Failure: " + failure.toString());
    }
      
    System.out.println("Bay Specific Scene Tests Successful: " + result.wasSuccessful());
	}	

  /**
   * Runs the Generic/Shared Abstract
   * Scene.java tests
   */
  private static void abstractTests() {
    // Abstract Scene Tests
    System.out.println("\nRunning Generic Scene Tests...");
      
    result = JUnitCore.runClasses(AbstractSceneTests.class);

    for (Failure failure : result.getFailures()) {
       System.out.println("Failure: " + failure.toString());
    }
      
    System.out.println("Generic Scene Tests Successful: " + result.wasSuccessful()); 
  }
  

  /**
   * Prints a test separator to stdout
   */
  private static void printSeparator() {
    System.out.println("\n\n========================================");
    System.out.println("========================================\n\n");
  }
}
