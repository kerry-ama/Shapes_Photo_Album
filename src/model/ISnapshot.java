package model;

import java.util.List;

/**
 * Represents the current state of a screen. Classes that
 * implement ISnapshot should be able to get the object's id,
 * timestamp, description, and represent itself as a String.
 */
public interface ISnapshot {

  /**
   * Returns a String representation of this ISnapshot's id.
   * @return a String representation of this ISnapshot's id.
   */
  String getId();

  /**
   * A getter method that returns this Snapshot's timestamp.
   * @return a String representation of this Snapshot's
   *         timestamp.
   */
  String getTimeStamp();

  /**
   * A getter method that returns this ISnapshot's
   * description.
   * @return a String representing this Snapshot's
   *         description.
   */
  String getDescription();

  /**
   * Returns a String representation of this Snapshot in the form:
   * Snapshot ID:
   * TimeStamp:
   * Description:
   * Shape Information: .
   * @return a String representation of this PhotoAlbumModel
   */
  String toString();


  /**
   * Returns a list of this Snapshot's shape's.
   * @return a list of IShape shapes.
   */
  List<IShape> getListOfShapes();
}
