//Window Libraries
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Event Libraries
import javax.swing.event.MouseInputAdapter;

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
	
	// Active Scenes - identified by name
	Map<String, Scene> active_scenes = new HashMap<String, Scene>();
	
	
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
	    
	    initGame();
	}
	
	
	private void initGame() {
		active_scenes.put("HQ", new HeadquartersScene(SCREEN_WIDTH, SCREEN_HEIGHT));
		active_scenes.put("Bay", new BayScene(SCREEN_WIDTH, SCREEN_HEIGHT));

		gameLoop();
	}
	
	private void gameLoop() {
		int sleep_time = 0;
		 
	    while(true) {
	    	
	        // Initialize Window
	        Graphics2D g = (Graphics2D) buff_strat.getDrawGraphics();
	        
	        // Draw Scene
	        active_scenes.forEach((k, v)->{
	        	if (v.visible) {
	        		v.drawScene(g);
	        		game_window.setTitle("CISC 275 - Group 3 - Estuary Game - " + k);
	        	}
	        });
	      
	         
	        // Update Screen
	        g.dispose();
	        buff_strat.show();
	
	         
	        // Loop Delay
	        try { Thread.sleep(100); } catch (Exception e) {}
	        sleep_time += 100;
	        
	        if (sleep_time % 1000 == 0) 
	        	active_scenes.forEach((k,v)->v.updateTime());
	        
	        if (sleep_time % 3000 == 0) {
	        	active_scenes.forEach((k,v)->v.toggleVissible());
	        }
	        
	    }
	}
	
	public static void main(String args[]) {
		Game game = new Game();
	}
}
