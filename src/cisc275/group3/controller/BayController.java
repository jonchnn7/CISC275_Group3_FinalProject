package cisc275.group3.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import cisc275.group3.model.scene.BayScene;
import cisc275.group3.utility.LayerCode;
import cisc275.group3.view.GameWindow;
import cisc275.group3.view.SceneLayer;
import cisc275.group3.view.SceneView;

/**
 * Contains the controller actions and logic for BayScene.java.
 */
public class BayController extends SceneController {
  
  public BayController(int w, int h, GameWindow f, HashMap<String, Component> cl) {
    super(w, h, f, cl);
  }

  @Override
  protected void createScene() {
    scene = new BayScene("Bay", 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, true, true);
    sceneLayer = new SceneLayer(SCREEN_WIDTH, SCREEN_HEIGHT, scene.getSceneItems(), Color.BLUE);
    sceneView = new SceneView(SCREEN_WIDTH, SCREEN_HEIGHT, sceneLayer, 
        ((BayScene)scene).getScore(), ((BayScene)scene).getTime());
    
    sceneView.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    sceneView.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    sceneView.setDoubleBuffered(true);
    sceneView.setName("BayLayer");
    
    mainPane.setLayer(sceneView, LayerCode.Bay.getCode());
    mainPane.add(sceneView, LayerCode.Bay.getCode());
    
    componentList.put("Bay", sceneView);
  
    addML();
    addMapButton();
  }

  @Override
  protected void addML() {
    sceneLayer.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
          if ( scene.processClick(e.getX(), e.getY()) ) {
            ((BayScene)scene).updateScore();
            sceneView.updateScore(((BayScene)scene).getScore());
          }
        }
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
    if (mainPane.getLayer(componentList.get("Bay")) == LayerCode.Main.getCode()) {
      ((BayScene)scene).update();
      sceneLayer.updatePanel(scene.getSceneItems());
    }
  }
  
  public void updateTime() {
    ((BayScene)scene).updateTime();
    sceneView.updateTime(((BayScene)scene).getTime());
  }
}
