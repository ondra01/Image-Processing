package controller;

import java.io.IOException;
import java.util.Scanner;

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
   * DEPRECATED: Read an image file in the PPM format and convert it to a 2 dimensional Pixel array.
   * Use loadImage2(String filePathName) instead.
   *
   * @param filePathName the path of the file.
   * @return a 2 dimensional Pixel array representing the loaded image.
   */
  Pixel[][] loadImage(String filePathName);

  /**
   * Save an Image to a file in any common format.
   *
   * @param filePathName the path of the file.
   * @param imageToSave the Image to save.
   */
  void saveImage(String filePathName, Image imageToSave);

  /**
   * Read an image file in any common format and convert it to a 2 dimensional Pixel array.
   *
   * @param filePathName the path of the file.
   * @return a 2 dimensional Pixel array representing the loaded image.
   */
  Pixel[][] loadImage2(String filePathName) throws IOException;

  public void meatOfRunApplication(Scanner sc, String inputInfo) throws IOException;
}