package controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.ImageProcessingModel;
import view.TextView;

/**
 * Command which accepts a script file as a command-line option.
 * For example "name-of-script.txt". If a valid file is provided, it runs the script and exits.
 * If the program is run without any command line options, then it should allow interactive
 * entry of script commands as before.
 */
public class RunFileCommand implements Command {
  @Override
  public void apply(ImageProcessingModel model, TextView view, ImageController controller,
                    Scanner sc) throws IOException {
    String scriptFile = sc.next();
    Scanner textFileScanner = null;
    try {
      textFileScanner = new Scanner(new FileInputStream(scriptFile));
    } catch (FileNotFoundException e) {
      System.out.println("File " + scriptFile + " not found!");
    }
    controller.meatOfRunApplication(textFileScanner, "textFile-input");
  }
}
