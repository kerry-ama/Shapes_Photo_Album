package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A PhotoAlbumModel implements all the methods mandated by the
 * IPhotoAlbumModel. A PhotoAlbumModel knows its list of IShape
 * objects as well as its list of Snapshot objects. A PhotoAlbumModel
 * is able to create new IShapes, take Snapshots, add snapshots to its
 * list, add shapes to its list, remove shapes from its list, delete snapshots
 * from its list, move shapes, resize shapes, and be represented
 * as a String.
 */
public class PhotoAlbumModel implements IPhotoAlbumModel {//similar to registration system
  private List<IShape> listOfIShapes; //canvas, current
  private List<Snapshot> listOfSnapshots; //historical


  /**
   * The Constructor of the PhotoAlbumModel class that constructs
   * a PhotoAlbumModel object. The PhotoAlbumMo
   */
  public PhotoAlbumModel() {
    this.listOfIShapes = new LinkedList<>();
    //this.listOfSnapshots = new ArrayList<>(); //preserve order (consider chaning to a linkedlist)
    this.listOfSnapshots = new LinkedList<>();
  }

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
  public IShape createShape(String shapeType, String shapeName, double x, double y, Color color,
                       double width, double height) {
    if (shapeType.equalsIgnoreCase("rectangle")) {
      return new Rectangle(shapeName, x, y, color, width, height);
    }
    if (shapeType.equalsIgnoreCase("oval")) {
      return new Oval(shapeName, x, y, color, width, height);
    }
    return null;
  }



  /**
   * Takes a snapshot of this PhotoAlbum model.
   * @param description a String representing a snapshot's description
   * @return a Snapshot object of the current state of this PhotoAlbumModel
   */
  public Snapshot takeSnapshot(String description) {
    SimpleDateFormat id = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.ssssss");
    SimpleDateFormat timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    java.sql.Timestamp time = new Timestamp(System.currentTimeMillis());
    List<IShape> shapeList = this.listOfIShapes;

    return new Snapshot(description, shapeList, id, timeStamp.format(time));
  }

  /**
   * Adds a Snapshot object to the list array 'listOfSnapshots.'
   * @param newSnapshot a Snapshot object
   */
  public void addSnapshot(Snapshot newSnapshot) {
    this.listOfSnapshots.add(newSnapshot);
  }


  /**
   * Adds a shape to the photo album.
   * @param newShape an IShape that will be added to the screen.
   */
  public void addShape(IShape newShape) {
    this.listOfIShapes.add(newShape);
  }

  /**
   * Returns a specific snapshot.
   * @param num the order of the desired snapshot is added
   * @return a Snapshot object.
   * @throws IllegalArgumentException if the snapshot does not exist.
   */
  public Snapshot getSnapshot(int num) throws IllegalArgumentException {
    if (num > this.listOfSnapshots.size() || num <= 0) {
      throw new IllegalArgumentException("There is no such snapshot");
    }
    return this.listOfSnapshots.get(num -1);
  }


  /**
   * Removes a shape from this PhotoAlbumModel's list of shapes.
   * @param name a String representing the desired shape to be removed
   *             name
   * @throws NoSuchElementException if the shape does not exist
   */
  public void removeShape(String name) throws NoSuchElementException {
    for (IShape shape: this.listOfIShapes) {
      if (shape.getName().equalsIgnoreCase(name)) {
        this.listOfIShapes.remove(shape);
      }
    }
  }

  /**
   * Moves the shape of a shape with
   * a specific name.
   * @param name a String representing the shape's name
   * @param x a double representing the shape's new x coordinate
   * @param y a double representing the shape's new y coordinate
   */
  public void moveShape(String name, double x, double y) {
    for (IShape shape: this.listOfIShapes) {
      if(shape.getName().equalsIgnoreCase(name)) {
        shape.move(x, y); //could change to Point2D
      }
    }
  }

  /**
   * Moves the shape of a given shape to a new position
   * in a cartesian plane.
   * @param name a String representing the name of the shape
   * @param newPosition a Point2D object that represents
   *                    the new position on a cartesian plane of the
   *                    new object.
   */
  public void moveShape(String name, Point2D newPosition) { //keep both
    for (IShape shape: this.listOfIShapes) {
      if(shape.getName().equalsIgnoreCase(name)) {
        shape.move(newPosition);
      }
    }
  }

  /**
   * Deletes a snapshot from this PhotoAlbumModel.
   * @param description a String representation of the Snapshot
   *                    that is going to be deleted.
   */
  public void deleteSnapshot(String description) {
    for (Snapshot snap: this.listOfSnapshots) {
      if(snap.getDescription().equalsIgnoreCase(description)) {
        this.listOfSnapshots.remove(snap);
      }

    }
  }

  /**
   * Changes the size of a shape with a given name
   * in the listOfIShapes.
   * @param name the name of a shape
   * @param horizontal a double representing the horizontal
   *                   dimension of a shape
   * @param vertical a double representing the vertical
   *                 dimension of a shape
   */
  public void reSizeShape(String name, double horizontal, double vertical) {
    for (IShape shape: this.listOfIShapes) {
      if (shape.getName().equalsIgnoreCase(name)) {
        shape.changeSize(horizontal, vertical);
      }
    }
  }

  /**
   * Resets the listOfSnapshots to a new array.
   */
  public void reset() {
    this.listOfSnapshots = new LinkedList<>();
  }

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
  public String toString() {
    StringBuilder shapesListString = new StringBuilder();

    for (Snapshot shots: this.listOfSnapshots) {
      shapesListString.append(shots.toString());
      shapesListString.append("\n\n\n");
    }
    return "Printing Snapshots\n" + shapesListString;

  }

}
