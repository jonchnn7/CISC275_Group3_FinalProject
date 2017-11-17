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
	    		if (Scene.getCurrentMission().getTargetObject() == null) {
	    			int tmp = randGen.nextInt(6);
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
	    			}
	    			
	    			Scene.setCurrentMission(new Mission("BetaFish", randGen.nextInt(10) + 1));
	    			Scene.getCurrentMission().setObjectName(s);
	    			
	    			displayMission();
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
