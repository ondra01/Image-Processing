package model;

/**
 * Represents a filter which can be applied to an Image.
 */
public interface Filter {

  int getSize();


  double get(int row, int column);
}
