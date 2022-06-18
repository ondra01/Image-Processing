import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import controller.ImageController;
import controller.ImageControllerImpl;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import view.ImageView;
import view.ImageViewImpl;

/**
 * Class to hold the main method of this program.
 */
public class Main {
  /**
   * Entry point for the program.
   * @param args is not used, and can be ignored.
   */
  public static void main(String[] args) {
    ImageProcessingModel model = new ImageProcessingModelImpl();
    ImageView view = new ImageViewImpl(model, System.out);
    InputStreamReader input = new InputStreamReader(System.in);
    ImageController controller = new ImageControllerImpl(model, view, input);

    controller.runApplication();

//    BufferedImage buffImage = null;
//    try {
//      buffImage = ImageIO.read(new File("images/koala-vertical.png"));
//      int RGB = buffImage.getRGB(1, 0);
//      int red = (RGB >> 16) & 0x000000FF;
//      int green = (RGB >> 8) & 0x000000FF;
//      int blue = (RGB) & 0x000000FF;
//      System.out.println("Red=" + red + ", Green=" + green + ", Blue=" + blue);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
  }
}
