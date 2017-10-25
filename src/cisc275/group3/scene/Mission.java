package cisc275.group3.scene;

import java.awt.Color;

import cisc275.group3.sceneobjects.SceneObject;

public class Mission {
	private Color targetObjectColor;
	private boolean doneMission;
	
	public Mission(Color black) {
		this.targetObjectColor = black;
		this.doneMission = false;
	}

	public Color getTargetObjectColor() {
		return targetObjectColor;
	}

	public void setTargetObject(Color targetObjectColor) {
		this.targetObjectColor = targetObjectColor;
	}

	public boolean isDoneMission() {
		return doneMission;
	}

	public void setDoneMission(boolean doneMission) {
		this.doneMission = doneMission;
	}
	
	public String toString() {
		if (this.targetObjectColor == null) {
			return "None";
		}
		
		if (this.doneMission) {
			return "Completed!";
		}
		
		if (this.targetObjectColor.equals(Color.black)) {
			return "Black";
		} else if (this.targetObjectColor.equals(Color.cyan)) {
			return "Cyan";
		} else if (this.targetObjectColor.equals(Color.darkGray)) {
			return "Dark grey";
		} else if (this.targetObjectColor.equals(Color.magenta)) {
			return "Magenta";
		} else if (this.targetObjectColor.equals(Color.red)) {
			return "Red";
		} else if (this.targetObjectColor.equals(Color.yellow)) {
			return "Yellow";
		} else if (this.targetObjectColor.equals(Color.orange)) {
			return "Orange";
		} else {
			return "";
		}
	}
}
