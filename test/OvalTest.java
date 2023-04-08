import model.Color;
import model.Oval;
import model.Point2D;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the methods of the Oval class.
 */
public class OvalTest {
  private Oval oval1;

  /**
   * Creates Oval object instances.
   */
  @Before
  public void setUp() {
    Point2D point1 = new Point2D(500.0, 100.0);
    Color color1 = new Color(0, 0, 1);
    oval1 = new Oval("O", point1, color1, 60, 30);
  }

  /**
   * Tests the getRadiusX method of the Oval class.
   */
  @Test
  public void testGetRadiusX() {
    assertEquals(60, oval1.getRadiusX(), 0.001);
  }

  /**
   * Tests the getRadiusY method of the Oval class.
   */
  @Test
  public void testGetRadiusY() {
    assertEquals(30, oval1.getRadiusY(), 0.001);
  }
}
