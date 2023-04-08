import org.junit.Before;

import model.Color;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the methods of the Color class.
 */
public class ColorTest {
  private Color color1;
  private Color color2;

  /**
   * Creates Color object instances.
   */
  @Before
  public void setUp() {
    color1 = new Color(25, 30, 3);

  }

  /**
   * Tests the attempts to create bad Color object instances.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadSetUp() {
    Color c1 = new Color(0, -1, 10);
  }

  /**
   * Tests the getRed method of the Color class.
   */
  @Test
  public void testGetRed() {
    assertEquals(25, color1.getRed(), 0.001);
  }

  /**
   * Tests the getGreen method of the Color class.
   */
  @Test
  public void testGetGreen() {
    assertEquals(30, color1.getGreen(), 0.001);
  }

  /**
   * Tests the 'getBlue' method of the Color class.
   */
  @Test
  public void testGetBlue() {
    assertEquals(3,color1.getBlue(), 0.001);
  }

  /**
   * Tests the 'toString' method of the Color class.
   */
  @Test
  public void testToString() {
    assertEquals("(25.0,30.0,3.0)", color1.toString());
  }

}
