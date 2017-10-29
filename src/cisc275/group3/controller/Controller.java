package cisc275.group3.controller;


// Project Imports
import cisc275.group3.model.scene.BayScene;
import cisc275.group3.model.scene.Scene;
import cisc275.group3.utility.SceneId;
import cisc275.group3.view.View;

public class Controller {
		  
  public static void main (String[] args) {
	  BayScene testBay = new BayScene(720.0, "Bay", 0, 0, 1280, true, true);
	  System.out.println(testBay);
  }
}