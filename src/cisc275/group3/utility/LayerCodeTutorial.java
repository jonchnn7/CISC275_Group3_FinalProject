package cisc275.group3.utility;

public enum LayerCodeTutorial {
  ButtonInventory(40), Inventory(41),
  ButtonContinue(32), LabelObjective(33), 
  LabelObjectiveSpeech(30), LabelObjectiveArrow(31),
  ButtonGetMission(20),LabelGetMission(21),
  MainTop(10),
  TitleScreen(-1), TutorialScreen(-2), ControllerHQ(-3),
  ButtonGetMissionHidden(-10), LabelGetMissionHidden(-11),
  ButtonContinueHidden(-20), LabelObjectiveHidden(-21), 
  LabelObjectiveSpeechHidden(-22), LabelObjectiveArrowHidden(-23),
  ButtonInventoryHidden(-30), InventoryHidden(-31);
  
  
  private final int code;
  
  LayerCodeTutorial(int code) {
    this.code = code;
  }
  
  public int getCode() {
    return code;
  }
}
