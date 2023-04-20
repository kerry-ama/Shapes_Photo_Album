package utility;

import model.Color;

/**
 * A wrapper class that translates between incompatible interfaces of
 * the model.Color class and Java's Color class.
 */
public class ColorAdaptor {
  public static java.awt.Color toSwingFromModel(Color photoAlbumColor) {
    return new java.awt.Color(photoAlbumColor.getRed(),
            photoAlbumColor.getGreen(),
            photoAlbumColor.getBlue());
  }
}
