package cisc275.group3.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Font;


import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.sceneobject.SceneObject;

@SuppressWarnings("serial")
public class AlphaView extends JPanel {
  private static int frameHeight;
  private static int frameWidth;
  
  private JFrame frame;
  private Scene theScene;
  //private ArrayList<SceneObject> fishList;
  private BufferedImage currentImg;
  
  @Override
  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    
    //Draw Background
    g2d.setColor(theScene.getBackgroundColor());
    g2d.fillRect(0, 0, frameWidth, frameHeight);
    
    //Draw NavItems
    for(int i = 0; i < theScene.getNavObjects().size(); i++) {
		g.setColor(Color.GREEN);
        g.fillRect((int)theScene.getNavObjects().get(i).getLocation().getX(),(int) theScene.getNavObjects().get(i).getLocation().getY(), (int)theScene.getNavObjects().get(i).getPassport().getWidth(), (int)theScene.getNavObjects().get(i).getPassport().getHeight());
        g.setColor(Color.white);
		g.setFont(new Font("Sans Serif", Font.BOLD, 18));
		
		g.drawString(theScene.getNavObjects().get(i).navClick(),
   		     ((int) theScene.getNavObjects().get(i).getLocation().getX() + ((int)theScene.getNavObjects().get(i).getPassport().getWidth() - g.getFontMetrics().stringWidth(theScene.getNavObjects().get(i).navClick()))/2 ),
		         (int) (theScene.getNavObjects().get(i).getLocation().getY() + (int)theScene.getNavObjects().get(i).getPassport().getHeight()/2) + (g.getFontMetrics().getHeight()/4) );

    }
    
    
    //Draw SceneItems
    Collections.reverse(theScene.getSceneItems());
    theScene.getSceneItems().forEach((item)->{
      try {
        currentImg = ImageIO.read(new File(item.getPassport().getImageFile()));
      } catch (IOException e) {
        e.printStackTrace();
      }
      g2d.drawImage(currentImg, (int)item.getLocation().getX(), (int)item.getLocation().getY(), this);
    });
    g2d.dispose();
  }
  
  public AlphaView (int w, int h, Scene sc) {
    // Display Parameters
    frameHeight = h;
    frameWidth = w;
    theScene = sc;
    
    this.setBackground(Color.blue);
    
    // Create Display Window
	frame = new JFrame();
    frame.getContentPane().add(this);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(frameWidth, frameHeight);
    frame.setVisible(true);
  }
 
  public void changeActiveScene(Scene sc) {
	  theScene = sc;
  }
  
  public void paintScene() {
  
//  public void updateObjects(ArrayList<SceneObject> s) {
    //fishList = (ArrayList<SceneObject>) s.clone();  // FIX ME.   FIX ME.   FIX ME.   FIX ME.
    frame.repaint();
  }
}
