import model.IShape;
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
  private Rectangle rectangle1; //ASK is it okay to create a RECTANGLE object instead of ISHAPE?

  /**
   * Creates Rectangle object instances.
   */
  @Before
  public void setUp() {
    Color color1 = new Color(1, 0, 0);
    Point2D point1 = new Point2D(200.0, 200.0);
    rectangle1 = new Rectangle("R", point1, color1, 50.0, 100.0 );
  }

  /**
   * Tests the getWidth method.
   */
  @Test
  public void testGetWidth() { //can't test if creating an IShape
    assertEquals(50.0, rectangle1.getWidth(), 0.001);
  }

  /**
   * Tests the getHeight method.
   */
  @Test
  public void testGetHeight() {
    assertEquals(100.0, rectangle1.getHeight(), 0.001);
  }

  /**
   * Tests the changeSize method of the Rectangle class.
   */
  @Test
  public void testChangeSize() {
    rectangle1.changeSize(25,100.0);
    assertEquals(25.0, rectangle1.getWidth(), 0.001);
    assertEquals(100.0, rectangle1.getHeight(), 0.001);
  }

  /**
   * Tests the changeColor method of the Rectangle class.
   */
  @Test
  public void testChangeColor() {
    Color newColor = new Color(0, 1, 0 );
    rectangle1.changeColor(newColor);
    assertEquals("(0.0,1.0,0.0)", rectangle1.getColor());
  }

  /**
   * Tests the move method of the Rectangle class.
   */
  @Test
  public void testMove() {
    rectangle1.move(100, 300);
    assertEquals("(100.0,300.0)", rectangle1.getPosition());
  }

  /**
   * Tests the getName method of the Rectangle class.
   */
  @Test
  public void testGetName() {
    assertEquals("R", rectangle1.getName());
  }

  /**
   * Tests the toString method of the Rectangle class.
   */
  @Test
  public void testToString() {
    assertEquals("Name: R\nType: rectangle\n"
            + "Min corner: (200.0,200.0), Width: 50.0, "
            + "Height: 100.0, Color: (1.0,0.0,0.0)", rectangle1.toString());
  }

}
