package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Represents an implementation of an Image using a 2 dimensional array of Pixels.
 */
public class ImageImpl implements Image {

  private final Pixel[][] pixels;
  private final int width; //This is the number of columns
  private final int height; //This is the number of rows.

  /**
   * Only Constructor for an ImageImpl.
   *
   * @param pixels is a 2 dimensional array of Pixels that must not be null.
   */
  public ImageImpl(Pixel[][] pixels) {
    if (pixels != null) {
      this.pixels = pixels;
      this.width = pixels[0].length;
      this.height = pixels.length;
    } else {
      throw new IllegalArgumentException("pixels cannot be null!");
    }
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public Pixel getPixel(int row, int col) {
    return this.pixels[row][col];
  }

  @Override
  public Image flipHorizontally() {
    Pixel[][] alteredPixels = new Pixel[this.height][this.width];
    for (int r = 0; r < pixels.length; r++) {
      int cFromLeft = 0;
      for (int cFromRight = this.width - 1; cFromRight >= 0; cFromRight--) {
        alteredPixels[r][cFromLeft] = pixels[r][cFromRight];
        cFromLeft++;
      }
    }
    return new ImageImpl(alteredPixels);
  }

  @Override
  public Image flipVertically() {
    Pixel[][] alteredPixels = new Pixel[this.height][this.width];
    for (int c = 0; c < this.width; c++) {
      int rFromTop = 0;
      for (int rFromBottom = this.height - 1; rFromBottom >= 0; rFromBottom--) {
        alteredPixels[rFromTop][c] = pixels[rFromBottom][c];
        rFromTop++;
      }
    }
    return new ImageImpl(alteredPixels);
  }

  @Override
  public Image brightenBy(int amount) {
    Pixel[][] alteredPixels = new Pixel[this.height][this.width];
    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels.length; c++) {
        int alteredRed = pixels[r][c].getRedValue() + amount;
        int alteredGreen = pixels[r][c].getGreenValue() + amount;
        int alteredBlue = pixels[r][c].getBlueValue() + amount;
        Pixel alteredPixel = new PixelImpl(alteredRed, alteredGreen, alteredBlue);
        alteredPixels[r][c] = alteredPixel;
      }
    }
    return new ImageImpl(alteredPixels);
  }

  @Override
  public Image redToGreyScale() {
    Pixel[][] alteredPixels = new Pixel[this.height][this.width];
    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels.length; c++) {
        int alteredVal = pixels[r][c].getRedValue();
        Pixel alteredPixel = new PixelImpl(alteredVal);
        alteredPixels[r][c] = alteredPixel;
      }
    }
    return new ImageImpl(alteredPixels);
  }

  @Override
  public Image greenToGreyScale() {
    Pixel[][] alteredPixels = new Pixel[this.height][this.width];
    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels.length; c++) {
        int alteredVal = pixels[r][c].getGreenValue();
        Pixel alteredPixel = new PixelImpl(alteredVal);
        alteredPixels[r][c] = alteredPixel;
      }
    }
    return new ImageImpl(alteredPixels);
  }

  @Override
  public Image blueToGreyScale() {
    Pixel[][] alteredPixels = new Pixel[this.height][this.width];
    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels.length; c++) {
        int alteredVal = pixels[r][c].getBlueValue();
        Pixel alteredPixel = new PixelImpl(alteredVal);
        alteredPixels[r][c] = alteredPixel;
      }
    }
    return new ImageImpl(alteredPixels);
  }

  @Override
  public Image valueToGreyScale() {
    Pixel[][] alteredPixels = new Pixel[this.height][this.width];
    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels.length; c++) {
        int alteredVal = pixels[r][c].getMaxValue();
        Pixel alteredPixel = new PixelImpl(alteredVal);
        alteredPixels[r][c] = alteredPixel;
      }
    }
    return new ImageImpl(alteredPixels);
  }

  @Override
  public Image intensityToGreyScale() {
    Pixel[][] alteredPixels = new Pixel[this.height][this.width];
    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels.length; c++) {
        int alteredVal = (int) pixels[r][c].getIntensity();
        Pixel alteredPixel = new PixelImpl(alteredVal);
        alteredPixels[r][c] = alteredPixel;
      }
    }
    return new ImageImpl(alteredPixels);
  }

  @Override
  public Image lumaToGreyScale() {
    Pixel[][] alteredPixels = new Pixel[this.height][this.width];
    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels.length; c++) {
        int alteredVal = (int) pixels[r][c].getLuma();
        Pixel alteredPixel = new PixelImpl(alteredVal);
        alteredPixels[r][c] = alteredPixel;
      }
    }
    return new ImageImpl(alteredPixels);
  }
}
