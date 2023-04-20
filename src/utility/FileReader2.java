package utility;

import model.Color;
import model.IShape;
import model.PhotoAlbumModel;
import model.Snapshot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The FileReader2 class is a class that reads every line
 * in a text file and builds a PhotoAlbumModel model.
 */
public class FileReader2 {

  /**
   * Constructs a FileReader2 object.
   */
  public FileReader2() {

  }

  /**
   * A method that parses through a file and
   * creates a PhotoAlbumModel object.
   * @param inputFile the file that will be parsed
   * @return a PhotoAlbumModel object.
   */
  public PhotoAlbumModel fileLineReader(File inputFile) {
    PhotoAlbumModel model = new PhotoAlbumModel();
    try {

      BufferedReader file = new BufferedReader(new FileReader(inputFile));


      String line;
      while ((line = file.readLine()) != null) {

        line = line.trim();
        //split to get each word in the line
        List<String> lineList = Arrays.asList(line.split(" "));

        lineList.removeAll(Collections.singleton(" "));

        //remove all the empty string elements in the array
        List<String> newList = new ArrayList<>();
        for (String each: lineList) {
          if (!each.equalsIgnoreCase("")) {
            newList.add(each);
          }
        }
        //System.out.println(lineList);
        //System.out.println(newList);

        //array message
        //will iterate to next line in file if line starts or contains #
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
        //resizes the specified shape
        if (line.contains("resize")) {

          Integer r = newList.indexOf("resize");
          model.reSizeShape(newList.get(r + 1),
                  Integer.parseInt(newList.get(r + 2)),
                  Integer.parseInt(newList.get(r + 3)));

          continue;
        }
        //creates a rectangle IShape
        if (line.contains("shape") && line.contains("rectangle")) {
          Integer s = line.indexOf("shape");

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
        //creates an oval IShape
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
        //creates a Snapshot object
        if ((line.contains("snapshot") || line.toLowerCase().contains("snapshot")) && newList.size() > 1) {
          StringBuilder string = new StringBuilder();
          for (int i = 1; i < newList.size(); i++) {
            string.append(newList.get(i));
            string.append(" ");
          }

          Snapshot newSnap = model.takeSnapshot(string.toString());
          //call add snapshot
          //System.out.println(newSnap.toString());
          model.addSnapshot(newSnap);
          //System.out.println("snapshot added w description");
          continue;

        }
        if (line.contains("snapshot") || line.toLowerCase().contains("snapshot") && newList.size() == 1) {
          Snapshot newSnap = model.takeSnapshot();
          //call add snapshot
          System.out.println(newSnap.toString());
          model.addSnapshot(newSnap);
          System.out.println("snapshot taken and added");
          //System.out.println(model.getListOfShapes().toString());
          //System.out.println(model.getListOfSnapshots().size());
          continue;
        }

        //changes the color of a specified shape
        if (line.contains("color")) {
          Integer i = newList.indexOf("color");
          model.changeShapeColor(newList.get(i + 1),
                  Integer.parseInt(newList.get(i + 2)),
                  Integer.parseInt(newList.get(i + 3)),
                  Integer.parseInt(newList.get(i + 4)));

        }
        //removes specified shape from the shape list
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
}
