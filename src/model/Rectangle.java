package model;


/**
 * A Rectangle object extends all the methods
 * mandated by the AbstractShape class. A Rectangle represents
 * an IShape that knows its width, height, and type.
 */
public class Rectangle extends AbstractShape {

  private String name;
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
    super(name, x, y, color, width, height);
    this.name = name;

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
    super(name, position, color, width, height);
    this.name = name;


  }

  /**
   * A getter method that returns this Oval's
   * type.
   * @return a String representing the type of this
   *         IShape.
   */
  public String getType() {
    return this.TYPE;
  }

  /**
   * Returns a String representation of this
   * IShape's name.
   * @return a String representing the name of
   *         this IShape.
   */
  public String getName() {
    return this.name;
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
            + "Width: " + this.getHorizontal() + ", "
            + "Height: " + this.getVertical() + ", " + "Color: "
            + this.getColor().toString();
  }


}
