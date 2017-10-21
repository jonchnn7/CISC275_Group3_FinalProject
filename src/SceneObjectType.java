import java.util.ArrayList;

public enum SceneObjectType {
	AlphaItem ();
	//Add in new sceneObjects here as they are created
	
	ArrayList<String> compatibleObjects;
	
	SceneObjectType() {
		this.compatibleObjects = new ArrayList<String>();
	}
	//Add compatible objects as the sceneObjects are being added
	public void addCompatibleObject(String s) {
		this.compatibleObjects.add(s);
	}
	
	public boolean searchCompatability(String s) {
		for (String obj : this.compatibleObjects) {
			if (s.getClass().equals(obj.getClass())) {
				return true;
			}
		}
		return false;
	}
}
