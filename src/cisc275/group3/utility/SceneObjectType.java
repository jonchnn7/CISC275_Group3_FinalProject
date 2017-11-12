package cisc275.group3.utility;

import java.util.ArrayList;

/**
 * @author Jolyne
 */
public enum SceneObjectType {
	BetaItem (new String[]{"camera"}),
	BetaFish (new String[]{"Net"});
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