package cisc275.group3.utility;

public enum LayerCodeTutorial {
  ButtonGetMission(20),LabelGetMission(21),
  MainTop(10),
  TitleScreen(-1), TutorialScreen(-2), ControllerHQ(-3),
  ButtonGetMissionHidden(-10), LabelGetMissionHidden(-11);
  
  private final int code;
  
  LayerCodeTutorial(int code) {
    this.code = code;
  }
  
  public int getCode() {
    return code;
  }
}
