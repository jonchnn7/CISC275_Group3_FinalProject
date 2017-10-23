import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

//NEED TO CHANGE PROCCESS CLICK IF THIS IS GOING TO EXTEND SCENE

//in game active_scenes.put("Inventory", new Inventory(SCREEN_WIDTH, SCREEN_HEIGHT));

public class Inventory extends Scene{
	
	//ArrayList<SceneObject> inventory_items = new ArrayList<SceneObject>(); Add once we figure out item types

	public Inventory(int interface_width, int width, int height) {
		super(interface_width, width, height, "Inventory");
		this.scene_background = Color.ORANGE;
		this.visible = true;
		this.time = 300;
		this.fillScene();
	}
	
	protected void fillScene()
	{
		this.scene_items = new ArrayList<SceneObject>();
		int temp_x = 300;
		int temp_y = 300;
		
		for (int i=0; i < 30; i++)
		{
			this.scene_items.add(new AlphaItem(temp_x,temp_y,50,50,0));
			
			temp_x = temp_x + 70;
			if (temp_x >= 980)
			{
				temp_x = 300;
				temp_y = temp_y + 70;
			}
		}
		
		Collections.sort(this.scene_items);
	}

	/* Should end up being something like this
	protected void fillScene() {
		this.scene_items = new ArrayList<SceneObject>();
	
		int temp_x = 300;
		int temp_y = 300;
		
		for (SceneObject k : inventory_items)
		{
			this.scene_items.add(new SceneObject(temp_x, temp_y, 50, 50, k.type));
			
			temp_x = temp_x + 70;
			if (temp_x >= 980)
			{
				temp_x = 300;
				temp_y = temp_y + 70;
			}
		}
		
	}*/

}