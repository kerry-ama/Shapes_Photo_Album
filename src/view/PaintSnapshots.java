package view;

import model.Snapshot;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import utility.ColorAdaptor;

/**
 * The PaintSnapshots class represents a class that extends
 * Java's JPanel class and utilizes its paintComponent method
 * to display specific Snapshot object instances that are specified
 * by the SwingView. In order to obtain the correct Snapshot to be displayed
 * this class utilizes a global counter a setter method to align with the
 * global counter in the SwingView class. This class knows
 * its list of Snapshots that will be displayed in the JPanel.
 */
public class PaintSnapshots extends JPanel {
  private List<Snapshot> listOfSnaps;
  //private LinkedList<Snapshot> listOfSnaps;
  private int i;

  /**
   * Constructs a PaintSnapshots object instance.
   * @param listOfSnaps a list of Snapshot objects
   * @param windowWidth an int representing the desired
   *                    window width
   * @param windowHeight an int representing the desired window
   *                     height
   */
  public PaintSnapshots(List<Snapshot> listOfSnaps, int windowWidth, int windowHeight) {

    this.listOfSnaps = listOfSnaps;

  }

  /**
   * Constructs a PaintSnapshots object instance.
   * @param listOfSnaps a list of Snapshot objects
   *
   */
  public PaintSnapshots(List<Snapshot> listOfSnaps) {

    this.listOfSnaps = listOfSnaps;

  }

  /**
   * This method is java method that is needed to draw something on JPanel other
   * than drawing the background color. This method iterates through
   * the list of Shapes to draw all the shapes in a Snapshot that will
   * be displayed by the view.
   * @param g the <code>Graphics</code> object to protect
   */
  public void paintComponent(Graphics g) { //
    super.paintComponents(g);
    Graphics2D graphics2D = (Graphics2D) g;
    //drawPaintId();
    //loop through list of shapes
    //for (int i = 0; i < listOfSnaps.size(); i++) { not necessary will result in iterating too many times
      for (int j = 0; j < listOfSnaps.get(i).getListOfShapes().size(); j++) {
        if (listOfSnaps.get(i).getListOfShapes().get(j).getType().equalsIgnoreCase("rectangle")) {
          Integer posX = (int) listOfSnaps.get(i).getListOfShapes().get(j).getPosition().getX();
          Integer posY = (int) listOfSnaps.get(i).getListOfShapes().get(j).getPosition().getY();
          Integer width = (int) listOfSnaps.get(i).getListOfShapes().get(j).getHorizontal();
          Integer height = (int) listOfSnaps.get(i).getListOfShapes().get(j).getVertical();
          model.Color photoAlbumColor = new model.Color(listOfSnaps.get(i).getListOfShapes().get(j).getColor().getRed(),
                  listOfSnaps.get(i).getListOfShapes().get(j).getColor().getGreen(),
                  listOfSnaps.get(i).getListOfShapes().get(j).getColor().getBlue());
          graphics2D.setColor(ColorAdaptor.toSwingFromModel(photoAlbumColor));
          graphics2D.fillRect(posX, posY, width, height);


        }
        if (listOfSnaps.get(i).getListOfShapes().get(j).getType().equalsIgnoreCase("oval")) {
          Integer posX = (int) listOfSnaps.get(i).getListOfShapes().get(j).getPosition().getX();
          Integer posY = (int) listOfSnaps.get(i).getListOfShapes().get(j).getPosition().getY();
          Integer radiusX = (int) listOfSnaps.get(i).getListOfShapes().get(j).getHorizontal();
          Integer radiusY = (int) listOfSnaps.get(i).getListOfShapes().get(j).getVertical();

          model.Color photoAlbumColor = new model.Color(listOfSnaps.get(i).getListOfShapes().get(j).getColor().getRed(),
                  listOfSnaps.get(i).getListOfShapes().get(j).getColor().getGreen(),
                  listOfSnaps.get(i).getListOfShapes().get(j).getColor().getBlue());

          graphics2D.setColor(ColorAdaptor.toSwingFromModel(photoAlbumColor));
          graphics2D.fillOval(posX, posY, radiusX, radiusY); //change to fillOval

        }

      }

    }


  /**
   * Setter method that sets the index
   * of the global index to the index
   * of the Snapshot that needs to be displayed by
   * the view.
   * @param index an int representing the index of
   *              a Snapshot object in a list that needs
   *              to be displayed.
   */
  public void setSnapIndex(int index) {
    this.i = index;

  }

  private void drawPaintId() {
    JPanel pinkPanel = new JPanel();
    pinkPanel.setBounds(0, 0, 800, 20);
    pinkPanel.setBackground(Color.pink);
    JLabel label = new JLabel();
    label.setText(this.listOfSnaps.get(this.i).getId()
            + "\n" + this.listOfSnaps.get(this.i).getDescription());
    label.setHorizontalTextPosition(JLabel.LEFT);
    pinkPanel.add(label);
    //frame.add(pinkPanel);
  }
}
