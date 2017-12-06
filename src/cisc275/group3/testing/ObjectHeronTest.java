package cisc275.group3.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.model.sceneobject.BetaHeron;
import cisc275.group3.utility.ConstructHeron;
import cisc275.group3.utility.ObjectId;


public class ObjectHeronTest {
	// Left Herons
	BetaHeron leftHeron1;
	BetaHeron leftHeron2;
	BetaHeron leftHeron3;

	// Right Herons
	BetaHeron rightHeron1;
	BetaHeron rightHeron2;
	BetaHeron rightHeron3;

	/**
	 * Before each test, create fresh instances of the test herons.
	 */
	@Before
	public void createHeron() {
		// Left Herons
		leftHeron1 = new BetaHeron(
				new ObjectId(0, 230, 200, "img/betaHeronPics/heron_flying_left.png", "Great Blue Heron", 177), 1.0, 0.0,
				100.0, 100.0, true);
		leftHeron2 = ConstructHeron.constructLeftHeron(1, 0, 100, 100, true, true);
		leftHeron3 = ConstructHeron.constructLeftHeron(1, 0, 100, 100, false, true);

		// Right Herons
		rightHeron1 = new BetaHeron(
				new ObjectId(0, 230, 200, "img/betaHeronPics/heron_flying_right.png", "Great Blue Heron", 177), 1.0, 0.0,
				100.0, 100.0, false);		
		rightHeron2 = ConstructHeron.constructRightHeron(1, 0, 100, 100, true, true);
		rightHeron3 = ConstructHeron.constructLeftHeron(1, 0, 100, 100, false, true);

	}

	/**
	 * Tests the move() method.
	 */
	@Test
	public void testMove() {

		leftHeron1.move();
		leftHeron2.move();
		leftHeron3.move();
		rightHeron1.move();
		rightHeron2.move();
		rightHeron3.move();

		assertEquals("leftHeron1 = 100", 120, leftHeron1.getLocation().getX(), 0.2);
		assertEquals("leftHeron2 = 100", 100, leftHeron1.getLocation().getX(), 0.2);
		assertEquals("rightHeron1 = 100", 100, leftHeron1.getLocation().getX(), 0.2);
		assertEquals("rightHeron2 = 100", 100, leftHeron1.getLocation().getX(), 0.2);

	}

	/**
	 * Tests the get getLeftHeron() getter.
	 */
	@Test
	public void testGetLeftHeron() {
		System.out.println("  Testing getLeftHeron():");
		// Persons
		assertEquals("leftHeron1 = true", true, leftHeron1.getLeftHeron());
		assertEquals("leftHeron2 = true", true, leftHeron2.getLeftHeron());
		assertEquals("leftHeron3 = true", true, leftHeron3.getLeftHeron());
		assertEquals("rightHeron1 = false", false, rightHeron1.getLeftHeron());
		assertEquals("rightHeron2 = false", false, rightHeron2.getLeftHeron());
		assertEquals("rightHeron3 = false", false, rightHeron3.getLeftHeron());

	}

	/**
	 * Tests the get speedX getter.
	 */
	@Test
	public void testGetSpeedX() {
		System.out.println("  Testing getSpeedX():");
		// Persons
		assertEquals("leftHeron1 = 20", 20, leftHeron1.getSpeedX(), 0.2);
		assertEquals("leftHeron2 = 20", 20, leftHeron2.getSpeedX(), 0.2);
		assertEquals("leftHeron3 = 20", 20, leftHeron3.getSpeedX(), 0.2);
		assertEquals("rightHeron1 = 20", 20, rightHeron1.getSpeedX(), 0.2);
		assertEquals("rightHeron2 = 20", 20, rightHeron2.getSpeedX(), 0.2);
		assertEquals("rightHeron3 = 20", 20, rightHeron3.getSpeedX(), 0.2);

	}

	/**
	 * Tests the getLanded() getter.
	 */
	@Test
	public void testGetLanded() {
		System.out.println("  Testing getLanded():");
		// Persons
		assertEquals("leftHeron1 = false", false, leftHeron1.getLanded());
		assertEquals("leftHeron2 = false", true, leftHeron2.getLanded());
		assertEquals("leftHeron3 = false", false, leftHeron3.getLanded());
		assertEquals("rightHeron1 = false", false, rightHeron1.getLanded());
		assertEquals("rightHeron2 = false", true, rightHeron2.getLanded());
		assertEquals("rightHeron3 = false", false, rightHeron3.getLanded());

	}

	/**
	 * Tests the getHasLanded() getter.
	 */
	@Test
	public void testHasGetLanded() {
		System.out.println("  Testing getHasLanded():");
		// Persons
		assertEquals("leftHeron1 = false", false, leftHeron1.getHasLanded());
		assertEquals("leftHeron2 = false", true, leftHeron2.getHasLanded());
		assertEquals("leftHeron3 = false", true, leftHeron3.getHasLanded());
		assertEquals("rightHeron1 = false", false, rightHeron1.getHasLanded());
		assertEquals("rightHeron2 = false", true, rightHeron2.getHasLanded());
		assertEquals("rightHeron3 = false", true, rightHeron3.getHasLanded());

	}

	/**
	 * Tests the get speedY getter.
	 */
	@Test
	public void testGetSpeedY() {
		System.out.println("  Testing getSpeedY():");
		// Persons
		assertEquals("leftHeron1 = 10", 10, leftHeron1.getSpeedY(), 0.2);
		assertEquals("leftHeron2 = 10", 10, leftHeron2.getSpeedY(), 0.2);
		assertEquals("rightHeron1 = 10", 10, rightHeron1.getSpeedY(), 0.2);
		assertEquals("rightHeron2 = 10", 10, rightHeron2.getSpeedY(), 0.2);

	}
}
