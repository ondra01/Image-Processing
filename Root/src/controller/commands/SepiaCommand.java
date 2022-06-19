package controller.commands;

import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.ImageProcessingModel;
import view.ImageView;

/**
 * Command to create a sepia-toned Image based on a specified Image.
 */
public class SepiaCommand implements Command {
  @Override
  public void apply(ImageProcessingModel model, ImageView view, ImageController controller,
                    Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    model.sepiaToneImage(imageName, destImageName);
    view.renderMessage("Image \"" + imageName + "\" has been sepia-toned "
            + "and can be referred to by \"" + destImageName + "\".\n");
  }
}
