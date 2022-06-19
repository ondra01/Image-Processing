package controller;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import javax.imageio.ImageIO;

import controller.commands.BlueComponentCommand;
import controller.commands.BlurCommand;
import controller.commands.BrightenCommand;
import controller.commands.GreenComponentCommand;
import controller.commands.GreyscaleCommand;
import controller.commands.HorizontalFlipCommand;
import controller.commands.IntensityComponentCommand;
import controller.commands.LoadCommand;
import controller.commands.LumaComponentCommand;
import controller.commands.RedComponentCommand;
import controller.commands.RunFileCommand;
import controller.commands.SaveCommand;
import controller.commands.SepiaCommand;
import controller.commands.SharpenCommand;
import controller.commands.ValueComponentCommand;
import controller.commands.VerticalFlipCommand;
import controller.commands.ViewToRenderHelpMessageCommand;
import controller.commands.ViewToRenderWelcomeMessageCommand;
import model.Image;
import model.ImageProcessingModel;
import model.Pixel;
import model.PixelImpl;
import view.ImageView;

/**
 * Represents an ImageControllerImplementation for an Image processor application.
 */
public class ImageControllerImpl implements ImageController {
  boolean programOver = false;
  private final ImageProcessingModel model;
  private final ImageView view;
  private final Readable input;
  Map<String, Command> commandMap = new HashMap<String, Command>();

  /**
   * Default constructor for an ImageControllerImpl.
   *
   * @param model keeps track of state and operations available.
   * @param view  is responsible for displaying the state, and operations available to the user
   *              graphically.
   * @param input is the Readable abstraction for user input.
   * @throws IllegalArgumentException if model, view, or input are null.
   */
  public ImageControllerImpl(ImageProcessingModel model, ImageView view, Readable input)
          throws IllegalArgumentException {
    if (model == null || view == null || input == null) {
      throw new IllegalArgumentException("The model, view, and the Readable input cannot be null!");
    } else {
      this.model = model;
      this.view = view;
      this.input = input;
      commandMap.put("help", new ViewToRenderHelpMessageCommand());
      commandMap.put("load", new LoadCommand());
      commandMap.put("save", new SaveCommand());
      commandMap.put("red-component", new RedComponentCommand());
      commandMap.put("green-component", new GreenComponentCommand());
      commandMap.put("blue-component", new BlueComponentCommand());
      commandMap.put("value-component", new ValueComponentCommand());
      commandMap.put("intensity-component", new IntensityComponentCommand());
      commandMap.put("luma-component", new LumaComponentCommand());
      commandMap.put("h-flip", new HorizontalFlipCommand());
      commandMap.put("v-flip", new VerticalFlipCommand());
      commandMap.put("brighten", new BrightenCommand());
      commandMap.put("welcome-message", new ViewToRenderWelcomeMessageCommand());
      commandMap.put("blur", new BlurCommand());
      commandMap.put("sharpen", new SharpenCommand());
      commandMap.put("greyscale", new GreyscaleCommand());
      commandMap.put("sepia", new SepiaCommand());
      commandMap.put("file", new RunFileCommand());
    }
  }

  /**
   * Utilizes a view and model to run an Image Processing Application. It throws an
   * IllegalStateException only if the controller is unable to successfully read input or transmit
   * output.
   */
  @Override
  public void runApplication() throws IllegalStateException {
    try {
      Scanner sc = new Scanner(input);
      this.commandMap.get("welcome-message").apply(this.model, this.view, this, sc);
      this.meatOfRunApplication(sc, "user-input");

    } catch (IOException e) {
      throw new IllegalStateException("IOException thrown when attempting to run the program");
    }
  }

  @Override
  public void meatOfRunApplication(Scanner sc, String inputInfo) throws IOException {
    while (!programOver) { //continue until the user quits
      if (!sc.hasNext()) {
        if (inputInfo.equals("user-input")) {
          throw new IllegalStateException("Out of inputs!");
        } else {
          if (this.model.hasAnImage()) {
            return;
          } else {
            this.view.renderMessage("Nothing left in the script to run!\n");
            sc = new Scanner(input);
          }
        }
      }
      //While program is ongoing, the next user input is obtained from the Readable object.
      String userInput = sc.next().toLowerCase();

      switch (userInput) {
        case "q":
        case "quit":
          this.view.renderMessage("Image Processing Program has been quit...");
          programOver = true;
          break;
        default:
          if (commandMap.containsKey(userInput)) {
            this.commandMap.get(userInput).apply(this.model, this.view, this, sc);
          } else {
            //Invalid command given as user input. Ask for new input, and loop.
            this.view.renderMessage("Invalid User Input. Command entered by user = \""
                    + userInput + "\". Please input a valid command or enter "
                    + "\"help\" to get a list of possible commands.\n");
          }
      }
    }
  }

  @Override
  public void saveImage(String filePathName, Image imageToSave) {
    BufferedWriter writer = null;
    try {
      writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePathName)));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    // write header
    int rowDimension = imageToSave.getHeight();
    int columnDimension = imageToSave.getWidth();
    try {
      writer.write("P3");
      writer.newLine();
      writer.write(columnDimension + " " + rowDimension);
      writer.newLine();
      writer.write("255");
      writer.newLine();
      for (int row = 0; row < rowDimension; row++) {
        for (int column = 0; column < columnDimension; column++) {
          writer.write(imageToSave.getPixel(row, column).getRedValue() + " ");
          writer.write(imageToSave.getPixel(row, column).getGreenValue() + " ");
          writer.write(imageToSave.getPixel(row, column).getBlueValue() + "");
          if (column < columnDimension - 1) {
            writer.write(" ");
          }
        }
        writer.newLine();
      }
      writer.flush();
      writer.close();
    } catch (java.io.IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Read an image file in the PPM format and convert it to a 2 dimensional Pixel array.
   *
   * @param filePathName the path of the file.
   * @return a 2 dimensional Pixel array representing the loaded image.
   */
  public Pixel[][] loadImage(String filePathName) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filePathName));
    } catch (FileNotFoundException e) {
      System.out.println("File " + filePathName + " not found!");
      return null;
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();

    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    //System.out.println("Width of image: "+width);
    int height = sc.nextInt();
    //System.out.println("Height of image: "+height);
    int maxValue = sc.nextInt();
    //System.out.println("Maximum value of a color in this file (usually 255): "+maxValue);

    Pixel[][] pixelsFromFile = new Pixel[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int red = sc.nextInt();
        int green = sc.nextInt();
        int blue = sc.nextInt();
        pixelsFromFile[i][j] = new PixelImpl(red, green, blue);
      }
    }
    return pixelsFromFile;
  }

  /**
   * Read an image file in any common format and convert it to a 2 dimensional Pixel array.
   *
   * @param filePathName the path of the file.
   * @return a 2 dimensional Pixel array representing the loaded image.
   */
  public Pixel[][] loadImage2(String filePathName) throws IOException {
    //System.out.println(filePathName);
    BufferedImage buffImage = ImageIO.read(new File(filePathName));
    //System.out.println(buffImage.getHeight() + " " + buffImage.getWidth());
    Pixel[][] loadedPixels = new Pixel[buffImage.getHeight()][buffImage.getWidth()];
    for (int row = 0; row < buffImage.getHeight(); row++) {
      for (int col = 0; col < buffImage.getWidth(); col++) {
        int rgb = buffImage.getRGB(col, row);
        int red = (rgb >> 16) & 0x000000FF;
        int green = (rgb >> 8) & 0x000000FF;
        int blue = (rgb) & 0x000000FF;
        loadedPixels[row][col] = new PixelImpl(red, green, blue);
      }
    }
    return loadedPixels;
  }
}
