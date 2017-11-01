package cisc275.group3.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cisc275.group3.model.sceneobject.SceneObject;

@SuppressWarnings("serial")
public class AlphaView extends JPanel {
  private static int frameHeight;
  private static int frameWidth;
  
  private JFrame frame;
  private ArrayList<SceneObject> fishList;
  private BufferedImage fishImg;
  
  @Override
  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setColor(Color.blue);
    g2d.fillRect(0, 0, frameWidth, frameHeight);
    Collections.reverse(fishList);
    fishList.forEach((item)->{
      try {
        fishImg = ImageIO.read(new File(item.getPassport().getImageFile()));
      } catch (IOException e) {
        e.printStackTrace();
      }
      g2d.drawImage(fishImg, (int)item.getLocation().getX(), (int)item.getLocation().getY(), this);
    });
    g2d.dispose();
  }
  
  public AlphaView (int w, int h) {
    // Display Parameters
    frameHeight = h;
    frameWidth = w;
    
    this.setBackground(Color.blue);
    
    // Create Display Window
	frame = new JFrame();
    frame.getContentPane().add(this);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(frameWidth, frameHeight);
    frame.setVisible(true);
  }
  
  public void updateObjects(ArrayList<SceneObject> s) {
    fishList = (ArrayList<SceneObject>) s.clone();  // FIX ME.   FIX ME.   FIX ME.   FIX ME.
    frame.repaint();
  }
}
