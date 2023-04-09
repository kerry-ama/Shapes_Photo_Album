package model;


/**
 * A Rectangle object extends all the methods
 * mandated by the AbstractShape class. A Rectangle represents
 * an IShape that knows its width, height, and type.
 */
public class Rectangle extends AbstractShape {

  private double width;
  private double height;
  private static final String TYPE = "rectangle";

  /**
   * Constructs a Rectangle object instance.
   * @param name a String representing the name of this Rectangle.
   * @param x a double representing this Rectangle's x-coordinate position
   * @param y a double representing this Rectangle's y-coordinate position
   * @param color a Color object representing this Rectangle's Color.
   * @param width a double representing the width of this Rectangle.
   * @param height a double representing the height of this Rectangle
   */
  public Rectangle(String name, double x, double y, Color color,
                   double width, double height) throws IllegalArgumentException {
    super(name, x, y, color);
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Invalid height and/or width");
    }
    this.height = height;
    this.width = width;
  }

  /**
   * Constructs a Rectangle object instance.
   * @param name a String representing the name of this Rectangle.
   * @param position a Point2D object representing the position of
   *                 this Rectangle on a cartesian plane.
   * @param color a Color object representing this Rectangle's Color.
   * @param width a double representing the width of this Rectangle.
   * @param height a double representing the height of this Rectangle
   */
  public Rectangle(String name, Point2D position, Color color, double width, double height) {
    super(name, position, color);
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Invalid height and/or width");
    }
    this.width = width;
    this.height = height;

  }

  /**
   * Returns a double representing the width
   * of the Rectangle.
   * @return a double representing the width of
   *    the Rectangle.
   */
  public double getWidth() {
    return this.width;
  }

  /**
   * Returns a double representing the height
   * of the Rectangle.
   * @return a double representing the height
   *         of the Rectangle.
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * Changes the size of this Rectangle.
   * @param newWidth a double representing the Rectangle's new radiusX
   *                   of this Rectangle
   * @param newHeight a double representing the Rectangle's new radiusY
   *                   of this Rectangle
   */
  @Override
  public void changeSize(double newWidth, double newHeight)
          throws IllegalArgumentException {
    if (newWidth <= 0 || newHeight <= 0) {
      throw new IllegalArgumentException("Invalid newWidth and/or newHeight");
    }
    this.width = newWidth;
    this.height = newHeight;

  }

  /**
   * Returns a String representation of this Rectangle in the form:
   * Name:
   * Type:
   * Center: X radius: , Y radius: , Color:
   * @return a String representation of this Rectangle.
   */
  @Override
  public String toString() {
    return  "Name: " + this.getName() + "\n"
            + "Type: " + this.TYPE + "\n"
            + "Min corner: " +  this.getPosition().toString() + ", "
            + "Width: " + this.width + ", "
            + "Height: " + this.height + ", " + "Color: "
            + this.getColor().toString();
  }


}
