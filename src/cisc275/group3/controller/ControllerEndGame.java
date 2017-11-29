package cisc275.group3.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.SceneHQ;
import cisc275.group3.utility.LayerCode;
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
 * ControllerMap.java
 * <p>
 * 
 * @author Jon
 */

public class ControllerEndGame extends ControllerScene implements LinkDynamics {

	private JPanel endGamePanel;
	private JButton resetButton;
	private JButton continueButton;
	private JLabel finalScore;

	public ControllerEndGame(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
		super(w, h, f, cl, sceneType);
	}

	  /**
	   * Creates the scene and adds it to
	   * the main pain. Sets the layers and component list
	   * for the endGame. 
	   */
	@Override
	protected void createScene() {
		endGamePanel = new JPanel() {
		};
		scene = new SceneHQ("EndGame", 0, 0, 1, 1, "", 3);

		// Set Panel Properties
		endGamePanel.setLayout(null);
		endGamePanel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		endGamePanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		endGamePanel.setBackground(Color.CYAN);
		endGamePanel.setOpaque(true);

		addLabelButtons();

		// Add to Layered Pane
		// and Component List
		mainPane.setLayer(endGamePanel, LayerCode.EndGameHide.getCode());
		mainPane.add(endGamePanel, LayerCode.EndGameHide.getCode());
		componentList.put("EndGame", endGamePanel);
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

		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scene.resetScore();
				setDefaultLayers();
				mainPane.setLayer(mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("HQ")))[0],
						LayerCode.MainAll.getCode());
			}
		});
		endGamePanel.add(resetButton);

		continueButton = new JButton("Continue");
		continueButton.setFont(new Font("Roboto", Font.BOLD, 10));
		continueButton.setBounds(850, 500, 100, 100);

		continueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDefaultLayers();
				mainPane.setLayer(mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("HQ")))[0],
						LayerCode.MainAll.getCode());

			}
		});
		endGamePanel.add(continueButton);

	}

	/**
	 * Every button initially resets all the layers to their default locations
	 * before placing the appropriate layer up front. This method appropriates all
	 * the repeated code.
	 * <p>
	 * Each layer is set to its default position, and the mouse is reset to its
	 * default configuration.
	 */
	private void setDefaultLayers() {
		Component mapComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Map")))[0];
		Component hqComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("HQ")))[0];
		Component bayComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Bay")))[0];
		Component beachComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Beach")))[0];
		Component wetlandComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Wetland")))[0];
		Component beachMiniComponent = mainPane
				.getComponentsInLayer(mainPane.getLayer(componentList.get("BeachMini")))[0];
		Component titleComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Title")))[0];
		Component missionComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Mission")))[0];

		// Set Scenes to Default Layer Position
		mainPane.setLayer(mapComponent, LayerCode.Map.getCode());
		mainPane.setLayer(hqComponent, LayerCode.HQ.getCode());
		mainPane.setLayer(bayComponent, LayerCode.Bay.getCode());
		mainPane.setLayer(beachComponent, LayerCode.Beach.getCode());
		mainPane.setLayer(wetlandComponent, LayerCode.Wetland.getCode());
		mainPane.setLayer(beachMiniComponent, LayerCode.BeachMini.getCode());
		mainPane.setLayer(titleComponent, LayerCode.Title.getCode());
		mainPane.setLayer(missionComponent, LayerCode.MissionHide.getCode());
		mainPane.setLayer(endGamePanel, LayerCode.EndGameHide.getCode());

		// Reset Mouse
		Scene.setCurrentTool(null);
		mouseLabel.setIcon(new ImageIcon("img/mouse_empty.png"));
		mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
