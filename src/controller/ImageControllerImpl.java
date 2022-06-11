package controller;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;


import model.Image;
import model.ImageImpl;
import model.ImageProcessingModel;
import model.Pixel;
import model.PixelImpl;
import view.ImageView;

/**
 * Represents an ImageControllerImplementation for an Image processor application.
 */
public class ImageControllerImpl implements ImageController {
  private final ImageProcessingModel model;
  private final ImageView view;
  private final Readable input;

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
    }
  }

  /**
   * Used to command the view to render the welcome message.
   *
   * @throws IllegalStateException if the view is unable to write to the destination.
   */
  private void commandViewToRenderWelcomeMessage() throws IllegalStateException {
    try {
      StringBuilder str = new StringBuilder();
      str.append("Welcome to Image Processor!\n");
      str.append("Type \"help\" for a list of possible commands, "
              + "or simply begin entering commands.\n"
              + "Enter q or quit at any time to quit the program!\n");
      this.view.renderMessage(str.toString());
    } catch (IOException e) {
      throw new IllegalStateException("IOException thrown when attempting to render the "
              + "welcome message!");
    }
  }

  private void commandViewToRenderHelpMessage() throws IOException {
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
    this.view.renderMessage(str.toString());
  }

  /**
   * Utilizes a view and model to run an Image Processing Application. It throws an
   * IllegalStateException only if the controller is unable to successfully read input or transmit
   * output.
   */
  @Override
  public void runApplication() throws IllegalStateException {
    Scanner sc = new Scanner(input);
    boolean programOver = false;
    this.commandViewToRenderWelcomeMessage();

    while (!programOver) { //continue until the user quits
      if (!sc.hasNext()) {
        throw new IllegalStateException("Out of inputs!");
      }

      //3) If the program is ongoing, the next user input is obtained from the Readable object.
      try {
        //Check if it is the letter q
        String userInput = sc.next().toLowerCase();

        switch (userInput) {
          case "q":
          case "quit":
            this.view.renderMessage("Image Processing Program has been quit...");
            programOver = true;
            break;
          case "help":
            this.commandViewToRenderHelpMessage();
            break;
          case "load":
            this.loadCommand(sc);
            break;
          case "save":
            this.saveCommand(sc);
            break;
          case "red-component":
            this.redComponentCommand(sc);
            break;
          case "green-component":
            this.greenComponentCommand(sc);
            break;
          case "blue-component":
            this.blueComponentCommand(sc);
            break;
          case "value-component":
            this.valueComponentCommand(sc);
            break;
          case "luma-component":
            this.lumaComponentCommand(sc);
            break;
          case "intensity-component":
            this.intensityComponentCommand(sc);
            break;
          case "horizontal-flip":
            this.horizontalFlipCommand(sc);
            break;
          case "vertical-flip":
            this.verticalFlipCommand(sc);
            break;
          case "brighten":
            this.brightenCommand(sc);
            break;
          default:
            //Invalid command given as user input. Ask for new input, and loop.
            this.view.renderMessage("Invalid User Input. Command entered by user = \""
                    + userInput + "\". Please input a valid command or enter "
                    + "\"help\" to get a list of possible commands.\n");
        }
      } catch (IOException e) {
        throw new IllegalStateException("IOException thrown when attempting to run the program");
      }
    }
  }

  private void intensityComponentCommand(Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    this.model.intensityToGreyScale(imageName, destImageName);
    this.view.renderMessage("Image \"" + imageName + "\" has been intensity-To-Grey-Scaled "
            + "and can be referred to by \"" + destImageName + "\".\n");
  }

  private void lumaComponentCommand(Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    this.model.lumaToGreyScale(imageName, destImageName);
    this.view.renderMessage("Image \"" + imageName + "\" has been luma-To-Grey-Scaled "
            + "and can be referred to by \"" + destImageName + "\".\n");
  }

  private void valueComponentCommand(Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    this.model.valueToGreyScale(imageName, destImageName);
    this.view.renderMessage("Image \"" + imageName + "\" has been value-To-Grey-Scaled "
            + "and can be referred to by \"" + destImageName + "\".\n");
  }

  private void blueComponentCommand(Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    this.model.blueToGreyScale(imageName, destImageName);
    this.view.renderMessage("Image \"" + imageName + "\" has been blue-To-Grey-Scaled "
            + "and can be referred to by \"" + destImageName + "\".\n");
  }

  private void greenComponentCommand(Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    this.model.greenToGreyScale(imageName, destImageName);
    this.view.renderMessage("Image \"" + imageName + "\" has been green-To-Grey-Scaled "
            + "and can be referred to by \"" + destImageName + "\".\n");
  }

  private void redComponentCommand(Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    this.model.redToGreyScale(imageName, destImageName);
    this.view.renderMessage("Image \"" + imageName + "\" has been red-To-Grey-Scaled "
            + "and can be referred to by \"" + destImageName + "\".\n");
  }

  private void brightenCommand(Scanner sc) throws IOException {
    int amount = sc.nextInt();
    String imageName = sc.next();
    String destImageName = sc.next();
    this.model.brightenBy(amount, imageName, destImageName);
    this.view.renderMessage("Image \"" + imageName + "\" has been brightened by " + amount
            + "and can be referred to by \"" + destImageName + "\".\n");
  }

  private void verticalFlipCommand(Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    this.model.flipVertically(imageName, destImageName);
    this.view.renderMessage("Image \"" + imageName + "\" has been flipped vertically and can be "
            + "referred to by \"" + destImageName + "\".\n");
  }

  private void horizontalFlipCommand(Scanner sc) throws IOException {
    String imageName = sc.next();
    String destImageName = sc.next();
    this.model.flipHorizontally(imageName, destImageName);
    this.view.renderMessage("Image \"" + imageName + "\" has been flipped horizontally and can be "
            + "referred to by \"" + destImageName + "\".\n");
  }

  private void loadCommand(Scanner sc) throws IOException {
    String filePathName = sc.next();
    String imageName = sc.next();
    Image loadedImage = new ImageImpl(this.loadImage(filePathName));
    this.model.addImage(imageName, loadedImage);
    this.view.renderMessage("Image \"" + imageName + "\" has been loaded.\n");
  }

  private void saveCommand(Scanner sc) throws IOException {
    String filePathName = sc.next();
    String imageName = sc.next();
    Image imageToSave = this.model.getImage(imageName);
    this.saveImage(filePathName, imageToSave);
    this.view.renderMessage("Image \"" + imageName + "\" has been saved as "
            + filePathName + ".\n");
  }

  @Override
  public void saveImage(String filePathName, Image imageToSave) {
    //First thing should be "P3"
    //width
    //height
    //maximum value

    //new line probably
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
          if (column < columnDimension - 1) writer.write(" ");
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
}
