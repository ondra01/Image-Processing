package model;

/**
 * Represents the model in an MVC design of an Image Processing Application.
 */
public class ImageModelImpl implements ImageModel {
  private int height; //This is the number of rows.
  private int width; //This is the number of columns
  private Pixel[][] image;

  /**
   * Initializes the image stored by the model with the proper Pixels.
   */
  private void setUpImage() {

  }

  /**
   * Used to flip the Image horizontally. This does not change the size of the Image.
   */
  @Override
  public void flipHorizontally() {

  }

  /**
   * Used to flip the Image vertically. This does not change the size of the Image.
   */
  @Override
  public void flipVertically() {

  }

  /**
   * Used to brighten all the Pixels of an Image by a specified amount. If the amount is negative
   * then the image is being darkened. Positive means brightening. When changing the brightness of
   * the Pixels that make up an image the 0 <= x <= 255 color boundaries of each pixel are
   * respected, so no RGB value of a Pixel can exceed those.
   *
   * @param amount is the specified amount by which to brighten (or darken) the image.
   */
  @Override
  public void brightenBy(int amount) {

  }
}
