import org.junit.Before;
import org.junit.Test;

import model.Pixel;
import model.PixelImpl;

import static org.junit.Assert.*;

public class PixelImplTest {
  Pixel black;

  @Before
  public void setUp() throws Exception {
    black = new PixelImpl(0, 0, 0);
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