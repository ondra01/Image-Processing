package model;

/**
 * This class represents a single Pixel in an Image. A Pixel contains RGB integer values from 0
 * to 255, which are an 8-bit representation creating 256 distinct possible levels of each base
 * color. In order to make a Pixel Grey, an equal amount should be used for each RGB value.
 */
public class PixelImpl implements Pixel {

  private final int red;
  private final int green;
  private final int blue;

  /**
   * This constructor allows the user to specify all relevant values needed to describe an
   * individual pixel.
   *
   * @param red   represents the Red value of a pixel, ranging from 0 to 255 inclusive.
   * @param green represents the Green value of a pixel, ranging from 0 to 255 inclusive.
   * @param blue  represents the Blue value of a pixel, ranging from 0 to 255 inclusive.
   */
  public PixelImpl(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Used to retrieve the Red value associated with this Pixel.
   *
   * @return the Red value of this Pixel.
   */
  @Override
  public int getRedValue() {
    return this.red;
  }

  /**
   * Used to retrieve the Green value associated with this Pixel.
   *
   * @return the Green value of this Pixel.
   */
  @Override
  public int getGreenValue() {
    return this.green;
  }

  /**
   * Used to retrieve the Blue value associated with this Pixel.
   *
   * @return the Blue value of this Pixel.
   */
  @Override
  public int getBlueValue() {
    return this.blue;
  }
}
