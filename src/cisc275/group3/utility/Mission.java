package cisc275.group3.utility;

import java.awt.Color;

import cisc275.group3.model.sceneobject.BetaCrab;
import cisc275.group3.model.sceneobject.BetaFish;
import cisc275.group3.model.sceneobject.BetaVegetation;
import cisc275.group3.model.sceneobject.SceneObject;

public class Mission {
	private String targetObject;
	private String objectName;
	private int objectNum;
	private boolean doneMission;
	
	public Mission(String o, int num) {
		targetObject = o;
		objectNum = num;
		objectName = "";
		doneMission = false;
	}
	
	public void decreaseNum() {
		objectNum--;
	}

	public String getTargetObject() {
		return targetObject;
	}
	
	public void setTargetObject(String o) {
		targetObject = o;
	}
	
	public int getObjectNum() {
		return objectNum;
	}
	
	public void setObjectNum(int i) {
		objectNum = i;
	}
	
	public String getObjectName() {
		return objectName;
	}
	
	public void setObjectName(String n) {
		objectName = n;
	}

	public boolean isDoneMission() {
		return doneMission;
	}

	public void setDoneMission(boolean doneMission) {
		this.doneMission = doneMission;
	}
	
	public String toString() {
		if (doneMission) {
			return "Completed!";
		}
		
		if (targetObject == null) {
			return "None";
		}
		
		String s = objectNum + " ";
    
		if (targetObject.equals("BetaFish")) {
			if (objectName.equals("")) {
				s += "BetaFish";
			} else {
				s += objectName;
			}
		} else if (targetObject.equals("BetaCrab")) {
			if (objectName.equals("")) {
				s += "BetaCrab";
			} else {
				s += objectName;
			}
		} else if (targetObject.equals("BetaVegetation")) {
			if (objectName.equals("")) {
				s += "BetaVegetation";
			} else {
				s += objectName;
			}
		}
		return s;
	}
}
