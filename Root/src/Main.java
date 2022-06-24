import java.io.InputStreamReader;

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
    //ImageView view = new ImageViewImpl(model, System.out);
    //InputStreamReader input = new InputStreamReader(System.in);
    ImageController controller = new ImageControllerImpl(model, view, input);

    controller.runApplication();
  }
}
