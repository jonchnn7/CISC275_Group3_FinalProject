package cisc275.group3.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * Creates a JButton to be used in the construction
 * of the game's overlay menu. The minimum requirements
 * are an ImageIcon to use as the button and its
 * corresponding width and height. Optionally, an
 * additional ImageIcon can be used as the button's
 * rollover icon.
 * <p>
 * ViewOverlayButton.java
 * <p>
 * @author Scott
 */
@SuppressWarnings("serial")
public class ViewOverlayLabel extends JPanel {
  private final ImageIcon LABEL_IMAGE;
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
    LABEL_IMAGE = null;
    LABEL_BG_IMAGE = null;
    LABEL_WIDTH = w;
    LABEL_HEIGHT = h;
     
    labelString = s;
     
    overLabel = new JLabel(labelString);
      
    setLabelProperties();
  }
  
  /**
   * Image Label Constructor
   * @param li  ImageIcon-label image
   * @param w   int-label width
   * @param h   int-label height
   * @param s   String-label string
   */
  public ViewOverlayLabel(ImageIcon li, int w, int h, String s) {
    super();
    LABEL_IMAGE = li;
    LABEL_BG_IMAGE = null;
    LABEL_WIDTH = w;
    LABEL_HEIGHT = h;
    
    labelString = s;
    
    overLabel = new JLabel(labelString, LABEL_IMAGE, JLabel.CENTER);
    
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
    LABEL_IMAGE = li;
    LABEL_BG_IMAGE = bgi;
    LABEL_WIDTH = w;
    LABEL_HEIGHT = h;
    
    labelString = s;
    
    overLabel = new JLabel(labelString, LABEL_IMAGE, JLabel.CENTER){
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

   
    this.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
    this.setDoubleBuffered(true);
    this.setOpaque(false);
    
    this.add(overLabel);

  }
  
  /**
   * Returns pointer to the button. Allows the 
   * controller to create the button action
   * @return pointer to JButton
   */
  public JLabel getOverLabel() {
    return overLabel;
  }
}