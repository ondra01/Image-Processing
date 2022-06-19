import org.junit.Before;
import org.junit.Test;

import model.ColorMatrix;
import model.CustomColorMatrix;
import model.GreyscaleColorMatrix;
import model.SepiaColorMatrix;

import static org.junit.Assert.assertEquals;

/**
 * Tests ColorMatrix implementations.
 */
public class ColorMatrixTest {
  ColorMatrix sepia = new SepiaColorMatrix();
  ColorMatrix greyScale = new GreyscaleColorMatrix();
  ColorMatrix custom;

  @Before
  public void setUp() throws Exception {
    double[][] matrix = new double[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        matrix[i][j] = 1;
      }
    }
    custom = new CustomColorMatrix(matrix);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidCustomColorMatrix() {
    custom = new CustomColorMatrix(new double[4][4]);
  }

  @Test
  public void get() {
    assertEquals(1, this.custom.get(0,0), 0.000001);
    assertEquals(1, this.custom.get(1,2), 0.000001);
    assertEquals(0.168, this.sepia.get(1,2), 0.000001);
    assertEquals(0.7152, this.greyScale.get(1,1), 0.000001);
  }
}