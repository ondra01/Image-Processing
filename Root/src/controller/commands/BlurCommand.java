package controller.commands;

import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.ImageProcessingModel;
import view.ImageView;

/**
 * Command to create a blurred Image based on the specified Image.
 */
public class BlurCommand implements Command {
  @Override
  public void apply(ImageProcessingModel model, ImageView view, ImageController controller,
                    Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    model.blurImage(imageName, destImageName);
    view.renderMessage("Image \"" + imageName + "\" has been blurred "
            + "and can be referred to by \"" + destImageName + "\".\n");
  }
}
