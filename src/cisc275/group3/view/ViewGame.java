package cisc275.group3.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.sceneobject.SceneObject;

/**
 * @author Scott
 * @author Jolyne
 */
public class ViewGame extends JPanel {
  private final int FRAME_WIDTH;
  private final int FRAME_HEIGHT;
	  
  private ArrayList<SceneObject> itemList;
  private BufferedImage currentImg;
  private String bgImage;
	  
  @Override
  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    
    // Draw Background Image
    g2d.drawImage((new ImageIcon(bgImage).getImage()), 0, 0, FRAME_WIDTH, FRAME_HEIGHT, this);
	    
    // Draw SceneItems
    Collections.reverse(itemList);
    itemList.forEach((item)->{
      try {
        currentImg = ImageIO.read(new File(item.getPassport().getImageFile()));
      } catch (IOException e) {
        e.printStackTrace();
      }
      g2d.drawImage(currentImg, (int)item.getLocation().getX(), (int)item.getLocation().getY(), this);
    });
    if (Scene.getCurrentMission().isDoneMission() && (Scene.getCurrentMission().getObjectNum() == -5) && (Scene.getCurrentMission().getTargetObject() == null)) {
    	g2d.setColor(Color.WHITE);
    	g2d.setFont(new Font("Roboto", Font.BOLD, 40));
    	g2d.drawString(Scene.getCurrentFact(), FRAME_WIDTH/4, FRAME_HEIGHT/4);
    }
    g2d.dispose();
  }
	  
  public ViewGame (int w, int h, ArrayList<SceneObject> obList, String bg) {
    super();
    // Display Parameters
    FRAME_HEIGHT = h;
    FRAME_WIDTH = w;
    itemList = obList;
    bgImage = bg;
    
    this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
    this.setDoubleBuffered(true);
  }
	  
  @SuppressWarnings("unchecked")
  public void updatePanel(ArrayList<SceneObject> list) {
    itemList = (ArrayList<SceneObject>) list.clone();  
    this.repaint();
  }
}

