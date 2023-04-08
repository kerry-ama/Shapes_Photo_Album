package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A Snapshot implements all the methods mandated by the
 * ISnapshot interface. A Snapshot object represents the
 * current state of a screen. A Snapshot object knows its
 * description, its list of shapes, its id, and its timestamp
 * (ie when the snapshot was produced).
 */
public class Snapshot implements ISnapshot {

  private String description;
  private List<IShape> shapes = new ArrayList<>(); //ASK TA: is this necessary
  private SimpleDateFormat id;
  private String timeStamp;


  /*
  private final SimpleDateFormat id
          = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.ssssss");
  private final SimpleDateFormat timeStamp
          = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
  */
  //ASK: TA should I add/remove shape?
  //could consider passing in id as a String

  /**
   * Constructs a Snapshot object.
   * @param description a String representing a description of the
   *                    Snapshot
   * @param shapes a list of IShapes representing the shapes that are
   *               in this Snapshot
   * @param id a SimpleDateFormat object that represents the date and time
   *           this Snapshot was produced in the form:
   *           yyyy-MM-dd'T'HH:mm:ss.ssssss.
   * @param timeStamp a SimpleDateFormat object that represents the date
   *                  and time this Snapshot was produced in the form:
   *                  dd-MM-yyyy HH:mm:ss.
   */
  public Snapshot(String description, List<IShape> shapes, SimpleDateFormat id, String timeStamp) { //add to const
    this.description = description;
    this.shapes = shapes;
    this.id = id;
    this.timeStamp = timeStamp;
  }


  /**
   * Returns a String representation of this Snapshot's id.
   * @return a String representation of this Snapshot's id.
   */
  public String getId() { //SimpleDateFormat instead of string
    java.sql.Timestamp time = new Timestamp(System.currentTimeMillis());
    //LocalDateTime time2 = LocalDateTime.of()
    //return this.id.format(time);
    return this.id.format(time);
  }

  /**
   * A getter method that returns this Snapshot's timestamp.
   * @return a String representation of this Snapshot's
   *         timestamp.
   */
  public String getTimeStamp() {
    return this.timeStamp;
  }

  /**
   * A getter method that returns this Snapshot's
   * description.
   * @return a String representing this Snapshot's
   *         description.
   */
  public String getDescription() {
    return this.description;
  }


  /**
   * Returns a String representation of this Snapshot in the form:
   * Snapshot ID:
   * TimeStamp:
   * Description:
   * Shape Information: .
   * @return a String representation of this PhotoAlbumModel
   */

  public String toString() {
    StringBuilder shapesListString = new StringBuilder();
    for (IShape shape: this.shapes) {
      shapesListString.append(shape.toString());
      shapesListString.append("\n\n");
    }

    java.sql.Timestamp time = new Timestamp(System.currentTimeMillis());
    if (shapesListString.length() <= 0 ) {
      return "Snapshot ID: " + this.id.format(time) + "\n"
              + "Timestamp: " + this.timeStamp + "\n"
              + "Description: " + this.getDescription() + "\n";
    }
    return "Snapshot ID: " + this.id.format(time) + "\n"
            + "Timestamp: " + this.timeStamp + "\n"
            + "Description: " + this.getDescription() + "\n"
            + "Shape Information:" + "\n" + shapesListString.substring(0, shapesListString.length() - 2);
  }
}
