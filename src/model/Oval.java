package model;

/**
 * An Oval object extends all the methods
 * mandated by the AbstractShape class. An Oval represents
 * an IShape that knows its x radius, y radius, and type.
 */
public class Oval extends AbstractShape {
  private double radiusX;
  private double radiusY;
  private static final String TYPE = "oval";


  /**
   * Constructs a Oval object instance.
   * @param name a String representing the name of this Oval.
   * @param x a double representing this Oval's x-coordinate position
   * @param y a double representing this Oval's y-coordinate position
   * @param color a Color object representing this Rectangle's Color.
   * @param radiusX a double representing the width of this Oval.
   * @param radiusY a double representing the height of this Oval
   */
  public Oval(String name, double x, double y, Color color, double radiusX, double radiusY) {
    super(name, x, y, color);
    this.radiusX = radiusX;
    this.radiusY = radiusY;
  }

  /**
   * Constructs a Rectangle object instance.
   * @param name a String representing the name of this Rectangle.
   * @param position a Point2D object representing the position of
   *                 this Rectangle on a cartesian plane.
   * @param color a Color object representing this Rectangle's Color.
   * @param radiusX a double representing the width of this Rectangle.
   * @param radiusY a double representing the height of this Rectangle
   */
  public Oval(String name, Point2D position, Color color, double radiusX, double radiusY) {
    super(name, position, color);
    this.radiusX = radiusX;
    this.radiusY = radiusY;


  }

  /**
   * A getter method that returns
   * this Oval's radiusX.
   * @return a double representing the value
   *         of this Oval's horizontal/x-axis radius
   */
  public double getRadiusX() {
    return this.radiusX;
  }

  /**
   * A getter method that returns this Oval's
   * radiusY.
   * @return a double representing the value of
   *         this Oval's vertical/y-axis radius
   */
  public double getRadiusY() {
    return this.radiusY;
  }

  /**
   * Changes the size of this Oval.
   * @param newRadiusX a double representing the Oval's new radiusX
   *                   of this Oval
   * @param newRadiusY a double representing the Oval's new radiusY
   *                   of this Oval
   */
  @Override
  public void changeSize(double newRadiusX, double newRadiusY) {
    this.radiusX = newRadiusX;
    this.radiusY = newRadiusY;
  }

  /**
   * Returns a String representation of this Oval in the form:
   * Name:
   * Type:
   * Center: X radius: , Y radius: , Color:
   * @return a String representation of this Oval.
   */
  @Override
  public String toString() {
    return  "Name: " + this.getName() + "\n"
            + "Type: " + this.TYPE + "\n"
            + "Center: " +  this.getPosition().toString()
            + ", " + "X radius: " + this.radiusX + ", "
            + "Y radius: " + this.radiusY + ", " + "Color: "
            + this.getColor().toString();
  }

}
