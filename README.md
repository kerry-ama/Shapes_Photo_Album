# Shapes Photo Album
# 1.1 Project Overview:
Shapes Photo Album is an application that helps create a simple photo album from shapes. This project is a visual aid application for users to view the basic functionality and application of an object-oriented designed project that implements SOLID Principles in project architecture and incorporates best-practices of object-oriented programming including separation of concerns. This application will support the description of data we want visualized which will render the descriptive text property in a variety of ways.

# 1.2	Motivation:
Many of us use our phones and cameras to take pictures of friends and family members, and then share those pictures in online or physical photo albums. These pictures shared in photo albums can represent a multitude of things, such as data, events, paintings, self-portraits, objects, etc. Therefore, this shapes photo album application helps to create a simple photo album of shapes that allows users to create images with shapes. 

# 1.3 Illustrations of Application:
<img src="https://github.com/kerry-ama/Shapes_Photo_Album/blob/main/Cities%20image%20select.png" width="300" height="300">
<img src="https://github.com/kerry-ama/Shapes_Photo_Album/blob/main/cities_image_screenshot_2.png" width="300" height="300">
<img src="https://github.com/kerry-ama/Shapes_Photo_Album/blob/main/Cities_image_screenshot_3.png" width="300" height="300">

<img src="https://github.com/kerry-ama/Shapes_Photo_Album/blob/main/teri_wallpaper_screenshot_1.png" width="300" height="300">


![Watch The Video](https://github.com/kerry-ama/Shapes_Photo_Album/blob/main/video3367785876.mp4)

# 1.4 Detailed Project Design:
This application possesses design inspiration from the Model-View-Controller architecture. The design route taken for this project is synonymous to an MVVM approach such that the view communicates with the model and the controller, rather than the controller retrieving/relaying information between the model and the view. However, my design does possess a controller that contributes to the initialization of each program run.

To start off, the PhotoAlbumMain class acts as a driver by calling a function that parses through every line in a text file to build the desired model. Throughout the file parsing stage, shapes and snapshots are added/modified to the model, PhotoAlbumModel object, based on the commands provided in the text file. After the cessation of the file parsing, the model is created. Subsequently, based on the command line arguments, either a graphical view object (titled SwingView) or a web view object (titled PhotoAlbumWebView) is instantiated, and the contents of the model are displayed to the user. For instance, if the view type mentioned in the command line is of type graphical, the SwingView is instantiated, otherwise if the view type signifies web, a PhotoAlbumWebView will be created. The PhotoAlbumWebView utilizes Java’s SVG library to create the desired html file. To create the html file, the PhotoAlbumWebView contains methods that create different parts of the html file. The methods utilize Java’s StringBuilder class to create the different subsections of an html file.

The SwingView class utilizes Java’s JFrame and Java’s JPanel to add and display images to users. Prior to the instantiation of the SwingView, a PaintSnapshots object is instantiated. The purpose of this class is to paint the graphics obtained from the model onto the canvas. In order to allow users to interact with the JFrame, JButtons are instantiated which prompt the user to decide between changing the current snapshot display or quit the program. The actions performed by the user are communicated and handled by the SwingView. A switch statement is used to decipher the correct action performed by the user. Consequently, the view communicates with the model of the necessary changes to be made with the use of its composed class object, PaintSnapshots, which in turn leads to the view displaying the changes. In order to render the correct snapshot to be displayed to the user, SwingView utilizes a global counter variable that keeps track of the index of the displayed snapshot.

Due to the implementation of the model prior to implementing the view and controller, modifications were made to the classes in the model package. These modifications included the addition/removal of methods in the IShape interface and its corresponding subclasses as well as the IPhotoAlbumModel and the ISnapshot interfaces and their corresponding subclasses. First off, the changes made in the IShape interface include the addition of the methods: getHorizontal(), getVertical(), changeSize(double newHorizontal, double newVertical), and getType(). The addition of these methods consequently required implementations to the AbstractShape class. The addition of the getter methods, getHorizontal() and getVertical(), was due to ease of rendering the correct dimensions of a given IShape, irrespective of the type of the desired shape. Due to the addition of these getter methods in the IShape interface and AbstractShape class, the getter methods in terms each IShape’s respective dimensions were removed from the concrete classes. Similarly, the addition of the ‘changeSize’ method to the interface allowed for every IShape, irrespective of type, to use; this was useful for when an IShape’s dimensions needed change. The addition of the changeSize() method in the interface and AbstractShape class resulted in the removal of the method in the concrete classes: Rectangle and Oval. Lastly, getType() was added to IShape and consequently implemented in the concrete classes. The getType() method was useful in the implementation of the paintComponent() method in the PaintSnapshots class. It allowed for differentiation in terms of which type of IShape was needed to be drawn on the canvas. Due to the addition of multiple methods in the AbstractShape class, the getter methods, the changeSize methods, and the dimension fields in the Rectangle and Oval concrete classes were deleted.

In the ISnapshot interface and concrete Snapshot class, a getter method was implemented to return the list of ‘this’ ISnapshot’s shapes. In addition, a new constructor was added to the Snapshot class that allows Snapshot objects to be created without the need for a String description. Lastly, in the IPhotoAlbumModel interface, the methods takeSnapshot(), changeShapeColor(), and getListOfSnapshots(). The method takeSnapshot() was added to allow snapshots to be captured without the need of a String description. The method getListOfSnapshots() was added for ease in functionality in the views when needing to display certain Snapshots. Lastly, changeShapeColor() was added to allow current shapes in a Snapshot object to change color. All in all, the modifications were made to ensure proper functionality in the Photo Album application.
