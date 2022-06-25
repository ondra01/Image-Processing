package view;

import java.io.IOException;

/**
 * This interface represents operations that should be offered by a view for Image Processing
 * Application.
 */
public interface TextView {

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  void renderMessage(String message) throws IOException;
}
