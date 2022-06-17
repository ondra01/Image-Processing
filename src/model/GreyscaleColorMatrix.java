package model;

public class GreyscaleColorMatrix extends AbstractColorMatrix implements ColorMatrix {

  public GreyscaleColorMatrix() {
    this.matrix = new double[3][3];
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        if (col == 0) {
          matrix[row][col] = 0.2126;
        }
        if (col == 1) {
          matrix[row][col] = 0.7152;
        }
        if (col == 2) {
          matrix[row][col] = 0.0722;
        }
      }
    }
  }
}
