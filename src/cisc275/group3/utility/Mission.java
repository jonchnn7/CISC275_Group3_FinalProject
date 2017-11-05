package cisc275.group3.utility;

import java.awt.Color;

import cisc275.group3.model.sceneobject.SceneObject;

public class Mission {
  private Color targetObjectColor;
  private boolean doneMission;
	
  public Mission(Color c) {
    targetObjectColor = c;
    doneMission = false;
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
    if (targetObjectColor == null) {
      return "None";
    }
		
    if (doneMission) {
      return "Completed!";
    }
		
    if (targetObjectColor.equals(Color.black)) {
      return "Black";
    } else if (targetObjectColor.equals(Color.cyan)) {
      return "Cyan";
    } else if (targetObjectColor.equals(Color.darkGray)) {
      return "Dark grey";
    } else if (targetObjectColor.equals(Color.magenta)) {
      return "Magenta";
    } else if (targetObjectColor.equals(Color.red)) {
      return "Red";
    } else if (targetObjectColor.equals(Color.yellow)) {
      return "Yellow";
    } else if (targetObjectColor.equals(Color.orange)) {
      return "Orange";
    } else {
      return "";
  }
}
}
