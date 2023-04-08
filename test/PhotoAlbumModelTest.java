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


  }

  /**
   * Tests the createShape method.
   */
  @Test
  public void testCreateShape() {
    Color color1 = new Color(1, 0, 0);
    IShape shape1 =  model1.createShape("rectangle", "R",
            200, 200, color1, 50, 100 );

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
    List<IShape> list1 = new ArrayList<>();
    list1.add(shape1);
    Snapshot snap1;
    snap1 = model1.takeSnapshot("First", list1);
    System.out.println(snap1);
    System.out.println("\n");
    Color color = new Color(1, 0, 0);
    IShape shape2 = new Oval("O",
            200, 200, color, 50, 100 );

    list1.add(shape2);
    Snapshot snap2 = model1.takeSnapshot("Second", list1);
    System.out.println(snap2);
  }

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

    Snapshot s2 = new Snapshot("Second", list2, id, timeStamp.format(time));
    model1.addSnapshot(s2);



    System.out.println(model1.getSnapshot(2).toString());
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
    System.out.println(model1.toString());
    Snapshot snap1 = model1.takeSnapshot("First");
    model1.addSnapshot(snap1);
    System.out.println(model1.toString());
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
    System.out.println(model1.getSnapshot(1).toString());
    //assertEquals();
  }

  /**
   * Tests the removeShape method.
   */
  @Test//(expected = NoSuchElementException.class)
  public void testBadRemoveShape() {
    //System.out.println(model2.toString());
    //model2.removeShape("shapes");
    //System.out.println(model2.toString());
    model2.addShape(shape);
   Snapshot shot1 = model2.takeSnapshot("snap1");
    model2.addSnapshot(shot1);
    model2.removeShape("R");
    System.out.println(model2.toString());

    //System.out.println(model2.toString());
    //System.out.println(model2.toString());
    //model2.removeShape("R");
   // Snapshot shot2 = model2.takeSnapshot("snap2");
    //model2.addSnapshot(shot2);
    //System.out.println(model2.toString());
  }




}
