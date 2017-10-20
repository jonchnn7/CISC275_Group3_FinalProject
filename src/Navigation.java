import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Navigation extends SceneObject {

	protected String label;
		
	public Navigation(String lbl) {
		super(5,5, 100, 50);
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
		g.setFont(new Font("Sans Serif", Font.BOLD, 28));
        g.drawString(this.label,
        		     (this.item_x + (this.item_width - g.getFontMetrics().stringWidth(this.label))/2 ),
			         (this.item_height/2 + 14));
	}

}
