package controller;

import java.io.IOException;
import java.util.Scanner;

import model.ImageProcessingModel;
import view.ImageView;

/**
 * Represents a command available to the controller using the command design pattern. Commands
 * utilize existing public methods to implement macro functionality.
 */
public interface Command {

  /**
   * Takes in a model, view and Scanner and executes this command on it.
   *
   * @param model is the ImageProcessingModel which represents the application.
   * @param view is the view for the application.
   * @param sc is the Scanner which takes in a Readable and holds or gets the input to the program.
   */
  void apply(ImageProcessingModel model, ImageView view, ImageController controller, Scanner sc)
          throws IOException;
}
