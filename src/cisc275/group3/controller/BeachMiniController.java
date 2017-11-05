package cisc275.group3.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import cisc275.group3.model.scene.BeachMiniScene;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.SceneLayer;
import cisc275.group3.view.SceneView;

/**
 * Contains the controller actions and logic for BayScene.java.
 */
public class BeachMiniController extends SceneController {
  
  public BeachMiniController(int w, int h, GameWindow f, HashMap<String, Component> cl) {
    super(w, h, f, cl);
  }

  @Override
  protected void createScene() {
    scene = new BeachMiniScene("Bay", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, true, true);
    sceneLayer = new SceneLayer(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), Color.YELLOW);
    sceneView = new SceneView(SCREEN_WIDTH, SCREEN_HEIGHT, sceneLayer, ((BeachMiniScene)scene).getTime());
    
    sceneView.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    sceneView.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    sceneView.setDoubleBuffered(true);
    sceneView.setName("BeachMiniLayer");
    
    mainPane.setLayer(sceneView, LayerCode.BeachMini.getCode());
    mainPane.add(sceneView, LayerCode.BeachMini.getCode());
    
    componentList.put("BeachMini", sceneView);
  
    addML();
    addMapButton();
  }

  @Override
  protected void addML() {
    sceneLayer.addMouseMotionListener(new MouseAdapter() {
      int initialX;
      
      @Override
      public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
          initialX = e.getX();
        }
      }
      
      @Override
      public void mouseDragged(MouseEvent e) {
        ((BeachMiniScene)scene).update(0.004*(e.getX()-initialX));
      }
    });
  }
 
  @Override
  protected void addMapButton() {
    mapButton = sceneView.getMapButton();
    
    mapButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component mapComponent = mainPane.getComponentsInLayer(LayerCode.Map.getCode())[0];       
        mainPane.setLayer(mapComponent, LayerCode.Overlay.getCode());
      }
    });
  }
  
  @Override
  public void update() {
	if (mainPane.getLayer(componentList.get("BeachMini")) == LayerCode.Main.getCode()) {
      ((BeachMiniScene)scene).update();
      sceneLayer.updatePanel(scene.getSceneItems());
	}
  }
  
  public void updateTime() {
    ((BeachMiniScene)scene).updateTime();
    sceneView.updateTime(((BeachMiniScene)scene).getTime());
  }
}
