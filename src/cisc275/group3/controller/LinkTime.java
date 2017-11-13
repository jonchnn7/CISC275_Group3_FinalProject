package cisc275.group3.controller;

/**
 * Simple interface for controllers/models that
 * require a time update every second.
 * <p>
 * The design goal was to show relevant behavior
 * in the definitions of implementing classes.
 * <p>
 * LinkTime.java
 * <p>
 * @author Scott
 */
public interface LinkTime {
  void updateTime();
  void displayTime();
}
