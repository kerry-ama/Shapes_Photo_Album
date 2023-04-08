import model.Point2D;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the methods of the Point2D class.
 */
public class Point2DTest {
  private Point2D point1;

  /**
   * Creates Point2D object instances.
   */
  @Before
  public void setUp() {
    point1 = new Point2D(100, 300);

  }

  /**
   * Tests the 'getX' method of the Point2D class.
   */
  @Test
  public void testGetX() {
    assertEquals(100, point1.getX(), 0.001);
  }

  /**
   * Tests the 'getY' method of the Point2D class.
   */
  @Test
  public void testGetY() {
    assertEquals(300, point1.getY(), 0.001 );
  }

  /**
   * Tests the 'toString' method of the Point2D class.
   */
  @Test
  public void testToString() {
    assertEquals("(100.0,300.0)", point1.toString());
  }
}
