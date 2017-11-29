import java.awt.Dimension;

import java.awt.Toolkit;

import cisc275.group3.controller.GameController;

/**
 * Game initialization class.
 * <p>
 * Begins the game from outside the mvc model. Invoke
 * later and runnable are used to ensure all subsequent 
 * classes are created on the Event Dispatch Thread (EDT)
 * <p>
 * ClickAdventure.java
 * <p>
 * @author Scott
 */
public class ClickAdventure {
		 
  public static void main(String[] args) {
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//final int HEIGHT = (int)screenSize.getHeight() - 50;
		//final int WIDTH = (int)screenSize.getWidth();

    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new GameController(1280, 720);
      } 
    });
  }
}