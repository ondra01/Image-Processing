package controller.commands;

import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.ImageProcessingModel;
import view.ImageView;

/**
 * Command to create a Grey-scaled Image based on the specified Image.
 */
public class GreyscaleCommand implements Command {
  @Override
  public void apply(ImageProcessingModel model, ImageView view, ImageController controller,
                    Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    model.greyscaleImage(imageName, destImageName);
    view.renderMessage("Image \"" + imageName + "\" has been grey-scaled "
            + "and can be referred to by \"" + destImageName + "\".\n");
  }
}
