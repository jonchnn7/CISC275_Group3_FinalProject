package cisc275.group3.utility;

public enum LayerCodeTutorial {
  ButtonMap(70),
  LabelToolsSpeech(70), ToolsPanel(71),
  ButtonTools(60), LabelToolsArrow(61),
  LabelInventoryArrow(50), LabelInventorySpeech(51),
  ButtonInventory(40), Inventory(41),
  ButtonContinue(32), LabelObjective(33), 
  LabelObjectiveSpeech(30), LabelObjectiveArrow(31),
  ButtonGetMission(20),LabelGetMission(21),
  MainTop(10),
  TitleScreen(-1), TutorialScreen(-2), ControllerHQ(-3),
  ButtonGetMissionHidden(-10), LabelGetMissionHidden(-11),
  ButtonContinueHidden(-20), LabelObjectiveHidden(-21), 
  LabelObjectiveSpeechHidden(-22), LabelObjectiveArrowHidden(-23),
  ButtonInventoryHidden(-30), InventoryHidden(-31),
  LabelInventoryArrowHidden(-40), LabelInventorySpeechHidden(-41),
  ButtonToolsHidden(-50), LabelToolsArrowHidden(-51),
  LabelToolsSpeechHidden(-52), ToolsPanelHidden(-53),
  ButtonMapHidden(-60);
  
  private final int code;
  
  LayerCodeTutorial(int code) {
    this.code = code;
  }
  
  public int getCode() {
    return code;
  }
}
