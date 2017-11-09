package cisc275.group3.controller;

/**
 * Simple interface for controllers/models that
 * require an update on every tick of the timer.
 * <p>
 * The design goal was to show relevant behavior
 * in the definitions of implementing classes.
 * <p>
 * LinkDynamics.java
 * <p>
 * @author Scott
 */
public interface LinkDynamics {
  void update();
}
