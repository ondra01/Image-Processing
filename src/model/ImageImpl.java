package model;

public class ImageImpl implements Image{

  private Pixel[][] pixels;
  int width;
  int height;

  public ImageImpl(Pixel[][] pixels) {
    if (pixels != null) {
      this.pixels = pixels;
      this.width = pixels[0].length;
      this.height = pixels.length;
    } else {
      throw new IllegalArgumentException("pixels cannot be null!");
    }
  }
}
