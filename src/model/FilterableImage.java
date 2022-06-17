package model;

public interface FilterableImage extends Image {

  Image applyFilter(Filter filter, int row, int col, String channel);
}
