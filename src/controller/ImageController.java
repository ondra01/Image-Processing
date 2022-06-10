package controller;

import model.Image;
import model.Pixel;

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

  /**
   * Read an image file in the PPM format and convert it to a 2 dimensional Pixel array.
   *
   * @param filePathName the path of the file.
   * @return a 2 dimensional Pixel array representing the loaded image.
   */
   Pixel[][] loadImage(String filePathName);

  void saveImage(String filePathName, Image imageToSave);
}