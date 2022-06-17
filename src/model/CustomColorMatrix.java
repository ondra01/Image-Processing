package model;

public class CustomColorMatrix extends AbstractColorMatrix implements ColorMatrix {

  public CustomColorMatrix(double[][] matrix) {
    if (matrix.length == 3 && matrix[0].length == 3) {
      this.matrix = matrix;
    } else {
      throw new IllegalArgumentException("ColorMatrix must be 3x3!");
    }
  }
}
