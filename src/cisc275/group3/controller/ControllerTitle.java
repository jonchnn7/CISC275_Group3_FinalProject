package cisc275.group3.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
 * 
 * @author Ryan
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
		startButton.setBounds(600, 500, 100, 100);
		startButton.setSize(100, 100);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			  System.out.println("Title Start");
			  Component titleComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Title")))[0];
		    Component hqComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("HQ")))[0];
		    Component missionComponent = mainPane.getComponentsInLayer(mainPane.getLayer(componentList.get("Mission")))[0];

				mainPane.setLayer(hqComponent, LayerCode.MainAll.getCode());			
				mainPane.setLayer(titleComponent, LayerCode.Title.getCode());
				mainPane.setLayer(missionComponent, LayerCode.Mission.getCode());
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