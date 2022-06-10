package model;

public interface Image {

  /**
   * Retrieves the number of columns of Pixels in an Image.
   *
   * @return the width of an Image.
   */
  int getWidth();

  /**
   * Retrieves the number of rows of Pixels in an Image.
   *
   * @return the height of an Image.
   */
  int getHeight();

  Pixel getPixel(int row, int col);

  /**
   * Used to flip the Image horizontally. This does not change the size of the Image.
   */
  Image flipHorizontally();

  /**
   * Used to flip the Image vertically. This does not change the size of the Image.
   *
   * @return
   */
  Image flipVertically();

  /**
   * Used to brighten all the Pixels of an Image by a specified amount. If the amount is negative
   * then the image is being darkened. Positive means brightening. When changing the brightness of
   * the Pixels that make up an image the 0 <= x <= 255 color boundaries of each pixel are
   * respected, so no RGB value of a Pixel can exceed those.
   *
   * @param amount is the specified amount by which to brighten (or darken) the image.
   */
  Image brightenBy(int amount);

  /**
   * Visualizes the red channel of an image by creating a greyscale image, where the RGB components
   * of the pixels are equal to the specific red channel value of that pixel in the original image.
   * For example, if a pixel in the original image has the color (120,234,23), then the
   * corresponding pixel to visualize the red component would have the color (120,120,120).
   */
  Image redToGreyScale();

  /**
   * Visualizes the green channel of an image by creating a greyscale image, where the RGB components
   * of the pixels are equal to the specific green channel value of that pixel in the original image.
   * For example, if a pixel in the original image has the color (120,234,23), then the
   * corresponding pixel to visualize the green component would have the color (120,120,120).
   */
  Image greenToGreyScale();

  /**
   * Visualizes the blue channel of an image by creating a greyscale image, where the RGB components
   * of the pixels are equal to the specific blue channel value of that pixel in the original image.
   * For example, if a pixel in the original image has the color (120,234,23), then the
   * corresponding pixel to visualize the blue component would have the color (120,120,120).
   */
  Image blueToGreyScale();
}
