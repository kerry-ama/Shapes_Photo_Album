package model;

/**
 * This class represents a 2D cartesian point.
 * A Point2D object knows its x_coordinate and y_coordinate.
 */
public class Point2D {
  private double x_coord;
  private double y_coord;

  /**
   * Constructs a 2D point on cartesian graph.
   * @param x_coord a double representing the x
   *                coordinate in a cartesian plane
   * @param y_coord a double representing the y
   *                coordinate in a cartesian plane
   */
  public Point2D(double x_coord, double y_coord) {
    this.x_coord = x_coord;
    this.y_coord = y_coord;
  }

  /**
   * Getter method that returns the x coordinate.
   * @return a double representing the x coordinate
   */
  public double getX() {
    return x_coord;
  }

  /**
   * Getter method that returns the y coordinate.
   * @return a double representing the y coordinate.
   */
  public double getY() {
    return y_coord;
  }

  /**
   * Returns a String representation of this Point2D.
   * @return a String representation of this Point2D object
   *         instance.
   */
  public String toString() {
    return "(" + this.x_coord + "," + this.y_coord + ")";
  }
}
