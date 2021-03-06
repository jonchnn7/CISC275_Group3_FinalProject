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

import cisc275.group3.scene.Scene;
import cisc275.group3.utility.EnumLayerCode;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.view.GameWindow;

/**
 * The Map controller is responsible for both the "model" and control of the
 * map.
 * <p>
 * This controller is only responsible for taking user input and switching
 * between game scenes. There is no underlying model to manipulate. Therefore,
 * the controller also defines the JPanel and JButtons to display for input.
 * <p>
 * ControllerMap.java
 * <p>
 * 
 * @author Scott
 * @author Ryan
 * @author Jolyne
 * @author Thomas
 */
public class ControllerMap extends ControllerScene {

	// JPanel and button variables
	private JPanel mapPanel;
	private JButton hqButton;
	private JButton bayButton;
	private JButton beachButton;
	private JButton wetlandButton;
	private JButton beachMiniButton;
	private final ImageIcon mapBg;

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
	public ControllerMap(int w, int h, GameWindow f, HashMap<String, Component> cl, EnumSceneType sceneType) {
		super(w, h, f, cl, sceneType);

		mapBg = new ImageIcon("img/newMapHuh.png");
	}

	/**
	 * Creates the scene and adds it to the main pain. Sets the layers and component
	 * list for the map.
	 */
	@Override
	@SuppressWarnings("serial")
	protected void createScene() {
		mapPanel = new JPanel(true) {
			@Override
			public void paintComponent(Graphics g) {
				Dimension size = new Dimension(mapBg.getIconWidth(), mapBg.getIconHeight());
				g.drawImage(mapBg.getImage(), 0, 0, size.width, size.height, this);
			}
		};

		// Set Map Panel Properties
		mapPanel.setLayout(null);
		mapPanel.setPreferredSize(new Dimension(180, 429));
		mapPanel.setBounds(0, SCREEN_HEIGHT - mapPanel.getPreferredSize().height, mapPanel.getPreferredSize().width,
				SCREEN_HEIGHT);
		mapPanel.setBackground(Color.DARK_GRAY);
		mapPanel.setOpaque(true);

		addMapButtons();

		// Add Map to Layered Pane
		// and Component List
		mainPane.setLayer(mapPanel, EnumLayerCode.Map.getCode());
		mainPane.add(mapPanel, EnumLayerCode.Map.getCode());
		componentList.put("Map", mapPanel);
	}

	/**
	 * Adds the various buttons needed to navigate the game (HQ, Bay, Beach,
	 * Wetland). Each button has an action listener that moves the game layers into
	 * the correct position
	 */
	private void addMapButtons() {
		hqButton = new JButton("HQ");
		hqButton.setIcon(new ImageIcon("img/HQTag.png"));
		hqButton.setFont(new Font("Roboto", Font.BOLD, 1));
		hqButton.setBounds(105, 97, 75, 30);
		hqButton.setOpaque(false);
		hqButton.setBorderPainted(false);
		hqButton.setBorder(null);
		hqButton.setMargin(new Insets(0, 0, 0, 0));
		hqButton.setContentAreaFilled(false);

		hqButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component hqComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("HQ")))[0];
				Component missionComponent = mainPane
						.getComponentsInLayer(mainPane.getLayer(componentList.get("Mission")))[0];
				Component factComponent = mainPane
						.getComponentsInLayer(mainPane.getLayer(componentList.get("MissionFact")))[0];
				Component requestComponent = mainPane
						.getComponentsInLayer(mainPane.getLayer(componentList.get("MissionRequest")))[0];

				// Reset all layers and mouse, then
				// move hq and mission layer forward
				setDefaultLayers();
				mainPane.setLayer(hqComponent, EnumLayerCode.MainAll.getCode());
				mainPane.setLayer(missionComponent, EnumLayerCode.Mission.getCode());
				mainPane.setLayer(factComponent, EnumLayerCode.MissionFact.getCode());
				mainPane.setLayer(requestComponent, EnumLayerCode.MissionRequest.getCode());

				if (Scene.getCurrentMission().getObjectNum() == -1) {
					Scene.getCurrentMission().setObjectNum(-5);
				}
			}
		});
		mapPanel.add(hqButton);

		bayButton = new JButton("Bay");
		bayButton.setIcon(new ImageIcon("img/BayTag.png"));
		bayButton.setFont(new Font("Roboto", Font.BOLD, 1));
		bayButton.setBounds(105, 137, 75, 30);
		bayButton.setOpaque(false);
		bayButton.setBorderPainted(false);
		bayButton.setBorder(null);
		bayButton.setMargin(new Insets(0, 0, 0, 0));
		bayButton.setContentAreaFilled(false);

		bayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component bayComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Bay")))[0];

				// Reset all layers and mouse,
				// then move bay layer forward
				setDefaultLayers();
				mainPane.setLayer(bayComponent, EnumLayerCode.MainAll.getCode());

				if (Scene.getCurrentMission().getObjectNum() == -5) {
					Scene.getCurrentMission().setObjectNum(-1);
				}
			}
		});
		mapPanel.add(bayButton);

		beachButton = new JButton("Beach");
		beachButton.setIcon(new ImageIcon("img/BeachTag.png"));
		beachButton.setFont(new Font("Roboto", Font.BOLD, 1));
		beachButton.setBounds(105, 177, 75, 30);
		beachButton.setOpaque(false);
		beachButton.setBorderPainted(false);
		beachButton.setBorder(null);
		beachButton.setMargin(new Insets(0, 0, 0, 0));
		beachButton.setContentAreaFilled(false);

		beachButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component beachComponent = mainPane
						.getComponentsInLayer(mainPane.getLayer(componentList.get("Beach")))[0];

				// Reset all layers and mouse, then
				// move beach layer forward
				setDefaultLayers();
				mainPane.setLayer(beachComponent, EnumLayerCode.MainAll.getCode());

				if (Scene.getCurrentMission().getObjectNum() == -5) {
					Scene.getCurrentMission().setObjectNum(-1);
				}
			}
		});
		mapPanel.add(beachButton);

		wetlandButton = new JButton("Wetland");
		wetlandButton.setIcon(new ImageIcon("img/WetlandTag.png"));
		wetlandButton.setFont(new Font("Roboto", Font.BOLD, 1));
		wetlandButton.setBounds(105, 217, 75, 30);
		wetlandButton.setOpaque(false);
		wetlandButton.setBorderPainted(false);
		wetlandButton.setBorder(null);
		wetlandButton.setMargin(new Insets(0, 0, 0, 0));
		wetlandButton.setContentAreaFilled(false);

		wetlandButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component wetlandComponent = mainPane
						.getComponentsInLayer(mainPane.getLayer(componentList.get("Wetland")))[0];

				// Reset all layers and mouse, then
				// move wetland layer forward
				setDefaultLayers();
				mainPane.setLayer(wetlandComponent, EnumLayerCode.MainAll.getCode());

				if (Scene.getCurrentMission().getObjectNum() == -5) {
					Scene.getCurrentMission().setObjectNum(-1);
				}
			}
		});
		mapPanel.add(wetlandButton);

		beachMiniButton = new JButton("BEACH MINIGAME");
		beachMiniButton.setFont(new Font("Roboto", Font.BOLD, 14));
		beachMiniButton.setBounds(20, 400, 160, 30);

		beachMiniButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component beachMiniComponent = mainPane
						.getComponentsInLayer(mainPane.getLayer(componentList.get("BeachMini")))[0];

				// Reset all layers and mouse, then
				// move beach mini layer forward
				setDefaultLayers();
				mainPane.setLayer(beachMiniComponent, EnumLayerCode.MainMapToolsTime.getCode());

				if (Scene.getCurrentMission().getObjectNum() == -5) {
					Scene.getCurrentMission().setObjectNum(-1);
				}
			}
		});
		//Mini game we left out of map
		//mapPanel.add(beachMiniButton);
	}

	/**
	 * Every map button initially resets all the layers to their default locations
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
		//Component titleComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Title")))[0];
		Component missionComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Mission")))[0];
		Component factComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("MissionFact")))[0];
		Component requestComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("MissionRequest")))[0];

		// Set Scenes to Default Layer Position
		mainPane.setLayer(mapComponent, EnumLayerCode.Map.getCode());
		mainPane.setLayer(hqComponent, EnumLayerCode.HQ.getCode());
		mainPane.setLayer(bayComponent, EnumLayerCode.Bay.getCode());
		mainPane.setLayer(beachComponent, EnumLayerCode.Beach.getCode());
		mainPane.setLayer(wetlandComponent, EnumLayerCode.Wetland.getCode());
		mainPane.setLayer(beachMiniComponent, EnumLayerCode.BeachMini.getCode());
		//mainPane.setLayer(titleComponent, EnumLayerCode.Title.getCode());
		mainPane.setLayer(missionComponent, EnumLayerCode.MissionHide.getCode());
		mainPane.setLayer(factComponent, EnumLayerCode.MissionFactHide.getCode());
		mainPane.setLayer(requestComponent, EnumLayerCode.MissionRequestHide.getCode());

		// Reset Mouse
		Scene.setCurrentTool(null);
		mouseLabel.setIcon(new ImageIcon("img/mouse_empty.png"));
		mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
