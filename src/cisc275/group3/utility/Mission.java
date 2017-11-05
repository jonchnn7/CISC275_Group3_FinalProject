package cisc275.group3.utility;

import java.awt.AWTException;
//Window Libraries
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import InterfaceWindow;
import cisc275.group3.model.scene.BayScene;
import cisc275.group3.model.scene.BeachScene;
import cisc275.group3.model.scene.HeadquartersScene;
import cisc275.group3.model.scene.InventoryScene;
import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.WetlandsScene;
import cisc275.group3.model.sceneobject.BetaFish;
import cisc275.group3.model.sceneobject.ToolCamera;
import cisc275.group3.model.sceneobject.ToolNet;
import cisc275.group3.model.sceneobject.ToolTrimmer;
import cisc275.group3.model.sceneobject.ToolSample;
import cisc275.group3.model.sceneobject.ToolObject;

import java.awt.event.InputEvent;
//Event Libraries
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Utility Libraries
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SuppressWarnings("serial")
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
	private Mission activeMission;
	private ToolObject activeTool;
	Random rand_gen = new Random();
	private Color[] color_list = {Color.black, Color.cyan, Color.darkGray, Color.magenta,
			  Color.red, Color.yellow, Color.orange};
	
	// Event Variables
	private int click_x;
	private int click_y;
	private boolean click_event;
	private int current_x;
	private int current_y;
	
	// Zone Variables
	Scene current_scene;
	Map<String, Scene> active_scenes = new HashMap<String, Scene>();
	
	// Inventory Variables
	InventoryScene inventory_scene = new InventoryScene(SCREEN_WIDTH, SCREEN_HEIGHT);
	
	// Interface Variables
	Map<String, Scene> interface_bars = new HashMap<String, Scene>();
	
	// Map Variable
	MapScene map_scene = new MapScene(SCREEN_WIDTH, SCREEN_HEIGHT);
	
	public Game() throws AWTException {
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
	    
	    addMouseMotionListener(new MouseAdapter() {
	    	public void mouseMoved(MouseEvent e) {
	    		current_x = e.getX();
	    		current_y = e.getY();
	    	}
	    });
	    
	    score = 0;
	    activeMission = new Mission(null);
	    initGame();
	}
	
	
	private void initGame() throws AWTException {
		active_scenes.put("Title", new TitleScene(SCREEN_WIDTH, SCREEN_HEIGHT));
		active_scenes.put("HQ", new HeadquartersScene(SCREEN_WIDTH, SCREEN_HEIGHT));
		active_scenes.put("Bay", new BayScene(SCREEN_WIDTH, SCREEN_HEIGHT));
		active_scenes.put("Beach", new BeachScene(SCREEN_WIDTH, SCREEN_HEIGHT));
		active_scenes.put("Wetlands", new WetlandsScene(SCREEN_WIDTH, SCREEN_HEIGHT));
		
		interface_bars.put("UPPER", new UpperInterfaceScene(SCREEN_WIDTH, "UPPER"));
		interface_bars.put("LOWER", new LowerInterfaceScene(SCREEN_WIDTH, SCREEN_HEIGHT, "LOWER"));

		processNav("Title");
		gameLoop();
	}
	
	private void gameLoop() throws AWTException {
		int sleep_time = 0;
		int robot_counter = 0;
	    
		Robot r1 = new Robot();
		
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
	        
	        
	        
	        /*-------------ROBOT SIMULATION---------------------
	         * This is only here to show clicking the gui during the alpha, will be removed after.
	         * A separate class for robot might be later used to implement a tutorial.
	         * */
	        
	        /* -------UNCOMMENT BELOW TO RUN ROBOT FOR ALPHA----------------------------
			if (robot_counter == 5) {
				// click beach
				r1.mouseMove(160, 40);
				r1.delay(100);
				r1.mousePress(InputEvent.BUTTON1_MASK);
			}
			if (robot_counter == 7) {
				r1.mouseRelease(InputEvent.BUTTON1_MASK);
				r1.mouseMove(100, 400);
				r1.delay(1000);
			}
			if (robot_counter >= 8 && robot_counter <= 55) {
				// click to race
				r1.mousePress(InputEvent.BUTTON1_MASK);
			}
			if (robot_counter == 56) {
				r1.mouseRelease(InputEvent.BUTTON1_MASK);
			}
			if (robot_counter == 57) {
				// move to bay
				r1.mouseMove(15, 80);
				r1.delay(1000);
			}
			if (robot_counter == 60) {
				// click bay
				r1.mousePress(InputEvent.BUTTON1_MASK);
			}
			if (robot_counter == 61) {
				r1.mouseRelease(InputEvent.BUTTON1_MASK);
			}
			if (robot_counter == 62) {
				// move to net
				r1.mouseMove(1100, 40);
				r1.delay(1000);
			}
			if (robot_counter == 72) {
				// click net
				r1.mousePress(InputEvent.BUTTON1_MASK);
			}
			if (robot_counter == 73) {
				r1.mouseRelease(InputEvent.BUTTON1_MASK);
			}
			if (robot_counter == 82) {
				r1.mouseMove(current_scene.getSceneObject().getX(), current_scene.getSceneObject().getY());
			}
			if (robot_counter == 86) {
				r1.mouseMove(current_scene.getSceneObject().getX() + 50, current_scene.getSceneObject().getY() + 50);
				r1.delay(50);
				r1.mousePress(InputEvent.BUTTON1_MASK);
				r1.delay(1000);
			}
			if (robot_counter == 87) {
				r1.mouseRelease(InputEvent.BUTTON1_MASK);
			}
			if (robot_counter == 88) {
				r1.mouseMove(current_scene.getSceneObject().getX() + 50, current_scene.getSceneObject().getY() + 50);
				r1.delay(50);
				r1.mousePress(InputEvent.BUTTON1_MASK);
				r1.delay(1000);
			}
			if (robot_counter == 89) {
				r1.mouseRelease(InputEvent.BUTTON1_MASK);
			}
			if (robot_counter == 90) {
				r1.mouseMove(current_scene.getSceneObject().getX() + 50, current_scene.getSceneObject().getY() + 50);
				r1.delay(50);
				r1.mousePress(InputEvent.BUTTON1_MASK);
				r1.delay(1000);
			}

			if (robot_counter == 91) {
				r1.mouseRelease(InputEvent.BUTTON1_MASK);
			}

			robot_counter++;
			
			*/

	        //-------END ROBOT-------------
	      
	        // If there's a click, figure out what to do with it and do it
	        if (click_event) {
	        	processNav( ((UpperInterfaceScene)interface_bars.get("UPPER")).navClick(click_x, click_y) );
	        	
	        	if (map_scene.getVisible()) {
	        		processNav( map_scene.navClick(click_x, click_y) );
	        		if (!current_scene.getVisible()) {
	        			current_scene.toggleClickable();
	        			map_scene.toggleVisible();
	        		}
	        	} else if (current_scene.getName() == "Headquarters") {
	        		processNav( ((HeadquartersScene)current_scene).navClick(click_x, click_y) );
	        	}
	        	
	        	
	        	Color tmp = current_scene.processClick(click_x, click_y, activeTool);
	       	
	        	if ((tmp != null) && current_scene.getClickable()) {
	        		if (activeMission.getTargetObjectColor()==(tmp)) {
	        			activeMission.setDoneMission(true);
	        		}
	        		current_scene.processScore();
	        	}
	             		
	        	click_event = false;
	        }
	        
	        
	        // Scene Object Updates
	        if (current_scene.getName() == "Beach")
	        	((BeachScene)current_scene).moveCrabs();
	        else if (current_scene.getName() == "Bay")
	        	((BayScene)current_scene).move();
	        
	        
	        // Draw Scene
	        current_scene.drawScene(g);
	        
	        // Draw Interface
	        ((UpperInterfaceScene)interface_bars.get("UPPER")).drawScene(g);
	        ((LowerInterfaceScene)interface_bars.get("LOWER")).drawScene(g, current_scene.getTime(), current_scene.getScore(), activeMission.toString());
	         
	        // Draw Map
	        if (map_scene.getVisible()) {
	        	map_scene.drawScene(g);
	        }
	     
	        // Draw Inventory
	        if (inventory_scene.getVisible()) {
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
			
		} else if (nav_label == "Map") {
			current_scene.toggleClickable();
			map_scene.toggleVisible();
		} else if (nav_label == "Missions") {
			activeMission = new Mission(color_list[rand_gen.nextInt(color_list.length)]);
		} else if (nav_label == "Net") {
			if ((activeTool == null) || (!activeTool.getName().equals("net"))) {
				activeTool = new NetTool(current_x, current_y, 0, 0);
			} else {
				activeTool = null;
			}
		} else if (nav_label == "Camera") {
			if ((activeTool == null) || (!activeTool.getName().equals("camera"))) {
				activeTool = new CameraTool(current_x, current_y, 0, 0);
			} else {
				activeTool = null;
			}
		}
		else if (nav_label == "Trimmer") {
			if ((activeTool == null) || (!activeTool.getName().equals("Trimmer"))) {
				activeTool = new TrimmerTool(current_x, current_y, 0, 0);
			} else {
				activeTool = null;
			}
		}
		else if (nav_label == "Sample") {
			if ((activeTool == null) || (!activeTool.getName().equals("Sample"))) {
				activeTool = new SampleTool(current_x, current_y, 0, 0);
			} else {
				activeTool = null;
			}
		}else {
			active_scenes.forEach((k,v)->{
						     	  if (k == nav_label)
						     		  v.setVisible();
								  else
									  v.setHidden();
			});
		}
	}
	
	public static void main(String args[]) throws AWTException {
		Game game = new Game();
	}
}
