package cisc275.group3.utility;

public enum EnumGameState {
  Title(0), Tutorial(1),
  Play(2);
  
  private final int code;
  
  EnumGameState(int code) {
    this.code = code;
  }
  
  public int getCode() {
    return code;
  }
}
