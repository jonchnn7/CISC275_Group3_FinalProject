import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class AlphaCrab extends SceneObject {
	
	Random rand_gen = new Random();

	public AlphaCrab(int x, int y, int d) {
		super(x, y, 100, 50, d);
		this.item_color = Color.getHSBColor(26, 68, 66);
	}
	
	@Override
	public void drawItem(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(this.item_color);
		g2.fill(this.shape);
		g2.setColor(Color.darkGray);
		g2.setStroke(new BasicStroke(2));
		g2.draw(this.shape);
	}
	
	@Override
	public boolean itemClicked(int click_x, int click_y) {
		return false;
	}
	
	public void move() {
		this.item_x += rand_gen.nextInt(10) + 2;
		this.shape = new Ellipse2D.Double(this.item_x, this.item_y, 100, 50);
	}

}
