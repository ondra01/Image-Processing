import org.junit.Test;

import model.Filter;
import model.GaussianBlurFilter;
import model.SharpenFilter;

import static org.junit.Assert.assertEquals;

/**
 * Tests Sharpen And Blur Filters.
 */
public class TestSharpenAndBlurFilters {
  Filter sharpen = new SharpenFilter();
  Filter blur = new GaussianBlurFilter();

  @Test
  public void testMethodsOfSharpenFilter() {
    assertEquals(5, sharpen.getSize());
    assertEquals(3, blur.getSize());
    assertEquals(-0.125, sharpen.get(0, 0), 0.00001);
    assertEquals(0.25, blur.get(1, 1), 0.00001);
  }
}