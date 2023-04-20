package model;



/**
 * This interface represents an IShape. An IShape
 * is a shape that can change its color, move to
 * a new position in a cartesian plane, change its size,
 * return its current color, returns its current position,
 * and return its current name.
 */
public interface IShape {

  /**
   * Changes the color of the IShape.
   * @param newColor the desired color change of this
   *                 IShape.
   * @return a Color object representing the new Color of
   *         this IShape.
   */
  Color changeColor(Color newColor);

  /**
   * Moves the IShape to a different coordinate
   * on a cartesian plane.
   * @param x a double representing the IShape's new
   *          x-coordinate
   * @param y a double representing the IShape's new
   *          y-coordinate
   * @return a Point2D object representing the IShape's new
   *         position.
   */
  Point2D move(double x, double y);

  /**
   * Moves the IShape to a different coordinate
   * on a cartesian plane.
   * @param newPosition a Point2D object representing
   *                    the IShape's new position.
   * @return a Point2D object representing the IShape's new
   *         position.
   */
  Point2D move(Point2D newPosition);

  /**
   * Changes the size of the IShape.
   * @param newHorizontal a double representing the width
   *                 dimension of the IShape.
   * @param newVertical a double representing the height/vertical
   *                  dimension of the IShape.
   */
  void changeSize(double newHorizontal, double newVertical);

  double getHorizontal();

  double getVertical();



  /**
   * A getter method that returns this IShape's
   * Color.
   * @return a Color object representing this IShape's Color.
   */
  Color getColor();

  /**
   * A getter method that returns this
   * IShape's position on a cartesian plane.
   * @return a Point2D object representing the position
   *         of this IShape.
   */
  Point2D getPosition();

  /**
   * A getter method that returns this IShape's
   * name.
   * @return a String representing this IShape's name.
   */
  String getName();


  /**
   * A getter method that returns this IShape's
   * type.
   * @return a String representing this IShape's type.
   */
  String getType();







}
