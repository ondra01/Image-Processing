package model;

/**
 * Represents a custom Color Matrix.
 */
public class CustomColorMatrix extends AbstractColorMatrix implements ColorMatrix {

  /**
   * Only constructor for CustomColorMatrix, which ensures it is 3X3.
   * @param matrix is a matrix made of doubles used to create a ColorMatrix.
   */
  public CustomColorMatrix(double[][] matrix) throws IllegalArgumentException {
    if (matrix.length == 3 && matrix[0].length == 3) {
      this.matrix = matrix;
    } else {
      throw new IllegalArgumentException("ColorMatrix must be 3x3!");
    }
  }
}
