# Shapes_Photo_Album
The objective of this project is to create an application that helps to create a simple "photo album" from shapes. In terms of the Model-View-Controller architecture, this program represents the Model. The design of the model includes three interfaces, an abstract class, and six concrete classes. The interfaces include: IShape, ISnapshot, and IPhotoAlbumModel. The abstract class is named AbstractShape and concrete classes are Color, Point2D, Rectangle, Oval, Snapshot, and PhotoAlbumModel. 

First off, the IShape interface is a blueprint for the functionality of the shapes in a simple photo album. Classes that implement IShape are mandated to have the ability to change its color, change its position (represented by cartesian x and y coordinate points), and change its size. In addition, classes that implement IShape are mandated to contain getter methods that return the IShape's color, position, and name. Due to the use of multiple shapes in the model as well as potential for an introduction of more shapes, an AbstractShape class was created. The AbstractShape class is an abstract class that implements all of the methods mandated by the IShape interface. An AbstractShape knows its name (represented by a String), knows its position (represented by a Point2D object), knows its color (represented by a Color object), and knows its dimensions. The AbstractShape implements all of the methods mandated by the IShape interface, therefore, an AbstractShape can change color, change its position, and change its size. The Oval and Rectangle class extend the AbstractShape class. They differentiate in terms of terminology used to represents its dimensions, radiusX and radiusY vs width and height, respectively. In addition to the methods implemented in the AbstractShape class, Rectangle and Oval object can also be represented by Strings utilizing their toString methods. Additionally, Rectangle and Oval objects know their type. Lastly, the Rectangle and Oval class contain two constructors to allow users to create an IShape utilizing an x and y coordinate or a Point2D object. 

As mentioned previously, an AbstractShape has a Color and has a Point2D. The Color class represents a system representing the colors (red, green, and blue) used on a digital display screen. Therefore, a Color object knows its proportions of red, green, and blue it contains. The Point2D class represents a point on a two-dimensional cartesian plane. Therefore, a Point2D object knows its x-coordinate and y-coordinate. 

Furthermore, the model contains an ISnapshot interface that represents a snapshot/pictures in a photo album. Classes that implement ISnapshot interface are mandated to contain getter methods that return its id, timestamp, and description as well as be able to return a String representation of itself. The concrete class that implements ISnapshot is Snapshot. A Snapshot object knows its String description, has a list of IShapes, its SimpleDateFormat id, and a String representation of its timeStamp. 

Lastly, the IPhotoAlbumModel interface is a blueprint for the functionality of a PhotoAlbumModel object. A PhotoAlbumModel object should be able to create shapes, take snapshots, add/remove snapshots, add/remove/move/resize shapes, reset itself, and represent itself as a String. The PhotoAlbumModel concrete class implements the IPhotoAlbumModel. A PhotoAlbumModel has a list of Snapshot objects and has a list of IShape objects. The lists are represented by utilizing the Java's LinkedLists to preserve order when adding/removing objects from the list. A PhotoAlbumModel object can create shapes, take snapshots, add/remove snapshots, add/remove/move/resize shapes, reset itself, and represent itself as a String. A PhotoAlbumModel object also has the capability of choosing whether a Snapshot is added to the album by including an addSnapshot method and a takeSnapshot method. 
