package model;

/**
 * This class represents a system representing the colors
 * used on a digital display screen. RGB, actually known as Red,
 * Green, and Blue, can be combined in various proportions to obtain any
 * color. Therefore, this class knows its proportions of
 * red, green, and blue as well as knows the boundaries of acceptable values
 * of each color (between 0 and 255).
 *
 */
public class Color {
  //make note changed to int
  private int red;
  private int green;
  private int blue;
  private static final int COLOR_MIN = 0;
  private static final int COLOR_MAX = 255;


  /**
   * Constructs a Color object.
   * @param red a double representing the proportion of red in the Color.
   * @param green a double representing the proportion of green in the Color.
   * @param blue a double representing the proportion of blue in the Color.
   * @throws IllegalArgumentException if the double is less than 0 or greater
   *         than 255.
   */
  public Color(int red, int green, int blue) throws IllegalArgumentException {
    if (red < COLOR_MIN || red > COLOR_MAX
            || green < COLOR_MIN || green > COLOR_MAX
            || blue < COLOR_MIN || blue > COLOR_MAX) {
      throw new IllegalArgumentException();
    }

    this.red = red;
    this.blue = blue;
    this.green = green;
  }

  /**
   * A getter method that returns this
   * Color's red proportion.
   * @return a double representing the proportion
   *         of red in this Color.
   */
  public int getRed() {
    return this.red;
  }

  /**
   * A getter method that returns this
   * Color's green proportion.
   * @return a double representing the proportion
   *         of green in this Color.
   */
  public int getGreen() {
    return this.green;
  }

  /**
   * A getter method that returns this
   * Color's blue proportion.
   * @return a double representing the proportion
   *         of blue in this Color.
   */
  public int getBlue() {
    return this.blue;
  }

  /**
   * Returns a String representation of this Color
   * in the form '(this.red,this.green,this.blue)'.
   * @return a String representation of this color.
   */
  public String toString() {
    return "(" + this.red + "," + this.green
            + "," + this.blue + ")";
  }

}
