package controller;

import model.ImageProcessingModel;
import model.Pixel;
import view.ImageView;

public class ImageControllerImpl implements ImageController {
  private final ImageProcessingModel model;
  private final ImageView view;
  private final Readable input;

  public ImageControllerImpl(ImageProcessingModel model, ImageView view, Readable input) {
    if (model == null || view == null || input == null) {
      throw new IllegalArgumentException("The model, view, and the Readable input cannot be null!");
    } else {
      this.model = model;
      this.view = view;
      this.input = input;
    }
  }

  /**
   * Utilizes a view and model to run an Image Processing Application. It throws an
   * IllegalStateException only if the controller is unable to successfully read input or transmit
   * output.
   */
  @Override
  public void runApplication() throws IllegalStateException {

  }
}
