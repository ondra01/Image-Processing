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

  @Before
  public void setUp() throws Exception {
    black = new PixelImpl(0, 0, 0);
    middleGray = new PixelImpl(128, 128, 128);
    red = new PixelImpl(255, 0, 0);
    green = new PixelImpl(0, 255, 0);
    blue = new PixelImpl(0, 0, 255);
    yellow = new PixelImpl(255, 255, 0);
    white = new PixelImpl(255, 255, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidNegativeRGBValuesForPixels1() {
    black = new PixelImpl(-3, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidNegativeRGBValuesForPixels2() {
    yellow = new PixelImpl(255, -255, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidNegativeRGBValuesForPixels3() {
    green = new PixelImpl(0, 255, -7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidNegativeRGBValuesForPixels4() {
    white = new PixelImpl(-1, -1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidRGBValuesExceed255ForPixels1() {
    green = new PixelImpl(0, 256, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidRGBValuesExceed255ForPixels2() {
    green = new PixelImpl(0, 255, 257);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidRGBValuesExceed255ForPixels3() {
    green = new PixelImpl(1000, 255, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidRGBValuesExceed255ForPixels4() {
    green = new PixelImpl(300, 300, 300);
  }

  @Test
  public void getRedValue() {
    assertEquals(0, black.getRedValue());
  }

  @Test
  public void getGreenValue() {
    assertEquals(0, black.getGreenValue());
  }

  @Test
  public void getBlueValue() {
    assertEquals(0, black.getBlueValue());
  }

  @Test
  public void getValue() {
    assertEquals(0, black.getValue());
  }

  @Test
  public void getIntensity() {
    assertEquals(0, black.getIntensity(), 0.000001);
  }

  @Test
  public void getLuma() {
    assertEquals(0, black.getLuma(), 0.000001);
  }
}