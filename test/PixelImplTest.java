import org.junit.Before;
import org.junit.Test;

import model.Pixel;
import model.PixelImpl;

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
}