import model.Color;
import model.Point2D;
import model.Rectangle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the methods of the Rectangle class.
 */
public class RectangleTest {
  private Rectangle rectangle1;
  private Rectangle rectangle2;

  /**
   * Creates Rectangle object instances.
   */
  @Before
  public void setUp() {
    Color color1 = new Color(1, 0, 0);
    Point2D point1 = new Point2D(200.0, 200.0);
    rectangle1 = new Rectangle("R", point1, color1, 50.0, 100.0 );
    rectangle2 = new Rectangle("R2", 45, -20, color1, 1, 0.6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadSetUp() {
    Color color1 = new Color(1, 0, 0);
    Point2D point1 = new Point2D(200.0, 200.0);
    Rectangle r = new Rectangle("R", point1, color1, 0, 20);
    assertEquals(0, r.getWidth(), 0.001);
    Rectangle r2 = new Rectangle("R2", 3, 3, color1, -100, -30);
  }

  /**
   * Tests the getWidth method.
   */
  @Test
  public void testGetWidth() {

    assertEquals(50.0, rectangle1.getWidth(), 0.001);
    assertEquals(1, rectangle2.getWidth(), 0.001);
  }

  /**
   * Tests the getHeight method.
   */
  @Test
  public void testGetHeight() {

    assertEquals(100.0, rectangle1.getHeight(), 0.001);
    assertEquals(0.6, rectangle2.getHeight(), 0.001);
  }

  /**
   * Tests the changeSize method of the Rectangle class.
   */
  @Test
  public void testChangeSize() {
    rectangle1.changeSize(25,100.0);
    rectangle2.changeSize(9000, 893);
    assertEquals(25.0, rectangle1.getWidth(), 0.001);
    assertEquals(100.0, rectangle1.getHeight(), 0.001);
    assertEquals(9000, rectangle2.getWidth(), 0.001);
    assertEquals(893, rectangle2.getHeight(), 0.001);
  }

  /**
   * Tests the changeColor method of the Rectangle class.
   */
  @Test
  public void testChangeColor() {
    Color newColor = new Color(0, 1, 0 );
    Color c2 = new Color(255, 255, 255);
    rectangle1.changeColor(newColor);
    rectangle2.changeColor(c2);
    assertEquals("(0.0,1.0,0.0)", rectangle1.getColor().toString());
    assertEquals("(255.0,255.0,255.0)", rectangle2.getColor().toString());
  }

  /**
   * Tests the move method of the Rectangle class.
   */
  @Test
  public void testMove() {
    rectangle1.move(100, 300);
    rectangle2.move(0, 0);
    assertEquals("(100.0,300.0)", rectangle1.getPosition().toString());
    assertEquals("(0.0,0.0)", rectangle2.getPosition().toString());
  }

  /**
   * Tests the getName method of the Rectangle class.
   */
  @Test
  public void testGetName() {

    assertEquals("R", rectangle1.getName());
    assertEquals("R2", rectangle2.getName());
  }

  /**
   * Tests the toString method of the Rectangle class.
   */
  @Test
  public void testToString() {
    assertEquals("Name: R\nType: rectangle\n"
            + "Min corner: (200.0,200.0), Width: 50.0, "
            + "Height: 100.0, Color: (1.0,0.0,0.0)", rectangle1.toString());
    assertEquals("Name: R2\n" + "Type: rectangle\n" + "Min corner: (45.0,-20.0), "
            + "Width: 1.0, Height: 0.6, Color: (1.0,0.0,0.0)", rectangle2.toString());
  }

}
