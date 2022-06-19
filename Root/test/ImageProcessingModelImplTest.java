import org.junit.Before;
import org.junit.Test;

import model.Image;
import model.ImageImpl;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import model.Pixel;
import model.PixelImpl;

import static org.junit.Assert.assertEquals;

/**
 * Tests to verify the functionality of ImageProcessingModelImpl.
 */
public class ImageProcessingModelImplTest {
  ImageProcessingModel model;
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

    model = new ImageProcessingModelImpl();
    model.addImage("Double", twoByTwoImage);
    model.addImage("Triple", threeByThreeImage);
  }

  @Test
  public void addAndGetImage() {
    model.addImage("Single", imageWithOnePixel);

    assertEquals(imageWithOnePixel, model.getImage("Single"));
    assertEquals(twoByTwoImage, model.getImage("Double"));
    assertEquals(threeByThreeImage, model.getImage("Triple"));

    assertEquals(null, model.getImage(null));
    assertEquals(null, model.getImage("noSuchString"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void addNullImage() {
    model.addImage("Null", null);

    assertEquals(null, model.getImage("Null"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void addImageWithNullName() {
    model.addImage(null, imageWithOnePixel);

    assertEquals(null, model.getImage("Null"));
  }

  @Test
  public void flipHorizontally() {
    model.flipHorizontally("Double", "DoubleFlippedHorizontally");

    Image horizontallyFlippedTwoByTwoImage = model.getImage("DoubleFlippedHorizontally");
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
  }

  @Test
  public void flipVertically() {
    model.flipVertically("Triple", "TripleFlippedHorizontally");

    Image verticallyFlippedThreeByThreeImage = model.getImage("TripleFlippedHorizontally");
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
    model.brightenBy(-5, "Triple", "TripleBrightenedByNegative5");

    Image brightenedByNegative5ThreeByThreeImage =
            model.getImage("TripleBrightenedByNegative5");
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
    model.addImage("SinglePixel", imageWithOnePixel);
    model.redToGreyScale("SinglePixel", "SinglePixelToGreyScale");
    Image imageWithOnePixelRedToGreyScale = model.getImage("SinglePixelToGreyScale");
    assertEquals(36,
            imageWithOnePixelRedToGreyScale.getPixel(0, 0).getRedValue());
    assertEquals(36,
            imageWithOnePixelRedToGreyScale.getPixel(0, 0).getGreenValue());
    assertEquals(36,
            imageWithOnePixelRedToGreyScale.getPixel(0, 0).getBlueValue());
  }

  @Test
  public void greenToGreyScale() {
    model.addImage("SinglePixel", imageWithOnePixel);
    model.greenToGreyScale("SinglePixel", "SinglePixelToGreyScale");
    Image imageWithOnePixelGreenToGreyScale = model.getImage("SinglePixelToGreyScale");
    assertEquals(128,
            imageWithOnePixelGreenToGreyScale.getPixel(0, 0).getRedValue());
    assertEquals(128,
            imageWithOnePixelGreenToGreyScale.getPixel(0, 0).getGreenValue());
    assertEquals(128,
            imageWithOnePixelGreenToGreyScale.getPixel(0, 0).getBlueValue());
  }

  @Test
  public void blueToGreyScale() {
    model.addImage("SinglePixel", imageWithOnePixel);
    model.blueToGreyScale("SinglePixel", "SinglePixelToGreyScale");
    Image imageWithOnePixelBlueToGreyScale = model.getImage("SinglePixelToGreyScale");
    assertEquals(210,
            imageWithOnePixelBlueToGreyScale.getPixel(0, 0).getRedValue());
    assertEquals(210,
            imageWithOnePixelBlueToGreyScale.getPixel(0, 0).getGreenValue());
    assertEquals(210,
            imageWithOnePixelBlueToGreyScale.getPixel(0, 0).getBlueValue());
  }
}