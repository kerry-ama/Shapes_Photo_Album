import model.PhotoAlbumModel;
import org.junit.Before;
import org.junit.Test;
import utility.FileReader2;
import utility.PhotoAlbumMain;
import view.PhotoAlbumWebView;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Tests methods of the PhotoAlbumWebView class.
 */
public class PhotoAlbumWebviewTest {

  private PhotoAlbumWebView view1;
  private PhotoAlbumWebView view2;
  private PhotoAlbumModel model1;
  private PhotoAlbumMain main1;
  private FileReader2 fileReader2;
  private PhotoAlbumModel model2;


  /**
   * Creates object instances required in order to test the methods
   * of the PhotoAlbumWebView class.
   */
  @Before
  public void setUp() {


    fileReader2 = new FileReader2();
    File inputFile = new File("buildings.txt");
    model1 = fileReader2.fileLineReader(inputFile);
    view1 = new PhotoAlbumWebView(model1, "buildings.txt");

    File inputFile2 = new File("demo_input.txt");
    model2 = fileReader2.fileLineReader(inputFile2);

    view2 = new PhotoAlbumWebView(model2, "demo_input.txt");

  }

  /**
   * Tests the generateSVGHeader function.
   */
  @Test
  public void testGenerateSVGHeader() {
    assertEquals("<!DOCTYPE html>\n<html>\n<head>\n<style>\n\t"
            + ".snapshot {\n\t\tborder: 5px outset red;"
            + "\n\t\tbackground-color: lightblue;\n\t}\n</style>\n</head>\n", view1.generateSVGHeader());
  }

  /**
   * Tests the generateSVGShape method.
   */
  @Test
  public void testGenerateSVGShape() {
    assertEquals("<rect id=background x=\"0.0\" "
            + "y=\"0.0\" width=\"800.0\" "
            + "height=\"800.0\" fill=\"rgb(33,94,248)\">\n"
            + "</rect>\n",view1.generateSVGShape(model1.getListOfShapes().get(0)));
    assertEquals("<ellipse id=myoval cx=\"500.0\" cy=\"400.0\" "
            + "rx=\"60.0\" ry=\"30.0\" fill=\"rgb(0,255,1)\">\n"
            + "</ellipse>\n", view2.generateSVGShape(model2.getListOfShapes().get(0)));
  }

  /**
   * Tests the generateSVGSnapshot method.
   */
  @Test
  public void testGenerateSVGSnapshot() {
    assertEquals("<rect id=myrect x=\"300.0\" y=\"200.0\" width=\"50.0\" "
            + "height=\"100.0\" fill=\"rgb(255,0,0)\">\n"
            + "</rect>\n" +  "<ellipse id=myoval cx=\"500.0\" "
            + "cy=\"400.0\" rx=\"60.0\" ry=\"30.0\" fill=\"rgb(0,255,1)\">\n" +
            "</ellipse>\n" + "</svg>\n" + "</div>\n",
            view2.generateSVGSnapshot(model2.getSnapshot(1)));

    assertEquals("<rect id=background x=\"0.0\" y=\"0.0\" width=\"800.0\" "
            + "height=\"800.0\" fill=\"rgb(33,94,248)\">\n"
            + "</rect>\n" + "<rect id=B0 x=\"80.0\" y=\"424.0\" "
            + "width=\"100.0\" height=\"326.0\" fill=\"rgb(0,0,0)\">\n"
            + "</rect>\n" + "<rect id=B1 x=\"260.0\" y=\"365.0\" "
            + "width=\"100.0\" height=\"385.0\" fill=\"rgb(0,0,0)\">\n"
            + "</rect>\n" + "<rect id=B2 x=\"440.0\" y=\"375.0\" "
            + "width=\"100.0\" height=\"375.0\" fill=\"rgb(0,0,0)\">\n"
            + "</rect>\n" + "<rect id=B3 x=\"620.0\" y=\"445.0\" "
            + "width=\"100.0\" height=\"305.0\" fill=\"rgb(0,0,0)\">\n"
            + "</rect>\n" + "<rect id=window000 x=\"100.0\" y=\"500.0\" "
            + "width=\"20.0\" height=\"20.0\" fill=\"rgb(255,255,255)\">\n"
            + "</rect>\n" + "<rect id=window001 x=\"140.0\" y=\"500.0\" "
            + "width=\"20.0\" height=\"20.0\" fill=\"rgb(255,255,255)\">\n"
            + "</rect>\n" + "<rect id=window010 x=\"100.0\" y=\"600.0\" "
            + "width=\"20.0\" height=\"20.0\" fill=\"rgb(255,255,255)\">\n"
            + "</rect>\n" + "<rect id=window011 x=\"140.0\" y=\"600.0\" "
            + "width=\"20.0\" height=\"20.0\" fill=\"rgb(255,255,255)\">\n"
            + "</rect>\n" + "</svg>\n" + "</div>\n",
            view1.generateSVGSnapshot(model1.getSnapshot(1)));
  }

  /**
   * Tests the generateSVGBody method.
   */
  @Test
  public void testGenerateSVGBody() {
    assertEquals("<body>\n"
            + "<h1>HTML with SVG for the Evening!!</h1>\n"
            + "<div class=\"snapshot\">\n"
            + "<h2>"+ model2.getSnapshot(1).getId() + "</h2><h4>After first selfie "
                    + "</h4><svg width=\"800\" height=\"800\">\n"
            + " <rect id=myrect x=\"300.0\" y=\"200.0\" width=\"50.0\" " +
            "height=\"100.0\" fill=\"rgb(255,0,0)\">\n"
            + "</rect>\n" + "<ellipse id=myoval cx=\"500.0\" cy=\"400.0\" "
            + "rx=\"60.0\" ry=\"30.0\" fill=\"rgb(0,255,1)\">\n" + "</ellipse>\n"
            + "</svg>\n" + "</div>\n" + "<div class=\"snapshot\">\n"
            + "<h2>"+ model2.getSnapshot(2).getId() +"</h2><h4>2nd selfie </h4><svg "
            + "width=\"800\" height=\"800\">\n" + " <rect id=myrect x=\"100.0\" "
            + "y=\"300.0\" width=\"25.0\" " + "height=\"100.0\" "
            + "fill=\"rgb(0,0,255)\">\n" + "</rect>\n" + "<ellipse "
            + "id=myoval cx=\"500.0\" cy=\"400.0\" rx=\"60.0\" "
            + "ry=\"30.0\" fill=\"rgb(0,255,1)\">\n"
            + "</ellipse>\n" + "</svg>\n" + "</div>\n" + "<div class=\"snapshot\">\n"
            + "<h2>"+ model2.getSnapshot(3).getId() + "</h2><h4></h4>"
            + "<svg width=\"800\" height=\"800\">\n"
            + " <rect id=myrect x=\"100.0\" y=\"300.0\" width=\"25.0\" "
            + "height=\"100.0\" fill=\"rgb(0,0,255)\">\n"
            + "</rect>\n" + "<ellipse id=myoval cx=\"500.0\" cy=\"400.0\" "
            + "rx=\"60.0\" ry=\"30.0\" fill=\"rgb(0,255,1)\">\n"
            + "</ellipse>\n" + "</svg>\n" + "</div>\n" + "<div class=\"snapshot\">\n"
            + "<h2>" + model2.getSnapshot(4).getId()+ "</h2><h4>Selfie after removing "
            + "the rectangle from the picture </h4><svg width=\"800\" height=\"800\">\n"
            + " <ellipse id=myoval cx=\"500.0\" cy=\"400.0\" rx=\"60.0\" "
            + "ry=\"30.0\" fill=\"rgb(0,255,1)\">\n" + "</ellipse>\n" + "</svg>\n" + "</div>\n"
            + "</body>",view2.generateSVGBody(model2.getListOfSnapshots()));

  }

}
