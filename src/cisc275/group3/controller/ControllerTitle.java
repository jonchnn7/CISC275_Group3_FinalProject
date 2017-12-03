package cisc275.group3.controller;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.utility.EnumGameState;
import cisc275.group3.utility.EnumLayerCode;
import cisc275.group3.view.GameWindow;

/**
 * The Title Controller is responsible for the control of the title screen.
 * 
 * The title screen is the first interface that is visible for the user and
 * provides a start button that sends the user to the hq upon clicking.
 * 
 * ControllerTitle.java
 * 
 * @author Ryan
 * @author Scott
 * @author Jon
 */

public class ControllerTitle extends ControllerScene {
	private final ImageIcon BG_IMAGE = new ImageIcon("img/backgrounds/titleScreen_bg.png");
	private JPanel titlePanel;
	private JButton startButton;
	private JButton tutorialButton;
	private JButton exitButton;

	/**
	 * 
	 * @param w
	 *            int-scene width
	 * @param h
	 *            int-scene height
	 * @param f
	 *            GameWindow-JFrame container
	 * @param cl
	 *            HashMap-associations of scene controllers and layers
	 * @param sceneType
	 *            int-indicates how the scene should be initialized/updated 0 =
	 *            empty/no update, 1 = special update (ex. tutorial HQ), 2 =
	 *            standard update, 3 = menus/interfaces
	 */
	public ControllerTitle(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
		super(w, h, f, cl, sceneType);
	}

	/**
	 * Creates the scene and adds it to the main pain. Sets the layers and component
	 * list for the ControllerTitle.
	 */
  @Override
	@SuppressWarnings("serial")
	protected void createScene() {
		titlePanel = new JPanel(true) {
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(BG_IMAGE.getImage(), 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, this);
			}
		};

		// Set Properties
		titlePanel.setLayout(null);
		titlePanel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		titlePanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		titlePanel.setOpaque(true);

		titlePanel.setName("TitleLayer");
		addTitleButton();
		addTutorialButton();
		addExitButton();
		/*
		 * if (sceneType == 1) { addTutorialButton(); } else { addTitleButton(); }
		 */

		mainPane.setLayer(titlePanel, EnumLayerCode.MainTop.getCode());
		mainPane.add(titlePanel, EnumLayerCode.MainTop.getCode());
		componentList.put("Title", titlePanel);
	}

	/**
	 * Adds title button to controller scene
	 */
	private void addTitleButton() {
		startButton = new JButton("Start");
		startButton.setFont(new Font("Roboto", Font.BOLD, 1));
		startButton.setBounds(SCREEN_WIDTH/3-150, SCREEN_HEIGHT*3/4, 300, 96);
		startButton.setIcon(new ImageIcon("img/Yellow startbutton.png"));
		startButton.setOpaque(false);
		startButton.setBorderPainted(false);
		startButton.setBorder(null);
		startButton.setMargin(new Insets(0, 0, 0, 0));
		startButton.setContentAreaFilled(false);
		startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		startButton.setSize(300, 96);
		titlePanel.add(startButton);
	}
	
	 /**
   * Returns start button.
   * <p>
   * This method allows GameController to define the
   * listener so state changes are within the correct
   * scope.
   */
	public JButton getStartButton() {
	  return startButton;
	}

	/**
	 * Adds a tutorial button to initialize the tutorial phase
	 */
	private void addTutorialButton() {
		tutorialButton = new JButton("Tutorial");
		tutorialButton.setFont(new Font("Roboto", Font.BOLD, 1));
		tutorialButton.setBounds(SCREEN_WIDTH*2/3-150, SCREEN_HEIGHT*3/4, 300, 96);
		tutorialButton.setIcon(new ImageIcon("img/Yellow Tutorialbutton.png"));
		tutorialButton.setOpaque(false);
		tutorialButton.setBorderPainted(false);
		tutorialButton.setBorder(null);
		tutorialButton.setMargin(new Insets(0, 0, 0, 0));
		tutorialButton.setContentAreaFilled(false);
		tutorialButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tutorialButton.setSize(330, 96);
		titlePanel.add(tutorialButton);
	}
	
	/**
	 * Returns tutorial button.
	 * <p>
   * This method allows GameController to define the
   * listener so state changes are within the correct
   * scope.
	 */
	public JButton getTutorialButton() {
	  return tutorialButton;
	}
	
	/**
	 * Adds an exit button to the top left corner
	 */
  private void addExitButton() {
    exitButton = new JButton(" ");
	  exitButton.setFont(new Font("Roboto", Font.BOLD, 1));
	  exitButton.setBounds(10, 10, 75, 75);
	  exitButton.setIcon(new ImageIcon("img/title_exit_icon.png"));
	  exitButton.setOpaque(false);
	  exitButton.setBorderPainted(false);
	  exitButton.setBorder(null);
	  exitButton.setMargin(new Insets(0, 0, 0, 0));
	  exitButton.setContentAreaFilled(false);
	  exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	  exitButton.setSize(75, 75);
	  titlePanel.add(exitButton);
	  
	  // Add action listener 
	  exitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
	  });
	}

	/**
	 * Required by abstract class
	 */
	@Override
	protected void addML() {
	}
}