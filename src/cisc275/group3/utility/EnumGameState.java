package cisc275.group3.utility;

public enum EnumGameState {
  Title(0), Tutorial(1), IN_Tutorial(2),
  Play(3), IN_Game(4), EndGame(5);
  
  private final int code;
  
  EnumGameState(int code) {
    this.code = code;
  }
  
  public int getCode() {
    return code;
  }
}
