package model;

import java.util.Objects;

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
    if (!isValidCoordinate(row, col)) {
      throw new IllegalArgumentException("Invalid coordinate for Pixel retrieval!");
    }
    return this.pixels[row][col];
  }

  @Override
  public Image flipHorizontally() {
    Pixel[][] alteredPixels = new Pixel[this.height][this.width];
    for (int r = 0; r < this.height; r++) {
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
    for (int r = 0; r < this.height; r++) {
      for (int c = 0; c < this.width; c++) {
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
    for (int r = 0; r < this.height; r++) {
      for (int c = 0; c < this.width; c++) {
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
    for (int r = 0; r < this.height; r++) {
      for (int c = 0; c < this.width; c++) {
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
    for (int r = 0; r < this.height; r++) {
      for (int c = 0; c < this.width; c++) {
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
    for (int r = 0; r < this.height; r++) {
      for (int c = 0; c < this.width; c++) {
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
    for (int r = 0; r < this.height; r++) {
      for (int c = 0; c < this.width; c++) {
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
    for (int r = 0; r < this.height; r++) {
      for (int c = 0; c < this.width; c++) {
        int alteredVal = (int) pixels[r][c].getLuma();
        Pixel alteredPixel = new PixelImpl(alteredVal);
        alteredPixels[r][c] = alteredPixel;
      }
    }
    return new ImageImpl(alteredPixels);
  }

  @Override
  public Image applyFilter(Filter filter) {
    Objects.requireNonNull(filter);
    Pixel[][] alteredPixels = new Pixel[this.height][this.width];

    //Loop through this image
    for (int row = 0; row < this.height; row++) {
      for (int column = 0; column < this.width; column++) {
        alteredPixels[row][column] = this.applyFilterToPixel(filter, row, column);
      }
    }
    return new ImageImpl(alteredPixels);
  }

  @Override
  public Image greyscaleImage() {
    Pixel[][] alteredPixels = new Pixel[this.height][this.width];
    //Loop through this image
    for (int row = 0; row < this.height; row++) {
      for (int column = 0; column < this.width; column++) {
        alteredPixels[row][column]
                = pixels[row][column].applyColorTransformation(new GreyscaleColorMatrix());
      }
    }
    return new ImageImpl(alteredPixels);
  }

  @Override
  public Image sepiaToneImage() {
    Pixel[][] alteredPixels = new Pixel[this.height][this.width];
    //Loop through this image
    for (int row = 0; row < this.height; row++) {
      for (int column = 0; column < this.width; column++) {
        alteredPixels[row][column]
                = pixels[row][column].applyColorTransformation(new SepiaColorMatrix());
      }
    }
    return new ImageImpl(alteredPixels);
  }

  private Pixel applyFilterToPixel(Filter filter, int imageRow, int imageColumn) {
    int filterSize = filter.getSize();
    int filterCenterIndex = filterSize / 2;
    int newRed = 0;
    int newGreen = 0;
    int newBlue = 0;
    //Loop through the kernel of the filter
    for (int r = 0; r < filterSize; r++) {
      for (int c = 0; c < filterSize; c++) {
        int equivalentImageRow = imageRow - filterCenterIndex + r;
        int equivalentImageCol = imageColumn - filterCenterIndex + c;
        if (isValidCoordinate(equivalentImageRow, equivalentImageCol)) {
          //Multiply kernel cell value by pixel value
          newRed += filter.get(r, c)
                  * pixels[equivalentImageRow][equivalentImageCol].getRedValue();
          newGreen += filter.get(r, c)
                  * pixels[equivalentImageRow][equivalentImageCol].getGreenValue();
          newBlue += filter.get(r, c)
                  * pixels[equivalentImageRow][equivalentImageCol].getBlueValue();
        }
      }
    }
    return new PixelImpl(newRed, newGreen, newBlue);
  }

  private boolean isValidCoordinate(int row, int col) {
    return !(row < 0 || col < 0 || row >= this.height || col >= this.width);
  }
}
