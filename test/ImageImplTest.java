import org.junit.Before;
import org.junit.Test;

import model.Image;
import model.ImageImpl;
import model.Pixel;
import model.PixelImpl;

import static org.junit.Assert.assertEquals;

public class ImageImplTest {
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
  public void getWidth() {
    assertEquals(1, imageWithOnePixel.getWidth());
    assertEquals(2, twoByTwoImage.getWidth());
    assertEquals(3, threeByThreeImage.getWidth());
  }

  @Test
  public void getHeight() {
    assertEquals(1, imageWithOnePixel.getHeight());
    assertEquals(2, twoByTwoImage.getHeight());
    assertEquals(3, threeByThreeImage.getHeight());
  }

  @Test
  public void getPixel() {
    assertEquals(randomColor, imageWithOnePixel.getPixel(0, 0));
    assertEquals(image_Row0_Column0, twoByTwoImage.getPixel(0, 0));
    assertEquals(image_Row0_Column0, threeByThreeImage.getPixel(0, 0));
    assertEquals(image_Row0_Column1, twoByTwoImage.getPixel(0, 1));
    assertEquals(image_Row0_Column1, threeByThreeImage.getPixel(0, 1));
    assertEquals(image2_Row2_Column2, threeByThreeImage.getPixel(2, 2));
  }

  @Test
  public void flipHorizontally() {
    Image horizontallyFlippedTwoByTwoImage = twoByTwoImage.flipHorizontally();
    assertEquals(194,
            horizontallyFlippedTwoByTwoImage.getPixel(0, 0).getRedValue());
    assertEquals(194,
            horizontallyFlippedTwoByTwoImage.getPixel(0, 0).getGreenValue());
    assertEquals(194,
            horizontallyFlippedTwoByTwoImage.getPixel(0, 0).getBlueValue());
    assertEquals(10,
            horizontallyFlippedTwoByTwoImage.getPixel(0, 1).getRedValue());
    assertEquals(239,
            horizontallyFlippedTwoByTwoImage.getPixel(1, 0).getRedValue());
    assertEquals(154,
            horizontallyFlippedTwoByTwoImage.getPixel(1, 1).getRedValue());

    Image horizontallyFlippedThreeByThreeImage = threeByThreeImage.flipHorizontally();
    assertEquals(211,
            horizontallyFlippedThreeByThreeImage.getPixel(0, 0).getRedValue());
    assertEquals(211,
            horizontallyFlippedThreeByThreeImage.getPixel(0, 0).getGreenValue());
    assertEquals(211,
            horizontallyFlippedThreeByThreeImage.getPixel(0, 0).getBlueValue());
    assertEquals(194,
            horizontallyFlippedThreeByThreeImage.getPixel(0, 1).getRedValue());
    assertEquals(10,
            horizontallyFlippedThreeByThreeImage.getPixel(0, 2).getRedValue());
    assertEquals(64,
            horizontallyFlippedThreeByThreeImage.getPixel(1, 0).getBlueValue());
    assertEquals(239,
            horizontallyFlippedThreeByThreeImage.getPixel(1, 1).getBlueValue());
    assertEquals(154,
            horizontallyFlippedThreeByThreeImage.getPixel(1, 2).getBlueValue());
    assertEquals(111,
            horizontallyFlippedThreeByThreeImage.getPixel(2, 0).getBlueValue());
    assertEquals(96,
            horizontallyFlippedThreeByThreeImage.getPixel(2, 1).getBlueValue());
    assertEquals(69,
            horizontallyFlippedThreeByThreeImage.getPixel(2, 2).getBlueValue());
  }

  @Test
  public void flipVertically() {
    Image verticallyFlippedTwoByTwoImage = twoByTwoImage.flipVertically();
    assertEquals(154,
            verticallyFlippedTwoByTwoImage.getPixel(0, 0).getRedValue());
    assertEquals(154,
            verticallyFlippedTwoByTwoImage.getPixel(0, 0).getGreenValue());
    assertEquals(154,
            verticallyFlippedTwoByTwoImage.getPixel(0, 0).getBlueValue());
    assertEquals(239,
            verticallyFlippedTwoByTwoImage.getPixel(0, 1).getRedValue());
    assertEquals(10,
            verticallyFlippedTwoByTwoImage.getPixel(1, 0).getRedValue());
    assertEquals(194,
            verticallyFlippedTwoByTwoImage.getPixel(1, 1).getRedValue());

    Image verticallyFlippedThreeByThreeImage = threeByThreeImage.flipVertically();
    assertEquals(69,
            verticallyFlippedThreeByThreeImage.getPixel(0, 0).getRedValue());
    assertEquals(69,
            verticallyFlippedThreeByThreeImage.getPixel(0, 0).getGreenValue());
    assertEquals(69,
            verticallyFlippedThreeByThreeImage.getPixel(0, 0).getBlueValue());
    assertEquals(96,
            verticallyFlippedThreeByThreeImage.getPixel(0, 1).getRedValue());
    assertEquals(111,
            verticallyFlippedThreeByThreeImage.getPixel(0, 2).getRedValue());
    assertEquals(154,
            verticallyFlippedThreeByThreeImage.getPixel(1, 0).getBlueValue());
    assertEquals(239,
            verticallyFlippedThreeByThreeImage.getPixel(1, 1).getBlueValue());
    assertEquals(64,
            verticallyFlippedThreeByThreeImage.getPixel(1, 2).getBlueValue());
    assertEquals(10,
            verticallyFlippedThreeByThreeImage.getPixel(2, 0).getBlueValue());
    assertEquals(194,
            verticallyFlippedThreeByThreeImage.getPixel(2, 1).getBlueValue());
    assertEquals(211,
            verticallyFlippedThreeByThreeImage.getPixel(2, 2).getBlueValue());
  }

  @Test
  public void brightenBy() {
    Image brightenedBy10TwoByTwoImage = twoByTwoImage.brightenBy(10);
    assertEquals(20,
            brightenedBy10TwoByTwoImage.getPixel(0, 0).getRedValue());
    assertEquals(20,
            brightenedBy10TwoByTwoImage.getPixel(0, 0).getGreenValue());
    assertEquals(20,
            brightenedBy10TwoByTwoImage.getPixel(0, 0).getBlueValue());
    assertEquals(204,
            brightenedBy10TwoByTwoImage.getPixel(0, 1).getRedValue());
    assertEquals(164,
            brightenedBy10TwoByTwoImage.getPixel(1, 0).getRedValue());
    assertEquals(249,
            brightenedBy10TwoByTwoImage.getPixel(1, 1).getRedValue());

    Image brightenedByNegative5ThreeByThreeImage = threeByThreeImage.brightenBy(-5);
    assertEquals(5,
            brightenedByNegative5ThreeByThreeImage.getPixel(0, 0).getRedValue());
    assertEquals(5,
            brightenedByNegative5ThreeByThreeImage.getPixel(0, 0).getGreenValue());
    assertEquals(5,
            brightenedByNegative5ThreeByThreeImage.getPixel(0, 0).getBlueValue());
    assertEquals(189,
            brightenedByNegative5ThreeByThreeImage.getPixel(0, 1).getRedValue());
    assertEquals(206,
            brightenedByNegative5ThreeByThreeImage.getPixel(0, 2).getRedValue());
    assertEquals(149,
            brightenedByNegative5ThreeByThreeImage.getPixel(1, 0).getBlueValue());
    assertEquals(234,
            brightenedByNegative5ThreeByThreeImage.getPixel(1, 1).getBlueValue());
    assertEquals(59,
            brightenedByNegative5ThreeByThreeImage.getPixel(1, 2).getBlueValue());
    assertEquals(64,
            brightenedByNegative5ThreeByThreeImage.getPixel(2, 0).getBlueValue());
    assertEquals(91,
            brightenedByNegative5ThreeByThreeImage.getPixel(2, 1).getBlueValue());
    assertEquals(106,
            brightenedByNegative5ThreeByThreeImage.getPixel(2, 2).getBlueValue());
  }

  @Test
  public void redToGreyScale() {
    Image imageWithOnePixelRedToGreyScale = imageWithOnePixel.redToGreyScale();
    assertEquals(36,
            imageWithOnePixelRedToGreyScale.getPixel(0, 0).getRedValue());
    assertEquals(36,
            imageWithOnePixelRedToGreyScale.getPixel(0, 0).getGreenValue());
    assertEquals(36,
            imageWithOnePixelRedToGreyScale.getPixel(0, 0).getBlueValue());
  }

  @Test
  public void greenToGreyScale() {
    Image imageWithOnePixelGreenToGreyScale = imageWithOnePixel.greenToGreyScale();
    assertEquals(128,
            imageWithOnePixelGreenToGreyScale.getPixel(0, 0).getRedValue());
    assertEquals(128,
            imageWithOnePixelGreenToGreyScale.getPixel(0, 0).getGreenValue());
    assertEquals(128,
            imageWithOnePixelGreenToGreyScale.getPixel(0, 0).getBlueValue());
  }

  @Test
  public void blueToGreyScale() {
    Image imageWithOnePixelBlueToGreyScale = imageWithOnePixel.blueToGreyScale();
    assertEquals(210,
            imageWithOnePixelBlueToGreyScale.getPixel(0, 0).getRedValue());
    assertEquals(210,
            imageWithOnePixelBlueToGreyScale.getPixel(0, 0).getGreenValue());
    assertEquals(210,
            imageWithOnePixelBlueToGreyScale.getPixel(0, 0).getBlueValue());
  }
}