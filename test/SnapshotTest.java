import model.*;
import model.Color;
import model.Snapshot;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests the methods of the Snapshot class.
 */
public class SnapshotTest {
  private Snapshot shot1;

  /**
   * Creates Snapshot object instances.
   */
  @Before
  public void setUp() {
    Point2D point1 = new Point2D(200, 200);
    Color color1 = new Color(1,0,0);
    IShape R = new Rectangle("R", point1, color1, 50, 100);
    Point2D point2 = new Point2D(500, 100);
    Color color2 = new Color(0,0,1);
    IShape O = new Oval("O", point2, color2, 60, 30);
    List<IShape> listofshapes = new ArrayList<>();
    listofshapes.add(R);
    listofshapes.add(O);

    SimpleDateFormat id
            = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.ssssss");
    SimpleDateFormat timeStamp
            = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    java.sql.Timestamp time = new Timestamp(System.currentTimeMillis());

    //shot1 = new Snapshot("After first selfie", listofshapes, id.format(time), timeStamp.format(time));
    shot1 = new Snapshot("After first selfie", listofshapes, id.format(time), java.time.LocalDateTime.now().toString());
  }

  /**
   * Tests the getId method.
   */
  @Test
  public void testGetId() {
    assertEquals("Snapshot ID: " + shot1.getId() + "\n"
            + "Timestamp: " + shot1.getTimeStamp() + "\n" + "Description: After first selfie\n"
            +  "Shape Information:\n" +  "Name: R\n" + "Type: rectangle\n"
            + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)\n"
            + "\n" + "Name: O\n" + "Type: oval\n"
            + "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, "
            +  "Color: (0.0,0.0,1.0)", shot1.toString());
    System.out.println(shot1.getId());
  }


  /**
   * Tests the getTimeStamp method.
   */
  @Test
  public void testGetTimeStamp() {
    assertEquals("Snapshot ID: " + shot1.getId() + "\n"
            + "Timestamp: " + shot1.getTimeStamp() + "\n" + "Description: After first selfie\n"
            +  "Shape Information:\n" +  "Name: R\n" + "Type: rectangle\n"
            + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)\n"
            + "\n" + "Name: O\n" + "Type: oval\n"
            + "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, "
            +  "Color: (0.0,0.0,1.0)", shot1.toString());
    System.out.println(shot1.getTimeStamp());
    shot1.getTimeStamp();


  }

  /**
   * Tests the getDescription method.
   */
  @Test
  public void testGetDescription() {
    assertEquals("After first selfie", shot1.getDescription());
  }

  /**
   * Tests the toString method.
   */
  @Test
  public void testToString() {


    assertEquals("Snapshot ID: " + shot1.getId() + "\n"
            + "Timestamp: " + shot1.getTimeStamp() + "\n" + "Description: After first selfie\n"
            +  "Shape Information:\n" +  "Name: R\n" + "Type: rectangle\n"
            + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)\n"
            + "\n" + "Name: O\n" + "Type: oval\n"
            + "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, "
            +  "Color: (0.0,0.0,1.0)", shot1.toString());


  }

}
