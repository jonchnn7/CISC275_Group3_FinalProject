package cisc275.group3.utility;

/**
 * Defines layer/depth codes for the main JLayeredPane.
 */
public enum LayerCode {
  OverlayMap(9), OverlayTools(7), Main(5), Title(0), Bay(-1), Beach(-3), 
  BeachMini(-4), HQ(-5), Inventory(-7), Map(-9), Tools(-11), Wetlands(-13);

  private final int code;
  
  LayerCode(int code) {
    this.code = code;
  }
  
  public int getCode() {
    return code;
  }
}
