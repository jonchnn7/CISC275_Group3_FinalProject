package cisc275.group3.utility;

/**
 * Defines layer/depth codes for the main JLayeredPane.
 * <p>
 * @author Scott
 */
public enum LayerCode {
  MapButton(11), MapOverlay(10), MainMap(9), // Layers for Map + Game Only
  ToolsButton(8), ToolsOverlay(7), MainMapTools(5), // Layers for Map + Tools + Game
  TimeLabel(4), MainToolsTime(3), // Layers for Map + Tools + Time + Game 
  ScoreLabel(2), MainAll(1), // Layers for Time + Score + Game with all the fixins
  Bay(-1), Beach(-3), BeachMini(-4), HQ(-5), Inventory(-7), // "Hidden" Layers
  Map(-9), Title(-10), Tools(-11), Wetlands(-13); // "Hidden" Layers

  private final int code;
  
  LayerCode(int code) {
    this.code = code;
  }
  
  public int getCode() {
    return code;
  }
}
