package cisc275.group3.sceneobjects;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class NavObject extends SceneObject {

	protected String label;
		
	public NavObject(int x, int y, int width, int height, String lbl) {
		super(x, y, width, height, 20);
		this.item_color = Color.BLACK;
		this.shape = new Rectangle2D.Double(this.item_x, this.item_y, this.item_width, this.item_height);
		this.label = lbl;
	}
	
	@Override
	public void drawItem(Graphics g) {
		g.setColor(this.item_color);
        g.fillRect(this.item_x, this.item_y, (this.item_width), (this.item_height));
        g.setColor(Color.white);
        g.drawRect(this.item_x, this.item_y, this.item_width, this.item_height);
        
        g.setColor(Color.white);
		g.setFont(new Font("Sans Serif", Font.BOLD, 18));
        g.drawString(this.label,
        		     (this.item_x + (this.item_width - g.getFontMetrics().stringWidth(this.label))/2 ),
			         (this.item_y + (this.item_height/2) + (g.getFontMetrics().getHeight()/4) ));
	}
	
	public String navClick() {
		return this.label;
	}
	
	public Color getColorFill() {
		return this.item_color;
	}
	
	public void setColorFill(Color color) {
		this.item_color = color;
	}

}
