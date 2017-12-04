package cisc275.group3.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.SceneHQ;
import cisc275.group3.utility.EstuaryPrompts;
import cisc275.group3.utility.EnumLayerCode;
import cisc275.group3.utility.EnumLayerCodeTutorial;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;
import cisc275.group3.view.ViewOverlayButton;
import cisc275.group3.view.ViewOverlayLabel;

/**
 * Contains the controller actions and logic for SceneHQ.java.
 * <p>
 * Extends the abstract ConstrollerScene class and adds dynamics and timing
 * attributes. Those interfaces require the controller to pass an update call to
 * the model on every timer tick, and to update the time every second.
 * <p>
 * See cisc275.group3.controller.ControllerScene.java
 * <p>
 * ControllerHQ.java
 * <p>
 * 
 * @author Scott
 * @author Jon
 * @author Jolyne
 * @author Thomas
 */
public class ControllerHQ extends ControllerScene implements LinkDynamics, LinkTime {
	private final String BG_IMAGE = "img/backgrounds/HQ_bg.jpg";
	private ViewOverlayLabel statusLabel;
	private ViewOverlayLabel missionLabel;
	
	EstuaryPrompts prompts = new EstuaryPrompts();

	// Tutorial Layer Variables
	ViewOverlayButton tutorialButton;
	ViewOverlayLabel tutorialLabel;

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
	public ControllerHQ(int w, int h, GameWindow f, HashMap<String, Component> cl, EnumSceneType sceneType) {
		super(w, h, f, cl, sceneType);
	}

	/**
	 * Creates the scene and adds it to the main pain. Sets the layers and component
	 * list for the HQ.
	 */
	@Override
	protected void createScene() {
		scene = new SceneHQ("HQ", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, BG_IMAGE, sceneType);
		viewGame = new ViewGame(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), scene.getManifest().getBG());
		

		viewGame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		viewGame.setName("HQLayer");

		// Set Cursor
		viewGame.setCursor(new Cursor(Cursor.HAND_CURSOR));

		mainPane.setLayer(viewGame, EnumLayerCode.HQ.getCode());
		mainPane.add(viewGame, EnumLayerCode.HQ.getCode());

		componentList.put("HQ", viewGame);
	
		statusLabel = new ViewOverlayLabel(new ImageIcon(), new ImageIcon(), 600, 226, " ");
		statusLabel.setBounds((SCREEN_WIDTH / 2)+100, 0 , 600, 226);

		statusLabel.setName("MissionFact");
		
		mainPane.setLayer(statusLabel, EnumLayerCode.MissionFact.getCode());
		mainPane.add(statusLabel, EnumLayerCode.MissionFact.getCode());

		componentList.put("MissionFact", statusLabel);
		
		missionLabel = new ViewOverlayLabel(new ImageIcon(), new ImageIcon(), 600, 226, " ");
		missionLabel.setBounds(100, SCREEN_HEIGHT/8-100 , 600, 226);

		missionLabel.setName("MissionRequest");
		
		mainPane.setLayer(missionLabel, EnumLayerCode.MissionRequest.getCode());
		mainPane.add(missionLabel, EnumLayerCode.MissionRequest.getCode());
		
		componentList.put("MissionRequest", missionLabel);

		if (sceneType == EnumSceneType.TUTORIAL) {
		  mainPane.setLayer(viewGame, EnumLayerCodeTutorial.MainTop.getCode());
			tutorialStepOne();
		} else {
		  mainPane.setLayer(viewGame, EnumLayerCode.MainAll.getCode());
		}
	}

	/**
	 * Connects the HQ model and HQ view. So long as the HQ scene is the active
	 * pane, update the model and then pass the updated scene objects to the view.
	 * <p>
	 * Overridden from interface LinkDynamics.java
	 */
	@Override
	public void update() {
		if (mainPane.getLayer(componentList.get("HQ")) == EnumLayerCode.MainAll.getCode()) {
			// Update Model
			scene.update();
			viewGame.updatePanel(scene.getSceneItems());
			statusLabel.updateBG(new ImageIcon(Scene.getCurrentFact()));
			
			if ((Scene.getCurrentMission().getTargetObject() != null)
					&& !(Scene.getCurrentMission().isDoneMission())) {
				missionLabel.updateBG(new ImageIcon(prompts.getPrompt(Scene.getCurrentMission())));
			} else {//if (Scene.getCurrentMission().getObjectNum() == -5) {
				missionLabel.updateBG(new ImageIcon(""));
			}
		}
	}

	/**
	 * Updates the linked time through the SceneHQ. If there is an active mission,
	 * the time is incremented and if the Mission is turned in, the time is reset,
	 * and mission is scored appropriately
	 */
	@Override
	public void updateTime() {
		if ((scene.getTime() < 1) && !(Scene.getCurrentMission().isDoneMission())
				&& !(Scene.getCurrentMission().getTargetObject() == null)) {
			((SceneHQ) scene).missionScoreFail();
			scene.resetTime();
			Scene.getCurrentMission().setObjectNum(-5);
			Scene.getCurrentMission().setDoneMission(true);
			Scene.getCurrentMission().setTargetObject(null);
			displayMission();
			ControllerInventory.removeItem(Scene.getCurrentMission().getObjectName());
			((ViewOverlayLabel) componentList.get("MissionLabel")).updateIcon(null);
		}

		if ((!Scene.getCurrentMission().isDoneMission()) && !(Scene.getCurrentMission().getTargetObject() == null)) {
			((SceneHQ) scene).updateTime();
		} else {
			if (((SceneHQ) scene).getTime() != 0) {
				scene.missionScore();
				scene.resetTime();
			}
		}
		if (mainPane.getLayer(componentList.get("HQ")) == EnumLayerCode.MainAll.getCode()) {
			displayTime();
		}
		displayScore();
	}

	/**
	 * Displays the model time in the shared time label.
	 * <p>
	 * Overridden from interface LinkTime.java
	 */
	@Override
	public void displayTime() {
		String sceneTime;

		sceneTime = Integer.toString(scene.getTime());
		((ViewOverlayLabel) componentList.get("TimeLabel")).updateLabel(sceneTime);
	}

	/**
	 * Adds various components of the first step in the tutorial (The mission). This
	 * includes: Arrow to point to get mission, label, sets next button click to go
	 * to step two
	 */
	private void tutorialStepOne() {
		// Get Mission Label
		ImageIcon getMissionLabelIcon = new ImageIcon("img/tutorialPics/AskForAMission.png");
		tutorialLabel = new ViewOverlayLabel(getMissionLabelIcon, 800, 300, "");
		tutorialLabel.setBounds(SCREEN_WIDTH*3/8, SCREEN_HEIGHT*3/14, 800, 300);
		tutorialLabel.setName("GetMissionLabel");
		tutorialLabel.getLabel().setFont(new Font("Roboto", Font.BOLD, 48));

		mainPane.setLayer(tutorialLabel, EnumLayerCodeTutorial.LabelGetMission.getCode());
		mainPane.add(tutorialLabel, EnumLayerCodeTutorial.LabelGetMission.getCode());
		componentList.put("GetMissionLabel", tutorialLabel);

		// Get Mission Button
		ImageIcon getMissionButtonIcon = new ImageIcon("img/tutorial_getMission_button.png");
		tutorialButton = new ViewOverlayButton(getMissionButtonIcon, 400, 600);
		tutorialButton.setBounds(SCREEN_WIDTH/4, SCREEN_HEIGHT/5, 400, 600);
		tutorialButton.setName("GetMissionButton");

		mainPane.setLayer(tutorialButton, EnumLayerCodeTutorial.ButtonGetMission.getCode());
		mainPane.add(tutorialButton, EnumLayerCodeTutorial.ButtonGetMission.getCode());
		componentList.put("GetMissionButton", tutorialButton);

		tutorialButton.getOverButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPane.setLayer(componentList.get("GetMissionButton"),
						EnumLayerCodeTutorial.ButtonGetMissionHidden.getCode());
				mainPane.setLayer(componentList.get("GetMissionLabel"),
						EnumLayerCodeTutorial.LabelGetMissionHidden.getCode());

				tutorialStepTwo();

				mainPane.setLayer(componentList.get("ObjectiveLabel"), EnumLayerCodeTutorial.LabelObjective.getCode());
				mainPane.setLayer(componentList.get("ObjectiveArrow"), EnumLayerCodeTutorial.LabelObjectiveArrow.getCode());
				mainPane.setLayer(componentList.get("ObjectiveLabelSpeech"),
						EnumLayerCodeTutorial.LabelObjectiveSpeech.getCode());
				mainPane.setLayer(componentList.get("ContinueButton"), EnumLayerCodeTutorial.ButtonContinue.getCode());
			}
		});
	}

	/**
	 * Adds various components of the second step in the tutorial(The objectives).
	 * This includes: Arrow to point to the mission, speech label, mission text,
	 * sets next button click to go to step three
	 */
	private void tutorialStepTwo() {
		// Objective Label
		ImageIcon labelIcon = new ImageIcon("img/tutorial_mission_objectives.png");
		tutorialLabel = new ViewOverlayLabel(labelIcon, 200, 85, "");
		tutorialLabel.setBounds(SCREEN_WIDTH / 2 - 100, -5, 200, 85);
		tutorialLabel.setName("ObjectiveLabel");
		tutorialLabel.getLabel().setFont(new Font("Roboto", Font.BOLD, 48));

		mainPane.setLayer(tutorialLabel, EnumLayerCodeTutorial.LabelObjectiveHidden.getCode());
		mainPane.add(tutorialLabel, EnumLayerCodeTutorial.LabelObjectiveHidden.getCode());
		componentList.put("ObjectiveLabel", tutorialLabel);

		// Objective Arrow Label
		labelIcon = new ImageIcon("img/tutorial_arrow_upLeft.png");
		tutorialLabel = new ViewOverlayLabel(null, labelIcon, 150, 120, "");
		tutorialLabel.setBounds(SCREEN_WIDTH / 2 + 110, -5, 150, 120);
		tutorialLabel.setName("ObjectiveArrow");

		mainPane.setLayer(tutorialLabel, EnumLayerCodeTutorial.LabelObjectiveArrowHidden.getCode());
		mainPane.add(tutorialLabel, EnumLayerCodeTutorial.LabelObjectiveArrowHidden.getCode());
		componentList.put("ObjectiveArrow", tutorialLabel);

		// Objective Speech Label
		tutorialLabel = new ViewOverlayLabel(new ImageIcon(), new ImageIcon("img/tutorialPics/speech_bubble_right_tutorial_mission.png"), 600, 226, " ");
		tutorialLabel.setBounds(SCREEN_WIDTH*3/8, SCREEN_HEIGHT*1/14, 600, 226);
		tutorialLabel.setName("ObjectiveSpeech");		
		labelIcon = new ImageIcon("img/tutorialPics/speech_bubble_right_tutorial.png");

		mainPane.setLayer(tutorialLabel, EnumLayerCodeTutorial.LabelObjectiveSpeechHidden.getCode());
		mainPane.add(tutorialLabel, EnumLayerCodeTutorial.LabelObjectiveSpeechHidden.getCode());
		componentList.put("ObjectiveLabelSpeech", tutorialLabel);

		// Objective Continue Button
		ImageIcon tutorialButtonIcon = new ImageIcon("img/tutorial_continue_button.png");
		tutorialButton = new ViewOverlayButton(tutorialButtonIcon, 100, 100);
		tutorialButton.setBounds(SCREEN_WIDTH - 150, SCREEN_HEIGHT - 200, 100, 100);
		tutorialButton.setName("Continue");

		mainPane.setLayer(tutorialButton, EnumLayerCodeTutorial.ButtonContinueHidden.getCode());
		mainPane.add(tutorialButton, EnumLayerCodeTutorial.ButtonContinueHidden.getCode());
		componentList.put("ContinueButton", tutorialButton);

		tutorialButton.getOverButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPane.setLayer(componentList.get("ObjectiveLabelSpeech"),
						EnumLayerCodeTutorial.LabelObjectiveSpeechHidden.getCode());
				mainPane.setLayer(componentList.get("ObjectiveArrow"),
						EnumLayerCodeTutorial.LabelObjectiveArrowHidden.getCode());

				tutorialStepThree();

				mainPane.setLayer(componentList.get("InventoryButton"), EnumLayerCodeTutorial.ButtonInventory.getCode());
				mainPane.setLayer(componentList.get("InventoryArrow"), EnumLayerCodeTutorial.LabelInventoryArrow.getCode());
				mainPane.setLayer(componentList.get("InventorySpeech"),
						EnumLayerCodeTutorial.LabelInventorySpeech.getCode());
			}
		});
	}

	/**
	 * Adds various components of the third step in the tutorial(The inventory).
	 * This includes: Arrow to point to the inventory, inventory interface, speech
	 * text, sets next button click to go to step four
	 */
	private void tutorialStepThree() {
		// Objective Arrow Label
		ImageIcon labelIcon = new ImageIcon("img/tutorial_arrow_rightUp.png");
		tutorialLabel = new ViewOverlayLabel(null, labelIcon, 150, 120, "");
		tutorialLabel.setBounds(20, 120, 150, 120);
		tutorialLabel.setName("InventoryArrow");

		mainPane.setLayer(tutorialLabel, EnumLayerCodeTutorial.LabelInventoryArrowHidden.getCode());
		mainPane.add(tutorialLabel, EnumLayerCodeTutorial.LabelInventoryArrowHidden.getCode());
		componentList.put("InventoryArrow", tutorialLabel);

		// Objective Speech Label
		tutorialLabel = new ViewOverlayLabel(new ImageIcon(), new ImageIcon("img/tutorialPics/speech_bubble_right_tutorial_inventory.png"), 600, 226, " ");
		tutorialLabel.setBounds(SCREEN_WIDTH*3/8, SCREEN_HEIGHT*1/14, 600, 226);
		tutorialLabel.setName("InventorySpeechSpeech");		

		mainPane.setLayer(tutorialLabel, EnumLayerCodeTutorial.LabelInventorySpeechHidden.getCode());
		mainPane.add(tutorialLabel, EnumLayerCodeTutorial.LabelInventorySpeechHidden.getCode());
		componentList.put("InventorySpeech", tutorialLabel);

		// Continue Button
		tutorialButton.getOverButton().removeActionListener(tutorialButton.getOverButton().getActionListeners()[0]);
		tutorialButton.getOverButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPane.setLayer(componentList.get("InventorySpeech"),
						EnumLayerCodeTutorial.LabelInventorySpeechHidden.getCode());
				mainPane.setLayer(componentList.get("InventoryArrow"),
						EnumLayerCodeTutorial.LabelInventoryArrowHidden.getCode());

				tutorialStepFour();

				mainPane.setLayer(componentList.get("ToolsSpeech"), EnumLayerCodeTutorial.LabelToolsSpeech.getCode());
				mainPane.setLayer(componentList.get("ToolsArrow"), EnumLayerCodeTutorial.LabelToolsArrow.getCode());
				mainPane.setLayer(componentList.get("ToolsButton"), EnumLayerCodeTutorial.ButtonTools.getCode());
			}
		});
	}

	/**
	 * Adds various components of the second step in the tutorial(The tools). This
	 * includes: Arrow to point to the tools, tool interface, speech text, sets next
	 * button click to add the map button
	 */
	private void tutorialStepFour() {
		// Objective Arrow Label
				ImageIcon labelIcon = new ImageIcon("img/tutorial_arrow_leftUp.png");
				tutorialLabel = new ViewOverlayLabel(null, labelIcon, 150, 120, "");
				tutorialLabel.setBounds(SCREEN_WIDTH - 220, 80, 150, 120);
				tutorialLabel.setName("ToolsArrow");

				mainPane.setLayer(tutorialLabel, EnumLayerCodeTutorial.LabelToolsArrowHidden.getCode());
				mainPane.add(tutorialLabel, EnumLayerCodeTutorial.LabelToolsArrowHidden.getCode());
				componentList.put("ToolsArrow", tutorialLabel);

				// Objective Speech Label
				tutorialLabel = new ViewOverlayLabel(new ImageIcon(), new ImageIcon("img/tutorialPics/speech_bubble_right_tutorial_tools.png"), 600, 226, " ");
				tutorialLabel.setBounds(SCREEN_WIDTH*3/8, SCREEN_HEIGHT*1/14, 600, 226);
				tutorialLabel.setName("ToolsSpeech");		

				mainPane.setLayer(tutorialLabel, EnumLayerCodeTutorial.LabelToolsSpeechHidden.getCode());
				mainPane.add(tutorialLabel, EnumLayerCodeTutorial.LabelToolsSpeechHidden.getCode());
				componentList.put("ToolsSpeech", tutorialLabel);

		// Continue Button
		tutorialButton.getOverButton().removeActionListener(tutorialButton.getOverButton().getActionListeners()[0]);
		tutorialButton.getOverButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPane.setLayer(componentList.get("ToolsSpeech"),
						EnumLayerCodeTutorial.LabelToolsSpeechHidden.getCode());
				mainPane.setLayer(componentList.get("ToolsArrow"),
						EnumLayerCodeTutorial.LabelToolsArrowHidden.getCode());

				tutorialStepFive();

				mainPane.setLayer(componentList.get("ScoreArrow"), EnumLayerCodeTutorial.LabelScoreArrow.getCode());
				mainPane.setLayer(componentList.get("TimeArrow"), EnumLayerCodeTutorial.LabelTimeArrow.getCode());
				mainPane.setLayer(componentList.get("ScoreTimeSpeech"), EnumLayerCodeTutorial.LabelScoreTimeSpeech.getCode());
				mainPane.setLayer(componentList.get("ToolsButton"), EnumLayerCodeTutorial.LabelScore.getCode());
				mainPane.setLayer(componentList.get("ScoreLabel"), EnumLayerCodeTutorial.LabelScore.getCode());
        mainPane.setLayer(componentList.get("TimeLabel"), EnumLayerCodeTutorial.LabelTime.getCode());
			}
		});
	}
	
	//Map Button
	private void tutorialStepFive() {
		// Objective Arrow Label
		ImageIcon labelIcon = new ImageIcon("img/tutorial_arrow_leftUp.png");
		tutorialLabel = new ViewOverlayLabel(null, labelIcon, 150, 120, "");
		tutorialLabel.setBounds(SCREEN_WIDTH - 220, 300, 150, 120);
		tutorialLabel.setName("TimeArrow");

		mainPane.setLayer(tutorialLabel, EnumLayerCodeTutorial.LabelTimeArrowHidden.getCode());
		mainPane.add(tutorialLabel, EnumLayerCodeTutorial.LabelTimeArrowHidden.getCode());
		componentList.put("TimeArrow", tutorialLabel);
		
		ImageIcon labelIcon1 = new ImageIcon("img/tutorial_arrow_leftUp.png");
		tutorialLabel = new ViewOverlayLabel(null, labelIcon1, 150, 120, "");
		tutorialLabel.setBounds(SCREEN_WIDTH - 220, 400, 150, 120);
		tutorialLabel.setName("ScoreArrow");

		mainPane.setLayer(tutorialLabel, EnumLayerCodeTutorial.LabelScoreArrowHidden.getCode());
		mainPane.add(tutorialLabel, EnumLayerCodeTutorial.LabelScoreArrowHidden.getCode());
		componentList.put("ScoreArrow", tutorialLabel);

		// Objective Speech Label
		tutorialLabel = new ViewOverlayLabel(new ImageIcon(), new ImageIcon("img/tutorialPics/speech_bubble_right_tutorial_time_score.png"), 600, 226, " ");
		tutorialLabel.setBounds(SCREEN_WIDTH*3/8, SCREEN_HEIGHT*1/14, 600, 226);
		tutorialLabel.setName("ScoreTimeSpeech");
		
		mainPane.setLayer(tutorialLabel, EnumLayerCodeTutorial.LabelToolsSpeechHidden.getCode());
		mainPane.add(tutorialLabel, EnumLayerCodeTutorial.LabelToolsSpeechHidden.getCode());
		componentList.put("ScoreTimeSpeech", tutorialLabel);

		// Continue Button
		tutorialButton.getOverButton().removeActionListener(tutorialButton.getOverButton().getActionListeners()[0]);
		tutorialButton.getOverButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPane.setLayer(componentList.get("ToolsSpeech"), EnumLayerCodeTutorial.LabelToolsSpeechHidden.getCode());
				mainPane.setLayer(componentList.get("ToolsArrow"), EnumLayerCodeTutorial.LabelToolsArrowHidden.getCode());
				tutorialButton.setBounds(1, 1, 2, 2);
				mainPane.setLayer(componentList.get("MapButton"), EnumLayerCodeTutorial.ButtonMap.getCode());
			}
		});
	}
}
