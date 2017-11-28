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
	    			int tmpScene = randGen.nextInt(3);
	    			int tmp = randGen.nextInt(12);
	    			
	    			while (newMission == false)
	    			{
	    				tmpScene = randGen.nextInt(3);
	    				if (tmpScene == 0 && lastMission != 0)
	    					newMission = true;
	    				else if (tmpScene == 1 && lastMission != 1)
	    					newMission = true;
	    				else if (tmpScene == 2 && lastMission != 2)
	    					newMission = true;
	    			}
	    			newMission = false;
	    			
	    			switch(tmpScene)
	    			{
	    				case 0:
	    					tmp = randGen.nextInt(3);
	    					break;
	    				case 1:
	    					tmp = randGen.nextInt(2)+3;
	    					break;
	    				case 2:
	    					tmp = randGen.nextInt(2)+ 5;
	    					break;
	    			}
	    			
	    			String s = "";
	    			switch(tmp) {
		    			case 0: s = "Striped Bass";
		    					((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/striped_bass_icon.png"));
		    					lastMission = 0;
		    					break;
		    			case 1: s = "American Shad";
    							((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/shad_left.png"));
    							lastMission = 0;
								break;
		    			case 2: s = "Shortnose Sturgeon";
    							((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/shortnose_left.png"));
    							lastMission = 0;
								break;
		    			case 3: s = "Atlantic Blue Crab";
								((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/crab_blue_icon.png"));
								lastMission = 1;
								break;
		    			case 4: s = "Horseshoe Crab";
								((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/horeshoe_mission_icon.png"));
								lastMission = 1;
								break;
		    			case 5: s = "Great Blue Heron";
		    					((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/heron_mission_icon.png"));
		    					lastMission = 2;
		    					break;
		    			case 6: s = "Invasive Plant";
		    					((ViewOverlayLabel)componentList.get("MissionLabel")).updateIcon(new ImageIcon("img/weeds_mission_icon.png"));
		    					lastMission = 2;
		    					break;
	    			}
	    			
	    			if (tmp <= 2) {
	    				Scene.setCurrentMission(new Mission("BetaFish", randGen.nextInt(5) + 1));
	    			} else if ((tmp > 2) && (tmp <= 4)) {
	    				Scene.setCurrentMission(new Mission("BetaCrab", randGen.nextInt(5) + 1));
	    			} else if(tmp == 5){
	    				Scene.setCurrentMission(new Mission("BetaHeron", randGen.nextInt(5) + 1));
	    			} else {
	    				Scene.setCurrentMission(new Mission("BetaVegetation", randGen.nextInt(5) + 1));
	    			}
	    			Scene.getCurrentMission().setObjectName(s);
	    			Scene.getCurrentMission().setTargetNameForFact(s);
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
