package cisc275.group3.controller;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.BayScene;
import cisc275.group3.model.scene.HQScene;
import cisc275.group3.view.AlphaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.Timer;


public class Controller {
  
  // Screen Parameters
  private final int SCREEN_WIDTH;
  private final int SCREEN_HEIGHT;
  
//  // View and Model
//  private AlphaView testView;
//  private BayScene testBay;
  
  //MultiViews/Models	
  //private ArrayList<AlphaView> gameViews = new ArrayList<AlphaView>();
  private ArrayList<Scene> gameModels;
  private AlphaView activeView;
  private Scene activeScene;
  
  public Controller(int x, int y) {
    SCREEN_WIDTH = x;
    SCREEN_HEIGHT = y;
    //gameViews = new ArrayList<AlphaView>();
    gameModels = new ArrayList<Scene>();
    gameModels.add(new HQScene("HQ", 0,0,SCREEN_WIDTH, SCREEN_HEIGHT, true, true));
    gameModels.add(new BayScene("Bay", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, false, false));
   //gameViews.add(new AlphaView(SCREEN_WIDTH, SCREEN_HEIGHT, gameModels.get(0)));
    //gameViews.add(new AlphaView(SCREEN_WIDTH, SCREEN_HEIGHT, gameModels.get(1)));
    
    
    activeScene = gameModels.get(0);
    activeView = new AlphaView(SCREEN_WIDTH, SCREEN_HEIGHT, gameModels.get(0));
    activeView.paintScene();
    
    /**
     * Adds mouse listener to JPanel. On mouse press, the 
     * scene is passed the x and y coordinates to process
     * the event.
     */
    activeView.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
        	if(activeScene.processNav(e.getX(), e.getY()) != "NONE") {
          	  	for(int i = 0; i < gameModels.size(); i++) {
          	  		//System.out.println(gameModels.get(i));
          	  		//System.out.println(activeScene);
          	  		if(activeScene.processNav(e.getX(), e.getY()) == gameModels.get(i).getManifest().getName() && gameModels.get(i).getVisible() == false) {
          	  			activeScene.toggleClickable();
          	  			activeScene.toggleVisible();
          	  			gameModels.get(i).toggleClickable();
          	  			gameModels.get(i).toggleVisible();
          	  			activeScene = gameModels.get(i);
          	  			activeView.changeActiveScene(gameModels.get(i));
          	  		}
        	  }  
        	}
        	else if(activeScene.processClick(e.getX(), e.getY())) {
    		  //System.out.println("CLICK PROCESSED");
    		  //activeScene.updateScore();
          }
        }
      }
    });
    
    /**
     * Adds mouse motion listener to JPanel
     */
    activeView.addMouseMotionListener(new MouseAdapter() {
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
    	  for(int i = 0; i < gameModels.size(); i++) {
    		  if(gameModels.get(i).getVisible()) {
    			  activeScene = gameModels.get(i);
    			  activeView.changeActiveScene(activeScene);;
    		  }
    	  }     	  
    	  activeScene.update();
          activeView.paintScene();
      }
     });
    timer.start();
  }
}