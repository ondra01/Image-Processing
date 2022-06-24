import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

import controller.ImageController;
import controller.ImageControllerImpl;
import model.Image;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import view.ImageView;
import view.ImageViewImpl;

import static org.junit.Assert.assertEquals;


/**
 * Tests ImageController implementations.
 */
public class ImageControllerImplTest {
  ImageProcessingModel model;
  ImageView view;
  StringBuilder output;

  //Readable inputs and their respective controllers
  Readable input;
  ImageController controller;
  Readable input2;
  ImageController controller2;
  Readable input3;
  ImageController controller3;
  Readable input4;
  ImageController controller4;

  @Before
  public void setUp() throws Exception {
    model = new ImageProcessingModelImpl();
    output = new StringBuilder();
    view = new ImageViewImpl(model, output);
    input = new StringReader("load images/koala.ppm koala q");
    controller = new ImageControllerImpl(model, view, input);
    input2 = new StringReader("load images/koala.ppm koala save images/alsoKoala.ppm koala "
            + "save images/alsoKoala.png save images/alsoKoala.jpeg koala q");
    controller2 = new ImageControllerImpl(model, view, input2);
    input3 = new StringReader("load images/koala.ppm koala "
            + "vertical-flip koala koala-vertical q");
    controller3 = new ImageControllerImpl(model, view, input3);
    input4 = new StringReader("load images/koala.ppm koala "
            + "horizontal-flip koala koala-horizontal q");
    controller4 = new ImageControllerImpl(model, view, input4);
  }

  @Test
  public void testLoadImageFromPPM() {
    controller.runApplication();
    Image loadedImage = model.getImage("koala");
    assertEquals(768, loadedImage.getHeight());
    assertEquals(1024, loadedImage.getWidth());
  }

  @Test
  public void testExportImageToPPM() {
    controller2.runApplication();
    Image loadedImage = model.getImage("koala");
    String[] lines = output.toString().split("\n");
    assertEquals("Image \"koala\" has been saved as images/alsoKoala.ppm.", lines[4]);
  }

  @Test
  public void testFlippingVertically() {
    controller3.runApplication();
    String[] lines = output.toString().split("\n");
    Image flippedImage = model.getImage("koala-vertical");
    assertEquals(768, flippedImage.getHeight());
    assertEquals(1024, flippedImage.getWidth());
    assertEquals("Image \"koala\" has been flipped vertically and can be referred "
            + "to by \"koala-vertical\".", lines[4]);
  }

  @Test
  public void testFlippingHorizontal() {
    controller4.runApplication();
    String[] lines = output.toString().split("\n");
    Image flippedImage = model.getImage("koala-horizontal");
    assertEquals(768, flippedImage.getHeight());
    assertEquals(1024, flippedImage.getWidth());
    assertEquals("Image \"koala\" has been flipped horizontally and can be referred"
            + " to by \"koala-horizontal\".", lines[4]);
  }
}