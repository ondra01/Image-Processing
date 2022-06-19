package controller.commands;

import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.ImageProcessingModel;
import view.ImageView;

/**
 * Command which utilizes the view to display a help menu to the user with available commands.
 */
public class ViewToRenderHelpMessageCommand implements Command {

  @Override
  public void apply(ImageProcessingModel model, ImageView view, ImageController controller,
                    Scanner sc) throws IOException {
    StringBuilder str = new StringBuilder();
    str.append("The possible commands are:\n");
    str.append("1) \"load\" followed by the image-path then image-name ->"
            + " load image-path image-name\n");
    str.append("2) \"save\" followed by the image-path then image-name ->"
            + " save image-path image-name\n");
    str.append("3) \"red-component\" followed by the image-name then dest-image-name ->"
            + " red-component image-name dest-image-name\n");
    str.append("4) \"green-component\" followed by the image-name then dest-image-name ->"
            + " green-component image-name dest-image-name\n");
    str.append("5) \"blue-component\" followed by the image-name then dest-image-name ->"
            + " blue-component image-name dest-image-name\n");
    str.append("6) \"value-component\" followed by the image-name then dest-image-name ->"
            + " value-component image-name dest-image-name\n");
    str.append("7) \"luma-component\" followed by the image-name then dest-image-name ->"
            + " luma-component image-name dest-image-name\n");
    str.append("8) \"intensity-component\" followed by the image-name then dest-image-name ->"
            + " intensity-component image-name dest-image-name\n");
    str.append("9) \"blur\" followed by the image-name then dest-image-name ->"
            + " blur image-name dest-image-name\n");
    str.append("10) \"sharpen\" followed by the image-name then dest-image-name ->"
            + " sharpen image-name dest-image-name\n");
    str.append("11) \"greyscale\" followed by the image-name then dest-image-name ->"
            + " greyscale image-name dest-image-name\n");
    str.append("12) \"sepia\" followed by the image-name then dest-image-name ->"
            + " sepia image-name dest-image-name\n");
    str.append("13) \"h-flip\" followed by the image-name then dest-image-name ->"
            + " h-flip image-name dest-image-name\n");
    str.append("14) \"v-flip\" followed by the image-name then dest-image-name ->"
            + " v-flip image-name dest-image-name\n");
    str.append("15) \"file\" followed by the script-file-name.txt ->"
            + " file script-file-name.txt\n");
    str.append("Please enter a command:\n");
    view.renderMessage(str.toString());
  }
}
