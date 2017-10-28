package cisc275.group3.view;

// Java Imports
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class View {
  
  
}


// Generics
// https://docs.oracle.com/javase/tutorial/extra/generics/intro.html

// Actions
// https://docs.oracle.com/javase/tutorial/uiswing/misc/action.html

// javax.swing.JLayer
// javax.swing.plaf.LayerUI
// https://docs.oracle.com/javase/tutorial/uiswing/misc/jlayer.html


/**Import Image
 * 
 *  import javax.imageio.ImageIO;
 * 
 *  BufferedImage image = null;
 *  try {
 *    image = ImageIO.read(new File("input.jpg"))};
 *  } catch (IOException e) { e.printStackTrace(); }
 */


/* Image as Button 
 *
 *   import javax.imageio.ImageIO;
 *   
 *   BufferedImage button_icon = null;
 *   try {
 *     button_icon = ImageIO.read(new File("myImage.png"));
 *   } catch (IOException e) { e.printStackTrace(); }
 *   
 *   button = new JButton(new ImageIcon(button_icon));
 *   button.setBorderPainted(false);
 *   button.setFocusPainted(false);
 *   button.setContentAreaFilled(false);
 * 
 *   Notes:
 *      throws IOException
 */


 /** Resize Image
  *   
  *   import java.awt.Image;
  *   import java.awt.Toolkit;
  * 
  *   img = kit.getImage(file);
  *   img = img.getScaledInstance(300, -1, Image.SCALE_SMOOTH);
  */
 