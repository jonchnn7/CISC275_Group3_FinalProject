import cisc275.group3.controller.GameController;


public class ClickAdventure {
		 
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new GameController(1280, 720);
      }
    });
  }
}
