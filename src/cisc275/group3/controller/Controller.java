package cisc275.group3.controller;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.SceneWetlands;
import cisc275.group3.model.scene.SceneBay;
import cisc275.group3.model.scene.SceneBeach;
import cisc275.group3.model.scene.SceneHQ;
import cisc275.group3.model.scene.SceneMap;
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
    gameModels.add(new SceneHQ("HQ", 0,0,SCREEN_WIDTH, SCREEN_HEIGHT, true, true));
    gameModels.add(new SceneMap("Map", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, false, false));
    gameModels.add(new SceneBay("Bay", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, "null", false, false));
    gameModels.add(new SceneBeach("Beach", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, false, false));
    gameModels.add(new SceneWetlands("Wetlands", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, false, false));

    //gameViews.add(new AlphaView(SCREEN_WIDTH, SCREEN_HEIGHT, gameModels.get(0)));
    //gameViews.add(new AlphaView(SCREEN_WIDTH, SCREEN_HEIGHT, gameModels.get(1)));
    
    
    for (int i = 0; i < gameModels.size();i++) {
    	if(gameModels.get(i).getVisible() == true) {
    		activeScene = gameModels.get(i);
    	}
    }
    activeView = new AlphaView(SCREEN_WIDTH, SCREEN_HEIGHT, activeScene);
    activeView.paintScene();
    
    /**
     * Adds mouse listener to JPanel. On mouse press, the 
     * scene is passed the x and y coordinates to process
     * the event.
     */
    activeView.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
    	//get mouse click
        if (e.getButton() == MouseEvent.BUTTON1) {
        	//if mouseclick returns a nav button at given location
        	System.out.println(gameModels);
        	if(activeScene.processNav(e.getX(), e.getY()) != "NONE") {
        		System.out.println(activeScene.processNav(e.getX(), e.getY()));
        		//find the correct scene to nav to
        		int j = 0;
          	  	while(((activeScene.processNav(e.getX(), e.getY()) == gameModels.get(j).getManifest().getName()) && (gameModels.get(j).getVisible() == false)) == false) {
          	  		j++;
          	  	}
          	    //make active scene invisible/unclickable
	  			System.out.println("Active Scene: " + activeScene.getManifest().getName() + "is getting toggled");
	  			activeScene.toggleClickable();
	  			activeScene.toggleVisible();
	  			//set desired scene to visible/clickable
	  			System.out.println("Desired Scene: " + gameModels.get(j).getManifest().getName() + "is getting toggled");
	  			gameModels.get(j).toggleClickable();
	  			gameModels.get(j).toggleVisible();
	  			//assign new scene as active scene and view
	  			activeScene = gameModels.get(j);
	  			activeView.changeActiveScene(gameModels.get(j)); 
        	}
        	//check to see if click effects any other objects
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