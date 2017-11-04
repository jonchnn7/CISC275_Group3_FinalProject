import cisc275.group3.controller.Controller;


public class ClickAdventure {
		 
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
    	  new Controller(1280, 720);
      }
    });
  }
}
