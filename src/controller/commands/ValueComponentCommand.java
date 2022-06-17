package controller.commands;

import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.ImageProcessingModel;
import view.ImageView;

public class ValueComponentCommand implements Command {
  @Override
  public void apply(ImageProcessingModel model, ImageView view, ImageController controller,
                    Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    model.valueToGreyScale(imageName, destImageName);
    view.renderMessage("Image \"" + imageName + "\" has been value-To-Grey-Scaled "
            + "and can be referred to by \"" + destImageName + "\".\n");
  }
}
