package view;

import java.io.IOException;

import model.ImageProcessingModel;

/**
 * Acts as the view for an Image Processing Application.
 */
public class ImageViewImpl implements ImageView {

  private final ImageProcessingModel model;
  private final Appendable destination;

  /**
   * Creates a new ImageViewImpl using a passed model which implements
   * ImageProcessingModel and an Appendable destination to which to render the board.
   *
   * @param model       is the model to be queried in order to display the game.
   * @param destination is the object that this view uses as its destination for transmitting the
   *                    state of the marble solitaire board.
   * @throws IllegalArgumentException if the passed model or Appendable is null.
   */
  public ImageViewImpl(ImageProcessingModel model, Appendable destination)
          throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Model Cannot be Null!");
    } else if (destination == null) {
      throw new IllegalArgumentException("Appendable Cannot be Null!");
    } else {
      this.model = model;
      this.destination = destination;
    }
  }

  /**
   * Creates a new ImageViewImpl using a passed model which implements
   * ImageProcessingModel, and System.out as the default destination, to render the board.
   *
   * @param model is the model to be queried in order to display the game.
   * @throws IllegalArgumentException if the passed model is null.
   */
  public ImageViewImpl(ImageProcessingModel model)
          throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Model Cannot be Null!");
    } else {
      this.model = model;
      this.destination = System.out;
    }
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    this.destination.append(message);
  }
}
