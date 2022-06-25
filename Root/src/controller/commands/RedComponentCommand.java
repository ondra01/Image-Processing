package controller.commands;

import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.ImageProcessingModel;
import view.TextView;

/**
 * Command to create a grey-scaled Image based on the red-component of the specified Image.
 */
public class RedComponentCommand implements Command {
  @Override
  public void apply(ImageProcessingModel model, TextView view, ImageController controller,
                    Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    model.redToGreyScale(imageName, destImageName);
    view.renderMessage("Image \"" + imageName + "\" has been red-To-Grey-Scaled "
            + "and can be referred to by \"" + destImageName + "\".\n");
  }
}
