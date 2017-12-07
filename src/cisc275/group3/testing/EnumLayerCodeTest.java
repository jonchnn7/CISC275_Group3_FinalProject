package cisc275.group3.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cisc275.group3.utility.EnumLayerCode;

public class EnumLayerCodeTest {

  /**
   * Ensures the layer codes have
   * not changed.
   */
  @Test
  public void contractTests() {
    System.out.println("  Testing Layer Code Enforcement");

    assertEquals("EndGame = 25", 25, EnumLayerCode.EndGame.getCode());
    assertEquals("MainTop = 20", 20, EnumLayerCode.MainTop.getCode());
    assertEquals("MissionRequest = 16", 16, EnumLayerCode.MissionRequest.getCode());
    assertEquals("MissionFact = 15", 15, EnumLayerCode.MissionFact.getCode());
    assertEquals("InventoryOverlay = 14", 14, EnumLayerCode.InventoryOverlay.getCode());
    assertEquals("InventoryButton = 13", 13, EnumLayerCode.InventoryButton.getCode());
    assertEquals("Mission = 12", 12, EnumLayerCode.Mission.getCode());
    assertEquals("MapButton = 11", 11, EnumLayerCode.MapButton.getCode());
    assertEquals("MapOverlay = 10", 10, EnumLayerCode.MapOverlay.getCode());
    assertEquals("MainMap = 9", 9, EnumLayerCode.MainMap.getCode());
    assertEquals("ToolsButton = 8", 8, EnumLayerCode.ToolsButton.getCode());
    assertEquals("ToolsOverlay = 7", 7, EnumLayerCode.ToolsOverlay.getCode());
    assertEquals("MainMapTools = 5", 5, EnumLayerCode.MainMapTools.getCode());
    assertEquals("TimeLabel = 4", 4, EnumLayerCode.TimeLabel.getCode());
    assertEquals("MainMapToolsTime = 3", 3, EnumLayerCode.MainMapToolsTime.getCode());
    assertEquals("ScoreLabel = 2", 2, EnumLayerCode.ScoreLabel.getCode());
    assertEquals("MissionLabel = 1", 1, EnumLayerCode.MissionLabel.getCode());
    assertEquals("MainAll = 0", 0, EnumLayerCode.MainAll.getCode());
    assertEquals("Bay = -2", -2, EnumLayerCode.Bay.getCode());
    assertEquals("Beach = -3", -3, EnumLayerCode.Beach.getCode());
    assertEquals("BeachMini = -4", -4, EnumLayerCode.BeachMini.getCode());
    assertEquals("HQ = -6",-6, EnumLayerCode.HQ.getCode());
    assertEquals("Inventory = -7", -7, EnumLayerCode.Inventory.getCode());
    assertEquals("Map = -9", -9, EnumLayerCode.Map.getCode());
    assertEquals("Title = -10", -10, EnumLayerCode.Title.getCode());
    assertEquals("Tools = -11", -11, EnumLayerCode.Tools.getCode());
    assertEquals("Wetland = -13", -13, EnumLayerCode.Wetland.getCode());
    assertEquals("MissionHide = -15", -15, EnumLayerCode.MissionHide.getCode());
    assertEquals("MissionFactHide = -16", -16, EnumLayerCode.MissionFactHide.getCode());
    assertEquals("MissionRequestHide = -17", -17, EnumLayerCode.MissionRequestHide.getCode());
    assertEquals("EndGameHide = -18", -18, EnumLayerCode.EndGameHide.getCode());
  }
}
