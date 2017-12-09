package cisc275.group3.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cisc275.group3.scene.Scene;
import cisc275.group3.utility.EnumLayerCode;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.view.GameWindow;

/**
 * The EndGame controller is responsible for both the "model" and control of the
 * endgame state.
 * <p>
 * This controller is only responsible for taking user input and switching
 * between game scenes. There is no underlying model to manipulate. Therefore,
 * the controller also defines the JPanel and JButtons to display for input.
 * <p>
 * See cisc275.group3.controller.ControllerScene.java
 * <p>
 * ControllerEndGame.java
 * <p>
 * 
 * @author Ryan
 * @author Jon
 * @author Scott
 */

public class ControllerEndGame extends ControllerScene implements LinkDynamics {
	private final ImageIcon BG_IMAGE = new ImageIcon("img/backgrounds/endGame_bg.png");
	// JPanel and Buttons variables
	private JPanel endGamePanel;
	private JButton resetButton;
	private JButton continueButton;
	private JLabel finalScore;

	/**
	 * Constructor
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
	 *            EnumSceneType-type of scene to be constructed
	 */
	public ControllerEndGame(int w, int h, GameWindow f, HashMap<String, Component> cl, EnumSceneType sceneType) {
		super(w, h, f, cl, sceneType);
	}

	/**
	 * Creates the scene and adds it to the main pain. Sets the layers and component
	 * list for the endGame.
	 */
	@Override
	@SuppressWarnings("serial")
	protected void createScene() {
		endGamePanel = new JPanel(true) {
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(BG_IMAGE.getImage(), 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, this);
			}
		};

		// Set Properties
		endGamePanel.setLayout(null);
		endGamePanel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		endGamePanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		endGamePanel.setOpaque(true);

		endGamePanel.setName("EndGameLayer");
		// addEndGameButton();
		// addTutorialButton();
		addLabelButtons();

		mainPane.setLayer(endGamePanel, EnumLayerCode.MainTop.getCode());
		mainPane.add(endGamePanel, EnumLayerCode.MainTop.getCode());
		componentList.put("EndGame", endGamePanel);

		// Reset Mouse
		Scene.setCurrentTool(null);
		mouseLabel.setIcon(new ImageIcon("img/mouse_empty.png"));
		mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	/**
	 * Adds the score label, reset button and continue button. The label will
	 * display the current score when the game time expires. The reset button will
	 * bring the user back to the main menu, and the continue button will keep the
	 * current score, reset the game timer and bring the user to the HQ.
	 */
	private void addLabelButtons() {
		finalScore = new JLabel("Final Score: " + Scene.getScore(), JLabel.CENTER);
		finalScore.setBounds(SCREEN_WIDTH / 2 - 225, SCREEN_HEIGHT/16, 450, 96);

		finalScore.setFont(new Font("Roboto", Font.BOLD, 52));
		finalScore.setForeground(Color.white);
		endGamePanel.add(finalScore);

		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Roboto", Font.BOLD, 1));
		resetButton.setBounds(SCREEN_WIDTH / 3 - 150, SCREEN_HEIGHT * 3 / 4, 300, 96);
		resetButton.setIcon(new ImageIcon("img/buttonPics/yellowResetButton.png"));
		resetButton.setOpaque(false);
		resetButton.setBorderPainted(false);
		resetButton.setBorder(null);
		resetButton.setMargin(new Insets(0, 0, 0, 0));
		resetButton.setContentAreaFilled(false);
		resetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		resetButton.setSize(300, 96);
		endGamePanel.add(resetButton);

		continueButton = new JButton("Continue");
		continueButton.setFont(new Font("Roboto", Font.BOLD, 1));
		continueButton.setBounds(SCREEN_WIDTH * 2 / 3 - 150, SCREEN_HEIGHT * 3 / 4, 300, 96);
		continueButton.setIcon(new ImageIcon("img/buttonPics/yellowContinueButton.png"));
		continueButton.setOpaque(false);
		continueButton.setBorderPainted(false);
		continueButton.setBorder(null);
		continueButton.setMargin(new Insets(0, 0, 0, 0));
		continueButton.setContentAreaFilled(false);
		continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		continueButton.setSize(300, 96);
		endGamePanel.add(continueButton);

	}

	/**
	 * Returns continue button.
	 * <p>
	 * This method allows GameController to define the listener so state changes are
	 * within the correct scope.
	 * @return the continue JButton
	 */
	public JButton getContinueButton() {
		return continueButton;
	}

	/**
	 * Returns reset button.
	 * <p>
	 * This method allows GameController to define the listener so state changes are
	 * within the correct scope.
	 * @return the reset JButton
	 */
	public JButton getResetButton() {
		return resetButton;
	}

	/**
	 * Connects the EndGame model and game view. The final score will be taken from
	 * the games static score variable and displayed.
	 * <p>
	 * Overridden from interface LinkDynamics.java
	 */
	@Override
	public void update() {
		finalScore.setText("Final Score: " + Scene.getScore());
	}
}
