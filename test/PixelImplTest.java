import org.junit.Before;
import org.junit.Test;

import model.ColorMatrix;
import model.CustomColorMatrix;
import model.GreyscaleColorMatrix;
import model.Pixel;
import model.PixelImpl;
import model.SepiaColorMatrix;

import static org.junit.Assert.assertEquals;

/**
 * Tests to verify the functionality of the PixelImpl class.
 */
public class PixelImplTest {
  Pixel black;
  Pixel middleGray;
  Pixel red;
  Pixel green;
  Pixel blue;
  Pixel yellow;
  Pixel darkYellow;
  Pixel white;
  Pixel alsoMiddleGray;

  @Before
  public void setUp() throws Exception {
    black = new PixelImpl(0, 0, 0);
    middleGray = new PixelImpl(128, 128, 128);
    alsoMiddleGray = new PixelImpl(128);
    red = new PixelImpl(255, 0, 0);
    green = new PixelImpl(0, 255, 0);
    blue = new PixelImpl(0, 0, 255);
    yellow = new PixelImpl(255, 255, 0);
    darkYellow = new PixelImpl(100, 100, 0);
    white = new PixelImpl(255, 255, 255);
  }

  @Test
  public void invalidNegativeRGBValuesForPixels0() {
    alsoMiddleGray = new PixelImpl(-3);
    assertEquals(0, alsoMiddleGray.getRedValue());
    assertEquals(0, alsoMiddleGray.getGreenValue());
    assertEquals(0, alsoMiddleGray.getBlueValue());
  }

  @Test
  public void invalidNegativeRGBValuesForPixels1() {
    black = new PixelImpl(-3, 0, 0);
    assertEquals(0, black.getRedValue());
    assertEquals(0, black.getGreenValue());
    assertEquals(0, black.getBlueValue());
  }

  @Test
  public void invalidNegativeRGBValuesForPixels2() {
    yellow = new PixelImpl(255, -255, 0);
    assertEquals(255, yellow.getRedValue());
    assertEquals(0, yellow.getGreenValue());
    assertEquals(0, yellow.getBlueValue());
  }

  @Test
  public void invalidNegativeRGBValuesForPixels3() {
    green = new PixelImpl(0, 255, -7);
    assertEquals(0, green.getRedValue());
    assertEquals(255, green.getGreenValue());
    assertEquals(0, green.getBlueValue());
  }

  @Test
  public void invalidNegativeRGBValuesForPixels4() {
    white = new PixelImpl(-1, -1, -1);
    assertEquals(0, white.getRedValue());
    assertEquals(0, white.getGreenValue());
    assertEquals(0, white.getBlueValue());
  }

  @Test
  public void invalidRGBValuesExceed255ForPixels0() {
    alsoMiddleGray = new PixelImpl(256);
    assertEquals(255, alsoMiddleGray.getRedValue());
    assertEquals(255, alsoMiddleGray.getGreenValue());
    assertEquals(255, alsoMiddleGray.getBlueValue());
  }

  @Test
  public void invalidRGBValuesExceed255ForPixels1() {
    green = new PixelImpl(0, 256, 0);
    assertEquals(0, green.getRedValue());
    assertEquals(255, green.getGreenValue());
    assertEquals(0, green.getBlueValue());
  }

  @Test
  public void invalidRGBValuesExceed255ForPixels2() {
    green = new PixelImpl(-4, 255, 257);
    assertEquals(0, green.getRedValue());
    assertEquals(255, green.getGreenValue());
    assertEquals(255, green.getBlueValue());
  }

  @Test
  public void invalidRGBValuesExceed255ForPixels3() {
    green = new PixelImpl(1000, 255, 0);
    assertEquals(255, green.getRedValue());
    assertEquals(255, green.getGreenValue());
    assertEquals(0, green.getBlueValue());
  }

  @Test
  public void invalidRGBValuesExceed255ForPixels4() {
    green = new PixelImpl(300, 300, 300);
    assertEquals(255, green.getRedValue());
    assertEquals(255, green.getGreenValue());
    assertEquals(255, green.getBlueValue());
  }

  @Test
  public void getRedValue() {
    assertEquals(0, black.getRedValue());
    assertEquals(255, white.getRedValue());
    assertEquals(255, yellow.getRedValue());
    assertEquals(128, this.middleGray.getRedValue());
  }

  @Test
  public void getGreenValue() {
    assertEquals(0, black.getGreenValue());
    assertEquals(255, white.getGreenValue());
    assertEquals(255, yellow.getGreenValue());
    assertEquals(128, this.middleGray.getGreenValue());
  }

  @Test
  public void getBlueValue() {
    assertEquals(0, black.getBlueValue());
    assertEquals(255, white.getBlueValue());
    assertEquals(0, yellow.getBlueValue());
    assertEquals(128, this.middleGray.getBlueValue());
  }

  @Test
  public void getMaxValue() {
    assertEquals(0, black.getMaxValue());
    assertEquals(255, white.getMaxValue());
    assertEquals(255, yellow.getMaxValue());
    assertEquals(128, this.middleGray.getMaxValue());
  }

  @Test
  public void getIntensity() {
    assertEquals(0, black.getIntensity(), 0.000001);
    assertEquals(255, white.getIntensity(), 0.000001);
    assertEquals(170, yellow.getIntensity(), 0.000001);
    assertEquals(128, this.middleGray.getIntensity(), 0.000001);
  }

  @Test
  public void getLuma() {
    assertEquals(0, black.getLuma(), 0.000001);
    assertEquals(255, white.getLuma(), 0.000001);
    assertEquals(236.589, yellow.getLuma(), 0.000001);
    assertEquals(128, this.middleGray.getLuma(), 0.000001);
  }

  @Test
  public void applyGreyscaleColorTransformation() {
    ColorMatrix greyScaleMatrix = new GreyscaleColorMatrix();
    Pixel greyScaledBlack = black.applyColorTransformation(greyScaleMatrix);
    assertEquals(greyScaledBlack.getRedValue(), black.getRedValue());

    Pixel greyScaledYellow = darkYellow.applyColorTransformation(greyScaleMatrix);
    int darkYellowGreyValue = (int) (0.2126 * darkYellow.getRedValue()
            + 0.7152 * darkYellow.getGreenValue()
            + 0.0722 * darkYellow.getBlueValue());
    assertEquals(greyScaledYellow.getRedValue(), darkYellowGreyValue);
    assertEquals(greyScaledYellow.getGreenValue(), darkYellowGreyValue);
    assertEquals(greyScaledYellow.getBlueValue(), darkYellowGreyValue);
  }

  @Test
  public void applySepiaColorTransformation() {
    ColorMatrix sepiaColorMatrix = new SepiaColorMatrix();
    Pixel sepiaBlue = blue.applyColorTransformation(sepiaColorMatrix);
    assertEquals(sepiaBlue.getRedValue(), (int)(255*0.189));
    assertEquals(sepiaBlue.getGreenValue(), (int)(255*0.168));
    assertEquals(sepiaBlue.getBlueValue(), (int)(255*0.131));
  }

  @Test
  public void applyCustomColorTransformation() {
    double[][] matrix = new double[3][3];
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        matrix[r][c] = 0.5;
      }
    }
    ColorMatrix halfColorMatrix = new CustomColorMatrix(matrix);
    Pixel halfBlue = blue.applyColorTransformation(halfColorMatrix);
    assertEquals(halfBlue.getRedValue(), 255/2);
    assertEquals(halfBlue.getGreenValue(), 255/2);
    assertEquals(halfBlue.getBlueValue(), 255/2);
  }
}