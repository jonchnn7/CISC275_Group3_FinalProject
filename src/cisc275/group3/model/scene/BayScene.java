package cisc275.group3.model.scene;

import java.util.ArrayList;

import cisc275.group3.model.sceneobject.FishAlpha;
import cisc275.group3.utility.ObjectId;
import cisc275.group3.utility.SceneId;



public class BayScene extends Scene implements PropertyScored, PropertyTimed {
  
  // Fish File Locations
  private static final String[] FISH_LEFT_FILES = 
	    {"/fish_left_1.png", "/fish_left_2.png", "/fish_left_3.png"};
  private static final String[] FISH_RIGHT_FILES = 
	    {"/fish_right_1.png", "/fish_right_2.png", "/fish_right_3.png"};
  
  // Fish Names
  private static final String[] FISH_LEFT_NAMES = 
    {"Butterflyfish", "Rainbow Cichlid", "Goldfish"};
  private static final String[] FISH_RIGHT_NAMES = 
	{"Angelfish", "Threadfin Butterflyfish", "Sergeant Major"};
  
  // Fish Dimensions
  private static final int[] FISH_LEFT_LENGTH = {35, 25, 10};
  private static final int[] FISH_RIGHT_LENGTH = {25, 35, 10};
  
  // Fish Aspect Ratios
  private static final double[] FISH_LEFT_AR = {0.6367, 0.7898, 0.5828};
  private static final double[] FISH_RIGHT_AR = {0.7047, 0.7453, 0.6};
  
  // Fish ID Numbers
  private static final int[] FISH_LEFT_ID = {1, 2, 3};
  private static final int[] FISH_RIGHT_ID = {4, 5, 6};
  

  public BayScene(boolean click, SceneId mani, boolean vis) {
    super(click, mani, vis);
    time = 350;
    
    fillScene();
  }
  
  private void fillScene() {
    for (int i=0; i<5; i++) {
      int fishType = rand_gen.nextInt(3);
      
      // Create Left Fish ID
      ObjectId leftFishId = createLeftFishId(i+1, fishType);
      
      // Create Right Fish ID
      ObjectId rightFishId = createRightFishId((-1*i), fishType);
      
      // Add Left Fish to Scene
      scene_items.add(new FishAlpha(
        leftFishId, // id
        manifest.getWidth(), // x location
        i*140 + manifest.getStart_y() + 10, // y location
        20, // speed x
        0, // speed y
        true)); // left moving fish?
      
      scene_items.add(new FishAlpha(
        rightFishId, //id
        0, // x location
        i*140 + manifest.getStart_y() + 10, // y location
        20, // speed x
        0, // speed y
        false)); // left moving fish?
    }
  }
  
  private ObjectId createLeftFishId(int dpth, int fishType) {
	// Create Left Fish ID
    ObjectId leftFishId = new ObjectId(
      dpth, // depth
      (int)(FISH_LEFT_LENGTH[fishType]*FISH_LEFT_AR[fishType]), // height
      FISH_LEFT_ID[fishType], // id
      FISH_LEFT_FILES[fishType], // image file
      FISH_LEFT_NAMES[fishType], // name
      FISH_LEFT_LENGTH[fishType] ); // width
	
    return leftFishId;
  }
  
  private ObjectId createRightFishId(int dpth, int fishType) {
	// Create Right Fish ID
    ObjectId rightFishId = new ObjectId(
      dpth, // depth
      (int)(FISH_RIGHT_LENGTH[fishType]*FISH_RIGHT_AR[fishType]), // height
      FISH_RIGHT_ID[fishType], // id
      FISH_RIGHT_FILES[fishType], // image file
      FISH_RIGHT_NAMES[fishType], // name
      FISH_RIGHT_LENGTH[fishType] );
    
    return rightFishId;
  }
  
  @Override
  public int getTime() {
  	return time;
  }

  @Override
  public int getScore() {
  	return score;
  }

  @Override
  public void updateScore() {
  	// TODO Auto-generated method stub
  }
}
/*
	private void fillScene() {		
		for (int j=0; j<5; j++) {
			int length = rand_gen.nextInt(20) + 15;
			scene_items.add(new FishAlpha(0-length, 
				j*140 + this.start_y + 10,
				length,
				length/2,
	  		    j+1,
				true));
			scene_items.add(new AlphaFish(this.scene_width+length, 
				j*140 + this.start_y + 10,
				length,
				length/2,
				-1*j-1,
				false));
		
		Collections.sort(scene_items);	
		}
	}
	
	public void move() {
		int length = rand_gen.nextInt(20) + 15;
		
		// Generate new fish on ~4% of calls
		if (rand_gen.nextInt(25) == 1) {
			this.scene_items.add(new AlphaFish(0-length, 
                rand_gen.nextInt(this.scene_height) + this.start_y,
			    length,
				length/2,
				rand_gen.nextInt(10)+5,
				true));
			this.scene_items.add(new AlphaFish(this.scene_width+length, 
				rand_gen.nextInt(this.scene_height) + this.start_y,
				length,
				length/2,
				-1*rand_gen.nextInt(10)-5,
				false));		
		}
		
		for (SceneObject fish : scene_items)
			((AlphaFish)fish).move();
		
		removeFish();
	}
	
	private void removeFish() {
		for (Iterator<SceneObject> iterator = scene_items.iterator(); iterator.hasNext();) {
			AlphaFish fish = (AlphaFish)iterator.next();
			if ( fish.getLTR() && fish.getX() >= (this.scene_width+fish.getWidth()) ) {
				iterator.remove();
			
			} else if ( !fish.getLTR() && fish.getX() <= (0-fish.getWidth()) ) { 
				iterator.remove();
			}
		}
	}
*/