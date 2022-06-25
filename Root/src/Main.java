import controller.ImageController;
import controller.ImageControllerImpl;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import view.GUIView;
import view.GUIViewImpl;

/**
 * Class to hold the main method of this program.
 */
public class Main {
  /**
   * Entry point for the program.
   * @param args is not used, and can be ignored.
   */
  public static void main(String[] args) {
    //Text Based Program
    //ImageProcessingModel model = new ImageProcessingModelImpl();
    //ImageView view = new ImageViewImpl(model, System.out);
    //InputStreamReader input = new InputStreamReader(System.in);
    //ImageController controller = new ImageControllerImpl(model, view, input);

    //GUI Based Program
    ImageProcessingModel model = new ImageProcessingModelImpl();
    GUIView view = new GUIViewImpl(model);
    ImageController controller = new ImageControllerImpl(model, view);

    //Run the program
    controller.runApplication();
  }
}
