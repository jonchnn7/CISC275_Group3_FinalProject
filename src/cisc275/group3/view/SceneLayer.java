package cisc275.group3.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import cisc275.group3.model.sceneobject.SceneObject;

@SuppressWarnings("serial")
public class SceneLayer extends JPanel {
  protected final int FRAME_WIDTH;
  protected final int FRAME_HEIGHT;
	  
  protected ArrayList<SceneObject> itemList;
  protected BufferedImage currentImg;
  protected Color panelColor; 
	  
  @Override
  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
	    
    //Draw Background
    g2d.setColor(panelColor);
    g2d.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
	    
    //Draw SceneItems
    Collections.reverse(itemList);
    itemList.forEach((item)->{
      try {
        currentImg = ImageIO.read(new File(item.getPassport().getImageFile()));
      } catch (IOException e) {
        e.printStackTrace();
      }
      g2d.drawImage(currentImg, (int)item.getLocation().getX(), (int)item.getLocation().getY(), this);
    });
    g2d.dispose();
  }
	  
  public SceneLayer (int w, int h, ArrayList<SceneObject> obList, Color sc) {
    super();
    // Display Parameters
    FRAME_HEIGHT = h;
    FRAME_WIDTH = w;
    itemList = obList;
    panelColor = sc;
    
    this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
    this.setDoubleBuffered(true);
  }
	  
  @SuppressWarnings("unchecked")
  public void updatePanel(ArrayList<SceneObject> list) {
    itemList = (ArrayList<SceneObject>) list.clone();  
    this.repaint();
  }
}

