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
    if (red < 0 || green < 0 || blue < 0) {
      throw new IllegalArgumentException("RGB values for a Pixel cannot be negative!");
    } else if (red > 255 || green > 255 || blue > 255) {
      throw new IllegalArgumentException("RGB values for a Pixel cannot be greater than 255!");
    } else {
      this.red = red;
      this.green = green;
      this.blue = blue;
    }
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

  /**
   * Used to retrieve the maximum value of the RGB fields associated with this Pixel.
   *
   * @return the maximum value of the RGB fields associated with this Pixel.
   */
  @Override
  public int getValue() {
    return Math.max(Math.max(this.red, this.green), this.blue);
  }

  /**
   * Used to retrieve the average value of the RGB fields associated with this Pixel.
   *
   * @return the average value of the RGB fields associated with this Pixel.
   */
  @Override
  public double getIntensity() {
    return (this.red + this.green + this.blue) / 3.0;
  }

  /**
   * Used to retrieve the weighted sum of the RGB fields associated with this Pixel. The weighted
   * sum is given by the equation (0.2126 * red) + (0.7152 * green) + (0.0722 * blue)
   *
   * @return the weighted sum of the RGB fields associated with this Pixel.
   */
  @Override
  public double getLuma() {
    return (0.2126 * red) + (0.7152 * green) + (0.0722 * blue);
  }
}
