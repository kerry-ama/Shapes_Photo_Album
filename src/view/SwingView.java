package view;


import model.PhotoAlbumModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The SwingView class represents a "graphical" view that handles user events
 * and gives a richer UX (user experience). This class extends
 * all the methods in the JFrame class as well as implements
 * the methods of the ActionListener class. Therefore, this class contributes
 * to the display of Snapshot images to the user as well as listens to user
 * actions to display appropriate changes.
 */
public class SwingView extends JFrame implements ActionListener {
  //private JPanel panel;
  private JButton previous;//
  private JButton select;
  private JButton next;
  private JButton quit;
  private JFrame frame;
  private PhotoAlbumModel model;
  private PaintSnapshots paint;
  private int counter;
  private JPanel pinkPanel;
  private JLabel label;


  /**
   * Constructs a SwingView object by creating a JFrame and setting
   * the first Snapshot on the frame, adding the buttons to the frame.
   * @param model a PhotoAlbumModel object that constructs and posses
   *              all the information of what this PhotoAlbum posses
   *              in terms of Snapshot images and shapes that are
   *              displayed in each Snapshot image.
   * @param windowWidth an int representing the window width
   * @param windowHeight an int representing the window height
   * @param paint a PaintSnapshots method that utilizes JPanel and
   *              paintComponent method to display shapes on the panel
   */
  public SwingView(PhotoAlbumModel model, int windowWidth, int windowHeight, PaintSnapshots paint) {

    pinkPanel = new JPanel();
    pinkPanel.setBackground(Color.pink);
    pinkPanel.setBounds(0, 0, 800, 20);


    this.previous = new JButton("<< Prev <<");
    this.previous.setBounds(25, 75, 110, 25 );
    this.previous.addActionListener(this);


    this.select = new JButton("^^ Select ^^");
    this.select.setBounds(25, 115, 110, 25);
    this.select.addActionListener(this);

    this.next = new JButton(">> Next >>");
    this.next.setBounds(25, 145, 110, 25);
    this.next.addActionListener(this);

    this.quit = new JButton("xx Quit xx");
    this.quit.setBounds(25, 175, 110, 25);
    this.quit.addActionListener(this);
    JPanel buttonPanel = new JPanel();

    //might not need to instantiate JFrame since extending
    //could refractor and change all frame to this if have time
    frame = new JFrame();
    frame.setTitle("cs5004 Shapes Photo Album Viewer");
    frame.setSize(windowWidth, windowHeight);
    System.out.println(windowHeight);
    System.out.println(windowWidth);

    //allows user to exit using red exit button on top left corner
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //just added
    frame.add(pinkPanel);

    buttonPanel.add(this.previous);
    buttonPanel.add(this.select);
    buttonPanel.add(this.next);
    buttonPanel.add(this.quit);



    frame.add(buttonPanel, BorderLayout.PAGE_END);


    this.model = model;
    this.counter = 0;
    this.paint = paint;
    frame.add(paint);
    label = new JLabel();
    //label.setText(this.model.getSnapshot(this.counter + 1).getId()
           // + "\n" + this.model.getSnapshot(this.counter + 1).getDescription());
    label.setText(this.model.getListOfSnapshots().get(this.counter).getId());
    label.setHorizontalTextPosition(JLabel.LEFT);
    pinkPanel.add(label);
    frame.add(pinkPanel, BorderLayout.PAGE_START);


    frame.setVisible(true);


  }


  /**
   * Constructs a SwingView object. *Not using*
   * @param caption a String.
   */
  public SwingView(String caption) {
    super(caption);
    //setSize(1000,1000);
    //frame = new JFrame();
    frame.setTitle("cs5004 Shapes Photo Album Viewer");
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    //previous = new JButton("<< Prev <<");
    select = new JButton("^^ Select ^^");
    next = new JButton(">> Next >>");
    quit = new JButton("xx Quit xx");


  }


  /**
   * Displays the current Snapshot ID at the top of the
   * JFrame.
   */
  private void drawPaintId() {
    JPanel pinkPanel = new JPanel();
    pinkPanel.setBounds(0, 0, 800, 20);
    pinkPanel.setBackground(Color.pink);
    JLabel label = new JLabel();
    label.setText(this.model.getSnapshot(this.counter + 1).getId()
            + "\n" + this.model.getSnapshot(this.counter + 1).getDescription());
    label.setHorizontalTextPosition(JLabel.LEFT);
    pinkPanel.add(label);
    frame.add(pinkPanel);
  }

  /**
   * Displays the current Snapshot's ID at the top of the
   * JFrame.
   */
  private void updateID() {
    label.setText(this.model.getSnapshot(this.counter + 1).getId()
            + "\n" + this.model.getSnapshot(this.counter + 1).getDescription());
    //label.setText(this.model.getListOfSnapshots().get(this.counter).getId());
    label.setHorizontalTextPosition(JLabel.LEFT);

    pinkPanel.add(label);
    //pinkPanel.repaint();
    frame.add(pinkPanel, BorderLayout.PAGE_START);

  }



  /**
   * When a user clicks on one of four buttons created in the constructor,
   * an action will be performed. The four buttons created in the
   * Constructor are 'prev' (short for previous), 'select', 'next', and
   * 'quit'. If user clicks on 'prev', the display will change to the
   * previous Snapshot in the list of Snapshots if possible. If
   * user clicks on 'select', they are given a dropdown
   * option to choose whichever Snapshot ID they desire to be displayed.
   * If a user clicks on 'next', the next Snapshot in the list of Snapshots
   * will be displayed if possible. Lastly, if the user clicks on 'next',
   * the next Snapshot in the list will be displayed if possible.
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) { //move to graphical view

    //add button functionality
    switch (e.getActionCommand()) {
      //case1: get previous snapshot (get previous screenshot)

      case "<< Prev <<":
        //track to see what screenshot it is on.
        System.out.println("pressed prev");
        System.out.println(this.model.getListOfSnapshots().size());
        System.out.println(this.counter);
        if (this.counter > 0 && this.counter < this.model.getListOfSnapshots().size()) {
          this.counter--;
          paint.setSnapIndex(this.counter);
          //paint.paintComponent(super.);
          paint.repaint();

          frame.add(paint);
          updateID();

          frame.setVisible(true);



        } else {
          JOptionPane.showMessageDialog(this, "End of the photo album. No snapshots to show beyond this one.");
        }

        break;


        //case2: select snapshot (user explicitly selection from a list of options)
      case "^^ Select ^^":
        System.out.println("pressed select");
        String[] string = new String[this.model.getListOfSnapshots().size()];
        for (int i = 0; i < this.model.getListOfSnapshots().size(); i++) {
          string[i] = this.model.getSnapshotIds().get(i);
        }

        String selectedSnap = (String) JOptionPane.showInputDialog(this, "Choose:\n", "Menu",
                JOptionPane.QUESTION_MESSAGE, null, string, string[0] );
        for (int j = 0; j < this.model.getListOfSnapshots().size(); j++) {
          if (selectedSnap.equalsIgnoreCase(string[j])) {
            this.counter = j;
            //updateID();
          }
        }
        updateID();
        paint.setSnapIndex(this.counter);
        paint.repaint();
        //drawPaintId();
        //frame.add(paint);
        frame.setVisible(true);


        break;


        //case3: get next snapshot, if no next, prompt message

      case ">> Next >>":

        //increase counter by 1
        System.out.println(this.counter);
        System.out.println("pressed next");
        if (this.counter >= 0 && this.counter < this.model.getListOfSnapshots().size() - 1) {
          this.counter++;
          paint.setSnapIndex(this.counter);
          //paint.paintComponent(this.model.getListOfSnapshots().get(this.counter));
          paint.repaint();
          updateID();
          //frame.add(paint);


          frame.setVisible(true);


        } else {
          JOptionPane.showMessageDialog(this, "End of the photo album. No snapshots to show beyond this one.");

        }
        break;
        //case4: Quit
      case "xx Quit xx":
        System.out.println("quit happening");
        System.exit(0);
        break;

    }


  }
}
