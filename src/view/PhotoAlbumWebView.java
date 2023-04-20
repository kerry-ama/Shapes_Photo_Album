package view;


import model.*;

import java.io.*;
import java.util.List;


//https://stackoverflow.com/questions/44857220/writing-html-file-with-java-printwriter
//https://www.youtube.com/watch?v=pV0v_3YRQoM

/**
 * The PhotoAlbumWebView represents is a static html markup with
 * a bit of embedded SVG to draw the graphics.
 * This view creates one html document that delimits each snapshot in some
 * way to distinguish where snapshots begin and end to produce textual output
 * HTML file with embedded SVG. The SVG file format is an XML-based format
 * that can be used to describe images (and animations).
 * It is an example of “vector-based graphics” where it
 * stores explicitly the shapes to be drawn
 * and manipulations to be done on them, instead of pixel values.
 * Most browsers support SVG rendering. The graphics information is provided to the view
 * by the PhotoAlbumModel.
 *
 */
public class PhotoAlbumWebView implements IPhotoAlbumView {

  private String outputFileName;

  /**
   * Constructs a PhotoAlbumWebView object instance.
   * @param model a PhotoAlbumModel object that contains the information
   *              of the graphics that will be written in the HTML output
   *              file.
   * @param fileName a String representing the output file name provided by
   *                 the command line arguments.
   */
  public PhotoAlbumWebView(PhotoAlbumModel model, String fileName) {
    this.outputFileName = fileName;
  }

  /**
   * Constructs a PhotoAlbumWebView object instance
   * @param model a PhotoAlbumModel object that contains the information
   *              of the graphics that will be written in the HTML output
   *              file.
   * @param fileName a String representing the output file name provided by
   *                 the command line arguments.
   * @param windowWidth an int representing the windowWidth
   * @param windowHeight an int representing the windowHeight
   */
  public PhotoAlbumWebView(PhotoAlbumModel model, String fileName, int windowWidth, int windowHeight) {}

  /**
   * Creates an output HTML file that contains all the graphics information
   * from the PhotoAlbumModel object.
   * @param listOfSnapshots a list of Snapshot objects that will need to be
   *                        written in the output file.
   * @throws FileNotFoundException if the file is not found
   */
  public void displaySnapshots(List<Snapshot> listOfSnapshots) throws FileNotFoundException {
    //take all the Strings (append all of them and write to the file)
    //will call body and header
    String header = generateSVGHeader();
    StringBuilder snaps = new StringBuilder();
    snaps.append(header);
    String body = generateSVGBody(listOfSnapshots);
    snaps.append(body);
    String lastHTML = "\n</html>";
    snaps.append(lastHTML);

    FileOutputStream fileOutputStream = new FileOutputStream(this.outputFileName);
    //FileOutputStream fileOutputStream = new FileOutputStream("demo_final.html");
    PrintStream output = new PrintStream(fileOutputStream);
    output.println(snaps);


  }



  /**
   * Generates the SVGHeader. (Note: Due to testing purposes, changed the
   * modifier from private to public.)
   * @return a String containing the DOCTYPE and header information
   */
  public String generateSVGHeader() { //was private changed to public due to testing
    String header = "<!DOCTYPE html>\n<html>\n<head>\n<style>\n\t"
            + ".snapshot {\n\t\tborder: 5px outset red;"
            + "\n\t\tbackground-color: lightblue;\n\t}\n</style>\n</head>\n";
    return header;


  }

  /**
   * Generates an SVG body that contains all the Snapshot objects' information
   * that will be written to the output file.
   * @param snapshots a list of Snapshot object that will be written in the HTML
   *                  file.
   * @return a String containing all the Snapshot object information in SVG.
   */
  public String generateSVGBody(List<Snapshot> snapshots) { //was private changed to public due to testing
    //should be private since helper fxn, no outside client will need to call
    StringBuilder string = new StringBuilder();
    String body = "<body>\n<h1>" + "HTML with SVG for the Evening!!" + "</h1>\n";
    string.append(body);
    String snapshotsString;

    for (Snapshot each: snapshots) {
      string.append("<div class=\"snapshot\">\n");
      //string.append("<h" + (snapshots.indexOf(each) + 2) +">" + each.getId() + "</h" + (snapshots.indexOf(each) + 2) + ">");
      string.append("<h2>" + each.getId() + "</h2>");
      string.append("<h4>" + each.getDescription() + "</h4>");
      string.append("<svg width=\"800\" height=\"800\">\n ");
      string.append(generateSVGSnapshot(each));
    }
    string.append("</body>");
    return string.toString();
  }

  /**
   * Generates a String that represents the SVG shape information of a given
   * Snapshot in the PhotoAlbumModel.
   * @param shape an IShape object that will be written in the output file
   * @return a String containing IShape information that will be placed in the
   *         HTML file.
   */
  public String generateSVGShape(IShape shape) { //was private changed to public due to testing
    //should be private since helper fxn, no outside client will need to call

    if (shape.getType().equalsIgnoreCase("rectangle")) {
      //casting shape to specific shape

      return "<rect id=" + shape.getName() + " " +"x="
              + "\"" + shape.getPosition().getX() + "\"" + " " + "y="
              + "\"" + shape.getPosition().getY() + "\"" +  " " +"width="
              + "\"" + shape.getHorizontal() + "\"" + " " +"height="
              + "\"" + ((IShape)shape).getVertical() + "\"" + " " +"fill="
              + "\"" + "rgb" + shape.getColor().toString() + "\">"
              + "\n</rect>\n";
    }

      return "<ellipse id=" + shape.getName() + " " + "cx="
              + "\"" + shape.getPosition().getX() + "\"" + " " +"cy="
              + "\"" + shape.getPosition().getY() + "\"" + " " +"rx="
              + "\"" + ((IShape)shape).getHorizontal() + "\"" + " " +"ry="
              + "\"" + ((IShape)shape).getVertical() + "\"" + " " +"fill="
              + "\"" + "rgb" + shape.getColor().toString() + "\">"
              + "\n</ellipse>\n";

  }

  /**
   * Generates a String that represents the SVG Snapshot information of a given
   * Snapshot in the PhotoAlbumModel.
   * @param snapshot a Snapshot object
   * @return a String containing Snapshot information of one Snapshot in SVG format
   *         that will be written in the HTML file.
   */
  public String generateSVGSnapshot(ISnapshot snapshot) { //was private changed to public due to testing

    //call generateSVGShape
    StringBuilder string = new StringBuilder();

    List<IShape> listOfShapes = snapshot.getListOfShapes();
    for (IShape each: listOfShapes ) {
      string.append(generateSVGShape(each));
    }
    string.append("</svg>\n</div>\n");
    return string.toString();
  }

}
