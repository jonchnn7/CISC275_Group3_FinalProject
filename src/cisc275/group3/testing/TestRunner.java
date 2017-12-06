package cisc275.group3.testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Central testing class.
 * <p>
 * Runs all testing classes and outputs results and error messages.
 * 
 * @author Scott
 */
public class TestRunner {
	private static Result result;

	public static void main(String[] args) {
    ToolsTest();
    printSeparator();
	    
		abstractSceneObjectTests();
		printSeparator();

		objectCrabTests();
		printSeparator();

		objectHeronTests();
		printSeparator();

		objectFishTests();
		printSeparator();

		objectPersonTests();
		printSeparator();
		
		objectVegetationTests();
		printSeparator();

		sceneBayTests();
		printSeparator();
		
		sceneBeachTests();
		printSeparator();
		
		sceneWetlandTests();
		printSeparator();

		abstractSceneTests();
		printSeparator();
		
		sceneTitleTest();
		printSeparator();
		
		sceneTutorialTest();
		printSeparator();
	}

	/**
	 * Runs the Generic/Shared tests for AbstractObjectTests.java
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
	 * Runs the tests for ObjectHeron.java
	 */
	private static void objectHeronTests() {
		// Scene Object Tests
		System.out.println("\nRunning Object Heron Tests...");

		result = JUnitCore.runClasses(ObjectHeronTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println("Failure: " + failure.toString());
		}

		System.out.println("Running Object Heron Tests Successful: " + result.wasSuccessful());
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
	 * Runs the tests for ObjectPerson.java
	 */
	private static void objectPersonTests() {
		// Scene Object Tests
		System.out.println("\nRunning Object Person Tests...");

		result = JUnitCore.runClasses(ObjectPersonTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println("Failure: " + failure.toString());
		}

		System.out.println("Running Object Person Tests Successful: " + result.wasSuccessful());
	}

	/**
	 * Runs the tests for ObjectVegetation.java
	 */
	private static void objectVegetationTests() {
		// Scene Object Tests
		System.out.println("\nRunning Object Vegetation Tests...");

		result = JUnitCore.runClasses(ObjectVegetationTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println("Failure: " + failure.toString());
		}

		System.out.println("Running Object Vegetation Tests Successful: " + result.wasSuccessful());
	}

	/**
	 * Runs the Bay Specific tests for SceneBay.java
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
	 * Runs the Beach Specific tests for SceneBeach.java
	 */
	private static void sceneBeachTests() {
		// Bay Specific Tests
		System.out.println("\nRunning Beach Specific Scene Tests...");

		result = JUnitCore.runClasses(SceneBeachTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println("Failure: " + failure.toString());
		}

		System.out.println("Beach Specific Scene Tests Successful: " + result.wasSuccessful());
	}

	/**
	 *Runs the Wetland Specific tests for SceneWetland.java
	 */
	private static void sceneWetlandTests() {
		// Bay Specific Tests
		System.out.println("\nRunning Wetland Specific Scene Tests...");

		result = JUnitCore.runClasses(SceneWetlandTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println("Failure: " + failure.toString());
		}

		System.out.println("Wetland Specific Scene Tests Successful: " + result.wasSuccessful());
	}

	/**
	 * Runs the Title Specific tests for SceneTitle.java
	 */
	private static void sceneTitleTest() {
		// Bay Specific Tests
		System.out.println("\nRunning Title Scene Tests...");

		result = JUnitCore.runClasses(SceneBayTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println("Failure: " + failure.toString());
		}

		System.out.println("Title Scene Tests Successful: " + result.wasSuccessful());
	}

	/**
	 * Runs the Tutorial Specific tests for SceneTitle.java
	 */
	private static void sceneTutorialTest() {
		// Bay Specific Tests
		System.out.println("\nRunning Tutorial Scene Tests...");

		result = JUnitCore.runClasses(SceneTutorialTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println("Failure: " + failure.toString());
		}

		System.out.println("Tutorial Scene Tests Successful: " + result.wasSuccessful());
	}

	/**
	 * Runs the Generic/Shared Abstract Scene.java tests
	 */
	private static void abstractSceneTests() {
		// Abstract Scene Tests
		System.out.println("\nRunning Generic Scene Tests...");

		result = JUnitCore.runClasses(AbstractSceneTests.class);

		for (Failure failure : result.getFailures()) {
			System.out.println("Failure: " + failure.toString());
		}

		System.out.println("Generic Scene Tests Successful: " + result.wasSuccessful());
	}

	/**
	 * Runs the tests for ObjectPerson.java
	 */
	private static void ToolsTest() {
		// Scene Object Tests
		System.out.println("\nRunning Tools Tests...");

		result = JUnitCore.runClasses(SceneTitleTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println("Failure: " + failure.toString());
		}

		System.out.println("ToolsTest Successful: " + result.wasSuccessful());
	}

	/**
	 * Prints a test separator to stdout
	 */
	private static void printSeparator() {
		System.out.println("\n\n========================================");
		System.out.println("========================================\n\n");
	}
}
