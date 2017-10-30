package cisc275.group3.controller;

import cisc275.group3.model.scene.BayScene;
import cisc275.group3.view.AlphaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;


public class Controller {
  
  // Screen Parameters
  private final int SCREEN_WIDTH;
  private final int SCREEN_HEIGHT;
  
  // View and Model
  AlphaView testView;
  BayScene testBay;
	
  public Controller(int x, int y) {
    SCREEN_WIDTH = x;
    SCREEN_HEIGHT = y;
    
    testView = new AlphaView(SCREEN_WIDTH, SCREEN_HEIGHT);
    testBay = new BayScene("Bay", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, true, true);
    //System.out.println(testBay);
    
    testView.updateObjects(testBay.getSceneItems());
    
    /**
     * Adds mouse listener to JPanel. On mouse press, the 
     * scene is passed the x and y coordinates to process
     * the event.
     */
    testView.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
    	  if(testBay.processClick(e.getX(), e.getY())) {
            testBay.updateScore();
          }
        }
      }
    });
    
    /**
     * Adds mouse motion listener to JPanel
     */
    testView.addMouseMotionListener(new MouseAdapter() {
    	public void mouseMoved(MouseEvent e) {
    	}
    });
    //testView.addMouseListener(this);
    gameTime();
  }
  
  /**
   * Updates the model and display every 100ms
   */
  private void gameTime() {
    Timer timer = new Timer(100, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        testBay.update();
          testView.updateObjects(testBay.getSceneItems());
        }
     });
    timer.start();
  }
}