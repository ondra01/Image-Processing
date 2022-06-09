package model;

/**
 * This interface represents operations that can be used to mutate the state of an Image Processor
 * Application which can contain multiple Images, all of which are mapped to a String name which
 * represents them.
 */
public interface ImageProcessingModel {

  /**
   *
   *
   * @param filename
   * @param image
   */
  void addImage(String filename, Image image);

  Image getImage(String filename);

  /**
   * Used to flip the Image horizontally. This does not change the size of the Image.
   */
  void flipHorizontally(String original, String altered);

  /**
   * Used to flip the Image vertically. This does not change the size of the Image.
   *
   * @return
   */
  void flipVertically(String original, String altered);

  /**
   * Used to brighten all the Pixels of an Image by a specified amount. If the amount is negative
   * then the image is being darkened. Positive means brightening. When changing the brightness of
   * the Pixels that make up an image the 0 <= x <= 255 color boundaries of each pixel are
   * respected, so no RGB value of a Pixel can exceed those.
   *
   * @param amount is the specified amount by which to brighten (or darken) the image.
   */
  void brightenBy(int amount, String original, String altered);

  /**
   * Visualizes the red channel of an image by creating a greyscale image, where the RGB components
   * of the pixels are equal to the specific red channel value of that pixel in the original image.
   * For example, if a pixel in the original image has the color (120,234,23), then the
   * corresponding pixel to visualize the red component would have the color (120,120,120).
   */
  void redToGreyScale(String original, String altered);

  /**
   * Visualizes the green channel of an image by creating a greyscale image, where the RGB components
   * of the pixels are equal to the specific green channel value of that pixel in the original image.
   * For example, if a pixel in the original image has the color (120,234,23), then the
   * corresponding pixel to visualize the green component would have the color (120,120,120).
   */
  void greenToGreyScale(String original, String altered);

  /**
   * Visualizes the blue channel of an image by creating a greyscale image, where the RGB components
   * of the pixels are equal to the specific blue channel value of that pixel in the original image.
   * For example, if a pixel in the original image has the color (120,234,23), then the
   * corresponding pixel to visualize the blue component would have the color (120,120,120).
   */
  void blueToGreyScale(String original, String altered);

}
