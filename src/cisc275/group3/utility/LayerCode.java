package cisc275.group3.utility;

/**
 * Defines layer/depth codes for the main JLayeredPane.
 */
public enum LayerCode {
  MapButton(11), MapOverlay(10), MainMap(9), // Layers for Map + Game Only
  ToolsButton(8), ToolsOverlay(7), MainMapTools(5), // Layers for Map + Tools + Game
  Title(0), Bay(-1), Beach(-3), BeachMini(-4), HQ(-5), // "Hidden" Layers
  Inventory(-7), Map(-9), Tools(-11), Wetlands(-13); // "Hidden" Layers

  private final int code;
  
  LayerCode(int code) {
    this.code = code;
  }
  
  public int getCode() {
    return code;
  }
}
