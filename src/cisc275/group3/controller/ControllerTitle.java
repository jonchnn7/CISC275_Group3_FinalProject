package cisc275.group3.controller;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.SceneBay;
import cisc275.group3.model.scene.SceneTitle;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;

/**
 * 
 * @author Ryan
 */

public class ControllerTitle extends ControllerScene implements LinkDynamics, LinkTime {
	private final String BG_IMAGE = ("img/EstuaryTitle.png");
	private JButton startButton;

	public ControllerTitle(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
		super(w, h, f, cl, sceneType);
	}

	@Override
	protected void createScene(int sceneType) {
		scene = new SceneTitle("Title", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, BG_IMAGE, sceneType);
		viewGame = new ViewGame(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), scene.getManifest().getBG());
		viewGame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		viewGame.setName("TitleLayer");

		addTitleButton();

		mainPane.setLayer(viewGame, LayerCode.Title.getCode());
		mainPane.add(viewGame, LayerCode.Title.getCode());
		componentList.put("Title", viewGame);

	}

	private void addTitleButton() {
		startButton = new JButton("Start");
		startButton.setFont(new Font("Roboto", Font.BOLD, 30));
		startButton.setBounds(640, 500, 100, 100);
		startButton.setSize(100, 100);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component startComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("HQ")))[0];
				mainPane.setLayer(startComponent, LayerCode.MainAll.getCode());
			}
		});
		SceneTitle.add(startButton);
	}

	@Override
	protected void addML() {
	}

	@Override
	public void updateTime() {
	}

	@Override
	public void displayTime() {
	}

	@Override
	public void update() {
	}
}