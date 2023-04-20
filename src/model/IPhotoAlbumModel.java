package model;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * IPhotoAlbumModel is an interface representing a collection
 * of {@link IShape} and {@link ISnapshot}.
 */
public interface IPhotoAlbumModel {

  /**
   * Creates an IShape object to be placed in photo album.
   * @param shapeType represents a shape type
   *                  //possibly change to an enum
   * @param shapeName a String representation of a shape's name
   * @param x a double representing the x-coordinate
   * @param y a double representing the y-coordinate
   * @param color a Color object representing the new IShape's color
   * @param width a double representing the first dimension of the new
   *              IShape
   * @param height a double representing the second dimension of the new
   *               IShape
   * @return a new IShape object.
   */
  IShape createShape(String shapeType, String shapeName, double x, double y,
                     Color color, double width, double height);

  /**
   * Takes a snapshot of this PhotoAlbum model.
   * @param description a String representing a snapshot's description
   * @return a Snapshot object of the current state of this PhotoAlbumModel
   */
  Snapshot takeSnapshot(String description);

  /**
   * Takes a snapshot of this PhotoAlbumModel.
   * @return a Snapshot object of the current state of
   *         this PhotoAlbumModel
   */
  Snapshot takeSnapshot();

  /**
   * Adds a Snapshot object to the list array 'listOfSnapshots.'
   * @param newSnapshot a Snapshot object
   */
  void addSnapshot(Snapshot newSnapshot);

  /**
   * Adds a shape to the photo album.
   * @param newShape an IShape that will be added to the screen.
   */
  void addShape(IShape newShape);

  /**
   * Returns a specific snapshot.
   * @param num the order of the desired snapshot is added
   * @return a Snapshot object.
   * @throws IllegalArgumentException if the snapshot does not exist.
   */
  Snapshot getSnapshot(int num);

  /**
   * Removes a shape from this IPhotoAlbumModel's list of shapes.
   * @param name a String representing the desired shape to be removed
   *             name
   * @throws NoSuchElementException if the shape does not exist
   */
  void removeShape(String name);

  /**
   * Moves the shape of a shape with
   * a specific name.
   * @param name a String representing the shape's name
   * @param x a double representing the shape's new x coordinate
   * @param y a double representing the shape's new y coordinate
   */
  void moveShape(String name, double x, double y);

  /**
   * Moves the shape of a given shape to a new position
   * in a cartesian plane.
   * @param name a String representing the name of the shape
   * @param newPosition a Point2D object that represents
   *                    the new position on a cartesian plane of the
   *                    new object.
   */
  void moveShape(String name, Point2D newPosition);

  /**
   * Deletes a snapshot from this PhotoAlbumModel.
   * @param description a String representation of the Snapshot
   *                    that is going to be deleted.
   */
  void deleteSnapshot(String description);

  /**
   * Changes the size of a shape with a given name
   * in the listOfIShapes.
   * @param name the name of a shape
   * @param horizontal a double representing the horizontal
   *                   dimension of a shape
   * @param vertical a double representing the vertical
   *                 dimension of a shape
   */
  void reSizeShape(String name, double horizontal, double vertical);

  /**
   * Resets the listOfSnapshots to a new array.
   */
  void reset();

  /**
   * Returns a list of this PhotoAlbumModel's Snapshots.
   * @return a list of Snapshot objects
   */
  List<Snapshot> getListOfSnapshots();

  /**
   * Returns a String representation of the PhotoAlbumModel in the
   * form:
   * Printing Snapshots
   * Snapshot ID:
   * Timestamp:
   * Description:
   * Shape Information:
   * Name:
   * Type:
   * Min corner: ( , ), 'horizontal dimension': , 'vertical dimension': ,
   * Color: (, , ).
   * @return a String representation of the PhotoAlbumModel
   */
  String toString();





}


