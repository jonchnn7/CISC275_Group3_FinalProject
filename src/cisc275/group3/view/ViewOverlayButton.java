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
public class ViewOverlayButton extends JPanel {
  private final ImageIcon BUTTON_IMAGE;
  private final ImageIcon BUTTON_ROLL_IMAGE;
  private final int BUTTON_WIDTH;
  private final int BUTTON_HEIGHT;
  
  private JButton overButton;
  
  /**
   * Minimum requirement constructor
   * @param bi 	ImageIcon-button image
   * @param w 	int-image width
   * @param h	int-image height
   */
  public ViewOverlayButton(ImageIcon bi, int w, int h) {
    this(bi, bi, w, h);
  }
  
  /**
   * Rollover constructor
   * @param bi	ImageIcon-button image
   * @param bro	ImageIcon-rollover image
   * @param w	int-image width
   * @param h	int-image height
   */
  public ViewOverlayButton(ImageIcon bi, ImageIcon bro, int w, int h) {
    super();
    BUTTON_IMAGE = bi;
    BUTTON_ROLL_IMAGE = bro;
    BUTTON_WIDTH = w;
    BUTTON_HEIGHT = h;
    
    createButton();
    
    this.add(overButton);
    this.setDoubleBuffered(true);
    this.setOpaque(false);
    this.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
  }
  
  /**
   * Creates a new JButton given an ImageIcon
   * and, potentially, an additional ImageIcon
   * to use as the rollover image.
   */
  private void createButton() {
    overButton = new JButton();
    overButton.setBorderPainted(false);
    overButton.setBorder(null);
    overButton.setMargin(new Insets(0, 0, 0, 0));
    overButton.setContentAreaFilled(false);
    overButton.setIcon(BUTTON_IMAGE);
    overButton.setRolloverIcon(BUTTON_ROLL_IMAGE);
  }
  
  /**
   * Returns pointer to the button. Allows the 
   * controller to create the button action
   * @return pointer to JButton
   */
  public JButton getOverButton() {
    return overButton;
  }
}