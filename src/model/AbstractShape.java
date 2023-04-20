package model;

/**
 * The AbstractShape class implements all the
 * methods mandated by the IShape interface. An
 * AbstractShape represents a shape. An AbstractShape
 * knows its name, position, color, and position
 * in a cartesian graph.
 */
public class AbstractShape implements IShape {
  private String name; //will be input from user
  private Point2D position;
  private Color color;
  private double horizontal;
  private double vertical;



  /**
   * Displays the constructor of an AbstractShape
   * @param name a String representing the name of the shape
   * @param x a double representing the x_coordinate position
   *          of this IShape.
   * @param y a double representing the y_coordinate of this
   *          IShape.
   * @param color a Color object representing the color of this
   *              IShape.
   * @param horizontal a double representing the horizontal
   *                   dimension of this IShape
   * @param vertical a double representing the vertical
   *                 dimension of this IShape
   */
  public AbstractShape(String name, double x, double y, Color color,
                       double horizontal, double vertical) {
    if (horizontal <= 0 || vertical <= 0) {
      throw new IllegalArgumentException("Invalid height and/or width");
    }

    this.name = name;
    this.position = new Point2D(x, y);
    this.color = color;
    this.horizontal = horizontal;
    this.vertical = vertical;

  }

  /**
   * The constructor of the AbstractShape class.
   * @param name a String representing the name of the shape
   * @param position a Point2D object representing the position in a cartesian
   *                 graph
   * @param color a Color object representing the color of the AbstractShape
   * @param horizontal a double representing the horizontal
   *                   dimension of this IShape
   * @param vertical a double representing the vertical
   *                 dimension of this IShape
   */
  public AbstractShape(String name, Point2D position, Color color, double horizontal, double vertical) {
    if (horizontal <= 0 || vertical <= 0) {
      throw new IllegalArgumentException("Invalid height and/or width");
    }
    this.name = name;
    this.position = position;
    this.color = color;
    this.horizontal = horizontal;
    this.vertical = vertical;

  }

  /**
   * Getter method that returns the position of the shape.
   * @return the model.Point2D position of a shape.
   */
  public Point2D getPosition() {
    return this.position;
  }

  /**
   * Changes the color of the AbstractShape.
   * @param newColor a Color object
   * @return the AbstractShape's new color.
   */

  /**
   * Changes the color of the IShape to a newColor.
   * @param newColor the desired color change of this
   *                 IShape.
   * @return a Color object
   */
  @Override
  public Color changeColor(Color newColor) {
    this.color = newColor;
    return this.color;
  }


  /**
   * Moves the AbstractShape to a different cartesian point.
   * @param x a double representing the x coordinate
   * @param y a double representing the y coordinate
   * @return a Point2D point.
   */
  @Override
  public Point2D move(double x, double y) {
    this.position = new Point2D(x, y);
    return this.position; //probably change to void
  }

  /**
   * Moves the AbstractShape to a different cartesian point.
   * @param coordinate a Point2D object
   * @return the new Point2D position of this AbstractShape
   */
  @Override
  public Point2D move(Point2D coordinate) {
    this.position = coordinate;
    return this.position; //probably change to void
  }

  /**
   * Changes the size of this AbstractShape.
   * @param horizontal a double representing one dimension of
   *                   this AbstractShape
   * @param vertical a double representing one dimension of this
   *                 AbstractShape
   */
  @Override
  public void changeSize(double horizontal, double vertical) {
    if (horizontal <= 0 || vertical <= 0) {
      throw new IllegalArgumentException("Invalid newRadiusX and/or newRadiusY");
    }
    this.horizontal = horizontal;
    this.vertical = vertical;
  }


  /**
   * Getter method that returns this IShape's
   * horizontal dimension.
   * @return a double representing the IShape's
   *         horizontal dimension.
   */
  @Override
  public double getHorizontal() {
    return this.horizontal;
  }

  /**
   * Getter method that returns this IShape's
   * vertical dimension.
   * @return a double representing the IShape's
   *         vertical dimension.
   */
  @Override
  public double getVertical() {
    return this.vertical;
  }



  /**
   * A getter method that returns this AbstractShape's
   * color.
   * @return a Color object representing this AbstractShape's
   *         color.
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * A getter method representing this AbstractShape's
   * name.
   * @return a String representing this AbstractShape's name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * A getter method representing this AbstractShape's
   * type.
   * @return a String representing this AbstractShape's name.
   */
  public String getType() {
    return null;
  }
}
