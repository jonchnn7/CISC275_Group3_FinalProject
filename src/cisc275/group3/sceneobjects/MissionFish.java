package cisc275.group3.sceneobjects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MissionFish extends SceneImageObject{

	public MissionFish(int x, int y, int d) {
		super(x, y, d);
		System.out.println("MISSION FISH");
		File file = new File("images/Fish_left_1_Test.png");
		System.out.println( file.exists() );
		BufferedImage originalImage, resizedImage;
		try {	
			//Attempt at resizing the images on the fly
//		    originalImage = ImageIO.read(file);
//			resizedImage = new BufferedImage(100, 100, originalImage.getType());
//			Graphics2D g = image.createGraphics();
//			g.drawImage(originalImage, 0, 0, 100, 100, null);
//			g.dispose();

		    image = ImageIO.read(file);
		} catch (IOException e) {
		}
		
		//this.item_width = image.getWidth();
		//this.item_height = image.getHeight();

		this.name = "Mission Fish";
	}
}
