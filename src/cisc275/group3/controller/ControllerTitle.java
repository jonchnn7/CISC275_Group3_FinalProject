package cisc275.group3.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.SceneBay;
import cisc275.group3.model.scene.SceneTitle;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;

/**
 * The Title Controller is responsible for the control of the title screen.
 * 
 * The title screen is the first interface that is visible for the user and 
 * provides a start button that sends the user to the hq upon clicking.
 * 
 * ControllerTitle.java
 * 
 * @author Ryan
 * @author Scott
 */

public class ControllerTitle extends ControllerScene implements LinkDynamics, LinkTime {
	private final ImageIcon BG_IMAGE = new ImageIcon("img/EstuaryTitle.png");
	private JPanel titlePanel;
	private JButton startButton;

	public ControllerTitle(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
		super(w, h, f, cl, sceneType);
	}

	@Override
	protected void createScene(int sceneType) {
		titlePanel = new JPanel(true) {
			@Override
			public void paintComponent(Graphics g) {
				Dimension size = new Dimension(1280, 720);
				g.drawImage(BG_IMAGE.getImage(), 0, 0, size.width, size.height, this);
			}
		};

		// Set Properties
		titlePanel.setLayout(null);
		titlePanel.setPreferredSize(new Dimension(1280, 720));
		titlePanel.setBounds(0, 0, 1280, 720);
		titlePanel.setOpaque(true);

		titlePanel.setName("TitleLayer");

		addTitleButton();

		mainPane.setLayer(titlePanel, LayerCode.MainTop.getCode());
		mainPane.add(titlePanel, LayerCode.MainTop.getCode());
		componentList.put("Title", titlePanel);
	}

	private void addTitleButton() {
		startButton = new JButton("Start");
		startButton.setFont(new Font("Roboto", Font.BOLD, 30));
		startButton.setBounds(500, 600, 300, 96);
		startButton.setIcon(new ImageIcon("img/startButton.png"));
		startButton.setOpaque(false);
		startButton.setBorderPainted(false);
		startButton.setBorder(null);
		startButton.setMargin(new Insets(0, 0, 0, 0));
		startButton.setContentAreaFilled(false);
		startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		startButton.setSize(330, 96);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component titleComponent = mainPane
						.getComponentsInLayer(mainPane.getLayer(componentList.get("Title")))[0];
				Component hqComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("HQ")))[0];
				//Component missionComponent = mainPane
						//.getComponentsInLayer(mainPane.getLayer(componentList.get("Mission")))[0];

				mainPane.setLayer(hqComponent, LayerCode.MainAll.getCode());
				mainPane.setLayer(titleComponent, LayerCode.Title.getCode());
				//mainPane.setLayer(missionComponent, LayerCode.Mission.getCode());
			}
		});
		titlePanel.add(startButton);
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