package cisc275.group3.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cisc275.group3.utility.EnumLayerCodeTutorial;

public class EnumLayerCodeTutorialTest {

  /**
   * Ensures the layer codes have
   * not changed.
   */
  @Test
  public void contractTests() {
    System.out.println("  Testing Layer Code Enforcement");
    
    assertEquals("ButtonMap = 90", 90, EnumLayerCodeTutorial.ButtonMap.getCode());
    assertEquals("LabelMapArrow = 88", 88, EnumLayerCodeTutorial.LabelMapArrow.getCode());
    assertEquals("LabelScore = 80", 80, EnumLayerCodeTutorial.LabelScore.getCode());
    assertEquals("LabelTime = 85", 85, EnumLayerCodeTutorial.LabelTime.getCode());
    assertEquals("LabelScoreArrow = 86", 86, EnumLayerCodeTutorial.LabelScoreArrow.getCode());
    assertEquals("LabelTimeArrow = 87", 87, EnumLayerCodeTutorial.LabelTimeArrow.getCode());
    assertEquals("LabelMapSpeech = 81", 81, EnumLayerCodeTutorial.LabelMapSpeech.getCode());
    assertEquals("LabelToolsSpeech = 70", 70, EnumLayerCodeTutorial.LabelToolsSpeech.getCode());
    assertEquals("ToolsPanel = 71", 71, EnumLayerCodeTutorial.ToolsPanel.getCode());
    assertEquals("ButtonTools = 60", 60, EnumLayerCodeTutorial.ButtonTools.getCode());
    assertEquals("LabelToolsArrow = 61", 61, EnumLayerCodeTutorial.LabelToolsArrow.getCode());
    assertEquals("LabelInventoryArrow = 50", 50, EnumLayerCodeTutorial.LabelInventoryArrow.getCode());
    assertEquals("LabelInventorySpeech = 51", 51, EnumLayerCodeTutorial.LabelInventorySpeech.getCode());
    assertEquals("ButtonInventory = 40", 40, EnumLayerCodeTutorial.ButtonInventory.getCode());
    assertEquals("Inventory = 41", 41, EnumLayerCodeTutorial.Inventory.getCode());
    assertEquals("ButtonContinue = 32", 32, EnumLayerCodeTutorial.ButtonContinue.getCode());
    assertEquals("LabelObjective = 33", 33, EnumLayerCodeTutorial.LabelObjective.getCode());
    assertEquals("LabelObjectiveSpeech = 30", 30, EnumLayerCodeTutorial.LabelObjectiveSpeech.getCode());
    assertEquals("LabelObjectiveArrow = 31", 31, EnumLayerCodeTutorial.LabelObjectiveArrow.getCode());
    assertEquals("ButtonGetMission = 20", 20, EnumLayerCodeTutorial.ButtonGetMission.getCode());
    assertEquals("LabelGetMission = 21", 21, EnumLayerCodeTutorial.LabelGetMission.getCode());
    assertEquals("ButtonGetScoreTime = 17",17, EnumLayerCodeTutorial.ButtonGetScoreTime.getCode());
    assertEquals("LabelScoreTimeSpeech = 14", 14, EnumLayerCodeTutorial.LabelScoreTimeSpeech.getCode());
    assertEquals("MainTop = 10", 10, EnumLayerCodeTutorial.MainTop.getCode());
    assertEquals("TitleScreen = -1", -1, EnumLayerCodeTutorial.TitleScreen.getCode());
    assertEquals("TutorialScreen = -2", -2, EnumLayerCodeTutorial.TutorialScreen.getCode());
    assertEquals("ControllerHQ = -3", -3, EnumLayerCodeTutorial.ControllerHQ.getCode());
    assertEquals("ButtonGetMissionHidden = -10", -10, EnumLayerCodeTutorial.ButtonGetMissionHidden.getCode());
    assertEquals("LabelGetMissionHidden = -11", -11, EnumLayerCodeTutorial.LabelGetMissionHidden.getCode());
    assertEquals("LabelTimeArrowHidden = -15", -15, EnumLayerCodeTutorial.LabelTimeArrowHidden.getCode());
    assertEquals("LabelScoreTimeSpeechHidden = -14", -14, EnumLayerCodeTutorial.LabelScoreTimeSpeechHidden.getCode());
    assertEquals("ButtonGetScoreTimeHidden = -17", -17, EnumLayerCodeTutorial.ButtonGetScoreTimeHidden.getCode());
    assertEquals("LabelScoreArrowHidden = -16", -16, EnumLayerCodeTutorial.LabelScoreArrowHidden.getCode());
    assertEquals("ButtonContinueHidden = -20", -20, EnumLayerCodeTutorial.ButtonContinueHidden.getCode());
    assertEquals("LabelObjectiveHidden = -21", -21, EnumLayerCodeTutorial.LabelObjectiveHidden.getCode());
    assertEquals("LabelObjectiveSpeechHidden = -22", -22, EnumLayerCodeTutorial.LabelObjectiveSpeechHidden.getCode());
    assertEquals("LabelObjectiveArrowHidden = -23", -23, EnumLayerCodeTutorial.LabelObjectiveArrowHidden.getCode());
    assertEquals("ButtonInventoryHidden = -30", -30, EnumLayerCodeTutorial.ButtonInventoryHidden.getCode());
    assertEquals("InventoryHidden = -31", -31, EnumLayerCodeTutorial.InventoryHidden.getCode());
    assertEquals("LabelInventoryArrowHidden = -40", -40, EnumLayerCodeTutorial.LabelInventoryArrowHidden.getCode());
    assertEquals("LabelInventorySpeechHidden = -41", -41, EnumLayerCodeTutorial.LabelInventorySpeechHidden.getCode());
    assertEquals("ButtonToolsHidden = -50", -50, EnumLayerCodeTutorial.ButtonToolsHidden.getCode());
    assertEquals("LabelToolsArrowHidden = -51", -51, EnumLayerCodeTutorial.LabelToolsArrowHidden.getCode());
    assertEquals("LabelToolsSpeechHidden = -52", -52, EnumLayerCodeTutorial.LabelToolsSpeechHidden.getCode());
    assertEquals("ToolsPanelHidden = -53", -53, EnumLayerCodeTutorial.ToolsPanelHidden.getCode());
    assertEquals("ButtonMapHidden = -60", -60, EnumLayerCodeTutorial.ButtonMapHidden.getCode());
    assertEquals("Tools = -70", -70, EnumLayerCodeTutorial.Tools.getCode());
    assertEquals("LabelScoreHidden = -80", -80, EnumLayerCodeTutorial.LabelScoreHidden.getCode());
    assertEquals("LabelTimeHidden = -85", -85, EnumLayerCodeTutorial.LabelTimeHidden.getCode());
    assertEquals("LabelMapSpeechHidden = -81", -81, EnumLayerCodeTutorial.LabelMapSpeechHidden.getCode());
    assertEquals("LabelMapArrowHidden = -88", -88, EnumLayerCodeTutorial.LabelMapArrowHidden.getCode());
  }
  
}