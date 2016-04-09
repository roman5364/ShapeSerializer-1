package ua.codegym.serializer.xml.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.ListOfShapes;
import ua.codegym.serializer.shape.Shape;

import java.io.IOException;
import java.io.OutputStream;

public class GroupXmlSerializer implements Serializer{


  @Override
  public void serialize(Shape shape, OutputStream os) throws IOException {
    Group group = (Group) shape;
    os.write("<group>".getBytes());
    for (Shape innerShape : group.getShapes()) {
      String type = innerShape.getType() + "XML";
      Serializer serializer = ListOfShapes.getShapesMap().get(type);
      serializer.serialize(innerShape, os);
    }
    os.write("</group>".getBytes());
  }



}
