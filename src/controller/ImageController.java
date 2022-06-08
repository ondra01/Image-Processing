package controller;

/**
 * Represents a controller for an Image Processing Application.
 */
public interface ImageController {

  /**
   * Utilizes a view and model to run an Image Processing Application. It throws an
   * IllegalStateException only if the controller is unable to successfully read input or transmit
   * output.
   */
  void runApplication() throws IllegalStateException;
}