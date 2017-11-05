package cisc275.group3.utility;

/**
 * Defines layer/depth codes for the main JLayeredPane.
 */
public enum LayerCode {
  Overlay(7), Top(5), Bay(-1), Beach(-3), HQ(-5), 
  Inventory(-7), Map(-9), Title(-11), Wetlands(-13);

  private final int code;
  
  LayerCode(int code) {
    this.code = code;
  }
  
  public int getCode() {
    return code;
  }
}
