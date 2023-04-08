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

  //potentially add dimension1 and dimension2

  /**
   * Displays the constructor of an AbstractShape
   * @param name a String representing the name of the shape
   * @param x
   * @param y
   * @param color
   */
  public AbstractShape(String name, double x, double y, Color color) {
    //delete x and y include Point2D
    this.name = name;
    this.position = new Point2D(x, y);
    this.color = color;

  }

  /**
   * The constructor of the AbstractShape class.
   * @param name a String representing the name of the shape
   * @param position a Point2D object representing the position in a cartesian
   *                 graph
   * @param color a Color object representing the color of the AbstractShape
   */
  public AbstractShape(String name, Point2D position, Color color) {
    this.name = name;
    this.position = position;
    this.color = color;

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

  @Override
  public Color changeColor(Color newColor) {
    this.color = newColor;
    return this.color;
  }

  //ASK TA: which one to use for changeColor
 // public void changeColor(int red, int green, int blue) {
   // this.color = new Color(red, green, blue);
  //}

  //change to void

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
    this.horizontal = horizontal;
    this.vertical = vertical;
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
}
