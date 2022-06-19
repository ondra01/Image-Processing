package controller.commands;

import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.ImageProcessingModel;
import view.ImageView;

/**
 * Command to create a sharpened Image based on a specified Image.
 */
public class SharpenCommand implements Command {
  @Override
  public void apply(ImageProcessingModel model, ImageView view, ImageController controller,
                    Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    model.sharpenImage(imageName, destImageName);
    view.renderMessage("Image \"" + imageName + "\" has been sharpened "
            + "and can be referred to by \"" + destImageName + "\".\n");
  }
}
