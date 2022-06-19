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
    if (red < 0) {
      red = 0;
    }
    if (green < 0) {
      green = 0;
    }
    if (blue < 0) {
      blue = 0;
    }
    if (red > 255) {
      red = 255;
    }
    if (green > 255) {
      green = 255;
    }
    if (blue > 255) {
      blue = 255;
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * This convenience constructor allows the user to create a grey pixel with the specified shade.
   *
   * @param shade represents the RGB values of a pixel, ranging from 0 to 255 inclusive.
   */
  public PixelImpl(int shade) {
    if (shade < 0) {
      shade = 0;
    }
    if (shade > 255) {
      shade = 255;
    }
    this.red = shade;
    this.green = shade;
    this.blue = shade;
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
  public int getMaxValue() {
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

  @Override
  public Pixel applyColorTransformation(ColorMatrix matrix) {
    int newRed = (int) (matrix.get(0, 0) * this.red
            + matrix.get(0, 1) * this.green
            + matrix.get(0, 2) * blue);
    int newGreen = (int) (matrix.get(1, 0) * this.red
            + matrix.get(1, 1) * this.green
            + matrix.get(1, 2) * blue);
    int newBlue = (int) (matrix.get(2, 0) * this.red
            + matrix.get(2, 1) * this.green
            + matrix.get(2, 2) * blue);
    return new PixelImpl(newRed, newGreen, newBlue);
  }
}
