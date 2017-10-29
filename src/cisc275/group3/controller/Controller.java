package cisc275.group3.controller;

import cisc275.group3.model.scene.BayScene;
import cisc275.group3.view.AlphaView;

public class Controller {
		  
  public static void main (String[] args) {
    AlphaView testView = new AlphaView(1280, 720);
    BayScene testBay = new BayScene("Bay", 0, 0, 1280, 720, true, true);
    System.out.println(testBay);
    
    while (true){
      testView.drawFish(testBay.getSceneItems());
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      testBay.update();
    }
  }
}