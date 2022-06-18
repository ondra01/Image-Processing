import org.junit.Before;
import org.junit.Test;

import model.Filter;
import model.GaussianBlurFilter;
import model.Image;
import model.ImageImpl;
import model.Pixel;
import model.PixelImpl;
import model.SharpenFilter;

import static org.junit.Assert.assertEquals;

/**
 * Tests the ability of Image implementations to apply a filter.
 */
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
  Image imageWithOnePixel;
  Image twoByTwoImage;
  Image threeByThreeImage;

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
    Filter blur = new GaussianBlurFilter();

    //Testing blurring of an Image made of only one Pixel
    assertEquals(36, imageWithOnePixel.getPixel(0,0).getRedValue());
    assertEquals(128, imageWithOnePixel.getPixel(0,0).getGreenValue());
    assertEquals(210, imageWithOnePixel.getPixel(0,0).getBlueValue());
    Image blurredImageWithOnePixel = imageWithOnePixel.applyFilter(blur);
    assertEquals(9, blurredImageWithOnePixel.getPixel(0,0).getRedValue());
    assertEquals(32, blurredImageWithOnePixel.getPixel(0,0).getGreenValue());
    assertEquals(52, blurredImageWithOnePixel.getPixel(0,0).getBlueValue());
    //Testing blurring of a 3X3 Image
    assertEquals(10, threeByThreeImage.getPixel(0,0).getRedValue());
    assertEquals(194, threeByThreeImage.getPixel(0,1).getGreenValue());
    assertEquals(211, threeByThreeImage.getPixel(0,2).getBlueValue());
    assertEquals(154, threeByThreeImage.getPixel(1,0).getRedValue());
    assertEquals(239, threeByThreeImage.getPixel(1,1).getGreenValue());
    assertEquals(64, threeByThreeImage.getPixel(1,2).getGreenValue());
    assertEquals(69, threeByThreeImage.getPixel(2,0).getBlueValue());
    assertEquals(96, threeByThreeImage.getPixel(2,1).getBlueValue());
    assertEquals(111, threeByThreeImage.getPixel(2,2).getRedValue());
    Image blurredThreeByThreeImage = threeByThreeImage.applyFilter(blur);
    assertEquals(59, blurredThreeByThreeImage.getPixel(0,0).getRedValue());
    assertEquals(117, blurredThreeByThreeImage.getPixel(0,1).getGreenValue());
    assertEquals(98, blurredThreeByThreeImage.getPixel(0,2).getBlueValue());
    assertEquals(94, blurredThreeByThreeImage.getPixel(1,0).getRedValue());
    assertEquals(145, blurredThreeByThreeImage.getPixel(1,1).getGreenValue());
    assertEquals(102, blurredThreeByThreeImage.getPixel(1,2).getGreenValue());
    assertEquals(62, blurredThreeByThreeImage.getPixel(2,0).getBlueValue());
    assertEquals(87, blurredThreeByThreeImage.getPixel(2,1).getBlueValue());
    assertEquals(61, blurredThreeByThreeImage.getPixel(2,2).getRedValue());
  }

  @Test
  public void testSharpen() {
    Filter sharpen = new SharpenFilter();

    //Testing sharpening of an Image made of only one Pixel
    assertEquals(36, imageWithOnePixel.getPixel(0,0).getRedValue());
    assertEquals(128, imageWithOnePixel.getPixel(0,0).getGreenValue());
    assertEquals(210, imageWithOnePixel.getPixel(0,0).getBlueValue());
    Image sharpenedImageWithOnePixel = imageWithOnePixel.applyFilter(sharpen);
    assertEquals(36, sharpenedImageWithOnePixel.getPixel(0,0).getRedValue());
    assertEquals(128, sharpenedImageWithOnePixel.getPixel(0,0).getGreenValue());
    assertEquals(210, sharpenedImageWithOnePixel.getPixel(0,0).getBlueValue());

    //Testing sharpening of a 3X3 Image
    assertEquals(10, threeByThreeImage.getPixel(0,0).getRedValue());
    assertEquals(194, threeByThreeImage.getPixel(0,1).getGreenValue());
    assertEquals(211, threeByThreeImage.getPixel(0,2).getBlueValue());
    assertEquals(154, threeByThreeImage.getPixel(1,0).getRedValue());
    assertEquals(239, threeByThreeImage.getPixel(1,1).getGreenValue());
    assertEquals(64, threeByThreeImage.getPixel(1,2).getGreenValue());
    assertEquals(69, threeByThreeImage.getPixel(2,0).getBlueValue());
    assertEquals(96, threeByThreeImage.getPixel(2,1).getBlueValue());
    assertEquals(111, threeByThreeImage.getPixel(2,2).getRedValue());
    Image sharpenedThreeByThreeImage = threeByThreeImage.applyFilter(sharpen);
    assertEquals(85, sharpenedThreeByThreeImage.getPixel(0,0).getRedValue());
    assertEquals(255, sharpenedThreeByThreeImage.getPixel(0,1).getGreenValue());
    assertEquals(255, sharpenedThreeByThreeImage.getPixel(0,2).getBlueValue());
    assertEquals(255, sharpenedThreeByThreeImage.getPixel(1,0).getRedValue());
    assertEquals(255, sharpenedThreeByThreeImage.getPixel(1,1).getGreenValue());
    assertEquals(244, sharpenedThreeByThreeImage.getPixel(1,2).getGreenValue());
    assertEquals(118, sharpenedThreeByThreeImage.getPixel(2,0).getBlueValue());
    assertEquals(203, sharpenedThreeByThreeImage.getPixel(2,1).getBlueValue());
    assertEquals(133, sharpenedThreeByThreeImage.getPixel(2,2).getRedValue());
  }
}
