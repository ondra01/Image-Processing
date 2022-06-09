package model;

/**
 * This interface represents operations that can be used to monitor the state of a Pixel,
 * without changing it. Pixels are considered immutable in this project.
 */
public interface Pixel {

  /**
   * Used to retrieve the Red value associated with this Pixel.
   *
   * @return the Red value of this Pixel.
   */
  int getRedValue();

  /**
   * Used to retrieve the Green value associated with this Pixel.
   *
   * @return the Green value of this Pixel.
   */
  int getGreenValue();

  /**
   * Used to retrieve the Blue value associated with this Pixel.
   *
   * @return the Blue value of this Pixel.
   */
  int getBlueValue();

  /**
   * Used to retrieve the maximum value of the RGB fields associated with this Pixel.
   *
   * @return the maximum value of the RGB fields associated with this Pixel.
   */
  int getValue();

  /**
   * Used to retrieve the average value of the RGB fields associated with this Pixel.
   *
   * @return the average value of the RGB fields associated with this Pixel.
   */
  double getIntensity();

  /**
   * Used to retrieve the weighted sum of the RGB fields associated with this Pixel. The weighted
   * sum is given by the equation (0.2126 * red) + (0.7152 * green) + (0.0722 * blue)
   *
   * @return the weighted sum of the RGB fields associated with this Pixel.
   */
  double getLuma();
}
