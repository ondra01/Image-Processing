package controller.commands;

import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.ImageProcessingModel;
import view.TextView;

/**
 * Command to create a brightened Image based on the specified Image, and the amount to brighten
 * each RGB value of each Pixel.
 */
public class BrightenCommand implements Command {
  @Override
  public void apply(ImageProcessingModel model, TextView view, ImageController controller,
                    Scanner sc) throws IOException {
    int amount = sc.nextInt();
    String imageName = sc.next();
    String destImageName = sc.next();
    model.brightenBy(amount, imageName, destImageName);
    view.renderMessage("Image \"" + imageName + "\" has been brightened by " + amount
            + " and can be referred to by \"" + destImageName + "\".\n");
  }
}
