package model;

public abstract class AbstractFilter implements Filter {
  double[][] kernel;

  public AbstractFilter() {
    this.kernel = this.getKernel();
  }

  protected abstract double[][] getKernel();
}
