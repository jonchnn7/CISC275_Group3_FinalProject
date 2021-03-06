package cisc275.group3.utility;

/**
 * This is where the information for the mission is kept.  This is where the target object for 
 * the mision is stored, as well as how many of that object and if the mission is done. 
 * <p>
 * Mission.java
 * <p>
 * @author Jolyne
 */
public class Mission {
	private String targetObject;
	private String objectName;
	private int objectNum;
	private boolean doneMission;
	private String targetNameForFact = "";
	
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
	
	public void setTargetNameForFact(String s)
	{
		targetNameForFact = s;
	}
	
	public String getTargetNameForFact()
	{
		return targetNameForFact;
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
		} else if (targetObject.equals("BetaHeron")) {
			if (objectName.equals("")) {
				s += "BetaHeron";
			} else {
				s += objectName;
			}
		}
		return s;
	}
}
