package cisc275.group3.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.SceneBay;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.utility.Mission;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewOverlayLabel;

public class ControllerMission extends ControllerScene implements LinkDynamics, LinkTime {
	private JPanel missionPanel;
	private JButton missionButton;
	private Random randGen = new Random();
	
    public ControllerMission(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
        super(w, h, f, cl, sceneType);
    }
    
	@Override
	protected void createScene(int sceneType) {
		 missionPanel = new JPanel(true);
		 
		 missionPanel.setLayout(null);
		 missionPanel.setBounds(SCREEN_WIDTH/2 - 60, SCREEN_HEIGHT/2 - 15, 120, 30);
		 missionPanel.setOpaque(true);
		 
		 addMissionButton();
		 
		 mainPane.setLayer(missionPanel, -20);
		 mainPane.add(missionPanel, -20);
		 componentList.put("Mission", missionPanel);
	}
    
    private void addMissionButton() {
	    missionButton = new JButton("Mission");
	    missionButton.setFont(new Font("Roboto", Font.BOLD, 18));
	    missionButton.setBounds(0, 0, 120, 30);
		
	    missionButton.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		if ((Scene.getCurrentMission().getTargetObject() == null) && (Scene.getCurrentMission().isDoneMission())) {
	    			int tmp = randGen.nextInt(8);
	    			String s = "";
	    			switch(tmp) {
		    			case 0: s = "Butterflyfish";
		    					((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/fish_left_1.png"));
		    					break;
		    			case 1: s = "Rainbow Cichlid";
    							((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/fish_left_2.png"));
								break;
		    			case 2: s = "Goldfish";
    							((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/fish_left_3.png"));
								break;
		    			case 3: s = "Angelfish";
    							((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/fish_right_1.png"));
								break;
		    			case 4: s = "Threadfin Butterflyfish";
    							((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/fish_right_2.png"));
								break;
		    			case 5: s = "Sergeant Major";
    							((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/fish_right_3.png"));
								break;
		    			case 6: s = "Cristmas Island Red Crab";
								((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/crabLeft_red_icon.png"));
								break;
		    			case 7: s = "Atlantic Blue Crab";
								((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/crab_blue_icon.png"));
								break;
	    			}
	    			
	    			if (tmp <= 5) {
	    				Scene.setCurrentMission(new Mission("BetaFish", randGen.nextInt(5) + 1));
	    			} else if ((tmp >= 6) && (tmp <= 7)) {
	    				Scene.setCurrentMission(new Mission("BetaCrab", randGen.nextInt(5) + 1));
	    			} else {
	    				Scene.setCurrentMission(new Mission("BetaVegetation", randGen.nextInt(5) + 1));
	    			}
	    			Scene.getCurrentMission().setObjectName(s);
	    			displayMission();
	    		} else if ((Scene.getCurrentMission().getTargetObject() == null) && !(Scene.getCurrentMission().isDoneMission())) {
	    			Scene.getCurrentMission().setObjectNum(-5);
	    			Scene.getCurrentMission().setDoneMission(true);
	    			displayMission();
	    			System.out.println(Scene.getCurrentFact());
	    		}
	    	}
	    });
	    missionPanel.add(missionButton);
	}

	@Override
	public void updateTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
