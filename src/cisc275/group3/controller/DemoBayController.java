package cisc275.group3.controller;

//Project Imports
import cisc275.group3.model.scene.BayScene;

public class DemoBayController {
		  
  public static void main (String[] args) {
  BayScene testBay = new BayScene(720.0, "Bay", 0, 0, 1280, true, true);
	  
   // Print Bay
   System.out.println(testBay);
	  
   // Print Bay Manifest
   System.out.println(testBay.getManifest());

   // Print Each Fish
   testBay.getSceneItems().forEach((fish)->{System.out.println(fish);});
	
   for (int i=0; i<100; i++) { 
     testBay.update();
   }
	  
   // Print Bay
   System.out.println(testBay);
 
   // Print Each Fish
   testBay.getSceneItems().forEach((fish)->{System.out.println(fish);});  
  }
}