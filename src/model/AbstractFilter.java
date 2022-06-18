package model;

/**
 * Represents the common data and operations present in all implementations of Filter.
 */
public abstract class AbstractFilter implements Filter {
  protected double[][] kernel;

  /**
   * Only constructor available for Filters. Ensures that Filters have an odd size.
   */
  public AbstractFilter() throws IllegalArgumentException {
    this.kernel = this.getKernel();
    if (kernel.length % 2 == 0) {
      throw new IllegalArgumentException("Filters must have an odd size!");
    }
  }

  protected abstract double[][] getKernel();

  @Override
  public int getSize() {
    return kernel.length;
  }

  @Override
  public double get(int row, int column) {
    return kernel[row][column];
  }
}
