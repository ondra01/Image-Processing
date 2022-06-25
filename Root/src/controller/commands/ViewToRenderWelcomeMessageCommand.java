package controller.commands;

import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.ImageProcessingModel;
import view.TextView;

/**
 * Used to command the view to render the welcome message.
 *
 * @throws IllegalStateException if the view is unable to write to the destination.
 */
public class ViewToRenderWelcomeMessageCommand implements Command {
  @Override
  public void apply(ImageProcessingModel model, TextView view, ImageController controller,
                    Scanner sc) throws IOException {
    try {
      StringBuilder str = new StringBuilder();
      str.append("Welcome to Image Processor!\n");
      str.append("Type \"help\" for a list of possible commands, "
              + "or simply begin entering commands.\n"
              + "Enter q or quit at any time to quit the program!\n");
      view.renderMessage(str.toString());
    } catch (IOException e) {
      throw new IllegalStateException("IOException thrown when attempting to render the "
              + "welcome message!");
    }
  }
}
