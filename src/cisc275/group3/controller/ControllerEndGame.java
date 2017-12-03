package cisc275.group3.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.utility.EnumLayerCode;
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
 * @author Jon
 * @author Scott
 */

public class ControllerEndGame extends ControllerScene implements LinkDynamics {

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
	 *            int-indicates how the scene should be initialized/updated 0 =
	 *            empty/no update, 1 = special update (ex. tutorial HQ), 2 =
	 *            standard update, 3 = menus/interfaces
	 */
	public ControllerEndGame(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
		super(w, h, f, cl, sceneType);
	}

	/**
	 * Creates the scene and adds it to the main pain. Sets the layers and component
	 * list for the endGame.
	 */
	@Override
	protected void createScene() {
		endGamePanel = new JPanel();

		// Set Panel Properties
		endGamePanel.setLayout(null);
		endGamePanel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		endGamePanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		endGamePanel.setBackground(Color.CYAN);
		endGamePanel.setOpaque(true);

		addLabelButtons();

		// Add to Layered Pane
		// and Component List
		mainPane.setLayer(endGamePanel, EnumLayerCode.EndGame.getCode());
		mainPane.add(endGamePanel, EnumLayerCode.EndGame.getCode());
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
		System.out.println(Scene.getScore());
		finalScore = new JLabel("Final Score: " + Scene.getScore(), JLabel.CENTER);
		finalScore.setBounds(500, 100, 450, 150);
		finalScore.setFont(new Font("Roboto", Font.BOLD, 45));
		finalScore.setForeground(Color.black);
		endGamePanel.add(finalScore);

		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Roboto", Font.BOLD, 10));
		resetButton.setBounds(450, 500, 100, 100);
		
		endGamePanel.add(resetButton);

		continueButton = new JButton("Continue");
		continueButton.setFont(new Font("Roboto", Font.BOLD, 10));
		continueButton.setBounds(850, 500, 100, 100);

		endGamePanel.add(continueButton);

	}

  /**
   * Returns continue button.
   * <p>
   * This method allows GameController to define the
   * listener so state changes are within the correct
   * scope.
   */
	public JButton getContinueButton() {
	  return continueButton;
	}
	
  /**
   * Returns reset button.
   * <p>
   * This method allows GameController to define the
   * listener so state changes are within the correct
   * scope.
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
