package cisc275.group3.controller;

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
import cisc275.group3.utility.Mission;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewOverlayLabel;

public class ControllerMission extends ControllerScene implements LinkDynamics, LinkTime {
	private JPanel missionPanel;
	private JButton missionButton;
	private Random randGen = new Random();
	
	protected int lastMission = -1;
	protected boolean newMission = false;
	
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
	    			int tmp = randGen.nextInt(9);
	    			
	    			while (newMission == false)
	    			{
	    				tmp = randGen.nextInt(11);
	    				if (tmp <= 5 && lastMission != 0)
	    					newMission = true;
	    				else if (tmp>5 && tmp <= 11 && lastMission != 1)
	    					newMission = true;
	    			}
	    			
	    			newMission = false;
	    			
	    			String s = "";
	    			switch(tmp) {
		    			case 0: s = "Butterflyfish";
		    					((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/fish_left_1.png"));
		    					lastMission = 0;
		    					break;
		    			case 1: s = "Rainbow Cichlid";
    							((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/fish_left_2.png"));
    							lastMission = 0;
								break;
		    			case 2: s = "Goldfish";
    							((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/fish_left_3.png"));
    							lastMission = 0;
								break;
		    			case 3: s = "Angelfish";
    							((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/fish_right_1.png"));
    							lastMission = 0;
								break;
		    			case 4: s = "Threadfin Butterflyfish";
    							((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/fish_right_2.png"));
    							lastMission = 0;
								break;
		    			case 5: s = "Sergeant Major";
    							((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/fish_right_3.png"));
    							lastMission = 0;
								break;
		    			case 6: s = "Cristmas Island Red Crab";
								((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/crabLeft_red_icon.png"));
								lastMission = 1;
								break;
		    			case 7: s = "Atlantic Blue Crab";
								((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/crab_blue_icon.png"));
								lastMission = 1;
								break;
		    			case 8: s = "Horseshoe Crab";
								((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/horeshoeCrab.png"));
								lastMission = 1;
								break;
		    			case 9: s = "Great Blue Heron: standing";
		    					((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/heron_standing_left.png"));
		    					lastMission = 1;
		    					break;
		    			case 10: s = "Great Blue Heron: flying";
		    					((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/heron_flying_left.png"));
		    					lastMission = 1;
		    					break;
		    			case 11: s = "Plant: 1/3";
		    					((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/weeds1_resized.png"));
		    					lastMission = 1;
		    					break;
	    			}
	    			
	    			if (tmp <= 5) {
	    				Scene.setCurrentMission(new Mission("BetaFish", randGen.nextInt(5) + 1));
	    			} else if ((tmp >= 6) && (tmp <= 8)) {
	    				Scene.setCurrentMission(new Mission("BetaCrab", randGen.nextInt(5) + 1));
	    			} else if((tmp >= 8) && (tmp <=10)){
	    				Scene.setCurrentMission(new Mission("BetaHeron", randGen.nextInt(5) + 1));
	    			} else {
	    				Scene.setCurrentMission(new Mission("BetaVegetation", randGen.nextInt(5) + 1));
	    			}
	    			Scene.getCurrentMission().setObjectName(s);
	    			displayMission();
	    		} else if ((Scene.getCurrentMission().getTargetObject() == null) && !(Scene.getCurrentMission().isDoneMission())) {
	    			Scene.getCurrentMission().setObjectNum(-5);
	    			Scene.getCurrentMission().setDoneMission(true);
	    			displayMission();
	    			ControllerInventory.removeItem(Scene.getCurrentMission().getObjectName());
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
