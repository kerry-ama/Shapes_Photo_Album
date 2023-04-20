package utility;

import controller.PhotoAlbumController;
import model.*;
import view.IPhotoAlbumView;
import view.PaintSnapshots;
import view.PhotoAlbumWebView;
import view.SwingView;

import java.io.*;
import java.util.*;

/**
 * The PhotoAlbumMain entry-point for the application,
 * handling  of the control over to your MVC triad.
 */
public class PhotoAlbumMain {

  /**
   * A method that parses through a file and
   * creates a PhotoAlbumModel object.
   * @param inputFile the file that will be parsed
   * @return a PhotoAlbumModel object.
   */
  public static PhotoAlbumModel fileLineReader(File inputFile) {
    PhotoAlbumModel model = new PhotoAlbumModel();
    try {
      //create input and output files

      BufferedReader file = new BufferedReader(new FileReader(inputFile));

      //split to get each word in the line
      String line;
      while ((line = file.readLine()) != null) {

        line = line.trim();
        List<String> lineList = Arrays.asList(line.split(" "));

        lineList.removeAll(Collections.singleton(" "));

        List<String> newList = new ArrayList<>();
        for (String each: lineList) {
          if (!each.equalsIgnoreCase("")) {
            newList.add(each);
          }
        }
        System.out.println(lineList);
        System.out.println(newList);

        //array message
        if (line.startsWith("#") || line.contains("#")) {
          continue;
        }
        if (line.contains("move") && !line.contains("remove")) {
          Integer i = newList.indexOf("move");

          model.moveShape(newList.get(i + 1), Integer.parseInt(newList.get(i + 2)), Integer.parseInt(newList.get(i + 3)));
          System.out.println(newList.get(i +1));

          continue;

          //create an array (each word in the line)
        }
        if (line.contains("resize")) {
          System.out.println("ERROR");
          System.out.println(newList);
          Integer r = newList.indexOf("resize");
          model.reSizeShape(newList.get(r + 1),
                  Integer.parseInt(newList.get(r + 2)),
                  Integer.parseInt(newList.get(r + 3)));

          continue;
        }
        if (line.contains("shape") && line.contains("rectangle")) {
          Integer s = line.indexOf("shape");
          //System.out.println(s + 7);
          Color color = new Color(Integer.parseInt(newList.get(s + 7)),
                  Integer.parseInt(newList.get(s + 8)),
                  Integer.parseInt(newList.get(s + 9)));
          IShape newRect = model.createShape("rectangle", newList.get(s + 1),
                  Integer.parseInt(newList.get(s + 3)),
                  Integer.parseInt(newList.get(s + 4)),
                  color, Integer.parseInt(newList.get(s + 5)),
                  Integer.parseInt(newList.get(s + 6)));
          //call model.addshape.

          model.addShape(newRect);
        }
        if (line.contains("shape") && line.contains("oval")) {
          Integer s = line.indexOf("shape");
          Color color = new Color(Integer.parseInt(newList.get(s + 7)),
                  Integer.parseInt(newList.get(s + 8)),
                  Integer.parseInt(newList.get(s + 9)));
          IShape newOval = model.createShape("oval", newList.get(s + 1),
                  Integer.parseInt(newList.get(s + 3)),
                  Integer.parseInt(newList.get(s + 4)),
                  color, Integer.parseInt(newList.get(s + 5)),
                  Integer.parseInt(newList.get(s + 6)));
          //call model.addShape
          model.addShape(newOval);

        }
        if ((line.contains("snapshot") || line.toLowerCase().contains("snapshot")) && newList.size() > 1) {
          StringBuilder string = new StringBuilder();
          for (int i = 1; i < newList.size(); i++) {
            string.append(newList.get(i));
            string.append(" ");
          }

          Snapshot newSnap = model.takeSnapshot(string.toString());
          //call add snapshot
          System.out.println(newSnap.toString());
          model.addSnapshot(newSnap);
          System.out.println("snapshot added w description");
          continue;

        }
        if (line.contains("snapshot") || line.toLowerCase().contains("snapshot") && newList.size() == 1) {
          Snapshot newSnap = model.takeSnapshot();
          //call add snapshot
          //System.out.println(newSnap.toString());
          model.addSnapshot(newSnap);

          continue;
        }

        if (line.contains("color")) {
          Integer i = newList.indexOf("color");
          model.changeShapeColor(newList.get(i + 1),
                  Integer.parseInt(newList.get(i + 2)),
                  Integer.parseInt(newList.get(i + 3)),
                  Integer.parseInt(newList.get(i + 4)));

        }
        if (line.contains("remove")) {
          Integer j = newList.indexOf("remove");
          model.removeShape(newList.get(j + 1));
        }


      }


    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return model;

  }

  //PRESS RUN HERE TO INITIALIZE PROGRAM
  public static void main(String[] args) throws IOException {


    java.io.File inputFile = null;
    java.io.File outputFile = null;
    String outputFileName = "";
    PhotoAlbumModel model;
    boolean viewType = false;
    int windowWidth = 1000;
    int windowHeight = 1000;

    for (int i = 0; i < args.length; i++) {
      try {
        if ( i < args.length - 1 ) {
          windowWidth = Integer.parseInt(args[i]);
          //System.out.println(windowWidth);
          windowHeight = Integer.parseInt(args[i + 1]);
          //System.out.println(windowHeight);
        }
      } catch (NumberFormatException nfe) {

      }
    }




    for (int i = 0; i < args.length; i++) {
      if (args[i].equalsIgnoreCase("-in")) {
        inputFile = new File(args[i + 1]);
        //call file reading method
         //model = fileLineReader(inputFile);
      } else if (args[i].equalsIgnoreCase("-out")) {
        outputFile = new File(args[i + 1]);
        outputFileName = args[i + 1];
      } else if (args[i].equalsIgnoreCase("-view") || args[i].equalsIgnoreCase("-v")) {

        if (args[i + 1].equalsIgnoreCase("graphical")) {
          viewType = true;


        }

      }

    }
    if (viewType) {

      //System.out.println(fileLineReader(inputFile).toString());
      PhotoAlbumModel model2 = fileLineReader(inputFile);
      //PaintSnapshots paint = new PaintSnapshots( model2.getListOfSnapshots()); ORGINAL

      PaintSnapshots paint = new PaintSnapshots( fileLineReader(inputFile).getListOfSnapshots());
      SwingView view = new SwingView(model2, windowWidth, windowHeight, paint);
      PhotoAlbumController controller = new PhotoAlbumController(model2, view);
      //System.out.println("getting to go");
      //System.out.println(model2.toString());
      controller.go();
      System.out.println(model2.getSnapshotIds().toString());
    } else {

      PhotoAlbumModel model2 = fileLineReader(inputFile); //original
      //PhotoAlbumWebView webView = new PhotoAlbumWebView(model2, outputFileName); //original
      PhotoAlbumWebView webView = new PhotoAlbumWebView(fileLineReader(inputFile), outputFileName);
      webView.displaySnapshots(model2.getListOfSnapshots());

      //System.out.println(model2.getSnapshotIds().toString());




    }
  }



}

