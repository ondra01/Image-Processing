package controller.commands;

import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.ImageProcessingModel;
import view.ImageView;

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
    str.append("Please enter a command:\n");
    view.renderMessage(str.toString());
  }
}
