package model;

/**
 * Represents a Filter which can be used sharpen an Image.
 */
public class SharpenFilter extends AbstractFilter implements Filter {

  @Override
  protected double[][] getKernel() {
    double[][] matrix = new double[5][5];
    for (int r = 0; r < matrix.length; r++) {
      for (int c = 0; c < matrix[0].length; c++) {
        if (r == 0 || r == 4 || c == 0 || c == 4) {
          matrix[r][c] = -1.0 / 8;
        }
        if ((r == 1 || r == 3) && (c >= 1 && c <= 3)) {
          matrix[r][c] = 1.0 / 4;
        }
        if ((r == 2 && c == 1) || (r == 2 && c == 3)) {
          matrix[r][c] = 1.0 / 4;
        }
        if (r == 2 && c == 2) {
          matrix[r][c] = 1;
        }
      }
    }
    return matrix;
  }
}
