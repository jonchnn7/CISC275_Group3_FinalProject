package cisc275.group3.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cisc275.group3.model.sceneobject.BetaFish;
import cisc275.group3.model.sceneobject.ToolCage;
import cisc275.group3.model.sceneobject.ToolCamera;
import cisc275.group3.model.sceneobject.ToolNet;
import cisc275.group3.model.sceneobject.ToolTrimmer;
import cisc275.group3.utility.ConstructFish;

/**
 * Test class for ToolCage.java, ToolCamera.Java, ToolNet.java, ToolObject.java, ToolTrimmer.java
 *  properties and methods.
 * 
 * @author Thomas
 */
public class ToolsTest {

	  // Left Fish
	  ToolCage cage;
	  ToolNet net;
	  ToolCamera camera;
	  ToolTrimmer trimmer;

	  /**
	   * Before each test, create fresh
	   * instances of the test crabs.
	   */
	  @Before
	  public void createFish() {
	    cage = new ToolCage();
	    net = new ToolNet();
	    camera = new ToolCamera();
	    trimmer = new ToolTrimmer();
	  }
	  
	  /**
	   * Test the tool attributes
	   */
	  @Test
	  public void ToolCageTest()
	  {
		    System.out.println("  Testing Initial Conditions"); 
		    assertEquals("Cage Name = Cage", "Cage", cage.getName());
		    assertEquals("Net Name = Net", "Net", net.getName());
		    assertEquals("Camera Name = Camera", "Camera", camera.getName());
		    assertEquals("Trimmer Name = Trimmer", "Trimmer", trimmer.getName());
	  }
	
}
