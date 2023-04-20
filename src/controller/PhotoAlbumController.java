package controller;

import model.Color;
import model.IPhotoAlbumModel;
import model.PhotoAlbumModel;
import model.Snapshot;
//import utility.PhotoFileReader;
import view.IPhotoAlbumView;
import view.PhotoAlbumWebView;
import view.SwingView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

/**
 * This class represents a PhotoAlbumController. In this PhotoAlbum application,
 * the design pattern is synonymous to an MVC model and this class represents
 * the controller. The PhotoAlbumController initializes the program
 * and communicate with the Graphical SwingView class. However, this class diverges
 * from a typical controller in an MVC such that this class does not facilitate
 * communication between the model and view.
 */
public class PhotoAlbumController  {

  //private PhotoFileReader fileReader;
  private SwingView view;
  private PhotoAlbumWebView view_two;

  private int counter;

  private PhotoAlbumModel model;

  /**
   * Constructs a PhotoAlbumController object instance that takes in a
   * graphical SwingView object instance and model.
   * @param model represents the PhotoAlbumModel object instance
   *              that will be displayed
   * @param view a SwingView object instance that represents a graphical
   *             view that would be used to display the model
   *             to the user.
   */

  public PhotoAlbumController(PhotoAlbumModel model, SwingView view) {
    //this.fileReader = fileReader;
    this.model = model;
    this.view = view;
    this.counter = 0;
  }


  /**
   * Constructs a PhotoAlbumController object instance that takes in a
   * web PhotoAlbumWebView object instance and model.
   * @param model represents the PhotoAlbumModel object instance
   *              that will be displayed
   * @param view_two a PhotoAlbumWebView object instance that represents a web
   *             view that would be used to display the model
   *             to the user.
   */
  public PhotoAlbumController(PhotoAlbumModel model, PhotoAlbumWebView view_two) {
    //this.fileReader = fileReader;
    this.model = model;
    this.view_two = view_two;
    this.counter = 0;

  }


  /**
   * Initializes the program and sets the graphical view
   * visible to the user.
   * @throws IOException if there are errors in the input/output
   * errors
   *
   */
  public void go() throws IOException {
    Objects.requireNonNull(this.model);
    this.view.setVisible(true); //should go in view
  }



}
