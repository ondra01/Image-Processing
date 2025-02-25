package controller.commands;

import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.Image;
import model.ImageImpl;
import model.ImageProcessingModel;
import view.TextView;

/**
 * Command to load an Image from a file as a 2 dimensional array of Pixels represented by the
 * Image interface, and store it in the model.
 */
public class LoadCommand implements Command {

  @Override
  public void apply(ImageProcessingModel model, TextView view, ImageController controller,
                    Scanner sc) throws IOException {
    String filePathName = sc.next();
    String imageName = sc.next();
    Image loadedImage;
    if (filePathName.endsWith(".ppm")) {
      loadedImage = new ImageImpl(controller.loadImage(filePathName));
    } else {
      loadedImage = new ImageImpl(controller.loadImage2(filePathName));
    }
    model.addImage(imageName, loadedImage);
    view.renderMessage("Image \"" + imageName + "\" has been loaded.\n");
  }
}
