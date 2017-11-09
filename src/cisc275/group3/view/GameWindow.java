package cisc275.group3.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 * Largest level container used to hold the 
 * game view. The primary component is a 
 * JLayeredPane which holds the individual 
 * views (Title, Map, Bay, etc). 
 * <p>
 * @author Scott
 */
@SuppressWarnings("serial")
public class GameWindow extends JFrame {
  private final int WINDOW_WIDTH;
  private final int WINDOW_HEIGHT;
  
  private JLayeredPane mainPane;
  
  /**
   * Constructor takes in two int's to set the
   * window width and height. We then construct
   * the main JLayeredpane, and set its 
   * attributes so it doesn't collapse on pack().
   * @param w int-width
   * @param h int-height
   */
  public GameWindow(int w, int h) {
    super("Estuary Click Adventure");
    
    // Display Parameters
    WINDOW_WIDTH = w;
    WINDOW_HEIGHT = h;
    
    // Create main layered pane
    mainPane = new JLayeredPane();
    mainPane.setDoubleBuffered(true);
    mainPane.setBounds(0, 0, WINDOW_WIDTH, WINDOW_WIDTH);
    mainPane.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
    
    // Add main pane to window
    this.setLayout(new BorderLayout());
    this.add(mainPane, BorderLayout.CENTER);
    this.pack();
    
    // Finalize Display Window
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }
  
  /**
   * Helper method used to access the main
   * JLayeredPane.
   * @return the main JLayeredPane
   */
  public JLayeredPane getMainPane() {
    return mainPane;
  }
}
