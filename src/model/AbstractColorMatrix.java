package model;

/**
 * Represents the common data and operations present in all implementations of ColorMatrix.
 */
public abstract class AbstractColorMatrix implements ColorMatrix {

  protected double[][] matrix;

  @Override
  public double get(int row, int column) {
    return this.matrix[row][column];
  }
}
