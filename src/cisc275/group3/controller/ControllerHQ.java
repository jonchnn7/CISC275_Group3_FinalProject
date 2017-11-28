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
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.SceneHQ;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.utility.LayerCodeTutorial;
import cisc275.group3.utility.Mission;
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
 */
public class ControllerHQ extends ControllerScene implements LinkDynamics, LinkTime {
	private final String BG_IMAGE = "img/HQ_bg_v3.jpg";
	private ViewOverlayLabel statusLabel;

	// Tutorial Layer Variables
	ViewOverlayButton tutorialButton;
	ViewOverlayLabel tutorialLabel;
	
	public ControllerHQ(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
		super(w, h, f, cl, sceneType);

	}

	@Override
	protected void createScene() {
		scene = new SceneHQ("HQ", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, BG_IMAGE, sceneType);
		viewGame = new ViewGame(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), scene.getManifest().getBG());

		viewGame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		viewGame.setName("HQLayer");
		
    // Set Cursor
    viewGame.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		mainPane.setLayer(viewGame, LayerCode.HQ.getCode());
		mainPane.add(viewGame, LayerCode.HQ.getCode());

		componentList.put("HQ", viewGame);

		statusLabel = new ViewOverlayLabel((SCREEN_WIDTH/4)+300, (SCREEN_HEIGHT/4)-100, "  ");
		statusLabel.setBounds((SCREEN_WIDTH/4)+300, (SCREEN_HEIGHT/4)-100, 700, 400);

		statusLabel.setName("MissionFact");
		mainPane.setLayer(statusLabel, LayerCode.MissionFact.getCode());
		mainPane.add(statusLabel, LayerCode.MissionFact.getCode());

		componentList.put("MissionFact", statusLabel);
		
    if (sceneType == 1) {
      //mainPane.setLayer(statusLabel, LayerCode.MainTop.getCode());
      
      tutorialStepOne();
      tutorialStepTwo();
    }
	}

	
	@Override
	protected void addML() {
	}

	/**
	 * Connects the HQ model and HQ view. So long as the HQ scene is the active
	 * pane, update the model and then pass the updated scene objects to the view.
	 * <p>
	 * Overridden from interface LinkDynamics.java
	 */
	@Override
	public void update() {
		if (mainPane.getLayer(componentList.get("HQ")) == LayerCode.MainAll.getCode()) {
			// Update Model
			scene.update();
			viewGame.updatePanel(scene.getSceneItems());
			statusLabel.getLabel().setFont(new Font("Roboto", Font.BOLD, 18));
			statusLabel.getLabel().setForeground(Color.PINK);
			statusLabel.updateLabel(Scene.getCurrentFact());
		}
	}

	/**
	 * Updates the linked time through the SceneHQ. If there is an active mission,
	 * the time is incremented and if the Mission is turned in, the time is reset,
	 * and mission is scored appropriately
	 */
	@Override
	public void updateTime() {
		if ((scene.getTime() < 1) && !(Scene.getCurrentMission().isDoneMission()) && !(Scene.getCurrentMission().getTargetObject() == null)) {
			((SceneHQ) scene).missionScoreFail();
			scene.resetTime();
			Scene.getCurrentMission().setObjectNum(-5);
			Scene.getCurrentMission().setDoneMission(true);
			Scene.getCurrentMission().setTargetObject(null);
			displayMission();
			ControllerInventory.removeItem(Scene.getCurrentMission().getObjectName());
			((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(null);
		} 
		
		if ((!Scene.getCurrentMission().isDoneMission()) && !(Scene.getCurrentMission().getTargetObject() == null)){
			((SceneHQ) scene).updateTime();
		} else {
			if (((SceneHQ) scene).getTime() != 0) {
				scene.missionScore();
				scene.resetTime();
			}
		}
		if (mainPane.getLayer(componentList.get("HQ")) == LayerCode.MainAll.getCode()) {
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

	private void tutorialStepOne() { 		
		// Get Mission Label
		ImageIcon getMissionLabelIcon = new ImageIcon("img/tutorial_arrow_upLeft.png");
		ImageIcon getMissionLabelBG = new ImageIcon("img/tutorial_labelLeft_bg.png");
		tutorialLabel = new ViewOverlayLabel(getMissionLabelIcon, getMissionLabelBG, 780, 300, "Click for mission!");
		tutorialLabel.setBounds(480, 100, 780, 300);
		tutorialLabel.setName("GetMissionLabel");
		tutorialLabel.getLabel().setFont(new Font("Roboto", Font.BOLD, 48));
		
		mainPane.setLayer(tutorialLabel, LayerCodeTutorial.LabelGetMissionHidden.getCode());
		mainPane.add(tutorialLabel, LayerCodeTutorial.LabelGetMissionHidden.getCode());
    componentList.put("GetMissionLabel", tutorialLabel);
    
    // Get Mission Button
    ImageIcon getMissionButtonIcon = new ImageIcon("img/tutorial_getMission_button.png");
    tutorialButton = new ViewOverlayButton(getMissionButtonIcon, 400, 600);
    tutorialButton.setBounds(100, 0, 400, 600);
    tutorialButton.setName("GetMissionButton");   
    
    mainPane.setLayer(tutorialButton, LayerCodeTutorial.ButtonGetMissionHidden.getCode());
    mainPane.add(tutorialButton, LayerCodeTutorial.ButtonGetMissionHidden.getCode());
    componentList.put("GetMissionButton", tutorialButton);
    
    tutorialButton.getOverButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mainPane.setLayer(componentList.get("GetMissionButton"), LayerCodeTutorial.ButtonGetMissionHidden.getCode());
        mainPane.setLayer(componentList.get("GetMissionLabel"), LayerCodeTutorial.LabelGetMissionHidden.getCode());
        
        mainPane.setLayer(componentList.get("ObjectiveLabel"), LayerCodeTutorial.LabelObjective.getCode());
        mainPane.setLayer(componentList.get("ObjectiveArrow"), LayerCodeTutorial.LabelObjectiveArrow.getCode());
        mainPane.setLayer(componentList.get("ObjectiveLabelSpeech"), LayerCodeTutorial.LabelObjectiveSpeech.getCode());
        mainPane.setLayer(componentList.get("ContinueButton"), LayerCodeTutorial.ButtonContinue.getCode());
      }
    });
	}
	
	private void tutorialStepTwo() {
	   // Objective Label
    ImageIcon labelIcon = new ImageIcon("img/tutorial_mission_objectives.png");
    tutorialLabel = new ViewOverlayLabel(labelIcon, 200, 85, "");
    tutorialLabel.setBounds(SCREEN_WIDTH/2-100, -5, 200, 85);
    tutorialLabel.setName("ObjectiveLabel");
    tutorialLabel.getLabel().setFont(new Font("Roboto", Font.BOLD, 48));
    
    mainPane.setLayer(tutorialLabel, LayerCodeTutorial.LabelObjectiveHidden.getCode());
    mainPane.add(tutorialLabel, LayerCodeTutorial.LabelObjectiveHidden.getCode());
    componentList.put("ObjectiveLabel", tutorialLabel);
    
    // Objective Arrow Label
    labelIcon = new ImageIcon("img/tutorial_arrow_upLeft.png");
    tutorialLabel = new ViewOverlayLabel(null, labelIcon, 150, 120,"");
    tutorialLabel.setBounds(SCREEN_WIDTH/2+110, -5, 150, 120);
    tutorialLabel.setName("ObjectiveArrow");
    
    mainPane.setLayer(tutorialLabel, LayerCodeTutorial.LabelObjectiveArrowHidden.getCode());
    mainPane.add(tutorialLabel, LayerCodeTutorial.LabelObjectiveArrowHidden.getCode());
    componentList.put("ObjectiveArrow", tutorialLabel); 
    
    // Objective Speech Label
    labelIcon = new ImageIcon("img/tutorial_speechBubble_bg.png");
    ImageIcon offsetIcon = new ImageIcon("img/tutorial_speechBubble_offset.png");
    tutorialLabel = new ViewOverlayLabel(offsetIcon, labelIcon, 400, 250, "<html><br><br>Your mission objectives are up top.<br><br>We could really use a Horseshoe Crab, a Heron, and a Striped Bass!<html>");
    tutorialLabel.setBounds(470, 110, 400, 250);
    tutorialLabel.setName("ObjectiveSpeech");
    tutorialLabel.getLabel().setFont(new Font("Roboto", Font.BOLD, 22));
    tutorialLabel.getLabel().setHorizontalAlignment(JLabel.LEFT);
    tutorialLabel.getLabel().setVerticalAlignment(JLabel.TOP);
    
    mainPane.setLayer(tutorialLabel, LayerCodeTutorial.LabelObjectiveSpeechHidden.getCode());
    mainPane.add(tutorialLabel, LayerCodeTutorial.LabelObjectiveSpeechHidden.getCode());
    componentList.put("ObjectiveLabelSpeech", tutorialLabel); 
    
    // Objective Continue Button
    ImageIcon tutorialButtonIcon = new ImageIcon("img/tutorial_continue_button.png");
    tutorialButton = new ViewOverlayButton(tutorialButtonIcon, 100, 100);
    tutorialButton.setBounds(SCREEN_WIDTH-150, SCREEN_HEIGHT-200, 100, 100);
    tutorialButton.setName("Continue");   
    
    mainPane.setLayer(tutorialButton, LayerCodeTutorial.ButtonContinueHidden.getCode());
    mainPane.add(tutorialButton, LayerCodeTutorial.ButtonContinueHidden.getCode());
    componentList.put("ContinueButton", tutorialButton);
    
    tutorialButton.getOverButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {  
        Component invButton = mainPane.getComponentsInLayer(LayerCodeTutorial.ButtonInventoryHidden.getCode())[0];
        
        mainPane.setLayer(componentList.get("ObjectiveLabelSpeech"), LayerCodeTutorial.LabelObjectiveSpeechHidden.getCode());
        mainPane.setLayer(componentList.get("ObjectiveArrow"), LayerCodeTutorial.LabelObjectiveArrowHidden.getCode());

        mainPane.setLayer(componentList.get("InventoryButton"), LayerCodeTutorial.ButtonInventory.getCode());
        System.out.println(componentList.get("InventoryButton").getSize());
        System.out.println(invButton.getSize());
      }
    });
	}
	
	private void tutorialStepThree() {
	  
	}
}
