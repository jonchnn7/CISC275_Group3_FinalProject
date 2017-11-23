package cisc275.group3.model.scene;

/**
 * Imparts time dynamics to attached classes.
 * <p>
 * Filename chosen so all properties appear 
 * together in workspace browser.
 * <p>
 * PropertyTimed.java
 * <p>
 * @author Scott <p>
 */
public interface PropertyTimed {
  public int getTime();
  public void updateTime();
  public void resetTime();
}
