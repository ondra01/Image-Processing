package model;

/**
 * This interface represents operations that can be used to mutate the state of an Image Processor
 * Application which can contain multiple Images, all of which are mapped to a String name which
 * represents them.
 */
public interface ImageProcessingModel {

  /**
   * Adds an Image to be stored in the model.
   *
   * @param imageName is the key value (name) associated with the Image to be stored in the model.
   * @param image is the Image to be stored in the model.
   */
  void addImage(String imageName, Image image);

  /**
   * Gets an Image stored in the model.
   *
   * @param imageName is the key value (name) associated with the Image to get from the model. If
   *                  imageName is null or not present in the model then getImage returns null;
   * @return the Image associated with the imageName.
   */
  Image getImage(String imageName);

  /**
   * Used to flip the desired Image horizontally. This does not change the size of the Image.
   *
   * @param original is the key value (name) associated with an Image which stored in the model.
   * @param altered  is the key value (name) associated with the Image which will be created and
   *                 stored in the model by applying the desired change to the original Image.
   */
  void flipHorizontally(String original, String altered);

  /**
   * Used to flip the desired Image Vertically. This does not change the size of the Image.
   *
   * @param original is the key value (name) associated with an Image which stored in the model.
   * @param altered  is the key value (name) associated with the Image which will be created and
   *                 stored in the model by applying the desired change to the original Image.
   */
  void flipVertically(String original, String altered);

  /**
   * Used to brighten all the Pixels of an Image by a specified amount. If the amount is negative
   * then the image is being darkened. Positive means brightening. When changing the brightness of
   * the Pixels that make up an image the 0 <= x <= 255 color boundaries of each pixel are
   * respected, so no RGB value of a Pixel can exceed those.
   *
   * @param amount   is the specified amount by which to brighten (or darken) the image.
   * @param original is the key value (name) associated with an Image which stored in the model.
   * @param altered  is the key value (name) associated with the Image which will be created and
   *                 stored in the model by applying the desired change to the original Image.
   */
  void brightenBy(int amount, String original, String altered);

  /**
   * Visualizes the red channel of an image by creating a greyscale image, where the RGB components
   * of the pixels are equal to the specific red channel value of that pixel in the original image.
   * For example, if a pixel in the original image has the color (120,234,23), then the
   * corresponding pixel to visualize the red component would have the color (120,120,120).
   *
   * @param original is the key value (name) associated with an Image which stored in the model.
   * @param altered  is the key value (name) associated with the Image which will be created and
   *                 stored in the model by applying the desired change to the original Image.
   */
  void redToGreyScale(String original, String altered);

  /**
   * Visualizes the green channel of an image by creating a greyscale image, where the RGB
   * components of the pixels are equal to the specific green channel value of that pixel in the
   * original image. For example, if a pixel in the original image has the color (120,234,23), then
   * the corresponding pixel to visualize the green component would have the color (120,120,120).
   *
   * @param original is the key value (name) associated with an Image which stored in the model.
   * @param altered  is the key value (name) associated with the Image which will be created and
   *                 stored in the model by applying the desired change to the original Image.
   */
  void greenToGreyScale(String original, String altered);

  /**
   * Visualizes the blue channel of an image by creating a greyscale image, where the RGB components
   * of the pixels are equal to the specific blue channel value of that pixel in the original image.
   * For example, if a pixel in the original image has the color (120,234,23), then the
   * corresponding pixel to visualize the blue component would have the color (120,120,120).
   *
   * @param original is the key value (name) associated with an Image which stored in the model.
   * @param altered  is the key value (name) associated with the Image which will be created and
   *                 stored in the model by applying the desired change to the original Image.
   */
  void blueToGreyScale(String original, String altered);

  /**
   * Visualizes the value channel of an image by creating a greyscale image, where the RGB
   * components
   * of the pixels are equal to the specific value channel value of that pixel in the original
   * image.
   * For example, if a pixel in the original image has the color (120,234,23), then the
   * corresponding pixel to visualize the value component would have the color (120,120,120).
   *
   * @param original is the key value (name) associated with an Image which stored in the model.
   * @param altered  is the key value (name) associated with the Image which will be created and
   *                 stored in the model by applying the desired change to the original Image.
   */
  void valueToGreyScale(String original, String altered);

  /**
   * Visualizes the intensity channel of an image by creating a greyscale image, where the RGB
   * components
   * of the pixels are equal to the specific intensity channel value of that pixel in the original
   * image.
   * For example, if a pixel in the original image has the color (120,234,23), then the
   * corresponding pixel to visualize the intensity component would have the color (120,120,120).
   *
   * @param original is the key value (name) associated with an Image which stored in the model.
   * @param altered  is the key value (name) associated with the Image which will be created and
   *                 stored in the model by applying the desired change to the original Image.
   */
  void intensityToGreyScale(String original, String altered);

  /**
   * Visualizes the luma channel of an image by creating a greyscale image, where the RGB components
   * of the pixels are equal to the specific luma channel value of that pixel in the original image.
   * For example, if a pixel in the original image has the color (120,234,23), then the
   * corresponding pixel to visualize the luma component would have the color (120,120,120).
   *
   * @param original is the key value (name) associated with an Image which stored in the model.
   * @param altered  is the key value (name) associated with the Image which will be created and
   *                 stored in the model by applying the desired change to the original Image.
   */
  void lumaToGreyScale(String original, String altered);
}
