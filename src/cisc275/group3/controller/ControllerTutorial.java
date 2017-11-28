package cisc275.group3.controller;

import java.awt.Component;
import java.util.HashMap;

import cisc275.group3.controller.ControllerScene;
import cisc275.group3.view.GameWindow;

/**
 * Contains the controller actions and logic for SceneTutorial.java.
 * <p>
 * Extends the abstract ConstrollerScene class and adds dynamics
 * and timing attributes. Those interfaces require the controller
 * to pass an update call to the model on every timer tick, and
 * to update the time every second.
 * <p>
 * See cisc275.group3.controller.ControllerScene.java
 * <p>
 * ControllerTutorial.java
 * <p>
 * @author Scott 
 */
public class ControllerTutorial extends ControllerScene {

	public ControllerTutorial(int w, int h, GameWindow f, HashMap<String, Component> cl, int sceneType) {
		super(w, h, f, cl, sceneType);
	}

	@Override
	protected void createScene(int sceneType) {
		
		
	}

}
