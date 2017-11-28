package cisc275.group3.utility;

import java.util.ArrayList;

import cisc275.group3.model.sceneobject.BetaPerson;

/**
 * @author Jolyne
 */
public enum SceneObjectType {
	BetaPerson (new String[]{"Camera"}),
	BetaHeron (new String[]{"Camera"}),
	BetaFish (new String[]{"Net"}),
	BetaCrab (new String[] {"Cage"}),
	BetaVegetation (new String[] {"Trimmer"});
	 
	//Add in new sceneObjects here as they are created
	
	ArrayList<String> compatibleObjects;
	
	SceneObjectType(String[] objArr) {
		this.compatibleObjects = new ArrayList<String>();
		if (objArr != null) {
			for (String obj : objArr) {
				this.addCompatibleObject(obj);
			}
		}
	}
	//Add compatible objects as the sceneObjects are being added
	public void addCompatibleObject(String s) {
		this.compatibleObjects.add(s);
	}
	
	public boolean searchCompatability(String s) {
		for (String obj : this.compatibleObjects) {
			if (s.equals(obj)) {
				return true;
			}
		}
		return false;
	}
}