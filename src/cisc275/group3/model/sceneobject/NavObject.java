package cisc275.group3.model.sceneobject;

import java.awt.geom.Ellipse2D;

import cisc275.group3.utility.ObjectId;

public class NavObject extends SceneObject{
	
	private String location;
	
	//Extended Required Constructor
	public NavObject(ObjectId id, double x, double y) {
		super(id, x, y);
	}
	
	//Full Constructor
	public NavObject(double x, double y, String loc) {
		//Depth, height, object type?, image file, name, width, x, y
		super(new ObjectId(0,100, 0, "NONE", "NavObject", 100), x, y);
		location = loc;
	}
	
	public String toString() {
		return location;
	}
	
	public String navClick() {
		return this.location;
	}
	
	

}
