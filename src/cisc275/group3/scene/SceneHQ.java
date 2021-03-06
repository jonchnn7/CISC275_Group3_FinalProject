package cisc275.group3.scene;

import java.util.Collections;
import java.util.Iterator;

import cisc275.group3.controller.ControllerMission;
import cisc275.group3.sceneobject.ActionMove;
import cisc275.group3.sceneobject.ObjectPerson;
import cisc275.group3.sceneobject.SceneObject;
import cisc275.group3.utility.ConstructPerson;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.utility.SceneId;

/**
 * HQ scene/model.
 * <p>
 * The HQ scene implements scoring and timing functions via interface
 * implementations.
 * <p>
 * SceneHQ.java
 * <p>
 * 
 * @author Jon
 * @author Scott
 * @author Jolyne
 */
public class SceneHQ extends Scene {
	
	private int prevPerson;

	public SceneHQ(SceneId mani) {
		super(mani);
		time = 0;
		prevPerson = 4;
	}

	/**
	 * Used when SceneId must also be created
	 * 
	 * @param n
	 *            String-scene name
	 * @param x
	 *            double-x-coordinate of upper left corner
	 * @param y
	 *            double-y-coordinate of upper left corner
	 * @param w
	 *            double-scene width
	 * @param h
	 *            double-scene height
	 * @param bg
	 *            String-file location of bg image
	 * @param sceneType
	 *            EnumSceneType-type of scene
	 */
	public SceneHQ(String n, double x, double y, double w, double h, String bg, EnumSceneType sceneType) {
		this(new SceneId(n, x, y, w, h, sceneType, bg));
	}

	/**
	 * Required by Scene.java
	 */
	@Override
	protected void fillScene() {
	}
	
	/**
	 * @return a variable indicating the type of the previously generated person
	 */
	public int getPrevPerson() {
		return prevPerson;
	}
	

	/**
	 * Overridden from Scene.java abstract method. People are generated that will be
	 * linked to their respective mission
	 * <p>
	 * Each person moves from right to left, stops in the middle of the screen until
	 * the mission is initialized and completed, then moves off the right side of
	 * the screen.
	 */
	@Override
	public void update() {
		if (this.getManifest().getSceneType() == EnumSceneType.DEFAULT) {
			if (sceneItems.size() < 1) {
				int x = randGen.nextInt(4);
				while (x == prevPerson) {
					x = randGen.nextInt(4);
				}
				
				ControllerMission.setPersonID(x);
				sceneItems.add(ConstructPerson.constructPerson(randGen.nextInt(20) - 10, // depth
						x, // type
						getManifest().getWidth(), // x location
						getManifest().getHeight()/4)); // y location
				prevPerson = x;
			}
			// Move Person
			for (SceneObject person : sceneItems) {
				if ((person.getLocation().getX() < 600) && ((((ObjectPerson) person).getStatus()) == 1) && ((Scene.getCurrentMission().getObjectNum() == 0) || (Scene.getCurrentMission().getObjectNum() == -1) || (Scene.getCurrentMission().getObjectNum() == -4))) {
					((ObjectPerson) person).setStatus(0);
				} else if ((Scene.getCurrentMission().getObjectNum() == -5) && ((((ObjectPerson) person).getStatus()) == 0) || (((ObjectPerson) person).getStatus()) == -1) {
					((ObjectPerson) person).setStatus(-1);
					Scene.getCurrentMission().setObjectNum(-4);
				}
				((ActionMove) person).move();
			}

			// Remove Off-screen Person
			removePerson();

			// Sort by depth
			Collections.sort(sceneItems);
		}
	}

	/**
	 * Removes persons that are off-screen
	 */
	private void removePerson() {
		for (Iterator<SceneObject> iterator = sceneItems.iterator(); iterator.hasNext();) {
			ObjectPerson person = (ObjectPerson) iterator.next();

			if (person.getLocation().getX() >= (manifest.getWidth())) {
				iterator.remove();
			}
		}
	}
	
	/**
	 * @return if the mission button is clickable (person is not moving)
	 */
	public boolean isMissionClickable() {
		if(sceneItems.size() == 1) {
			if(((ObjectPerson)sceneItems.get(0)).getStatus() == 0) {
				return true;
			}
		}
		
		return false;
	}
}
