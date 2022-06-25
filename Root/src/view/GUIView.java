package view;

import java.awt.event.ActionListener;

import controller.Features;

/**
 * This interface represents a GUI view for the game of marble solitaire.
 */
public interface GUIView extends TextView {
  /*
   * Refresh the screen. This is called when the something on the
   * screen is updated and therefore it must be redrawn.
   */
  //void refresh();

  /**
   * Display a message in a suitable area of the GUI.
   * @param message the message to be displayed
   */
  void renderMessage(String message);

  void renderApplication();

  void setListener(ActionListener listener);

  void setFileOpenDisplay(String filepath);

  void setFileSaveDisplay(String filepath);

  /**
   * Simply pass on the feature object to the panel.
   * @param feature to pass to panel.
   */
  void acceptFeatures(Features feature);

  String getFilePath(boolean isLoad);

  String getUserGivenName();

  void displayImage(String userGivenName);

  String getOriginalName();

  String getAlteredName();

  void setSelectedImage(String imageFilePath);
}
