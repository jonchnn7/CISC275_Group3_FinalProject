package cisc275.group3.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.scene.SceneBay;
import cisc275.group3.scene.SceneWetland;
import cisc275.group3.sceneobject.BetaFish;
import cisc275.group3.utility.EnumSceneType;

/**
 * Test class for SceneWetland.java properties and methods not included in the
 * abstract class Scene.java.
 * 
 * @author Jon
 */
public class SceneWetlandTest {
	// Scene Variables
	private final int SCENE_WIDTH = 1280;
	private final int SCENE_HEIGHT = 720;
	private SceneWetland testWetland;

	private int vegCount = 0;
	private boolean heronR = false;
	private boolean heronL = false;

	/**
	 * Before each test, reset testBay to a new instance of SceneBay.java
	 */
	@Before
	public void sceneSetup() {
		testWetland = new SceneWetland("Test Wetland", 0, 0, SCENE_WIDTH, SCENE_HEIGHT, "img/wetland_bg.png",
				EnumSceneType.DEFAULT);
	}

	/**
	 * Test scene is constructed/filled correctly.
	 * <p>
	 * There should be 6 items created when a wetland scene of type DEFAULT is
	 * initialized.
	 */
	@Test
	public void testCreation() {
		System.out.println("  Testing Initial Conditions");

		assertEquals("Created Vegetation = 6", 6, testWetland.getSceneItems().size());
	}

	/**
	 * Test to see if vegeGen() is working properly
	 */
	@Test
	public void testVegeGen() {
		while (vegCount < 10) {
			vegCount = 0;
			testWetland.update();
			testWetland.getSceneItems().forEach(object -> {
				if ((object.getPassport().getId() == 70) || (object.getPassport().getId() == 71)
						|| (object.getPassport().getId() == 72)) {
					vegCount++;
				}
			});
		}
	}
	
	/**
	 * Test to see if vegeGen() is working properly
	 */
	@Test
	public void testHeronGen() {
		while (!(heronR == true && heronL == true)) {
			testWetland.update();
			testWetland.getSceneItems().forEach(object -> {
				if (object.getPassport().getId() == 100) {
					heronR = true;
				}
				else if (object.getPassport().getId() == 200) {
					heronL = true;
				}
				});
		}
	}
}
