package cisc275.group3.controller;

import java.awt.Color;
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
import cisc275.group3.model.scene.SceneBay;
import cisc275.group3.model.scene.SceneTitle;
import cisc275.group3.utility.EnumLayerCode;
import cisc275.group3.utility.EnumLayerCodeTutorial;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;

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

public class ControllerTitle extends ControllerScene implements LinkDynamics, LinkTime {
	private final ImageIcon BG_IMAGE = new ImageIcon("img/backgrounds/titleScreen_bg.png");
	private JPanel titlePanel;
	private JButton startButton;
	private JButton tutorialButton;

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
	protected void createScene() {
		titlePanel = new JPanel(true) {
			@Override
			public void paintComponent(Graphics g) {
				Dimension size = new Dimension(1280, 720);
				g.drawImage(BG_IMAGE.getImage(), 0, 0, size.width, size.height, this);
			}
		};

		// Set Properties
		titlePanel.setLayout(null);
		titlePanel.setPreferredSize(new Dimension(1280, 720));
		titlePanel.setBounds(0, 0, 1280, 720);
		titlePanel.setOpaque(true);

		titlePanel.setName("TitleLayer");
		addTitleButton();
		addTutorialButton();
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
		startButton.setBounds(200, 500, 300, 96);
		startButton.setIcon(new ImageIcon("img/Yellow startbutton.png"));
		startButton.setOpaque(false);
		startButton.setBorderPainted(false);
		startButton.setBorder(null);
		startButton.setMargin(new Insets(0, 0, 0, 0));
		startButton.setContentAreaFilled(false);
		startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		startButton.setSize(330, 96);
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
		tutorialButton.setBounds(800, 500, 300, 96);
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
	 * Sets the components to their correct layers when the start button is pressed
	 */
	public void startShuffle() {
		 Component titleComponent = mainPane
		 .getComponentsInLayer(mainPane.getLayer(componentList.get("Title")))[0];
		 Component hqComponent =
		 mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("HQ")))[0];
		 Component missionComponent = mainPane
		 .getComponentsInLayer(mainPane.getLayer(componentList.get("Mission")))[0];
		
		 mainPane.setLayer(hqComponent, EnumLayerCode.MainAll.getCode());
		 mainPane.setLayer(titleComponent, EnumLayerCode.Title.getCode());
		 mainPane.setLayer(missionComponent, EnumLayerCode.Mission.getCode());
	}
	
	/**
	 * Sets the components to their correct layers when the tutorial button is pressed
	 */
	public void tutShuffle() {
		 Component titleComponent = mainPane
		 .getComponentsInLayer(mainPane.getLayer(componentList.get("Title")))[0];
		 Component hqComponent =
		 mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("HQ")))[0];
		 Component getMissionButton = mainPane
		 .getComponentsInLayer(mainPane.getLayer(componentList.get("GetMissionButton")))[0];
		 Component getMissionLabel = mainPane
		 .getComponentsInLayer(mainPane.getLayer(componentList.get("GetMissionLabel")))[0];
		
		 mainPane.setLayer(hqComponent, EnumLayerCodeTutorial.MainTop.getCode());
		 mainPane.setLayer(titleComponent, EnumLayerCodeTutorial.TitleScreen.getCode());
		 mainPane.setLayer(getMissionButton,
		 EnumLayerCodeTutorial.ButtonGetMission.getCode());
		 mainPane.setLayer(getMissionLabel,
		 EnumLayerCodeTutorial.LabelGetMission.getCode());
	}

	/**
	 * Needed by abstract class
	 */
	@Override
	protected void addML() {
	}

	/**
	 * Needed by abstract class
	 */
	@Override
	public void updateTime() {
	}

	/**
	 * Needed by abstract class
	 */
	@Override
	public void displayTime() {
	}

	/**
	 * Needed by abstract class
	 */
	@Override
	public void update() {
	}
}