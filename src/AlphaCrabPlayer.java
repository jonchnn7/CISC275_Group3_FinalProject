import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class AlphaCrabPlayer extends AlphaCrab {

	public AlphaCrabPlayer(int x, int y) {
		super(x, y);
		this.item_color = Color.getHSBColor(26, 68, 66);
	}

	@Override
	public void drawItem(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(this.item_color);
		g2.fill(this.shape);
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(2));
		g2.draw(this.shape);
	}
}

