package model;

/**
 * Represents a ColorMatrix which can be used to sepia-tone an Image.
 */
public class SepiaColorMatrix extends AbstractColorMatrix implements ColorMatrix {

  /**
   * Creates a unique matrix capable of sepia-toning an Image.
   */
  public SepiaColorMatrix() {
    this.matrix = new double[3][3];
    matrix[0][0] = 0.393;
    matrix[0][1] = 0.769;
    matrix[0][2] = 0.189;
    matrix[1][0] = 0.349;
    matrix[1][1] = 0.686;
    matrix[1][2] = 0.168;
    matrix[2][0] = 0.272;
    matrix[2][1] = 0.534;
    matrix[2][2] = 0.131;
  }
}
