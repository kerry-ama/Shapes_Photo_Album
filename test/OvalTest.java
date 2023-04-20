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
  private Oval oval2;

  /**
   * Creates Oval object instances.
   */
  @Before
  public void setUp() {
    Point2D point1 = new Point2D(500.0, 100.0);
    Color color1 = new Color(0, 0, 1);
    Color color2 = new Color(255, 255, 255);
    oval1 = new Oval("O", point1, color1, 60, 30);
    oval2 = new Oval("O2", point1, color2, 1, 0.1);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadSetup() {
    Point2D point1 = new Point2D(500.0, 100.0);
    Color color1 = new Color(0, 0, 1);
    Color color2 = new Color(255, 255, 255);
    Oval newOval = new Oval("O", point1, color1, 0, 1);
    Oval o2 = new Oval("O2", point1, color2, -200, 15);
  }

  /**
   * Tests the getRadiusX method of the Oval class.
   */
  @Test
  public void testGetRadiusX() {

    assertEquals(60, oval1.getRadiusX(), 0.001);
    assertEquals(1, oval2.getRadiusX(), 0.001);
  }

  /**
   * Tests the getRadiusY method of the Oval class.
   */
  @Test
  public void testGetRadiusY() {

    assertEquals(30, oval1.getRadiusY(), 0.001);
    assertEquals(0.1, oval2.getRadiusY(), 0.001);
  }

  /**
   * Tests the changeSize method.
   */
  @Test
  public void testChangeSize() {
   oval1.changeSize(.1, .01);
   assertEquals(.1, oval1.getRadiusX(), 0.001);
   assertEquals(.01, oval1.getRadiusY(), 0.001);
  }

  /**
   * Tests the changeColor method.
   */
  @Test
  public void testChangeColor() {
    Color c1 = new Color(9, 8, 17);
    Color c2 = new Color(0,0,0);
    oval1.changeColor(c1);
    assertEquals("(9.0,8.0,17.0)",oval1.getColor().toString());
    oval2.changeColor(c2);
    assertEquals("(0.0,0.0,0.0)", oval2.getColor().toString());
  }

  /**
   * Tests the move method of the Rectangle class.
   */
  @Test
  public void testMove() {
    oval1.move(100, 300);
    oval2.move(0, 0);
    assertEquals("(100.0,300.0)", oval1.getPosition().toString());
    assertEquals("(0.0,0.0)", oval2.getPosition().toString());
    assertEquals(100, oval1.getPosition().getX(), 0.001);
    assertEquals(300, oval1.getPosition().getY(), 0.001);

  }

  /**
   * Tests the toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Name: O\n"
            + "Type: oval\n" + "Center: (500.0,100.0), X radius: 60.0, "
            + "Y radius: 30.0, Color: (0.0,0.0,1.0)", oval1.toString());
    assertEquals("Name: O2\n" + "Type: oval\n" + "Center: (500.0,100.0), "
           + "X radius: 1.0, Y radius: 0.1, Color: (255.0,255.0,255.0)",
            oval2.toString());
  }
}
