package controller.commands;

import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.Image;
import model.ImageProcessingModel;
import view.TextView;

/**
 * Command to save an Image to a file from a 2 dimensional array of Pixels represented by the
 * Image interface, and stored in the model.
 */
public class SaveCommand implements Command {
  @Override
  public void apply(ImageProcessingModel model, TextView view, ImageController controller,
                    Scanner sc) throws IOException {
    String filePathName = sc.next();
    String imageName = sc.next();
    Image imageToSave = model.getImage(imageName);
    controller.saveImage(filePathName, imageToSave);
    view.renderMessage("Image \"" + imageName + "\" has been saved as "
            + filePathName + ".\n");
  }
}
