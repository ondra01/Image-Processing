package model;

/**
 * Represents a Filter which can be used blur an Image.
 */
public class GaussianBlurFilter extends AbstractFilter implements Filter {

  @Override
  protected double[][] getKernel() {
    double[][] matrix = new double[3][3];
    matrix[0][0] = 1.0 / 16;
    matrix[0][1] = 1.0 / 8;
    matrix[0][2] = 1.0 / 16;
    matrix[1][0] = 1.0 / 8;
    matrix[1][1] = 1.0 / 4;
    matrix[1][2] = 1.0 / 8;
    matrix[2][0] = 1.0 / 16;
    matrix[2][1] = 1.0 / 8;
    matrix[2][2] = 1.0 / 16;
    return matrix;
  }
}
