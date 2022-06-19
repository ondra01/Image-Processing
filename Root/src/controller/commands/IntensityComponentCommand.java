package controller.commands;

import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.ImageProcessingModel;
import view.ImageView;

/**
 * Command to create a grey-scaled Image based on the Intensity of the specified Image.
 */
public class IntensityComponentCommand implements Command {
  @Override
  public void apply(ImageProcessingModel model, ImageView view, ImageController controller,
                    Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    model.intensityToGreyScale(imageName, destImageName);
    view.renderMessage("Image \"" + imageName + "\" has been intensity-To-Grey-Scaled "
            + "and can be referred to by \"" + destImageName + "\".\n");
  }
}
