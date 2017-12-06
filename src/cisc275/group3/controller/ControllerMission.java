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
import cisc275.group3.utility.EnumLayerCode;
import cisc275.group3.utility.EnumLayerCodeTutorial;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.utility.Mission;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewOverlayButton;
import cisc275.group3.view.ViewOverlayLabel;

/**
 * The Mission controller deals with the controller aspect of missions. This is
 * where we are actually able to see the mission
 * <p>
 * ControllerMission.java
 * <p>
 * 
 * @author Jolyne
 * @author Thomas
 */
public class ControllerMission extends ControllerScene {
	private JPanel missionPanel; // create mission JPanel
	private JButton missionButton; // create mission button
	private Random randGen = new Random();

	private static int currentPersonID = -1;
	private static int tmp = -1;

	protected int lastMission = -1; // used so missions can't repeat
	protected boolean newMission = false; // used so missions can't repeat

	/**
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
	public ControllerMission(int w, int h, GameWindow f, HashMap<String, Component> cl, EnumSceneType sceneType) {
		super(w, h, f, cl, sceneType);
	}

	/**
	 * Creates the scene and adds it to the main pain. Sets the layers and component
	 * list for the mission.
	 */
	@Override
	protected void createScene() {
		missionPanel = new JPanel(true);

		missionPanel.setLayout(null);
		missionPanel.setBounds((SCREEN_WIDTH / 2) - (SCREEN_WIDTH / 4), (SCREEN_HEIGHT / 2 - SCREEN_HEIGHT / 3),
				SCREEN_WIDTH / 8, SCREEN_HEIGHT * 2 / 5);
		missionPanel.setOpaque(false);

		addMissionButton();

		mainPane.setLayer(missionPanel, EnumLayerCode.Mission.getCode());
		mainPane.add(missionPanel, EnumLayerCode.Mission.getCode());
		componentList.put("Mission", missionPanel);
	}

	/**
	 * Adds the mission button to the mission panel. The button contains an action
	 * listener and when clicked: generates a random mission consisting of a random
	 * sceneObject and a random number. After the mission has been created, the
	 * mission can be completed when the correct sceneObjects have been clicked
	 */
	private void addMissionButton() {
		missionButton = new JButton();
		missionButton.setBounds(0, 0, SCREEN_WIDTH / 8, SCREEN_HEIGHT * 2 / 5);
		missionButton.setOpaque(false);
		missionButton.setContentAreaFilled(false);
		missionButton.setBorderPainted(false);

		missionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if ((Scene.getCurrentMission().getTargetObject() == null) && (Scene.getCurrentMission().isDoneMission())
						&& (Scene.getCurrentMission().getObjectNum() != -7) && (missionClickable == true)) {

					newMission = false;

					switch (currentPersonID) {
					// BirdWatcher (Heron)
					case 0:
						tmp = 5;
						break;
					// Park Ranger (Weeds)
					case 1:
						tmp = 6;
						break;
					// Scientist
					case 2:
						tmp = randGen.nextInt(2) + 3;
						break;
					// fish
					case 3:
						tmp = randGen.nextInt(3);
						break;
					}

					String s = "";
					switch (tmp) {
					case 0:
						s = "Striped Bass";
						((ViewOverlayLabel) componentList.get("MissionLabel"))
								.updateIcon(new ImageIcon("img/missionIconPics/striped_bass_icon.png"));
						lastMission = 0;
						break;
					case 1:
						s = "American Shad";
						((ViewOverlayLabel) componentList.get("MissionLabel"))
								.updateIcon(new ImageIcon("img/missionIconPics/shad_icon.png"));
						lastMission = 0;
						break;
					case 2:
						s = "Shortnose Sturgeon";
						((ViewOverlayLabel) componentList.get("MissionLabel"))
								.updateIcon(new ImageIcon("img/missionIconPics/shortnose_icon.png"));
						lastMission = 0;
						break;
					case 3:
						s = "Atlantic Blue Crab";
						((ViewOverlayLabel) componentList.get("MissionLabel"))
								.updateIcon(new ImageIcon("img/missionIconPics/crab_blue_icon.png"));
						lastMission = 1;
						break;
					case 4:
						s = "Horseshoe Crab";
						((ViewOverlayLabel) componentList.get("MissionLabel"))
								.updateIcon(new ImageIcon("img/missionIconPics/horeshoe_icon.png"));
						lastMission = 1;
						break;
					case 5:
						s = "Great Blue Heron";
						((ViewOverlayLabel) componentList.get("MissionLabel"))
								.updateIcon(new ImageIcon("img/missionIconPics/heron_mission_icon.png"));
						lastMission = 2;
						break;
					case 6:
						s = "Invasive Plant";
						((ViewOverlayLabel) componentList.get("MissionLabel"))
								.updateIcon(new ImageIcon("img/missionIconPics/weeds_mission_icon.png"));
						lastMission = 2;
						break;
					}

					if (tmp <= 2) {
						Scene.setCurrentMission(new Mission("BetaFish", randGen.nextInt(5) + 1));
					} else if ((tmp > 2) && (tmp <= 4)) {
						Scene.setCurrentMission(new Mission("BetaCrab", randGen.nextInt(5) + 1));
					} else if (tmp == 5) {
						Scene.setCurrentMission(new Mission("BetaHeron", randGen.nextInt(5) + 1));
					} else {
						Scene.setCurrentMission(new Mission("BetaVegetation", randGen.nextInt(5) + 1));
					}
					Scene.getCurrentMission().setObjectName(s);
					Scene.getCurrentMission().setTargetNameForFact(s);
					Scene.setCurrentFact("");
					displayMission();
				} else if ((Scene.getCurrentMission().getTargetObject() == null)
						&& !(Scene.getCurrentMission().isDoneMission())) {
					Scene.getCurrentMission().setObjectNum(-7);
					Scene.getCurrentMission().setDoneMission(true);
					displayMission();
					ControllerInventory.removeItem(Scene.getCurrentMission().getObjectName());
					System.out.println(Scene.getCurrentFact());
				} else if (Scene.getCurrentMission().getObjectNum() == -7) {
					Scene.getCurrentMission().setObjectNum(-5);
					Scene.setCurrentFact("");
				}
			}
		});
		missionPanel.add(missionButton);
	}

	public static void setPersonID(int tmpID) {
		currentPersonID = tmpID;
	}
}
