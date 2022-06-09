package model;

/**
 * This interface represents operations that can be used to mutate the state of an Image.
 */
public interface ImageModel extends ImageModelState {

  /**
   * Used to flip the Image horizontally. This does not change the size of the Image.
   */
  void flipHorizontally();

  /**
   * Used to flip the Image vertically. This does not change the size of the Image.
   */
  void flipVertically();

  /**
   * Used to brighten all the Pixels of an Image by a specified amount. If the amount is negative
   * then the image is being darkened. Positive means brightening. When changing the brightness of
   * the Pixels that make up an image the 0 <= x <= 255 color boundaries of each pixel are
   * respected, so no RGB value of a Pixel can exceed those.
   *
   * @param amount is the specified amount by which to brighten (or darken) the image.
   */
  void brightenBy(int amount);
}
