package model;

import java.util.Map;

/**
 * Represents a 2 dimensional Image which has methods to create a new Image based on the data
 * stored by this Image.
 */
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
   * Visualizes the green channel of an image by creating a greyscale image, where the RGB
   * components of the pixels are equal to the specific green channel value of that pixel in the
   * original image. For example, if a pixel in the original image has the color (120,234,23), then
   * the corresponding pixel to visualize the green component would have the color (120,120,120).
   */
  Image greenToGreyScale();

  /**
   * Visualizes the blue channel of an image by creating a greyscale image, where the RGB components
   * of the pixels are equal to the specific blue channel value of that pixel in the original image.
   * For example, if a pixel in the original image has the color (120,234,23), then the
   * corresponding pixel to visualize the blue component would have the color (120,120,120).
   */
  Image blueToGreyScale();

  Image valueToGreyScale();

  Image intensityToGreyScale();

  Image lumaToGreyScale();

  Image applyFilter(Filter filter);

  Image greyscaleImage();

  Image sepiaToneImage();

  /**
   * A histogram is a table of (value,frequency) entries. For RGB color images there are 4
   * Histograms associated with an Image. One Histogram for each component and one for the
   * intensity (the average of all components). If the Image has been grey-scaled then all 4 of the
   * Histograms are the same.
   *
   * @return the HashMap representing the Histogram of the Red Pixel values.
   */
  Map<Integer, Integer> getRedHistogram();

  /**
   * A histogram is a table of (value,frequency) entries. For RGB color images there are 4
   * Histograms associated with an Image. One Histogram for each component and one for the
   * intensity (the average of all components). If the Image has been grey-scaled then all 4 of the
   * Histograms are the same.
   *
   * @return the HashMap representing the Histogram of the Green Pixel values.
   */
  Map<Integer, Integer> getGreenHistogram();

  /**
   * A histogram is a table of (value,frequency) entries. For RGB color images there are 4
   * Histograms associated with an Image. One Histogram for each component and one for the
   * intensity (the average of all components). If the Image has been grey-scaled then all 4 of the
   * Histograms are the same.
   *
   * @return the HashMap representing the Histogram of the Blue Pixel values.
   */
  Map<Integer, Integer> getBlueHistogram();

  /**
   * A histogram is a table of (value,frequency) entries. For RGB color images there are 4
   * Histograms associated with an Image. One Histogram for each component and one for the
   * intensity (the average of all components). If the Image has been grey-scaled then all 4 of the
   * Histograms are the same.
   *
   * @return the HashMap representing the Histogram of the Intensity (average) Pixel values.
   */
  Map<Integer, Integer> getIntensityHistogram();
}
