package cisc275.group3.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates a JLabel to be used in the construction
 * of the game's overlay menu. The minimum requirements
 * are an 
 * <p>
 * ViewOverlayLabel.java
 * <p>
 * @author Scott
 */
@SuppressWarnings("serial")
public class ViewOverlayLabel extends JPanel {
  private ImageIcon label_image;
  private final ImageIcon LABEL_BG_IMAGE;
  private final int LABEL_WIDTH;
  private final int LABEL_HEIGHT;
  
  private JLabel overLabel;
  private String labelString;
  
  /**
   * Simple Label Constructor
   * @param w   int-label width
   * @param h   int-label height
   * @param s   String-display string
   */
  public ViewOverlayLabel(int w, int h, String s) {
    super();
    label_image = null;
    LABEL_BG_IMAGE = null;
    LABEL_WIDTH = w;
    LABEL_HEIGHT = h;
     
    labelString = s;
     
    overLabel = new JLabel(labelString);
      
    setLabelProperties();
  }
  
  /**
   * String Image Label Constructor
   * @param li  ImageIcon-label image
   * @param w   int-label width
   * @param h   int-label height
   * @param s   String-label string
   */
  public ViewOverlayLabel(ImageIcon li, int w, int h, String s) {
    super();
    label_image = li;
    LABEL_BG_IMAGE = null;
    LABEL_WIDTH = w;
    LABEL_HEIGHT = h;
    
    labelString = s;
    
    overLabel = new JLabel(labelString, label_image, JLabel.LEFT);
    
    setLabelProperties();
  }
  
  /**
   * Image Label with Background Constructor
   * @param li  ImageIcon-label image
   * @param bgi ImageIcon-background image
   * @param w   int-label width
   * @param h   int-label height
   * @param s   String-label string
   */
  public ViewOverlayLabel(ImageIcon li, ImageIcon bgi, int w, int h, String s) {
    super();
    label_image = li;
    LABEL_BG_IMAGE = bgi;
    LABEL_WIDTH = w;
    LABEL_HEIGHT = h;
    
    labelString = s;
    
    overLabel = new JLabel(labelString, label_image, JLabel.LEFT){
      public void paintComponent(Graphics g) {
        g.drawImage(LABEL_BG_IMAGE.getImage(), 0, 0, LABEL_WIDTH, LABEL_HEIGHT, this);
        super.paintComponent(g);
      }
    };  
    
    setLabelProperties();
  }
  
  /**
   * Sets JLabel properties for both a pure text
   * or text+image JLabel.
   */
  private void setLabelProperties() {
    overLabel.setFont(new Font("Roboto", Font.BOLD, 36));
    overLabel.setForeground(Color.black);
    overLabel.setFocusable(false);
    overLabel.setMinimumSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
    overLabel.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
    overLabel.setMaximumSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
    overLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

   
    this.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
    this.setDoubleBuffered(true);
    this.setOpaque(false);
    
    this.add(overLabel);

  }
  
  /**
   * Allows label text to be updated
   * @param upText  String-new label text
   */
  public void updateLabel(String upText) {
    overLabel.setText(upText);
  }
  
  public void updateIcon(ImageIcon i) {
	    overLabel.setIcon(i);
	  }
}