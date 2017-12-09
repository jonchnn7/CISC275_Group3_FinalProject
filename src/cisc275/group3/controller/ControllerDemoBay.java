package cisc275.group3.controller;

import cisc275.group3.scene.SceneBay;
import cisc275.group3.utility.EnumSceneType;

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
		SceneBay testBay = new SceneBay("Bay", 0, 0, 1280, 720, "null", EnumSceneType.DEFAULT);

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