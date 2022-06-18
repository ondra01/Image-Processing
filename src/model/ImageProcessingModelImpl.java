package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the model in an MVC design of an Image Processing Application.
 */
public class ImageProcessingModelImpl implements ImageProcessingModel {

  private Map<String, Image> savedImages;

  public ImageProcessingModelImpl() {
    savedImages = new HashMap<String, Image>();
  }


  /**
   * Adds an Image to be stored in the model.
   *
   * @param imageName is the key value (name) associated with the Image to be stored in the model.
   * @param image     is the Image to be stored in the model.
   */
  @Override
  public void addImage(String imageName, Image image) {
    if (imageName != null && image != null) {
      savedImages.put(imageName, image);
    } else {
      throw new IllegalArgumentException("The image or its name cannot be null!");
    }
  }

  /**
   * Gets an Image stored in the model.
   *
   * @param imageName is the key value (name) associated with the Image to get from the model. If
   *                  imageName is null or not present in the model then getImage returns null;
   * @return the Image associated with the imageName.
   */
  @Override
  public Image getImage(String imageName) {
    return savedImages.get(imageName);
  }

  /**
   * Used to flip the desired Image horizontally. This does not change the size of the Image.
   *
   * @param original is the key value (name) associated with an Image which stored in the model.
   * @param altered  is the key value (name) associated with the Image which will be created and
   *                 stored in the model by applying the desired change to the original Image.
   */
  @Override
  public void flipHorizontally(String original, String altered) {
    Image temp = savedImages.get(original);
    Image alteredImage = temp.flipHorizontally();
    savedImages.put(altered, alteredImage);
  }

  /**
   * Used to flip the desired Image Vertically. This does not change the size of the Image.
   *
   * @param original is the key value (name) associated with an Image which stored in the model.
   * @param altered  is the key value (name) associated with the Image which will be created and
   *                 stored in the model by applying the desired change to the original Image.
   */
  @Override
  public void flipVertically(String original, String altered) {
    Image temp = savedImages.get(original);
    Image alteredImage = temp.flipVertically();
    savedImages.put(altered, alteredImage);
  }

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
  @Override
  public void brightenBy(int amount, String original, String altered) {
    Image temp = savedImages.get(original);
    Image alteredImage = temp.brightenBy(amount);
    savedImages.put(altered, alteredImage);
  }

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
  @Override
  public void redToGreyScale(String original, String altered) {
    Image temp = savedImages.get(original);
    Image alteredImage = temp.redToGreyScale();
    savedImages.put(altered, alteredImage);
  }

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
  @Override
  public void greenToGreyScale(String original, String altered) {
    Image temp = savedImages.get(original);
    Image alteredImage = temp.greenToGreyScale();
    savedImages.put(altered, alteredImage);
  }

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
  @Override
  public void blueToGreyScale(String original, String altered) {
    Image temp = savedImages.get(original);
    Image alteredImage = temp.blueToGreyScale();
    savedImages.put(altered, alteredImage);
  }

  @Override
  public void valueToGreyScale(String original, String altered) {
    Image temp = savedImages.get(original);
    Image alteredImage = temp.valueToGreyScale();
    savedImages.put(altered, alteredImage);
  }

  @Override
  public void intensityToGreyScale(String original, String altered) {
    Image temp = savedImages.get(original);
    Image alteredImage = temp.intensityToGreyScale();
    savedImages.put(altered, alteredImage);
  }

  @Override
  public void lumaToGreyScale(String original, String altered) {
    Image temp = savedImages.get(original);
    Image alteredImage = temp.lumaToGreyScale();
    savedImages.put(altered, alteredImage);
  }

  @Override
  public void blurImage(String original, String altered) {
    Image temp = savedImages.get(original);
    Image alteredImage = temp.applyFilter(new GaussianBlurFilter());
    savedImages.put(altered, alteredImage);
  }

  @Override
  public void sharpenImage(String original, String altered) {
    Image temp = savedImages.get(original);
    Image alteredImage = temp.applyFilter(new SharpenFilter());
    savedImages.put(altered, alteredImage);
  }

  @Override
  public void greyscaleImage(String original, String altered) {
    Image temp = savedImages.get(original);
    Image alteredImage = temp.greyscaleImage();
    savedImages.put(altered, alteredImage);
  }

  @Override
  public void sepiaToneImage(String original, String altered) {
    Image temp = savedImages.get(original);
    Image alteredImage = temp.sepiaToneImage();
    savedImages.put(altered, alteredImage);
  }
}
