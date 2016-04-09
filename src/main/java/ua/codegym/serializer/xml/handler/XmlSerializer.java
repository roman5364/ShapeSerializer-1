package ua.codegym.serializer.xml.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.*;


import java.io.IOException;
import java.io.OutputStream;

public class XmlSerializer implements Serializer {

  public XmlSerializer() {
    String typeGroup = Group.class.getCanonicalName() + "XML";
    String typeCircle = Circle.class.getCanonicalName() + "XML";
    String typeSquare = Square.class.getCanonicalName() + "XML";
    ListOfShapes.addToShapesMap(typeGroup, new GroupXmlSerializer());
    ListOfShapes.addToShapesMap(typeCircle, new CircleXmlSerializer());
    ListOfShapes.addToShapesMap(typeSquare, new SquareXmlSerializer());
  }

  public void serialize(Shape shape, OutputStream os) throws IOException {
    String type = shape.getType() + "XML";
    Serializer serializer = ListOfShapes.getShapesMap().get(type);
    serializer.serialize(shape, os);
  }
}
