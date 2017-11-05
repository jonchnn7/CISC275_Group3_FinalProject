package cisc275.group3.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
  private final int WINDOW_WIDTH;
  private final int WINDOW_HEIGHT;
  
  private JLayeredPane mainPane;
  
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
  
  public JLayeredPane getMainPane() {
    return mainPane;
  }
}
