package cisc275.group3.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SceneView extends JPanel {
  private final int SCREEN_WIDTH;
  private final int SCREEN_HEIGHT;
  private final SceneLayer SCENE_LAYER;
  
  private JButton mapButton;
  private JLabel timeLabel;
  private JLabel scoreLabel;
  private JLayeredPane layeredPane;
  private JToolBar lowerLeftBar;
  private JToolBar scoreBar;
  private int score;
  private int time;
  
  public SceneView(int w, int h, JPanel panel) {
    super();
    SCREEN_WIDTH = w;
    SCREEN_HEIGHT = h;
    SCENE_LAYER = null;
    
    panel.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    
    createLowerLeftBar();
 
    layeredPane = new JLayeredPane();
    layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);
    layeredPane.add(lowerLeftBar, JLayeredPane.MODAL_LAYER);
    layeredPane.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    add(layeredPane);
  }
  
  public SceneView(int w, int h, SceneLayer sl, int s, int t) {
    super();
    SCREEN_WIDTH = w;
    SCREEN_HEIGHT = h;
    SCENE_LAYER = sl;
    
    score = s;
    time = t;
    
    SCENE_LAYER.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    
    createLowerLeftBar();
    createScoreBar();
  
    layeredPane = new JLayeredPane();
    layeredPane.add(sl, JLayeredPane.DEFAULT_LAYER);
    layeredPane.add(lowerLeftBar, JLayeredPane.MODAL_LAYER);
    layeredPane.add(scoreBar, JLayeredPane.MODAL_LAYER);
    layeredPane.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    add(layeredPane);
  }
  
  private void createScoreBar() {
    scoreLabel = new JLabel(Integer.toString(score),
    		                new ImageIcon("img/coins_icon.png"),
    		                JLabel.CENTER);
    scoreLabel.setFont(new Font("Roboto", Font.BOLD, 36));
    scoreLabel.setForeground(Color.black);
    scoreLabel.setFocusable(false);
    scoreLabel.setSize(200, 75);
    
    scoreBar = new JToolBar() {
      @Override
      public void paintComponent(Graphics g) {
        Dimension size = scoreBar.getSize();
        g.drawImage((new ImageIcon("img/coins_bg.png")).getImage(), 0, 0, size.width, size.height, this);
      }
    };
    scoreBar.add(scoreLabel);
    scoreBar.setOpaque(false);
    scoreBar.setFloatable(false);
    scoreBar.setSize(150, 80);
    scoreBar.setBorder(null);
    scoreBar.setLocation(SCREEN_WIDTH-200, SCREEN_HEIGHT-90);
  }
  
  private void createLowerLeftBar() {
    mapButton = new JButton();
    mapButton.setBorderPainted(false);
    mapButton.setBorder(null);
    mapButton.setMargin(new Insets(0, 0, 0, 0));
    mapButton.setContentAreaFilled(false);
    mapButton.setIcon(new ImageIcon("img/map_icon.png"));
    mapButton.setRolloverIcon(new ImageIcon("img/map_icon_invert.png"));
    mapButton.setSize(75, 75);
	    
    timeLabel = new JLabel(Integer.toString(time), 
                           new ImageIcon("img/clock_icon.png"), 
                           JLabel.CENTER);
    timeLabel.setFont(new Font("Roboto", Font.BOLD, 36));
    timeLabel.setForeground(Color.black);
    timeLabel.setFocusable(false);
    timeLabel.setSize(200, 75);
	    
    lowerLeftBar = new JToolBar(){
      @Override
      public void paintComponent(Graphics g) {
        Dimension size = lowerLeftBar.getSize();
        g.drawImage((new ImageIcon("img/upper_left_bg.png")).getImage(), 0, 0, size.width, size.height, this);
      }
    };
    lowerLeftBar.add(mapButton);
    lowerLeftBar.add(Box.createHorizontalGlue());
    lowerLeftBar.add(timeLabel);
    lowerLeftBar.setOpaque(false);
    lowerLeftBar.setFloatable(false);
    lowerLeftBar.setSize(250, 80);
    lowerLeftBar.setBorder(null);
    lowerLeftBar.setLocation(30, SCREEN_HEIGHT-90);
  }
  
  public void updateScore(int s) {
    scoreLabel.setText(Integer.toString(s));
  }
  
  public void updateTime(int t) {
	  timeLabel.setText(Integer.toString(t));
  }
  
  public JButton getMapButton() {
    return mapButton;
  }
}
