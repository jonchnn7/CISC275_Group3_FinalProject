import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

public class InterfaceWindow{
	// Interface Properties
	protected int interface_width;
	protected int interface_height;
	protected Color interface_background;
	
	protected ArrayList<SceneObject> interface_items;
	protected ArrayList<SceneObject> nav_items = new ArrayList<SceneObject>();
	
	public InterfaceWindow(int width, int height) {
		interface_width = width;
		interface_height = height; 
		interface_background = Color.black;
	}
	
	public void drawInterface(Graphics g, int score) {
        g.setColor(this.interface_background);
        g.fillRect(0, 0, interface_width, interface_height);
        
        g.setColor(Color.white);
		g.setFont(new Font("Sans Serif", Font.BOLD, 42));
		g.drawString("Estuary Click Adventure!",(interface_width/2)-g.getFontMetrics().stringWidth("Estuary Click Adventure!")/2,50);
		
        g.setColor(Color.white);
		g.setFont(new Font("Sans Serif", Font.BOLD, 25));
		g.drawString("Score: " + score, interface_width-150, interface_height-25);

    }

}
