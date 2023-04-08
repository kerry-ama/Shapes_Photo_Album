import model.*;
import model.Color;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests the methods of the PhotoAlbumModel class.
 */
public class PhotoAlbumModelTest {
  private PhotoAlbumModel model1;
  private PhotoAlbumModel model2;
  private IShape shape;
  private IShape shape2;

  /**
   * Creates object instances of the PhotoAlbumModel.
   */
  @Before
  public void setUp() {

    model1 = new PhotoAlbumModel();
    model2 = new PhotoAlbumModel();

    Color color = new Color(1, 0, 0);
    shape = new Rectangle("R",
            200, 200, color, 50, 100 );

    shape2 = new Oval("O",
            200, 200, color, 50, 100 );

    model2.addShape(shape2);
    //model2.addShape(shape);

    Color color1 = new Color(1, 0, 0);
    IShape shape2 = new Oval("O", 200, 200, color, 50, 100 );
  }

  /**
   * Tests the createShape method.
   */
  @Test
  public void testCreateShape() {
    Color color1 = new Color(1, 0, 0);
    IShape shape1 =  model1.createShape("rectangle", "R",
            200, 200, color1, 50, 100 );

    assertEquals("Name: R\n"
           +  "Type: rectangle\n"
            + "Min corner: (200.0,200.0), Width: 50.0, "
            + "Height: 100.0, Color: (1.0,0.0,0.0)", shape1.toString());

    IShape r1 = new Rectangle("R", 200, 200, color1, 50, 100);
    assertEquals(r1.getName(), shape1.getName());
    Point2D point = new Point2D(200, 200);
    assertEquals(point.getX(), r1.getPosition().getX(), 0.001);

  }

  /**
   * Tests the takeSnapshot method.
   */
  @Test
  public void testTakeSnapshot() {
    Color color1 = new Color(1, 0, 0);
    IShape shape1 =  model1.createShape("rectangle", "R",
            200, 200, color1, 50, 100 );


    Snapshot snap1;
    snap1 = model1.takeSnapshot("First");

    assertEquals("Snapshot ID: " + snap1.getId()
            + "\n" + "Timestamp: " + snap1.getTimeStamp() + "\n"
            + "Description: " + snap1.getDescription() + "\n", snap1.toString());

    Snapshot snap2 = model2.takeSnapshot("Second");
    assertEquals("Snapshot ID: " + snap1.getId()
            + "\n" + "Timestamp: " + snap1.getTimeStamp() + "\n"
            + "Description: " + snap2.getDescription() + "\n"
            + "Shape Information:" + "\n"+ "Name: O" +  "\n" + "Type: oval" + "\n"
            + "Center: (200.0,200.0), X radius: 50.0, Y radius: "
            + "100.0, Color: (1.0,0.0,0.0)", snap2.toString());
  }

  /**
   * Tests the addSnapshot method.
   */
  @Test
  public void testAddSnapshot() {
    Color color = new Color(1, 0, 0);
    IShape shape = new Rectangle("R",
            200, 200, color, 50, 100 );

    IShape shape2 = new Oval("O",
            200, 200, color, 50, 100 );

    List<IShape> list1 = new ArrayList<>();
    list1.add(shape);
    list1.add(shape2);

    List<IShape> list2 = new ArrayList<>();
    list2.add(shape2);

    final SimpleDateFormat id
            = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.ssssss");
    final SimpleDateFormat timeStamp
            = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    java.sql.Timestamp time = new Timestamp(System.currentTimeMillis());

    Snapshot s1 = new Snapshot("First", list1, id, timeStamp.format(time));


    model1.addSnapshot(s1);

    assertEquals("Snapshot ID: " + s1.getId()+ "\n"
                      + "Timestamp: " + s1.getTimeStamp() + "\n"
                       + "Description: " + s1.getDescription() + "\n"
            + "Shape Information:" + "\n"+ "Name: R" +  "\n"
            + "Type: rectangle" + "\n"
            + "Min corner: (200.0,200.0), Width: 50.0, Height: "
            + "100.0, Color: (1.0,0.0,0.0)" + "\n"
            + "\n"+ "Name: O" +  "\n" + "Type: oval" + "\n"
            + "Center: (200.0,200.0), X radius: 50.0, Y radius: "
            + "100.0, Color: (1.0,0.0,0.0)",model1.getSnapshot(1).toString());



  }

  /**
   * Tests the 'addShape' method.
   */
  @Test
  public void testAddShape() {
    Color color = new Color(1, 0, 0);
    IShape shape2 = new Oval("O",
            200, 200, color, 50, 100 );

    model1.addShape(shape2);
    assertEquals("Printing Snapshots\n", model1.toString());

    Snapshot snap1 = model1.takeSnapshot("First");
    model1.addSnapshot(snap1);
    assertEquals("Snapshot ID: " + snap1.getId() + "\n"
           +  "Timestamp: " + snap1.getTimeStamp() + "\n" + "Description: First\n"
           + "Shape Information:\n" + "Name: O\n" + "Type: oval\n"
           + "Center: (200.0,200.0), X radius: 50.0, Y radius: 100.0, "
           + "Color: (1.0,0.0,0.0)",model1.getSnapshot(1).toString());

  }

  /**
   * Tests the getSnapshot method.
   */
  @Test
  public void testGetSnapshot() {
    model1.addShape(shape);
    model1.addShape(shape2);
    Snapshot snap1 = model1.takeSnapshot("SNAP!");
    model1.addSnapshot(snap1);
    assertEquals("Snapshot ID: " + snap1.getId() + "\n" + "Timestamp: "
            + snap1.getTimeStamp() + "\n" +"Description: SNAP!\n" + "Shape Information:\n"
            +  "Name: R\n" + "Type: rectangle\n"
            + "Min corner: (200.0,200.0), Width: 50.0, "
            + "Height: 100.0, Color: (1.0,0.0,0.0)\n" + "\n"
            + "Name: O\n" + "Type: oval\n" + "Center: (200.0,200.0), "
            + "X radius: 50.0, Y radius: " + "100.0, Color: (1.0,0.0,0.0)",
            model1.getSnapshot(1).toString());


  }

  /**
   * Tests the removeShape method.
   */
  @Test
  public void testBadRemoveShape() {

    model2.addShape(shape);
    Snapshot shot1 = model2.takeSnapshot("snap1");
    model2.addSnapshot(shot1);

    model2.removeShape("P");
    assertEquals("Printing Snapshots\n"
            + "Snapshot ID: 2023-04-08T18:13:57.000057\n"
            + "Timestamp: 08-04-2023 18:13:57\n" + "Description: snap1\n"
            + "Shape Information:\n" + "Name: O\n"
            + "Type: oval\n" + "Center: (200.0,200.0), X radius: 50.0, "
            + "Y radius: 100.0, Color: (1.0,0.0,0.0)\n"
            + "\n" + "Name: R\n" + "Type: rectangle\n" + "Min corner: "
            + "(200.0,200.0), " + "Width: 50.0, Height: 100.0, "
            + "Color: (1.0,0.0,0.0)",model2.toString());

  }

  /**
   * Tests the removeShape method.
   */
  @Test
  public void testRemoveShape() {
    Snapshot shot1 = model2.takeSnapshot("snap1");
    model2.addSnapshot(shot1);
    model2.removeShape("O");
    assertEquals("Printing Snapshots\nSnapshot ID: "
            + shot1.getId() + "\n" + "Timestamp: " + shot1.getTimeStamp()
            + "\n" + "Description: snap1" + "\n\n\n\n", model2.toString());
  }

  /**
   * Tests the moveShape method.
   */
  @Test
  public void testMoveShape() {
    Snapshot shot1 = model2.takeSnapshot("snap1");
    model2.addSnapshot(shot1);
    assertEquals("Printing Snapshots\n"
           + "Snapshot ID: " + shot1.getId() + "\n"
           + "Timestamp: " + shot1.getTimeStamp() + "\n"
           +  "Description: snap1\n"
           + "Shape Information:\n" + "Name: O\n" + "Type: oval\n"
           + "Center: (200.0,200.0), X radius: 50.0, "
           + "Y radius: 100.0, Color: (1.0,0.0,0.0)\n\n\n", model2.toString());
    model2.moveShape("O", 0, 0);
    assertEquals("Printing Snapshots\n"
            + "Snapshot ID: " + shot1.getId() + "\n"
            + "Timestamp: " + shot1.getTimeStamp() + "\n"
            +  "Description: snap1\n"
            + "Shape Information:\n" + "Name: O\n" + "Type: oval\n"
            + "Center: (0.0,0.0), X radius: 50.0, "
            + "Y radius: 100.0, Color: (1.0,0.0,0.0)\n\n\n", model2.toString());
  }


  /**
   * Tests the deleteSnapshot method.
   */
  @Test
  public void testDeleteSnapshot() {
    Snapshot shot1 = model2.takeSnapshot("snap1");
    model2.addSnapshot(shot1);
    model2.deleteSnapshot("snap1");
    assertEquals("Printing Snapshots\n",model2.toString());

  }


  @Test
  public void testResizeShape() {
    Snapshot shot1 = model2.takeSnapshot("snap1");
    model2.addSnapshot(shot1);
    assertEquals("Printing Snapshots\n"
            + "Snapshot ID: " + shot1.getId() + "\n"
            + "Timestamp: " + shot1.getTimeStamp() + "\n"
            +  "Description: snap1\n"
            + "Shape Information:\n" + "Name: O\n" + "Type: oval\n"
            + "Center: (200.0,200.0), X radius: 50.0, "
            + "Y radius: 100.0, Color: (1.0,0.0,0.0)\n\n\n", model2.toString());
    model2.moveShape("O", 0, 0);
    assertEquals("Printing Snapshots\n"
            + "Snapshot ID: " + shot1.getId() + "\n"
            + "Timestamp: " + shot1.getTimeStamp() + "\n"
            +  "Description: snap1\n"
            + "Shape Information:\n" + "Name: O\n" + "Type: oval\n"
            + "Center: (200.0,200.0), X radius: 50.0, "
            + "Y radius: 100.0, Color: (1.0,0.0,0.0)\n\n\n", model2.toString());
  }

  /**
   * Tests the reset method.
   */
  @Test
  public void testReset() {
    Snapshot shot1 = model2.takeSnapshot("snap1");
    model2.addSnapshot(shot1);
    model2.reset();
    assertEquals("Printing Snapshots\n", model2.toString());

  }

  /**
   * Tests the toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Printing Snapshots\n",model1.toString());

    Snapshot shot1 = model2.takeSnapshot("snap1");
    model2.addSnapshot(shot1);
    assertEquals("Printing Snapshots\n"
            + "Snapshot ID: "+ shot1.getId() + "\n"
            + "Timestamp: " + shot1.getTimeStamp() + "\n"
            + "Description: snap1\n"
            + "Shape Information:\n"
            + "Name: O\n"
            + "Type: oval\n"
            + "Center: (200.0,200.0), X radius: 50.0, " +
            "Y radius: 100.0, Color: (1.0,0.0,0.0)\n\n\n",model2.toString());
  }



}
