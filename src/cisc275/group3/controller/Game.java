package cisc275.group3.controller;
//Window Libraries
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import InterfaceWindow;
import cisc275.group3.scene.BayScene;
import cisc275.group3.scene.BeachScene;
import cisc275.group3.scene.HeadquartersScene;
import cisc275.group3.scene.InventoryScene;
import cisc275.group3.scene.LowerInterfaceScene;
import cisc275.group3.scene.UpperInterfaceScene;
import cisc275.group3.scene.Scene;
import cisc275.group3.scene.WetlandsScene;

//Event Libraries
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Utility Libraries
import java.util.Random;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Game extends Canvas {
	/*	CISC 275 - Group 3 - Estuary Game
	 * 
	 * 	Game.java
	 * 
	 * 	This class serves as the controller in our 
	 *  MVC model.
	 */
	
	// Game Properties
	final private static int SCREEN_WIDTH = 1280;
	final private static int SCREEN_HEIGHT = 720;
	private BufferStrategy buff_strat;
	private JFrame game_window;
	private JPanel game_panel;
	private int score;
	
	// Event Variables
	private int click_x;
	private int click_y;
	private boolean click_event;
	
	// Zone Variables - identified by name
	Scene current_scene;
	Map<String, Scene> active_scenes = new HashMap<String, Scene>();
	
	// Inventory Variables
	InventoryScene inventory_scene = new InventoryScene(SCREEN_WIDTH, SCREEN_HEIGHT);
	
	// Interface Variables
	Map<String, Scene> interface_bars = new HashMap<String, Scene>();
	
	
	public Game() {
		// Define Window Vars
	    game_window = new JFrame("CISC 275 - Group 3 - Estuary Game");
	    game_panel = (JPanel) game_window.getContentPane();
	    game_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    // Set Window Properties
	    game_panel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	    setBounds(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);
	    game_panel.add(this);
	    game_panel.setIgnoreRepaint(true);
	    
	    // Display Window
	    game_window.pack();
	    game_window.setResizable(false);
	    game_window.setVisible(true);
	    
	    // Buffer Strategy for Accelerated Graphics
	    createBufferStrategy(2);
	    buff_strat = getBufferStrategy();
	    
	    // Mouse Events
	    click_event = false;
	    addMouseListener(new MouseAdapter() {
	    	public void mousePressed(MouseEvent e) {
	    		if (e.getButton() == MouseEvent.BUTTON1) {
	    			click_event = true;
	    			click_x = e.getX();
	    			click_y = e.getY();
	    		}
	    	}
	    });
	    
	    score = 0;
	    initGame();
	}
	
	
	private void initGame() {
		active_scenes.put("HQ", new HeadquartersScene(SCREEN_WIDTH, SCREEN_HEIGHT));
		active_scenes.put("Bay", new BayScene(SCREEN_WIDTH, SCREEN_HEIGHT));
		active_scenes.put("Beach", new BeachScene(SCREEN_WIDTH, SCREEN_HEIGHT));
		active_scenes.put("Wetlands", new WetlandsScene(SCREEN_WIDTH, SCREEN_HEIGHT));
		
		interface_bars.put("UPPER", new UpperInterfaceScene(SCREEN_WIDTH, "UPPER"));
		interface_bars.put("LOWER", new LowerInterfaceScene(SCREEN_WIDTH, SCREEN_HEIGHT, "LOWER"));

		processNav("HQ");
		gameLoop();
	}
	
	private void gameLoop() {
		int sleep_time = 0;
		 
	    while(true) {
	    	
	        // Initialize Window
	        Graphics2D g = (Graphics2D) buff_strat.getDrawGraphics();
	        
	        
	        // Draw Scene
	        active_scenes.forEach((k, v)->{
	        	if (v.getVisible()) {
	        		current_scene = v;
	        		game_window.setTitle("CISC 275 - Group 3 - Estuary Game - " + k);
	        	}
	        });
	      
	        
	        if (click_event) {
	        	processNav( ((UpperInterfaceScene)interface_bars.get("UPPER")).navClick(click_x, click_y) );   	
	       	
	        	if (current_scene.processClick(click_x, click_y) && current_scene.getClickable())
	        		current_scene.processScore();
	             		
	        	System.out.println("Score: " + score); // DEBUG - REMOVE
	        	click_event = false;
	        }
	        
	        
	        if (current_scene.getName() == "Beach")
	        	((BeachScene)current_scene).moveCrabs();
	        else if (current_scene.getName() == "Bay")
	        	((BayScene)current_scene).move();
	        
	        
	        // Draw Scene
	        current_scene.drawScene(g);
	        
	        // Draw Interface
	        ((UpperInterfaceScene)interface_bars.get("UPPER")).drawScene(g);
	        ((LowerInterfaceScene)interface_bars.get("LOWER")).drawScene(g, current_scene.getTime(), current_scene.getScore());
	         
	        // Draw Inventory
	        if (inventory_scene.getVisible()) {
	        	current_scene.toggleClickable();
	        	inventory_scene.drawScene(g);
	        }
	        	
	        // Update Screen
	        g.dispose();
	        buff_strat.show();
	
	         
	        // Loop Delay
	        try { Thread.sleep(50); } catch (Exception e) {}
	        sleep_time += 50;
	        
	        if (sleep_time % 1000 == 0) 
	        	active_scenes.forEach((k,v)->v.updateTime());
	      }
	}
	
	private void processNav(String nav_label) {
		System.out.println("NavClick: " + nav_label);  // DEBUG - REMOVE
		if (nav_label == null) {
			return;
		} else if (nav_label == "Inventory") {
			current_scene.toggleClickable();
			inventory_scene.toggleVisible();
			
		} else
			active_scenes.forEach((k,v)->{
						     	  if (k == nav_label)
						     		  v.setVisible();
								  else
									  v.setHidden();
			});
	}
	
	public static void main(String args[]) {
		Game game = new Game();
	}
}
