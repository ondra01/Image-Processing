package view;

/**
 * This interface represents a GUI view for the game of marble solitaire.
 */
public interface ImageProcessorGuiView {
  /**
   * Refresh the screen. This is called when the something on the
   * screen is updated and therefore it must be redrawn.
   */
  void refresh();

  /**
   * Display a message in a suitable area of the GUI.
   * @param message the message to be displayed
   */
  void renderMessage(String message);

  /**
   * Simply pass on the feature object to the panel.
   * @param feature to pass to panel.
   */
  //void acceptFeature(Feature feature);
}
