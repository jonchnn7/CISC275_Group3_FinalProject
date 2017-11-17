package cisc275.group3.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import cisc275.group3.model.scene.Scene;
import cisc275.group3.model.scene.SceneBeach;
import cisc275.group3.model.scene.SceneHQ;
import cisc275.group3.model.sceneobject.BetaFish;
import cisc275.group3.model.sceneobject.ToolCamera;
import cisc275.group3.model.sceneobject.ToolNet;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.utility.Mission;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.ViewGame;

public class ControllerHQ extends ControllerScene implements LinkDynamics, LinkTime {
	private final String BG_IMAGE = "img/bay_bg_2.jpg";
	  
	public ControllerHQ(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
		super(w, h, f, cl, sceneType);
	}
	  
	@Override
	protected void createScene(int sceneType) {
		scene = new SceneHQ("HQ", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, sceneType, BG_IMAGE);
	    viewGame = new ViewGame(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), scene.getManifest().getBG());
	    

	    viewGame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
	    viewGame.setName("HQLayer");
	    
	    mainPane.setLayer(viewGame, LayerCode.HQ.getCode());
	    mainPane.add(viewGame, LayerCode.HQ.getCode());
	    
	    componentList.put("HQ", viewGame);
	  
	    addML();
	  }
	
	  @Override
	  protected void addML() {
	  }
	
	@Override
	  public void update() {
	    if (mainPane.getLayer(componentList.get("HQ")) == LayerCode.MainAll.getCode()) {
	      // Update Model
	      ((SceneHQ)scene).update();
	      viewGame.updatePanel(scene.getSceneItems());
	    }
	  }

	@Override
	public void updateTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayTime() {
		// TODO Auto-generated method stub
		
	}
}
