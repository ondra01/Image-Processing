package controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import controller.Command;
import controller.ImageController;
import model.Image;
import model.ImageImpl;
import model.ImageProcessingModel;
import model.Pixel;
import model.PixelImpl;
import view.ImageView;

public class LoadCommand implements Command {

  @Override
  public void apply(ImageProcessingModel model, ImageView view, ImageController controller,
                    Scanner sc) throws IOException {
    String filePathName = sc.next();
    String imageName = sc.next();
    Image loadedImage = new ImageImpl(controller.loadImage(filePathName));
    model.addImage(imageName, loadedImage);
    view.renderMessage("Image \"" + imageName + "\" has been loaded.\n");
  }
}
