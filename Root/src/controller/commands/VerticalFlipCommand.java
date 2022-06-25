package controller.commands;

import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.ImageProcessingModel;
import view.TextView;

/**
 * Command to create a vertically-flipped Image based on the specified Image.
 */
public class VerticalFlipCommand implements Command {
  @Override
  public void apply(ImageProcessingModel model, TextView view, ImageController controller,
                    Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    model.flipVertically(imageName, destImageName);
    view.renderMessage("Image \"" + imageName + "\" has been flipped vertically and can be "
            + "referred to by \"" + destImageName + "\".\n");
  }
}
