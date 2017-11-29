package cisc275.group3.controller;

//Project Imports
import cisc275.group3.model.scene.SceneBay;

/**
 * Demonstration controller.
 * <p>
 * This controller manipulates the Bay model without the presence of a view. Not
 * needed for the final game.
 * <p>
 * ControllerDemoBay.java
 * <p>
 * See SceneBay.java
 * <p>
 * 
 * @author Scott
 */
public class ControllerDemoBay {

	public static void main(String[] args) {
		SceneBay testBay = new SceneBay("Bay", 0, 0, 1280, 720, "null", 2);

		// Print Bay
		System.out.println(testBay);

		// Print Bay Manifest
		System.out.println(testBay.getManifest());

		// Print Each Fish
		testBay.getSceneItems().forEach((fish) -> {
			System.out.println(fish);
		});

		// Move a bunch
		for (int i = 0; i < 50; i++) {
			testBay.update();
		}

		// Print Bay
		System.out.println(testBay);

		// Print Each Fish
		testBay.getSceneItems().forEach((fish) -> {
			System.out.println(fish);
		});

		// Print Bay
		System.out.println(testBay);

		// Watch a Fish
		for (int i = 0; i < 50; i++) {
			testBay.update();
			System.out.println(
					testBay.getSceneItems().get(0).getShortName() + ":" + testBay.getSceneItems().get(0).getLocation());
		}
	}
}