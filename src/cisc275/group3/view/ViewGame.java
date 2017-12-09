package cisc275.group3.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import cisc275.group3.sceneobject.SceneObject;

/**
 * @author Scott
 * @author Jolyne
 */
public class ViewGame extends JPanel {
	// frame sizes
	private final int FRAME_WIDTH;
	private final int FRAME_HEIGHT;

	// list of items in scene
	private ArrayList<SceneObject> itemList;

	// images
	private BufferedImage currentImg;
	private String bgImage;

	/**
	 * Paint frame
	 */
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();

		// Draw Background Image
		g2d.drawImage((new ImageIcon(bgImage).getImage()), 0, 0, FRAME_WIDTH, FRAME_HEIGHT, this);

		// Draw SceneItems
		Collections.reverse(itemList);
		itemList.forEach((item) -> {
			try {
				currentImg = ImageIO.read(new File(item.getPassport().getImageFile()));
			} catch (IOException e) {
				System.out.println(item.getPassport().getImageFile());
				e.printStackTrace();
			}
			g2d.drawImage(currentImg, (int) item.getLocation().getX(), (int) item.getLocation().getY(), this);
		});
		g2d.dispose();
	}

	/**
	 * Constructor - Initiate View Game
	 * 
	 * @param w
	 *            int-width of frame
	 * @param h
	 *            int-height of frame
	 * @param obList
	 *            ArrayList-list of items
	 * @param bg
	 *            String-backround image file
	 */
	public ViewGame(int w, int h, ArrayList<SceneObject> obList, String bg) {
		super();
		// Display Parameters
		FRAME_HEIGHT = h;
		FRAME_WIDTH = w;
		itemList = obList;
		bgImage = bg;

		this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		this.setDoubleBuffered(true);
	}

	/**
	 * updates panel
	 * 
	 * @param list
	 *            ArrayList<SceneObject> - list of items to update/repaint
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void updatePanel(ArrayList<SceneObject> list) {
		itemList = (ArrayList<SceneObject>) list.clone();
		this.repaint();
	}
}
