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
	ViewOverlayButton getMissionButton;
	ViewOverlayLabel getMissionLabel;
	
	public ControllerHQ(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
		super(w, h, f, cl, sceneType);

	}

	@Override
	protected void createScene(int sceneType) {
		scene = new SceneHQ("HQ", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, BG_IMAGE, sceneType);
		viewGame = new ViewGame(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), scene.getManifest().getBG());

		viewGame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		viewGame.setName("HQLayer");
		
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
	  // Set Cursor
	  viewGame.setCursor(new Cursor(Cursor.HAND_CURSOR));
	  		
		// Label
		ImageIcon getMissionLabelIcon = new ImageIcon("img/tutorial_arrow_upLeft.png");
		ImageIcon getMissionLabelBG = new ImageIcon("img/tutorial_labelLeft_bg.png");
		getMissionLabel = new ViewOverlayLabel(getMissionLabelIcon, getMissionLabelBG, 780, 300, "Click for mission!");
		getMissionLabel.setBounds(480, 100, 780, 300);
		getMissionLabel.setName("GetMissionLabel");
		getMissionLabel.getLabel().setFont(new Font("Roboto", Font.BOLD, 48));
		
		mainPane.setLayer(getMissionLabel, LayerCodeTutorial.LabelGetMissionHidden.getCode());
		mainPane.add(getMissionLabel, LayerCodeTutorial.LabelGetMissionHidden.getCode());
    componentList.put("GetMissionLabel", getMissionLabel);
    
    // Button
    ImageIcon getMissionButtonIcon = new ImageIcon("img/tutorial_GetMission_Button.png");
    getMissionButton = new ViewOverlayButton(getMissionButtonIcon, 400, 600);
    getMissionButton.setBounds(100, 0, 400, 600);
    getMissionButton.setName("GetMissionButton");   
    
    mainPane.setLayer(getMissionButton, LayerCodeTutorial.ButtonGetMissionHidden.getCode());
    mainPane.add(getMissionButton, LayerCodeTutorial.ButtonGetMissionHidden.getCode());
    componentList.put("GetMissionButton", getMissionButton);
    
    getMissionButton.getOverButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mainPane.setLayer(getMissionButton, LayerCodeTutorial.ButtonGetMissionHidden.getCode());
        mainPane.setLayer(getMissionLabel, LayerCodeTutorial.LabelGetMissionHidden.getCode());
        
      
        
      }
    });
		
	}
}
