package cisc275.group3.testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
  
	public static void main(String[] args) {
		  // Board Tests
	  System.out.println("Running Generic Scene Tests...");
		  
	  Result result = JUnitCore.runClasses(SceneTests.class);

	  for (Failure failure : result.getFailures()) {
	     System.out.println("Failure: " + failure.toString());
	  }
			
	  System.out.println("Generic Scene Tests Successful: " + result.wasSuccessful());
	}
}
