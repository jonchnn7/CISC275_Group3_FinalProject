package cisc275.group3.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.ImageIcon;

import cisc275.group3.utility.EnumLayerCode;
import cisc275.group3.utility.EnumLayerCodeTutorial;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewOverlayButton;
import cisc275.group3.view.ViewOverlayLabel;

/**
 * Responsible for creating the interface overlay buttons/labels, and adding
 * them to the main JLayeredPane (from GameWindow.java). After the button has
 * been added, the associated action listener and action is added.
 * <p>
 * 
 * @author Scott
 * @author Jolyne
 * @author Thomas
 * @author Ryan
 */
public class ControllerOverlay extends ControllerScene {

	// Varbiables to set imageicons,size, and overlay button for the following
	// Map
	private ImageIcon mapButtonImage;
	private ImageIcon mapButtonRolloverImage;
	private int mapButtonWidth;
	private int mapButtonHeight;
	private ViewOverlayButton mapButtonPanel;

	// Tools
	private ImageIcon toolsButtonImage;
	private ImageIcon toolsButtonRolloverImage;
	private int toolsButtonWidth;
	private int toolsButtonHeight;
	private ViewOverlayButton toolsButtonPanel;

	// Time
	private ImageIcon timeLabelBg;
	private ImageIcon timeLabelImage;
	private int timeLabelWidth;
	private int timeLabelHeight;
	private String timeLabelString;
	private ViewOverlayLabel timeLabelPanel;

	// Score
	private ImageIcon scoreLabelBg;
	private ImageIcon scoreLabelImage;
	private int scoreLabelWidth;
	private int scoreLabelHeight;
	private String scoreLabelString;
	private ViewOverlayLabel scoreLabelPanel;

	// MissionLabel
	private ImageIcon missionLabelBg;
	private ImageIcon missionLabelImage;
	private int missionLabelWidth;
	private int missionLabelHeight;
	private String missionLabelString;
	private ViewOverlayLabel missionLabelPanel;

	// Inventory
	private ImageIcon inventoryButtonImage;
	private ImageIcon inventoryButtonRolloverImage;
	private int inventoryButtonWidth;
	private int inventoryButtonHeight;
	private ViewOverlayButton inventoryButtonPanel;

	/**
	 * Default scene controller parameters. After they are passed to super(), the
	 * menu button/label parameters are set.
	 * <p>
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
	public ControllerOverlay(int w, int h, GameWindow f, HashMap<String, Component> cl, EnumSceneType sceneType) {
		super(w, h, f, cl, sceneType);

		// Map Button Parameters
		mapButtonImage = new ImageIcon("img/map_icon.png");
		mapButtonRolloverImage = new ImageIcon("img/map_icon_invert.png");
		mapButtonWidth = 75;
		mapButtonHeight = 75;

		// Tool Button Parameters
		toolsButtonImage = new ImageIcon("img/toolbox_menu_2.png");
		toolsButtonWidth = 107;
		toolsButtonHeight = 70;

		// Score Label Parameters
		scoreLabelBg = new ImageIcon("img/time_bg.png");
		scoreLabelImage = new ImageIcon("img/coins_icon.png");
		scoreLabelWidth = 170;
		scoreLabelHeight = 70;
		scoreLabelString = "0";

		// Time Label Parameters
		timeLabelBg = new ImageIcon("img/time_bg.png");
		timeLabelImage = new ImageIcon("img/clock_icon.png");
		timeLabelWidth = 150;
		timeLabelHeight = 85;
		timeLabelString = "0";

		// Mission Label Parameters
		missionLabelBg = new ImageIcon("img/time_bg.png");
		missionLabelWidth = 175;
		missionLabelHeight = 85;
		missionLabelString = "";

		// Inventory Button Parameters
		inventoryButtonImage = new ImageIcon("img/inventory.png");
		inventoryButtonRolloverImage = new ImageIcon("img/inventory.png");
		inventoryButtonWidth = 100;
		inventoryButtonHeight = 130;

		createScene();
	}

	/**
	 * Call private functions to create and add individual interface buttons.
	 * <p>
	 * Overridden from ControllerScene.java
	 */
	@Override
	protected void createScene() {
		// Create Buttons
		createMapButton();
		createToolsButton();
		createInventoryButton();

		// Create Labels
		createScoreLabel();
		createTimeLabel();
		createMissionLabel();
	}

	/**
	 * Creates the map JPanel/JButton combination and places it inside the game
	 * window at its defined layer. An action is then created to toggle moving the
	 * map (ControllerMap.java) between the overlay layer and its hidden storage
	 * layer.
	 */
	private void createMapButton() {
		mapButtonPanel = new ViewOverlayButton(mapButtonImage, mapButtonRolloverImage, mapButtonWidth, mapButtonHeight);
		mapButtonPanel.setBounds(180, SCREEN_HEIGHT - mapButtonHeight, mapButtonWidth, mapButtonHeight);
		mapButtonPanel.setName("MapButton");

		if (sceneType == EnumSceneType.TUTORIAL) {
			mainPane.setLayer(mapButtonPanel, EnumLayerCodeTutorial.ButtonMapHidden.getCode());
			mainPane.add(mapButtonPanel, EnumLayerCodeTutorial.ButtonMapHidden.getCode());
		} else {
			mainPane.setLayer(mapButtonPanel, EnumLayerCode.MapButton.getCode());
			mainPane.add(mapButtonPanel, EnumLayerCode.MapButton.getCode());
		}
		componentList.put("MapButton", mapButtonPanel);

		mapButtonPanel.getOverButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sceneType == EnumSceneType.TUTORIAL) {
					mainPane.setLayer(componentList.get("HQ"), -100);
					mainPane.setLayer(componentList.get("Tutorial"), EnumLayerCodeTutorial.MainTop.getCode());
					mainPane.setLayer(componentList.get("MapArrow"), EnumLayerCodeTutorial.LabelMapArrowHidden.getCode());
					mainPane.setLayer(componentList.get("MapSpeech"), EnumLayerCodeTutorial.LabelMapSpeechHidden.getCode());

				} else {
					Component mapComponent = mainPane
							.getComponentsInLayer(mainPane.getLayer(componentList.get("Map")))[0];

					if (mainPane.getLayer(mapComponent) == EnumLayerCode.Map.getCode()) {
						mainPane.setLayer(mapComponent, EnumLayerCode.MapOverlay.getCode());
					} else {
						mainPane.setLayer(mapComponent, EnumLayerCode.Map.getCode());
					}
				}
			}
		});
	}

	/**
	 * Creates the tools JPanel/JButton combination and places it inside the game
	 * window at its defined layer. An action is then created to toggle moving the
	 * toolbox (ControllerTools.java) between the overlay layer and its hidden
	 * storage layer.
	 */
	private void createToolsButton() {
		toolsButtonPanel = new ViewOverlayButton(toolsButtonImage, toolsButtonWidth, toolsButtonHeight);
		toolsButtonPanel.setBounds(SCREEN_WIDTH - toolsButtonWidth - 10, 0, toolsButtonWidth, toolsButtonHeight);
		toolsButtonPanel.setName("ToolsButton");

		if (sceneType == EnumSceneType.TUTORIAL) {
			mainPane.setLayer(toolsButtonPanel, EnumLayerCodeTutorial.ButtonToolsHidden.getCode());
			mainPane.add(toolsButtonPanel, EnumLayerCodeTutorial.ButtonToolsHidden.getCode());
		} else {
			mainPane.setLayer(toolsButtonPanel, EnumLayerCode.ToolsButton.getCode());
			mainPane.add(toolsButtonPanel, EnumLayerCode.ToolsButton.getCode());
		}

		componentList.put("ToolsButton", toolsButtonPanel);

		toolsButtonPanel.getOverButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sceneType == EnumSceneType.TUTORIAL) {
					Component toolsComponent = mainPane
							.getComponentsInLayer(mainPane.getLayer(componentList.get("Tools")))[0];

					if (mainPane.getLayer(toolsComponent) == EnumLayerCodeTutorial.ToolsPanel.getCode()) {
						mainPane.setLayer(toolsComponent, EnumLayerCodeTutorial.ToolsPanelHidden.getCode());
					} else {
						mainPane.setLayer(toolsComponent, EnumLayerCodeTutorial.ToolsPanel.getCode());
					}
				} else {
					Component toolsComponent = mainPane
							.getComponentsInLayer(mainPane.getLayer(componentList.get("Tools")))[0];

					if (mainPane.getLayer(toolsComponent) == EnumLayerCode.Tools.getCode()) {
						mainPane.setLayer(toolsComponent, EnumLayerCode.ToolsOverlay.getCode());
					} else {
						mainPane.setLayer(toolsComponent, EnumLayerCode.Tools.getCode());
					}
				}
			}
		});
	}

	/**
	 * Creates the inventory JPanel/JButton combination and places it inside the
	 * game window at its defined layer. An action is then created to toggle moving
	 * the inventory (SceneInventory.java) between the overlay layer and its hidden
	 * storage layer.
	 */
	private void createInventoryButton() {
		inventoryButtonPanel = new ViewOverlayButton(inventoryButtonImage, inventoryButtonRolloverImage,
				inventoryButtonWidth, inventoryButtonHeight);
		inventoryButtonPanel.setBounds(0, 0, inventoryButtonWidth, inventoryButtonHeight);
		inventoryButtonPanel.setName("InventoryButton");

		if (sceneType == EnumSceneType.TUTORIAL) {
			mainPane.setLayer(inventoryButtonPanel, EnumLayerCodeTutorial.ButtonInventoryHidden.getCode());
			mainPane.add(inventoryButtonPanel, EnumLayerCodeTutorial.ButtonInventoryHidden.getCode());
		} else {
			mainPane.setLayer(inventoryButtonPanel, EnumLayerCode.InventoryButton.getCode());
			mainPane.add(inventoryButtonPanel, EnumLayerCode.InventoryButton.getCode());
		}
		componentList.put("InventoryButton", inventoryButtonPanel);

		inventoryButtonPanel.getOverButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component inventoryComponent = mainPane
						.getComponentsInLayer(mainPane.getLayer(componentList.get("Inventory")))[0];

				if (mainPane.getLayer(inventoryComponent) == EnumLayerCode.Inventory.getCode()) {
					mainPane.setLayer(inventoryComponent, EnumLayerCode.InventoryOverlay.getCode());
				} else {
					mainPane.setLayer(inventoryComponent, EnumLayerCode.Inventory.getCode());
				}
			}
		});

	}

	/**
	 * Creates the score JPanel/JLabel combination and places it inside the game
	 * window at its defined layer.
	 */
	private void createScoreLabel() {
		scoreLabelPanel = new ViewOverlayLabel(scoreLabelImage, scoreLabelBg, scoreLabelWidth, scoreLabelHeight,
				scoreLabelString);
		scoreLabelPanel.setBounds(SCREEN_WIDTH - 2 * scoreLabelWidth, SCREEN_HEIGHT - scoreLabelHeight, scoreLabelWidth,
				scoreLabelHeight);
		scoreLabelPanel.setName("ScoreLabel");

		if (sceneType == EnumSceneType.TUTORIAL) {
      mainPane.setLayer(scoreLabelPanel, EnumLayerCodeTutorial.LabelScoreHidden.getCode());
      mainPane.add(scoreLabelPanel, EnumLayerCodeTutorial.LabelScoreHidden.getCode());
		} else {
  		mainPane.setLayer(scoreLabelPanel, EnumLayerCode.ScoreLabel.getCode());
  		mainPane.add(scoreLabelPanel, EnumLayerCode.ScoreLabel.getCode());
		}
		componentList.put("ScoreLabel", scoreLabelPanel);
	}

	/**
	 * Creates the time JPanel/JLabel combination and places it inside the game
	 * window at its defined layer.
	 */
	private void createTimeLabel() {
		timeLabelPanel = new ViewOverlayLabel(timeLabelImage, timeLabelBg, timeLabelWidth, timeLabelHeight,
				timeLabelString);
		timeLabelPanel.setBounds((SCREEN_WIDTH - timeLabelWidth) / 2, SCREEN_HEIGHT - timeLabelHeight, timeLabelWidth,
				timeLabelHeight);
		timeLabelPanel.setName("TimeLabel");

		if (sceneType == EnumSceneType.TUTORIAL) {
		  mainPane.setLayer(timeLabelPanel, EnumLayerCodeTutorial.LabelTimeHidden.getCode());
      mainPane.add(timeLabelPanel, EnumLayerCodeTutorial.LabelTimeHidden.getCode());
		} else {
  		mainPane.setLayer(timeLabelPanel, EnumLayerCode.TimeLabel.getCode());
  		mainPane.add(timeLabelPanel, EnumLayerCode.TimeLabel.getCode());
		}
  		
		componentList.put("TimeLabel", timeLabelPanel);
	}

	/**
	 * Creates the mission JPanel/JLabel combination and places it inside the game
	 * window at its defined layer.
	 */
	private void createMissionLabel() {
		missionLabelPanel = new ViewOverlayLabel(missionLabelImage, missionLabelBg, missionLabelWidth,
				missionLabelHeight, missionLabelString);
		missionLabelPanel.setBounds((SCREEN_WIDTH - missionLabelWidth) / 2, 0, missionLabelWidth, missionLabelHeight);
		missionLabelPanel.setName("MissionLabel");

		// missionLabelPanel.getLabel().setFont(new Font("Roboto", Font.BOLD, 16));

		mainPane.setLayer(missionLabelPanel, EnumLayerCode.MissionLabel.getCode());
		mainPane.add(missionLabelPanel, EnumLayerCode.MissionLabel.getCode());

		componentList.put("MissionLabel", missionLabelPanel);
	}
}
