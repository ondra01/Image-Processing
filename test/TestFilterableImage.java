import org.junit.Before;
import org.junit.Test;

import model.FilterableImage;
import model.Image;
import model.ImageImpl;
import model.Pixel;
import model.PixelImpl;

public class TestFilterableImage {
  Pixel randomColor = new PixelImpl(36, 128, 210);
  Pixel image_Row0_Column0 = new PixelImpl(10);
  Pixel image_Row0_Column1 = new PixelImpl(194);
  Pixel image2_Row0_Column2 = new PixelImpl(211);
  Pixel image_Row1_Column0 = new PixelImpl(154);
  Pixel image_Row1_Column1 = new PixelImpl(239);
  Pixel image2_Row1_Column2 = new PixelImpl(64);
  Pixel image2_Row2_Column0 = new PixelImpl(69);
  Pixel image2_Row2_Column1 = new PixelImpl(96);
  Pixel image2_Row2_Column2 = new PixelImpl(111);
  FilterableImage imageWithOnePixel;
  FilterableImage twoByTwoImage;
  FilterableImage threeByThreeImage;

  @Before
  public void setUp() throws Exception {
    Pixel[][] onePixel = new Pixel[1][1];
    onePixel[0][0] = randomColor;
    imageWithOnePixel = new ImageImpl(onePixel);

    Pixel[][] twoByTwoPixels = new Pixel[2][2];
    twoByTwoPixels[0][0] = image_Row0_Column0;
    twoByTwoPixels[0][1] = image_Row0_Column1;
    twoByTwoPixels[1][0] = image_Row1_Column0;
    twoByTwoPixels[1][1] = image_Row1_Column1;
    twoByTwoImage = new ImageImpl(twoByTwoPixels);

    Pixel[][] threeByThreePixels = new Pixel[3][3];
    threeByThreePixels[0][0] = image_Row0_Column0;
    threeByThreePixels[0][1] = image_Row0_Column1;
    threeByThreePixels[0][2] = image2_Row0_Column2;
    threeByThreePixels[1][0] = image_Row1_Column0;
    threeByThreePixels[1][1] = image_Row1_Column1;
    threeByThreePixels[1][2] = image2_Row1_Column2;
    threeByThreePixels[2][0] = image2_Row2_Column0;
    threeByThreePixels[2][1] = image2_Row2_Column1;
    threeByThreePixels[2][2] = image2_Row2_Column2;
    threeByThreeImage = new ImageImpl(threeByThreePixels);
  }

  @Test
  public void testBlur() {

  }
}
