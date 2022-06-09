package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the model in an MVC design of an Image Processing Application.
 */
public class ImageProcessingModelImpl implements ImageProcessingModel {
//  private int height; //This is the number of rows.
//  private int width; //This is the number of columns
//  private Pixel[][] image;
  private Map<String, Image> savedImages;

  public ImageProcessingModelImpl() {
    savedImages = new HashMap<String, Image>();
  }

  /**
   * Initializes the image stored by the model with the proper Pixels.
   */
  private void setUpImage() {

  }


  /**
   * @param filename
   * @param image
   */
  @Override
  public void addImage(String filename, Image image) {
    savedImages.put(filename, image);
  }

  @Override
  public Image getImage(String filename) {
    return savedImages.get(filename);
  }

  /**
   * Used to flip the Image horizontally. This does not change the size of the Image.
   *
   * @param original
   * @param altered
   */
  @Override
  public void flipHorizontally(String original, String altered) {
    Image temp = savedImages.get(original);
    Image alteredTemp = temp.flipHorizontally();
    savedImages.put(altered, alteredTemp);
  }

  /**
   * Used to flip the Image vertically. This does not change the size of the Image.
   *
   * @param original
   * @param altered
   * @return
   */
  @Override
  public void flipVertically(String original, String altered) {

  }

  /**
   * Used to brighten all the Pixels of an Image by a specified amount. If the amount is negative
   * then the image is being darkened. Positive means brightening. When changing the brightness of
   * the Pixels that make up an image the 0 <= x <= 255 color boundaries of each pixel are
   * respected, so no RGB value of a Pixel can exceed those.
   *
   * @param amount   is the specified amount by which to brighten (or darken) the image.
   * @param original
   * @param altered
   */
  @Override
  public void brightenBy(int amount, String original, String altered) {

  }

  /**
   * Visualizes the red channel of an image by creating a greyscale image, where the RGB components
   * of the pixels are equal to the specific red channel value of that pixel in the original image.
   * For example, if a pixel in the original image has the color (120,234,23), then the
   * corresponding pixel to visualize the red component would have the color (120,120,120).
   *
   * @param original
   * @param altered
   */
  @Override
  public void redToGreyScale(String original, String altered) {

  }

  /**
   * Visualizes the green channel of an image by creating a greyscale image, where the RGB components
   * of the pixels are equal to the specific green channel value of that pixel in the original image.
   * For example, if a pixel in the original image has the color (120,234,23), then the
   * corresponding pixel to visualize the green component would have the color (120,120,120).
   *
   * @param original
   * @param altered
   */
  @Override
  public void greenToGreyScale(String original, String altered) {

  }

  /**
   * Visualizes the blue channel of an image by creating a greyscale image, where the RGB components
   * of the pixels are equal to the specific blue channel value of that pixel in the original image.
   * For example, if a pixel in the original image has the color (120,234,23), then the
   * corresponding pixel to visualize the blue component would have the color (120,120,120).
   *
   * @param original
   * @param altered
   */
  @Override
  public void blueToGreyScale(String original, String altered) {

  }
}
